// Generated from C:/Users/Birte/IdeaProjects/ProjectMod8/src\MyLanguage.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyLanguageParser}.
 */
public interface MyLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MyLanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MyLanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(MyLanguageParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(MyLanguageParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declStat}
	 * labeled alternative in {@link MyLanguageParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDeclStat(MyLanguageParser.DeclStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declStat}
	 * labeled alternative in {@link MyLanguageParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDeclStat(MyLanguageParser.DeclStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assStat}
	 * labeled alternative in {@link MyLanguageParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssStat(MyLanguageParser.AssStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assStat}
	 * labeled alternative in {@link MyLanguageParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssStat(MyLanguageParser.AssStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MyLanguageParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(MyLanguageParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MyLanguageParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(MyLanguageParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MyLanguageParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(MyLanguageParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MyLanguageParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(MyLanguageParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MyLanguageParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterForStat(MyLanguageParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MyLanguageParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitForStat(MyLanguageParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link MyLanguageParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(MyLanguageParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link MyLanguageParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(MyLanguageParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code readStat}
	 * labeled alternative in {@link MyLanguageParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterReadStat(MyLanguageParser.ReadStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code readStat}
	 * labeled alternative in {@link MyLanguageParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitReadStat(MyLanguageParser.ReadStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link MyLanguageParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(MyLanguageParser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link MyLanguageParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(MyLanguageParser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link MyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(MyLanguageParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link MyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(MyLanguageParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link MyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(MyLanguageParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link MyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(MyLanguageParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link MyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(MyLanguageParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link MyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(MyLanguageParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prfExpr}
	 * labeled alternative in {@link MyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrfExpr(MyLanguageParser.PrfExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prfExpr}
	 * labeled alternative in {@link MyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrfExpr(MyLanguageParser.PrfExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link MyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(MyLanguageParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link MyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(MyLanguageParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link MyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(MyLanguageParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link MyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(MyLanguageParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link MyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumExpr(MyLanguageParser.NumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link MyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumExpr(MyLanguageParser.NumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link MyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlusExpr(MyLanguageParser.PlusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link MyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlusExpr(MyLanguageParser.PlusExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MyLanguageParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MyLanguageParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#prfOp}.
	 * @param ctx the parse tree
	 */
	void enterPrfOp(MyLanguageParser.PrfOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#prfOp}.
	 * @param ctx the parse tree
	 */
	void exitPrfOp(MyLanguageParser.PrfOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#multOp}.
	 * @param ctx the parse tree
	 */
	void enterMultOp(MyLanguageParser.MultOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#multOp}.
	 * @param ctx the parse tree
	 */
	void exitMultOp(MyLanguageParser.MultOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#plusOp}.
	 * @param ctx the parse tree
	 */
	void enterPlusOp(MyLanguageParser.PlusOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#plusOp}.
	 * @param ctx the parse tree
	 */
	void exitPlusOp(MyLanguageParser.PlusOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void enterBoolOp(MyLanguageParser.BoolOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void exitBoolOp(MyLanguageParser.BoolOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(MyLanguageParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(MyLanguageParser.CompOpContext ctx);
}