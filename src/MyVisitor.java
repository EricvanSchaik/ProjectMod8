import jdk.nashorn.internal.parser.TokenStream;
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

    private Map<String,Integer> scope = new HashMap<String,Integer>();
    private Map<String,Type> type = new HashMap<String,Type>();
    private Integer scopeLevel = 0;

    public static void main(String[] args) {
        MyVisitor visitor = new MyVisitor();
        try {
            System.out.println(visitor.traverse("class hoi; int x = 0;"));
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
            if (stat instanceof MyLanguageParser.DeclStatContext) {
                 result = visitDeclStat((MyLanguageParser.DeclStatContext) stat);
            }
            if (stat instanceof MyLanguageParser.AssStatContext) {
                result = visitAssStat((MyLanguageParser.AssStatContext) stat);
            }
            if (stat instanceof MyLanguageParser.IfStatContext) {
                result = visitIfStat((MyLanguageParser.IfStatContext) stat);
            }
            if (stat instanceof MyLanguageParser.WhileStatContext) {
                result = visitWhileStat((MyLanguageParser.WhileStatContext) stat);
            }
            if (stat instanceof MyLanguageParser.ForStatContext) {
                result = visitForStat((MyLanguageParser.ForStatContext) stat);
            }
            if (stat instanceof MyLanguageParser.BlockStatContext) {
                result = visitBlockStat((MyLanguageParser.BlockStatContext) stat);
            }
            if (stat instanceof MyLanguageParser.ReadStatContext) {
                result = visitReadStat((MyLanguageParser.ReadStatContext) stat);
            }
            if (stat instanceof MyLanguageParser.PrintStatContext) {
                result = visitPrintStat((MyLanguageParser.PrintStatContext) stat);
            }
        }
        return result;
    }

    @Override
    public Object visitDeclStat(MyLanguageParser.DeclStatContext ctx) {
        scope.put(ctx.ID().toString(), scopeLevel);
        if (ctx.type().BOOLEAN() != null) {
            type.put(ctx.ID().toString(), Type.BOOLEAN);
        }
        else {
            type.put(ctx.ID().toString(), Type.INTEGER);
        }
        return super.visitDeclStat(ctx);
    }

    @Override
    public Object visitAssStat(MyLanguageParser.AssStatContext ctx) {
        return super.visitAssStat(ctx);
    }

    @Override
    public Object visitIfStat(MyLanguageParser.IfStatContext ctx) {
        return super.visitIfStat(ctx);
    }

    @Override
    public Object visitWhileStat(MyLanguageParser.WhileStatContext ctx) {
        return super.visitWhileStat(ctx);
    }

    @Override
    public Object visitForStat(MyLanguageParser.ForStatContext ctx) {
        return super.visitForStat(ctx);
    }

    @Override
    public Object visitBlockStat(MyLanguageParser.BlockStatContext ctx) {
        return super.visitBlockStat(ctx);
    }

    @Override
    public Object visitReadStat(MyLanguageParser.ReadStatContext ctx) {
        return super.visitReadStat(ctx);
    }

    @Override
    public Object visitPrintStat(MyLanguageParser.PrintStatContext ctx) {
        return super.visitPrintStat(ctx);
    }

    @Override
    public Object visitParExpr(MyLanguageParser.ParExprContext ctx) {
        return super.visitParExpr(ctx);
    }

    @Override
    public Object visitVarExpr(MyLanguageParser.VarExprContext ctx) {
        return super.visitVarExpr(ctx);
    }

    @Override
    public Object visitCompExpr(MyLanguageParser.CompExprContext ctx) {
        return super.visitCompExpr(ctx);
    }

    @Override
    public Object visitPrfExpr(MyLanguageParser.PrfExprContext ctx) {
        return super.visitPrfExpr(ctx);
    }

    @Override
    public Object visitBoolExpr(MyLanguageParser.BoolExprContext ctx) {
        return super.visitBoolExpr(ctx);
    }

    @Override
    public Object visitMultExpr(MyLanguageParser.MultExprContext ctx) {
        return super.visitMultExpr(ctx);
    }

    @Override
    public Object visitNumExpr(MyLanguageParser.NumExprContext ctx) {
        return super.visitNumExpr(ctx);
    }

    @Override
    public Object visitPlusExpr(MyLanguageParser.PlusExprContext ctx) {
        return super.visitPlusExpr(ctx);
    }

    @Override
    public Object visitType(MyLanguageParser.TypeContext ctx) {
        return super.visitType(ctx);
    }

    @Override
    public Object visitPrfOp(MyLanguageParser.PrfOpContext ctx) {
        return super.visitPrfOp(ctx);
    }

    @Override
    public Object visitMultOp(MyLanguageParser.MultOpContext ctx) {
        return super.visitMultOp(ctx);
    }

    @Override
    public Object visitPlusOp(MyLanguageParser.PlusOpContext ctx) {
        return super.visitPlusOp(ctx);
    }

    @Override
    public Object visitBoolOp(MyLanguageParser.BoolOpContext ctx) {
        return super.visitBoolOp(ctx);
    }

    @Override
    public Object visitCompOp(MyLanguageParser.CompOpContext ctx) {
        return super.visitCompOp(ctx);
    }
}