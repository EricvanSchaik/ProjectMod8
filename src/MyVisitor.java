import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
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

    private Map<String, Type> exprType;
    private Map<Scope, Integer> scopes;
    private Map<String, Boolean> locked = new HashMap<>();
    private Scope currentScope;
    private Map<String, Object> registers = new HashMap<>();
    private List<String> instructions = new ArrayList<>();
    private Integer blockLength;
    private Integer threadAmount;

    public static void main(String[] args) {
        MyVisitor visitor = new MyVisitor();
        try {
            System.out.println(visitor.traverse("class test; 5 shared(i); int i = 0; for x in range (2;15;3) {i=i+1;}; print(i);"));
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
        for (int i = scopes.size()-1; i >= 0; i--) {
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

    private int getOffset(String s) {
        for (Scope scope : scopes.keySet()) {
            if (scope.offset(s)!=null) return scope.offset(s);
        }
        return -1;
    }

    @Override
    public Object visitProgram(MyLanguageParser.ProgramContext ctx) {
        System.out.println("visitProgram");
        exprType = new HashMap<>();
        scopes = new HashMap<>();
        currentScope = new Scope(0);
        scopes.put(currentScope, 0);
        Object result = null;
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
            BufferedWriter bw = new BufferedWriter(new FileWriter(prIl, true));
            bw.write("import Sprockell");
            bw.newLine();
            bw.write(className + ":: [Instruction]");
            bw.newLine();
            bw.write(className + "=");
            bw.flush();
            bw.close();
            visitThread(ctx.thread());
            result = visitBody(ctx.body());
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(prIl, true));
            bw2.write("[");
            for (String i : instructions){
                bw2.write(i + ", ");
            }
            bw2.write("EndProg");
            bw2.write("]");
            bw2.newLine();
            bw2.write("main = run [");
            for (int i = 1; i<threadAmount; i++){
                bw2.write(className + ", ");
            }
            bw2.write(className + "]");
            bw2.flush();
            bw2.close();
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe",
                    "/c",
                    "cd \"C:\\Users\\Birte\\IdeaProjects\\ProjectMod8\\src\" && runhaskell ",
                    "progs.hs");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) { break; }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Object visitThread (MyLanguageParser.ThreadContext ctx) {
        if (ctx.NUMBER() != null) {
            threadAmount = Integer.parseInt(ctx.NUMBER().getText());
            currentScope.put("lock", Type.BOOLEAN);
            instructions.add("WriteInstr reg0 (DirAddr " + getOffset("lock") + ")");
        } else { threadAmount = 1;}
        return null;
    }

    @Override
    public Object visitBody(MyLanguageParser.BodyContext ctx) {
        System.out.println("visitBody");
        Object result = null;
        for (MyLanguageParser.StatContext stat : ctx.stat()) {
            result = visit(stat);
        }
        return result;
    }

    @Override
    public Object visitDeclStat(MyLanguageParser.DeclStatContext ctx) {
        System.out.println("visitDeclStat");
        Object result = visit(ctx.expr());
        if (currentScope.contains(ctx.ID().getText())) {
            System.out.println("error, " + ctx.ID().getText() + " already declared in this scope");
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
            String reg = getreg(ctx.expr());
            if (reg != null) {
                int i = getOffset(ctx.ID().toString());
                if (i==-1) System.out.println("error, unknown offset");
                else instructions.add("Store " + reg + " (DirAddr " + i + ")");
                registers.replace(reg, null);
            }
            else {
                System.out.println("3 error, missing expr");
            }
        }
        return result;
    }

    @Override
    public Object visitAssStat(MyLanguageParser.AssStatContext ctx) {
        System.out.println("visitAssStat");
        Object result = visit(ctx.expr());
        if (isDeclared(ctx.ID().getText())) {
            if (!(getType(ctx.ID().getText()) == exprType.get(ctx.expr().getText()))) {
                System.out.println("error, wrong type");
            }
            else {
                String reg = getreg(ctx.expr());
                if (reg != null) {
                    int i = getOffset(ctx.ID().toString());
                    if (i==-1)System.out.println("error, unknown offset");
                    else instructions.add("Store " + reg + " (DirAddr " + getOffset(ctx.ID().toString()) + ")");
                    registers.replace(reg, null);
                }
                else {
                    System.out.println("4 error, missing expr");
                }
            }
        }
        else {
            System.out.println("error, variable not declared(assignment)");
        }
        return result;
    }

    @Override
    public Object visitIfStat(MyLanguageParser.IfStatContext ctx) {
        System.out.println("visitIfStat");
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
        System.out.println("visitWhileStat");
        int iexpr = instructions.size();
        Object result = visit(ctx.expr());
        if (exprType.get(ctx.expr().getText()) == Type.BOOLEAN) {
            String reg = getreg(ctx.expr());
            instructions.add("Compute Equal reg0 " + reg + " " + reg);
            int iblock = instructions.size();
            result = visit(ctx.block());
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
        System.out.println("visitForStat");
        Object result = null;
        if (isDeclared(ctx.ID().getText())) {
            System.out.println("error, variable already declared(forstat)");
        }
        else {
            System.out.println("currentScope newOffset: " + currentScope.newOffset());
            Scope newScope = new Scope(currentScope.newOffset());
            scopes.put(newScope, (scopes.get(currentScope) + 1));
            System.out.println(scopes.values());
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
            instructions.add("Store " + reg + " (DirAddr " + getOffset(ctx.ID().toString()) + ")");
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
        System.out.println("visitBlockStat");
        return visit(ctx.block());
    }

    @Override
    public Object visitBlock(MyLanguageParser.BlockContext ctx) {
        System.out.println("visitBlock");
        Object result = null;
        Scope newScope = new Scope(currentScope.newOffset());
        scopes.put(newScope, (scopes.get(currentScope)+1));
        currentScope = newScope;
        blockLength = instructions.size();
        for (MyLanguageParser.StatContext stat : ctx.stat()) {
            result = visit(stat);
        }
        blockLength = instructions.size() - blockLength;
        Scope previousScope = getPreviousScope();
        scopes.remove(currentScope);
        currentScope = previousScope;
        return result;
    }

    @Override
    public Object visitReadStat(MyLanguageParser.ReadStatContext ctx) {
        System.out.println("visitReadStat");
        if (!isDeclared(ctx.ID().getText())) {
            currentScope.put(ctx.ID().getText(), Type.INTEGER);
            String reg = freereg();
            if (reg != null) {
                instructions.add("ReadInstr numberIO");
                instructions.add("Receive " + reg);
                instructions.add("Store " + reg + " (DirAddr " + getOffset(ctx.ID().toString()) + ")");
                registers.replace(reg, null);
            } else {
                System.out.println("1 error, all registers are in use");
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
        System.out.println("visitPrintStat");
        Object result = visit(ctx.expr());
        String reg = getreg(ctx.expr());
        if (reg!=null) {
            instructions.add("WriteInstr " + reg + " numberIO");
            registers.replace(reg, null);
        }
        return result;
    }

    @Override
    public Object visitLockStat(MyLanguageParser.LockStatContext ctx) {
        System.out.println("visitLockStat");
        String reg = freereg();
        instructions.add("Load (ImmValue (TestAndSet (DirAddr " + getOffset("lock") + "))) " + reg);
        instructions.add("Branch " + reg + " (Rel -1)");
        return visit(ctx.block()); }

    @Override
    public Object visitPrfExpr(MyLanguageParser.PrfExprContext ctx) {
        System.out.println("visitPrfExpr");
        Object result = visit(ctx.expr());
        if (ctx.prfOp().MIN() != null) {
            if (exprType.get(ctx.expr().getText()) == Type.BOOLEAN) {
                System.out.println("error, expected integer, actual boolean");
            }
            else {
                String reg = getreg(ctx.expr());
                instructions.add("Compute Sub reg0 " + reg + reg);
                registers.replace(reg, ctx);
                exprType.put(ctx.getText(), Type.INTEGER);
            }
        } else {
            if (exprType.get(ctx.expr().getText())==Type.INTEGER) {
                System.out.println("error, expected boolean, actual integer");
            }
            else {
                String reg = getreg(ctx.expr());
                instructions.add("Compute Equal reg0 " + reg + reg);
                registers.replace(reg, ctx);
                exprType.put(ctx.getText(), Type.BOOLEAN);
            }
        }
        return result;
    }

    @Override
    public Object visitMultExpr(MyLanguageParser.MultExprContext ctx) {
        System.out.println("visitMultExpr");
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
                System.out.println("5 error, missing expr");
            }
        }
        return result;
    }

    @Override
    public Object visitPlusExpr(MyLanguageParser.PlusExprContext ctx) {
        System.out.println("visitPlusExpr");
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
                System.out.println("6 error, missing expr");
            }
        }
        return result;
    }

    @Override
    public Object visitCompExpr(MyLanguageParser.CompExprContext ctx) {
        System.out.println("visitCompExpr");
        Object result = visit(ctx.expr(0));
        visit(ctx.expr(1));
        if (((ctx.compOp().EQ() != null || ctx.compOp().NE() != null) && (exprType.get(ctx.expr(0).getText()) == exprType.get(ctx.expr(1).getText())))
        || (exprType.get(ctx.expr(0).getText()) == Type.INTEGER && exprType.get(ctx.expr(1).getText()) == Type.INTEGER)){
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
            } else System.out.println("7 error, missing expr");
        } else System.out.println("error, this operation can't be done with this types");
        return result;
    }

    @Override
    public Object visitBoolExpr(MyLanguageParser.BoolExprContext ctx) {
        System.out.println("visitBoolExpr");
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
                System.out.println("1 error, missing expr");
            }
        }
        return result;
    }

    @Override
    public Object visitParExpr(MyLanguageParser.ParExprContext ctx) {
        System.out.println("visitParExpr");
        Object result = visit(ctx.expr());
        exprType.put(ctx.getText(), exprType.get(ctx.expr().getText()));
        String reg = getreg(ctx.expr());
        if (reg != null) {
            registers.replace(reg, ctx);
        } else {
            System.out.println("2 error, missing expr");
        }
        return result;
    }

    @Override
    public Object visitVarExpr(MyLanguageParser.VarExprContext ctx) {
        System.out.println("visitVarExpr");
        if (!(isDeclared(ctx.getText()))) {
            System.out.println("error, variable not declared");
        }
        else {
            exprType.put(ctx.getText(), getType(ctx.getText()));
            String reg = freereg();
            if (reg != null) {
                instructions.add("Load (DirAddr " + getOffset(ctx.getText()) + ") " + reg);
                registers.replace(reg, ctx);
            } else {
                System.out.println(" 2 error, all registers are in use");
            }
        }
        return null;
    }

    @Override
    public Object visitBooleanExpr(MyLanguageParser.BooleanExprContext ctx) {
        System.out.println("visitBooleanExpr");
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
            System.out.println("3 error, all registers are in use");
        }
        return super.visitBooleanExpr(ctx);
    }

    @Override
    public Object visitNumExpr(MyLanguageParser.NumExprContext ctx) {
        System.out.println("visitNumExpr");
        exprType.put(ctx.getText(), Type.INTEGER);
        int value = Integer.parseInt(ctx.getText());
        String reg = freereg();
        if (reg != null){
            instructions.add("Load (ImmValue " + value + ") " + reg);
            registers.replace(reg, ctx);
        } else {
            System.out.println("4 error, all registers are in use");
        }
        return value;
    }
}
