import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Birte on 27-6-2017.
 */
public class MyVisitor extends MyLanguageBaseVisitor {

    private Map<String, Integer> scope = new HashMap<>();
    private Map<String, Type> varType = new HashMap<>();
    private Map<MyLanguageParser.ExprContext, Type> exprType = new HashMap<>();
    private Integer scopeLevel = 0;

    public static void main(String[] args) {
        MyVisitor visitor = new MyVisitor();
        try {
            System.out.println(visitor.traverse("class hoi; int x = 1;"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Object traverse(String text) throws ParseException {
        CharStream chars = CharStreams.fromString(text);
        MyLanguageLexer lexer = new MyLanguageLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MyLanguageParser parser = new MyLanguageParser(tokens);
        ParseTree tree = parser.program();
        return visit(tree);
    }

    @Override
    public Object visitProgram(MyLanguageParser.ProgramContext ctx) {
        return visitBody(ctx.body());
    }

    @Override
    public Object visitBody(MyLanguageParser.BodyContext ctx) {
        Object result = null;
        for (MyLanguageParser.StatContext stat : ctx.stat()) {
            result = visit(stat);
        }
        return result;
    }

    @Override
    public Object visitDeclStat(MyLanguageParser.DeclStatContext ctx) {
        Object result = visit(ctx.expr());
        if (scope.containsKey(ctx.ID().getText())) {
            System.out.println("error, duplicate declaration");
        }
        else {
            scope.put(ctx.ID().getText(), scopeLevel);
            if (ctx.type().getText().equals("int") && exprType.get(ctx.expr()) == Type.INTEGER) {
                varType.put(ctx.ID().getText(), Type.INTEGER);
            }
            else if (exprType.get(ctx.expr()) == Type.BOOLEAN) {
                varType.put(ctx.ID().getText(), Type.BOOLEAN);
            }
            else {
                System.out.println("error, wrong type");
            }
        }
        return result;
    }

    @Override
    public Object visitAssStat(MyLanguageParser.AssStatContext ctx) {
        Object result = visit(ctx.expr());
        if (scope.containsKey(ctx.ID().getText())) {
            if (!(varType.get(ctx.ID().getText()) == exprType.get(ctx.expr()))) {
                System.out.println("error, wrong type");
            }
        }
        else {
            System.out.println("error, variable not declared");
        }
        return result;
    }

    @Override
    public Object visitIfStat(MyLanguageParser.IfStatContext ctx) {
        Object result = visit(ctx.expr());
        if (exprType.get(ctx.expr()) == Type.BOOLEAN) {
            result = visit(ctx.block(0));
            if (ctx.block(1) != null) {
                visit(ctx.block(1));
            }
        }
        else {
            System.out.println("error, wrong condition");
        }
        return result;
    }

    @Override
    public Object visitWhileStat(MyLanguageParser.WhileStatContext ctx) {
        Object result = visit(ctx.expr());
        if (exprType.get(ctx.expr()) == Type.BOOLEAN) {
            result = visit(ctx.block());
        }
        else {
            System.out.println("error, wrong condition");
        }
        return result;
    }

    @Override
    public Object visitForStat(MyLanguageParser.ForStatContext ctx) {
        Object result = visit(ctx.block());
        if (scope.get(ctx.ID().getText()) != null) {
            System.out.println("error, variable already declared");
        }
        else {
            scope.put(ctx.ID().getText(), scopeLevel + 1);
            varType.put(ctx.ID().getText(), Type.INTEGER);
        }
        return result;
    }

    @Override
    public Object visitBlockStat(MyLanguageParser.BlockStatContext ctx) {
        return visit(ctx.block());
    }

    @Override
    public Object visitBlock(MyLanguageParser.BlockContext ctx) {
        Object result = null;
        scopeLevel++;
        for (MyLanguageParser.StatContext stat : ctx.stat()) {
            result = visit(stat);
        }
        for (String id : scope.keySet()) {
            if (scope.get(id).equals(scopeLevel)) {
                scope.remove(id);
            }
        }
        scopeLevel--;
        return result;
    }

    @Override
    public Object visitNumExpr(MyLanguageParser.NumExprContext ctx) {
        exprType.put(ctx, Type.INTEGER);
        return Integer.parseInt(ctx.getText());
    }
}
