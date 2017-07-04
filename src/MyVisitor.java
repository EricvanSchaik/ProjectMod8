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
    private Map<String, Type> exprType = new HashMap<>();
    private Map<Scope, Integer> scopes = new HashMap<>();
    private Scope currentScope = new Scope(0);

    public static void main(String[] args) {
        MyVisitor visitor = new MyVisitor();
        try {
            System.out.println(visitor.traverse("class hoi; int i = 0; while ( i < 3 ) { i = i + 1; };"));
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
        Object result = visit(tree);
        System.out.println(scope.toString());
        System.out.println(exprType.toString());
        return result;
    }

    public boolean isDeclared(String id) {
        for (Scope scope : scopes.keySet()) {
            if (scope.contains(id)) return true;
        }
        return false;
    }

    public Scope getPreviousScope() {
        for (Scope scope : scopes.keySet()) {
            if (scopes.get(scope) == scopes.get(currentScope)-1) {
                return scope;
            }
        }
        return null;
    }

    public Type getType(String id) {
        for (int i = scopes.size()-1; i > 0; i--) {
            Scope scope = null;
            for (Scope s : scopes.keySet()) {
                if (scopes.get(s) == i) {
                    scope = s;
                }
            }
            if (scope.getType(id) != null) {
                return scope.getType(id);
            }
        }
        return null;
    }

    @Override
    public Object visitProgram(MyLanguageParser.ProgramContext ctx) {
        scopes.put(currentScope, 0);
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
        if (currentScope.contains(ctx.ID().getText())) {
            System.out.println("error, already declared in this scope");
        }
        else {
            if (ctx.type().getText().equals("int") && exprType.get(ctx.expr().getText()) == Type.INTEGER) {
                currentScope.put(ctx.ID().getText(), Type.INTEGER);
            }
            else if (exprType.get(ctx.expr().getText()) == Type.BOOLEAN) {
                currentScope.put(ctx.ID().getText(), Type.BOOLEAN);
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
        if (isDeclared(ctx.ID().getText())) {
            if (!(getType(ctx.ID().getText()) == exprType.get(ctx.expr().getText()))) {
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
        if (exprType.get(ctx.expr().getText()) == Type.BOOLEAN) {
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
        if (exprType.get(ctx.expr().getText()) == Type.BOOLEAN) {
            result = visit(ctx.block());
        }
        else {
            System.out.println("error, wrong condition");
        }
        return result;
    }

    @Override
    public Object visitForStat(MyLanguageParser.ForStatContext ctx) {
        if (isDeclared(ctx.ID().getText())) {
            System.out.println("error, variable already declared");
        }
        else {
            Scope newScope = new Scope(currentScope.newOffset());
            scopes.put(newScope, scopes.get(currentScope)+1);
            currentScope = newScope;
//            scope.put(ctx.ID().getText(), scopeLevel + 1);
            currentScope.put(ctx.ID().getText(), Type.INTEGER);
        }
        Object result = visit(ctx.block());
        Scope previousScope = getPreviousScope();
        scopes.remove(currentScope);
        currentScope = previousScope;
        return result;
    }

    @Override
    public Object visitBlockStat(MyLanguageParser.BlockStatContext ctx) {
        return visit(ctx.block());
    }

    @Override
    public Object visitBlock(MyLanguageParser.BlockContext ctx) {
        Object result = null;
//        scopeLevel++;
        Scope newScope = new Scope(currentScope.newOffset());
        scopes.put(newScope, scopes.get(currentScope)+1);
        currentScope = newScope;
        for (MyLanguageParser.StatContext stat : ctx.stat()) {
            result = visit(stat);
        }
        Scope previousScope = getPreviousScope();
        scopes.remove(currentScope);
        currentScope = previousScope;
//        for (String id : scope.keySet()) {
//            if (scope.get(id).equals(scopeLevel)) {
//                scope.remove(id);
//            }
//        }
//        scopeLevel--;
        return result;
    }

    @Override
    public Object visitReadStat(MyLanguageParser.ReadStatContext ctx) {
        if (!isDeclared(ctx.ID().getText())) {
            currentScope.put(ctx.ID().getText(), Type.INTEGER);
            currentScope.put(ctx.ID().getText(), Type.INTEGER);
        }
        else {
            if (getType(ctx.ID().getText()) != Type.INTEGER) {
                System.out.println("error, wrong variable type");
            }
        }
        return super.visitReadStat(ctx);
    }

    @Override
    public Object visitPrfExpr(MyLanguageParser.PrfExprContext ctx) {
        exprType.put(ctx.getText(), exprType.get(ctx.expr().getText()));
        return visit(ctx.expr());
    }

    @Override
    public Object visitMultExpr(MyLanguageParser.MultExprContext ctx) {
        Object result = visit(ctx.expr(0));
        visit(ctx.expr(1));
        if (!(exprType.get(ctx.expr(0).getText()) == Type.INTEGER && exprType.get(ctx.expr(1).getText()) == Type.INTEGER)) {
            System.out.println("error, multiplication needs integers");
        }
        else {
            exprType.put(ctx.getText(), Type.INTEGER);
        }
        return result;
    }

    @Override
    public Object visitPlusExpr(MyLanguageParser.PlusExprContext ctx) {
        Object result = visit(ctx.expr(0));
        visit(ctx.expr(1));
        if (!(exprType.get(ctx.expr(0).getText()) == Type.INTEGER && exprType.get(ctx.expr(1).getText()) == Type.INTEGER)) {
            System.out.println("error, addition needs integers");
        }
        else {
            exprType.put(ctx.getText(), Type.INTEGER);
        }
        return result;
    }

    @Override
    public Object visitCompExpr(MyLanguageParser.CompExprContext ctx) {
        Object result = visit(ctx.expr(0));
        visit(ctx.expr(1));
        if (!(exprType.get(ctx.expr(0).getText()) == Type.INTEGER && exprType.get(ctx.expr(1).getText()) == Type.INTEGER)) {
            System.out.println("error, comparison needs integers");
        }
        else {
            exprType.put(ctx.getText(), Type.BOOLEAN);
        }
        return result;
    }

    @Override
    public Object visitBoolExpr(MyLanguageParser.BoolExprContext ctx) {
        Object result = visit(ctx.expr(0));
        visit(ctx.expr(1));
        if (!(exprType.get(ctx.expr(0).getText()) == Type.BOOLEAN && exprType.get(ctx.expr(1).getText()) == Type.BOOLEAN)) {
            System.out.println("error, operator needs booleans");
        }
        else {
            exprType.put(ctx.getText(), Type.BOOLEAN);
        }
        return result;
    }

    @Override
    public Object visitParExpr(MyLanguageParser.ParExprContext ctx) {
        Object result = visit(ctx.expr());
        exprType.put(ctx.getText(), exprType.get(ctx.expr().getText()));
        return result;
    }

    @Override
    public Object visitVarExpr(MyLanguageParser.VarExprContext ctx) {
        if (!(scope.containsKey(ctx.getText()))) {
            System.out.println("error, variable not declared");
        }
        else {
            exprType.put(ctx.getText(), getType(ctx.getText()));
        }
        return super.visitVarExpr(ctx);
    }

    @Override
    public Object visitBooleanExpr(MyLanguageParser.BooleanExprContext ctx) {
        exprType.put(ctx.getText(), Type.BOOLEAN);
        return super.visitBooleanExpr(ctx);
    }

    @Override
    public Object visitNumExpr(MyLanguageParser.NumExprContext ctx) {
        exprType.put(ctx.getText(), Type.INTEGER);
        return Integer.parseInt(ctx.getText());
    }
}
