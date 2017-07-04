import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Birte on 27-6-2017.
 */
public class MyVisitor extends MyLanguageBaseVisitor {

    private Map<String, Integer> scope = new HashMap<>();
    private Map<String, Type> exprType = new HashMap<>();
    private Map<Scope, Integer> scopes = new HashMap<>();
    private Scope currentScope = new Scope(0);
    private Map<String, Object> registers = new HashMap<>();
    private Integer scopeLevel = 0;
    private List<String> instructions = new ArrayList<>();
    private Integer blockLength;

    public static void main(String[] args) {
        MyVisitor visitor = new MyVisitor();
        try {
            System.out.println(visitor.traverse("class hoihoi; int i = 0; for x in range (2;10;3) {i=i+1;}; print(i);"));
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

    private String freereg(){
        for (String key : registers.keySet()) {
            if (registers.get(key) == null){
                return key;
            }
        }
        return null;
    }

    private String getreg(Object expr) {
        for (String key : registers.keySet()){
            if (registers.get(key) == expr){
                return key;
            }
        }
        return null;
    }

    private int offset(String s) {
        return 0;
    }

    @Override
    public Object visitProgram(MyLanguageParser.ProgramContext ctx) {
        String className = ctx.ID().toString();
        String[] reg = {"regA", "regB", "regC", "regD", "regE", "regF"};
        for (String register : reg){
            registers.put(register, null);
        }
        try {
            File prIl = new File("C:\\Users\\Birte\\IdeaProjects\\ProjectMod8\\src\\progs.hs");
            if (!prIl.createNewFile()){
                Path path = Paths.get(("C:\\Users\\Birte\\IdeaProjects\\ProjectMod8\\src\\progs.hs"));
                Files.delete(path);
            }
            FileWriter fw = new FileWriter(prIl, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("import Sprockell");
            bw.newLine();
            bw.write(className + ":: [Instruction]");
            bw.newLine();
            bw.write(className + "=");
            bw.newLine();
            bw.newLine();
            bw.flush();
            bw.close();
            visitBody(ctx.body());
            instructions.add("EndProg");
            FileWriter fw2 = new FileWriter(prIl, true);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            bw2.write("[");
            for (String i : instructions){
                bw2.write(i);
                bw2.newLine();
            }
            bw2.write("]");
            bw2.newLine();
            bw2.write("main = run [" + className + "]");
            bw2.flush();
            bw2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            String reg = getreg(ctx.expr());
            if (reg != null) {
                instructions.add("Store " + reg + " (DirAddr " + offset(ctx.ID().toString()) + ")");
                registers.replace(reg, null);
            }
            else {
                System.out.println("error, missing expr");
            }
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
            else {
                String reg = getreg(ctx.expr());
                if (reg != null) {
                    instructions.add("Store " + reg + " (DirAddr " + offset(ctx.ID().toString()) + ")");
                    registers.replace(reg, null);
                }
                else {
                    System.out.println("error, missing expr");
                }
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
            String reg = getreg(ctx.expr());
            instructions.add("Compute Equal reg0 " + reg + " " + reg);
            int iblock = instructions.size();
            result = visit(ctx.block(0));
            instructions.add(iblock, "Branch " + reg + " (Rel " + (blockLength+2) + ")");
            iblock = instructions.size();
            if (ctx.block(1) != null) {
                visit(ctx.block(1));
            }
            instructions.add(iblock, "Jump (Rel " + (blockLength+1) + ")");
            registers.replace(reg, null);
        }
        else {
            System.out.println("error, wrong condition");
        }
        return result;
    }

    @Override
    public Object visitWhileStat(MyLanguageParser.WhileStatContext ctx) {
        int iexpr = instructions.size();
        Object result = visit(ctx.expr());
        if (exprType.get(ctx.expr().getText()) == Type.BOOLEAN) {
            String reg = getreg(ctx.expr());
            instructions.add("Compute Equal reg0 " + reg + " " + reg);
            int iblock = instructions.size();
            result = visit(ctx.block());
            System.out.println(blockLength);
            instructions.add(iblock, "Branch " + reg + " (Rel " + (blockLength+2) + ")"); //length block + jump
            instructions.add("Jump (Abs " + iexpr + ")");
            registers.replace(reg, null);
        }
        else {
            System.out.println("error, wrong condition");
        }
        return result;
    }

    @Override
    public Object visitForStat(MyLanguageParser.ForStatContext ctx) {
        Object result = null;
        if (isDeclared(ctx.ID().getText())) {
            System.out.println("error, variable already declared");
        }
        else {
            Scope newScope = new Scope(currentScope.newOffset());
            scopes.put(newScope, scopes.get(currentScope) + 1);
            currentScope = newScope;
            currentScope.put(ctx.ID().getText(), Type.INTEGER);
            String reg = freereg();
            registers.replace(reg, ctx.NUMBER(0));
            String reg1 = freereg();
            registers.replace(reg1, ctx.NUMBER(1));
            String reg2 = freereg();
            registers.replace(reg2, ctx.NUMBER(2));
            String regbool = freereg();
            registers.replace(regbool, ctx);
            instructions.add("Load (ImmValue " + ctx.NUMBER(0) + ") " + reg);
            instructions.add("Load (ImmValue " + ctx.NUMBER(1) + ") " + reg1);
            instructions.add("Load (ImmValue " + ctx.NUMBER(2) + ") " + reg2);
            instructions.add("Compute LtE " + reg + " " + reg1 + " " + regbool);
            instructions.add("Compute Equal reg0 " + regbool + " " + regbool);
            int i = instructions.size();
            instructions.add("Store " + reg + " (DirAddr " + offset(ctx.ID().toString()) + ")");
            result = visit(ctx.block());
            instructions.add(i, "Branch " + regbool + " (Rel " + (blockLength + 4) + ")");
            instructions.add("Compute Add " + reg + " " + reg2 + " " + reg);
            instructions.add("Jump (Abs " + (i - 2) + ")");
            registers.replace(reg, null);
            registers.replace(reg1, null);
            registers.replace(reg2, null);
            registers.replace(regbool, null);
        }
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
        Scope newScope = new Scope(currentScope.newOffset());
        scopes.put(newScope, scopes.get(currentScope)+1);
        currentScope = newScope;
        blockLength = instructions.size();
        for (MyLanguageParser.StatContext stat : ctx.stat()) {
            result = visit(stat);
        }
        Scope previousScope = getPreviousScope();
        scopes.remove(currentScope);
        currentScope = previousScope;
        blockLength = instructions.size() - blockLength;
        return result;
    }

    @Override
    public Object visitReadStat(MyLanguageParser.ReadStatContext ctx) {
        if (!isDeclared(ctx.ID().getText())) {
            currentScope.put(ctx.ID().getText(), Type.INTEGER);
            currentScope.put(ctx.ID().getText(), Type.INTEGER);
            String reg = freereg();
            if (reg != null) {
                instructions.add("ReadInstr numberIO");
                instructions.add("Receive " + reg);
                instructions.add("Store " + reg + " (DirAddr " + offset(ctx.ID().toString()) + ")");
                registers.replace(reg, null);
            } else {
                System.out.println("error, all registers are in use");
            }
        }
        else {
            if (getType(ctx.ID().getText()) != Type.INTEGER) {
                System.out.println("error, wrong variable type");
            }
        }
        return super.visitReadStat(ctx);
    }

    @Override
    public Object visitPrintStat (MyLanguageParser.PrintStatContext ctx) {
        visit(ctx.expr());
        String reg = getreg(ctx.expr());
        instructions.add("WriteInstr " + reg + " numberIO");
        return null;
    }

    @Override
    public Object visitPrfExpr(MyLanguageParser.PrfExprContext ctx) {
        exprType.put(ctx.getText(), exprType.get(ctx.expr().getText()));
        String reg = getreg(ctx.expr());
        if (ctx.prfOp().MIN()!=null){
            instructions.add("Compute Sub reg0 " + reg + reg);
        }
        else {
            instructions.add("Compute Equal reg0 " + reg + reg);
        }
        registers.replace(reg, ctx);
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
            String reg1 = getreg(ctx.expr(0));
            String reg2 = getreg(ctx.expr(1));
            if ((reg1 != null) && (reg2 != null)) {
                if (ctx.multOp().TIMES()!=null){
                    instructions.add("Compute Mul " + reg1 + " " + reg2 + " " + reg1);
                } else {
                    instructions.add("Compute Add " + reg1 + " " + reg2 + " " + reg1);
                }
                registers.replace(reg1, ctx);
                registers.replace(reg2, null);
            } else {
                System.out.println("error, missing expr");
            }
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
            String reg1 = getreg(ctx.expr(0));
            String reg2 = getreg(ctx.expr(1));
            if ((reg1 != null) && (reg2 != null)) {
                if (ctx.plusOp().MIN()!=null){
                    instructions.add("Compute Sub " + reg1 + " " + reg2 + " " + reg1);
                } else {
                    instructions.add("Compute Add " + reg1 + " " + reg2 + " " + reg1);
                }
                registers.replace(reg1, ctx);
                registers.replace(reg2, null);
            } else {
                System.out.println("error, missing expr");
            }
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
            String reg1 = getreg(ctx.expr(0));
            String reg2 = getreg(ctx.expr(1));
            if ((reg1 != null) && (reg2 != null)){
                if (ctx.compOp().LE()!=null){
                    instructions.add("Compute LtE " + reg1 + " " + reg2 + " " + reg1);
                } else if (ctx.compOp().LT()!=null){
                    instructions.add("Compute Lt " + reg1 + " " + reg2 + " " + reg1);
                } else if (ctx.compOp().GE()!=null){
                    instructions.add("Compute GtE " + reg1 + " " + reg2 + " " + reg1);
                } else if (ctx.compOp().GT()!=null){
                    instructions.add("Compute Gt " + reg1 + " " + reg2 + " " + reg1);
                } else if (ctx.compOp().EQ()!=null){
                    instructions.add("Compute Equal " + reg1 + " " + reg2 + " " + reg1);
                } else {
                    instructions.add("Compute NEq " + reg1 + " " + reg2 + " " + reg1);
                }
                registers.replace(reg1, ctx);
                registers.replace(reg2, null);
            }
            else {
                System.out.println("error, missing expr");
            }
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
            String reg1 = getreg(ctx.expr(0));
            String reg2 = getreg(ctx.expr(1));
            if ((reg1 != null) && (reg2 != null)){
                if (ctx.boolOp().AND()!=null){
                    instructions.add("Compute And " + reg1 + " " + reg2 + " " + reg1);
                }
                else {
                    instructions.add("Compute Or " + reg1 + " " + reg2 + " " + reg1);
                }
                registers.replace(reg1, ctx);
                registers.replace(reg2, null);
            }
            else {
                System.out.println("error, missing expr");
            }
        }
        return result;
    }

    @Override
    public Object visitParExpr(MyLanguageParser.ParExprContext ctx) {
        Object result = visit(ctx.expr());
        exprType.put(ctx.getText(), exprType.get(ctx.expr().getText()));
        String reg = getreg(ctx.expr());
        if (reg != null) {
            registers.replace(reg, ctx);
        } else {
            System.out.println("error, missing expr");
        }
        return result;
    }

    @Override
    public Object visitVarExpr(MyLanguageParser.VarExprContext ctx) {
        if (!(scope.containsKey(ctx.getText()))) {
            System.out.println("error, variable not declared");
        }
        else {
            exprType.put(ctx.getText(), getType(ctx.getText()));
            String reg = freereg();
            if (reg != null) {
                instructions.add("Load (DirAddr " + offset(ctx.getText()) + ") " + reg);
                registers.replace(reg, ctx);
            } else {
                System.out.println("error, all registers are in use");
            }
        }
        return super.visitVarExpr(ctx);
    }

    @Override
    public Object visitBooleanExpr(MyLanguageParser.BooleanExprContext ctx) {
        exprType.put(ctx.getText(), Type.BOOLEAN);
        String reg = freereg();
        if (reg != null) {
            if (ctx.getText().equals("true")) {
                instructions.add("Load (ImmValue 1) " + reg);
            } else {
                instructions.add("Load (ImmValue 0) " + reg);
            }
            registers.replace(reg, ctx);
        } else {
            System.out.println("error, all registers are in use");
        }
        return super.visitBooleanExpr(ctx);
    }

    @Override
    public Object visitNumExpr(MyLanguageParser.NumExprContext ctx) {
        exprType.put(ctx.getText(), Type.INTEGER);
        int value = Integer.parseInt(ctx.getText());
        String reg = freereg();
        if (reg != null){
            instructions.add("Load (ImmValue " + value + ") " + reg);
            registers.replace(reg, ctx);
        } else {
            System.out.println("error, all registers are in use");
        }
        return value;
    }
}
