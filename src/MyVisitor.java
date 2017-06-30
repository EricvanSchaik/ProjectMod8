import jdk.nashorn.internal.parser.TokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Birte on 27-6-2017.
 */
public class MyVisitor extends MyLanguageBaseVisitor {

    private Map<String,Integer> scope = new HashMap<String,Integer>();
    private Map<String, MyLanguageParser.TypeContext> type = new HashMap<String,MyLanguageParser.TypeContext>();
    private Integer scopeLevel = 0;

    public static void main(String[] args) {
        MyVisitor visitor = new MyVisitor();
        try {
            System.out.println(visitor.traverse("class hoi; int x = 0; boolean x = 0;"));
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

    public Object instanceStat(MyLanguageParser.StatContext stat) {
        if (stat instanceof MyLanguageParser.DeclStatContext) {
            return visitDeclStat((MyLanguageParser.DeclStatContext) stat);
        }
        if (stat instanceof MyLanguageParser.AssStatContext) {
            return visitAssStat((MyLanguageParser.AssStatContext) stat);
        }
        if (stat instanceof MyLanguageParser.IfStatContext) {
            return visitIfStat((MyLanguageParser.IfStatContext) stat);
        }
        if (stat instanceof MyLanguageParser.WhileStatContext) {
            return visitWhileStat((MyLanguageParser.WhileStatContext) stat);
        }
        if (stat instanceof MyLanguageParser.ForStatContext) {
            return visitForStat((MyLanguageParser.ForStatContext) stat);
        }
        if (stat instanceof MyLanguageParser.BlockStatContext) {
            return visitBlockStat((MyLanguageParser.BlockStatContext) stat);
        }
        if (stat instanceof MyLanguageParser.ReadStatContext) {
            return visitReadStat((MyLanguageParser.ReadStatContext) stat);
        }
        else { //(stat instanceof MyLanguageParser.PrintStatContext)
            return visitPrintStat((MyLanguageParser.PrintStatContext) stat);
        }
    }

    public Object instanceExpr (MyLanguageParser.ExprContext expr) {
        if (expr instanceof MyLanguageParser.ParExprContext){
            return visitParExpr((MyLanguageParser.ParExprContext) expr);
        }
        if (expr instanceof MyLanguageParser.VarExprContext){
            return visitVarExpr((MyLanguageParser.VarExprContext) expr);
        }
        if (expr instanceof MyLanguageParser.CompExprContext){
            return visitCompExpr((MyLanguageParser.CompExprContext) expr);
        }
        if (expr instanceof MyLanguageParser.PrfExprContext){
            return visitPrfExpr((MyLanguageParser.PrfExprContext) expr);
        }
        if (expr instanceof MyLanguageParser.BoolExprContext){
            return visitBoolExpr((MyLanguageParser.BoolExprContext) expr);
        }
        if (expr instanceof MyLanguageParser.MultExprContext){
            return visitMultExpr((MyLanguageParser.MultExprContext) expr);
        }
        if (expr instanceof MyLanguageParser.NumExprContext){
            return visitNumExpr((MyLanguageParser.NumExprContext) expr);
        }
        else { //(expr instanceof MyLanguageParser.PlusExprContext)
            return visitPlusExpr((MyLanguageParser.PlusExprContext) expr);
        }
    }

    @Override
    public Object visitProgram(MyLanguageParser.ProgramContext ctx) {
        String className = ctx.ID().toString();
        try {
            File prIl = new File("C:\\Users\\Birte\\IdeaProjects\\ProjectMod8\\src\\" + className + ".hs");
            if (prIl.createNewFile()){
                System.out.println("File is created!");
                FileWriter fw = new FileWriter(prIl, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Some text here for a reason");
                bw.flush();
                bw.close();
                fw = new FileWriter(prIl, true);
                BufferedWriter bw2 = new BufferedWriter(fw);
                bw2.newLine();
                bw2.write("kldjfa");
                bw2.flush();
                bw2.close();
            }else{
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return visitBody(ctx.body());
    }

    @Override
    public Object visitBody(MyLanguageParser.BodyContext ctx) {
        Object result = null;
        for (MyLanguageParser.StatContext stat : ctx.stat()) {
            result = instanceStat(stat);
        }
        return result;
    }

    @Override
    public Object visitDeclStat(MyLanguageParser.DeclStatContext ctx) {
        if (scope.containsKey(ctx.ID().toString())) {
            System.out.println("error, duplicate declaration");
        }
        else {
            scope.put(ctx.ID().toString(), scopeLevel);
        }
        Object exprType = instanceExpr(ctx.expr());
        if (ctx.type() == exprType) {
            type.put(ctx.ID().toString(), ctx.type());
        }
        else {
            System.out.println("error, expected: " + ctx.type() + ", actual: " + exprType);
        }
        return null;
    }

    @Override
    public Object visitAssStat(MyLanguageParser.AssStatContext ctx) {
        if (scope.containsKey(ctx.ID())) {
            MyLanguageParser.ExprContext expr = ctx.expr();
            Object type;
        }
        if (type.get(ctx.ID())!=type) {
            System.out.println("error, expected: " + type.get(ctx.ID()) + "actual: " + type);
        }
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
        MyLanguageParser.ExprContext expr = ctx.expr();
        Object type;
        if (expr instanceof MyLanguageParser.ParExprContext) {
            type = visitParExpr((MyLanguageParser.ParExprContext) expr);
        }
        if (expr instanceof MyLanguageParser.VarExprContext) {
            type = visitVarExpr((MyLanguageParser.VarExprContext) expr);
        }
        if (expr instanceof MyLanguageParser.CompExprContext) {
            type = visitCompExpr((MyLanguageParser.CompExprContext) expr);
        }
        if (expr instanceof MyLanguageParser.PrfExprContext) {
            type = visitPrfExpr((MyLanguageParser.PrfExprContext) expr);
        }
        if (expr instanceof MyLanguageParser.BoolExprContext) {
            type = visitBoolExpr((MyLanguageParser.BoolExprContext) expr);
        }
        if (expr instanceof MyLanguageParser.MultExprContext) {
            type = visitMultExpr((MyLanguageParser.MultExprContext) expr);
        }
        if (expr instanceof MyLanguageParser.NumExprContext) {
            type = visitNumExpr((MyLanguageParser.NumExprContext) expr);
        }
        else {// (expr instanceof MyLanguageParser.PlusExprContext) {
            type = visitPlusExpr((MyLanguageParser.PlusExprContext) expr);
        }
        return type;
    }

    @Override
    public Object visitVarExpr(MyLanguageParser.VarExprContext ctx) {
        if (type.containsKey(ctx.ID())){
            return type.get(ctx.ID());
        }
        else {
            System.out.println("error, variable not in scope");
        }
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
