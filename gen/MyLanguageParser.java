// Generated from C:/Users/Eric/IdeaProjects/ProjectMod8/src\MyLanguage.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOOL=1, BOOLEAN=2, INTEGER=3, TRUE=4, FALSE=5, CLASS=6, IF=7, ELSE=8, 
		FOR=9, IN=10, RANGE=11, WHILE=12, READ=13, PRINT=14, NUMBER=15, ID=16, 
		CHAR=17, MIN=18, PLUS=19, NOT=20, TIMES=21, DIV=22, LT=23, LE=24, GT=25, 
		GE=26, EQ=27, NE=28, AND=29, OR=30, IS=31, LEFT=32, RIGHT=33, LPAR=34, 
		RPAR=35, SEMI=36, WS=37;
	public static final int
		RULE_program = 0, RULE_body = 1, RULE_stat = 2, RULE_block = 3, RULE_expr = 4, 
		RULE_type = 5, RULE_prfOp = 6, RULE_multOp = 7, RULE_plusOp = 8, RULE_boolOp = 9, 
		RULE_compOp = 10;
	public static final String[] ruleNames = {
		"program", "body", "stat", "block", "expr", "type", "prfOp", "multOp", 
		"plusOp", "boolOp", "compOp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'boolean'", "'int'", "'true'", "'false'", "'class'", "'if'", 
		"'else'", "'for'", "'in'", "'range'", "'while'", "'read'", "'print'", 
		null, null, null, "'-'", "'+'", "'!'", "'*'", "'/'", "'<'", "'<='", "'>'", 
		"'>='", "'=='", "'!='", "'&&'", "'||'", "'='", "'('", "')'", "'{'", "'}'", 
		"';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BOOL", "BOOLEAN", "INTEGER", "TRUE", "FALSE", "CLASS", "IF", "ELSE", 
		"FOR", "IN", "RANGE", "WHILE", "READ", "PRINT", "NUMBER", "ID", "CHAR", 
		"MIN", "PLUS", "NOT", "TIMES", "DIV", "LT", "LE", "GT", "GE", "EQ", "NE", 
		"AND", "OR", "IS", "LEFT", "RIGHT", "LPAR", "RPAR", "SEMI", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MyLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MyLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(MyLanguageParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(MyLanguageParser.SEMI, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(CLASS);
			setState(23);
			match(ID);
			setState(24);
			match(SEMI);
			setState(25);
			body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MyLanguageParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MyLanguageParser.SEMI, i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(27);
				stat();
				setState(28);
				match(SEMI);
				}
				}
				setState(32); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INTEGER) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << READ) | (1L << PRINT) | (1L << ID) | (1L << LPAR))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssStatContext extends StatContext {
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public TerminalNode IS() { return getToken(MyLanguageParser.IS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterAssStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitAssStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitAssStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStatContext extends StatContext {
		public TerminalNode IF() { return getToken(MyLanguageParser.IF, 0); }
		public TerminalNode LEFT() { return getToken(MyLanguageParser.LEFT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT() { return getToken(MyLanguageParser.RIGHT, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MyLanguageParser.ELSE, 0); }
		public IfStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReadStatContext extends StatContext {
		public TerminalNode READ() { return getToken(MyLanguageParser.READ, 0); }
		public TerminalNode LEFT() { return getToken(MyLanguageParser.LEFT, 0); }
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public TerminalNode RIGHT() { return getToken(MyLanguageParser.RIGHT, 0); }
		public ReadStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterReadStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitReadStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitReadStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStatContext extends StatContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterBlockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitBlockStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitBlockStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintStatContext extends StatContext {
		public TerminalNode PRINT() { return getToken(MyLanguageParser.PRINT, 0); }
		public TerminalNode LEFT() { return getToken(MyLanguageParser.LEFT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT() { return getToken(MyLanguageParser.RIGHT, 0); }
		public PrintStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterPrintStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitPrintStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitPrintStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclStatContext extends StatContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public TerminalNode IS() { return getToken(MyLanguageParser.IS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterDeclStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitDeclStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitDeclStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForStatContext extends StatContext {
		public TerminalNode FOR() { return getToken(MyLanguageParser.FOR, 0); }
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public TerminalNode IN() { return getToken(MyLanguageParser.IN, 0); }
		public TerminalNode RANGE() { return getToken(MyLanguageParser.RANGE, 0); }
		public TerminalNode LEFT() { return getToken(MyLanguageParser.LEFT, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(MyLanguageParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(MyLanguageParser.NUMBER, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MyLanguageParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MyLanguageParser.SEMI, i);
		}
		public TerminalNode RIGHT() { return getToken(MyLanguageParser.RIGHT, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterForStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitForStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitForStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStatContext extends StatContext {
		public TerminalNode WHILE() { return getToken(MyLanguageParser.WHILE, 0); }
		public TerminalNode LEFT() { return getToken(MyLanguageParser.LEFT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT() { return getToken(MyLanguageParser.RIGHT, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		int _la;
		try {
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case INTEGER:
				_localctx = new DeclStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				type();
				setState(35);
				match(ID);
				setState(36);
				match(IS);
				setState(37);
				expr(0);
				}
				break;
			case ID:
				_localctx = new AssStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				match(ID);
				setState(40);
				match(IS);
				setState(41);
				expr(0);
				}
				break;
			case IF:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				match(IF);
				setState(43);
				match(LEFT);
				setState(44);
				expr(0);
				setState(45);
				match(RIGHT);
				setState(46);
				block();
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(47);
					match(ELSE);
					setState(48);
					block();
					}
				}

				}
				break;
			case WHILE:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(51);
				match(WHILE);
				setState(52);
				match(LEFT);
				setState(53);
				expr(0);
				setState(54);
				match(RIGHT);
				setState(55);
				block();
				}
				break;
			case FOR:
				_localctx = new ForStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(57);
				match(FOR);
				setState(58);
				match(ID);
				setState(59);
				match(IN);
				setState(60);
				match(RANGE);
				setState(61);
				match(LEFT);
				setState(62);
				match(NUMBER);
				setState(63);
				match(SEMI);
				setState(64);
				match(NUMBER);
				setState(65);
				match(SEMI);
				setState(66);
				match(NUMBER);
				setState(67);
				match(RIGHT);
				setState(68);
				block();
				}
				break;
			case LPAR:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(69);
				block();
				}
				break;
			case READ:
				_localctx = new ReadStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(70);
				match(READ);
				setState(71);
				match(LEFT);
				setState(72);
				match(ID);
				setState(73);
				match(RIGHT);
				}
				break;
			case PRINT:
				_localctx = new PrintStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(74);
				match(PRINT);
				setState(75);
				match(LEFT);
				setState(76);
				expr(0);
				setState(77);
				match(RIGHT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(MyLanguageParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(MyLanguageParser.RPAR, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MyLanguageParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MyLanguageParser.SEMI, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(LPAR);
			setState(85); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(82);
				stat();
				setState(83);
				match(SEMI);
				}
				}
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INTEGER) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << READ) | (1L << PRINT) | (1L << ID) | (1L << LPAR))) != 0) );
			setState(89);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParExprContext extends ExprContext {
		public TerminalNode LEFT() { return getToken(MyLanguageParser.LEFT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT() { return getToken(MyLanguageParser.RIGHT, 0); }
		public ParExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterParExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitParExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitParExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public VarExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterVarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitVarExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanExprContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(MyLanguageParser.BOOL, 0); }
		public BooleanExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterBooleanExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitBooleanExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitBooleanExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public CompExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitCompExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitCompExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrfExprContext extends ExprContext {
		public PrfOpContext prfOp() {
			return getRuleContext(PrfOpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrfExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterPrfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitPrfExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitPrfExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BoolOpContext boolOp() {
			return getRuleContext(BoolOpContext.class,0);
		}
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MultOpContext multOp() {
			return getRuleContext(MultOpContext.class,0);
		}
		public MultExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitMultExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumExprContext extends ExprContext {
		public TerminalNode NUMBER() { return getToken(MyLanguageParser.NUMBER, 0); }
		public NumExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterNumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitNumExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitNumExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PlusOpContext plusOp() {
			return getRuleContext(PlusOpContext.class,0);
		}
		public PlusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterPlusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitPlusExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitPlusExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MIN:
			case NOT:
				{
				_localctx = new PrfExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(92);
				prfOp();
				setState(93);
				expr(9);
				}
				break;
			case LEFT:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
				match(LEFT);
				setState(96);
				expr(0);
				setState(97);
				match(RIGHT);
				}
				break;
			case ID:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99);
				match(ID);
				}
				break;
			case BOOL:
				{
				_localctx = new BooleanExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				match(BOOL);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(120);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(105);
						multOp();
						setState(106);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new PlusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(108);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(109);
						plusOp();
						setState(110);
						expr(8);
						}
						break;
					case 3:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(112);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(113);
						compOp();
						setState(114);
						expr(7);
						}
						break;
					case 4:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(116);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(117);
						boolOp();
						setState(118);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(MyLanguageParser.BOOLEAN, 0); }
		public TerminalNode INTEGER() { return getToken(MyLanguageParser.INTEGER, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if ( !(_la==BOOLEAN || _la==INTEGER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrfOpContext extends ParserRuleContext {
		public TerminalNode MIN() { return getToken(MyLanguageParser.MIN, 0); }
		public TerminalNode NOT() { return getToken(MyLanguageParser.NOT, 0); }
		public PrfOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prfOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterPrfOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitPrfOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitPrfOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrfOpContext prfOp() throws RecognitionException {
		PrfOpContext _localctx = new PrfOpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_prfOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !(_la==MIN || _la==NOT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultOpContext extends ParserRuleContext {
		public TerminalNode TIMES() { return getToken(MyLanguageParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(MyLanguageParser.DIV, 0); }
		public MultOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterMultOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitMultOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitMultOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultOpContext multOp() throws RecognitionException {
		MultOpContext _localctx = new MultOpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_multOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_la = _input.LA(1);
			if ( !(_la==TIMES || _la==DIV) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlusOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(MyLanguageParser.PLUS, 0); }
		public TerminalNode MIN() { return getToken(MyLanguageParser.MIN, 0); }
		public PlusOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterPlusOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitPlusOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitPlusOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlusOpContext plusOp() throws RecognitionException {
		PlusOpContext _localctx = new PlusOpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_plusOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_la = _input.LA(1);
			if ( !(_la==MIN || _la==PLUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolOpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(MyLanguageParser.AND, 0); }
		public TerminalNode OR() { return getToken(MyLanguageParser.OR, 0); }
		public BoolOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterBoolOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitBoolOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitBoolOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolOpContext boolOp() throws RecognitionException {
		BoolOpContext _localctx = new BoolOpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_boolOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompOpContext extends ParserRuleContext {
		public TerminalNode LE() { return getToken(MyLanguageParser.LE, 0); }
		public TerminalNode LT() { return getToken(MyLanguageParser.LT, 0); }
		public TerminalNode GE() { return getToken(MyLanguageParser.GE, 0); }
		public TerminalNode GT() { return getToken(MyLanguageParser.GT, 0); }
		public TerminalNode EQ() { return getToken(MyLanguageParser.EQ, 0); }
		public TerminalNode NE() { return getToken(MyLanguageParser.NE, 0); }
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterCompOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitCompOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitCompOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LE) | (1L << GT) | (1L << GE) | (1L << EQ) | (1L << NE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u008c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\6\3!\n\3\r\3\16\3\"\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\64\n\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4R\n\4\3\5\3\5\3\5\3\5\6\5X\n"+
		"\5\r\5\16\5Y\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6i"+
		"\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7"+
		"\6{\n\6\f\6\16\6~\13\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\f\2\3\n\r\2\4\6\b\n\f\16\20\22\24\26\2\b\3\2\4\5\4\2\24\24\26\26"+
		"\3\2\27\30\3\2\24\25\3\2\37 \3\2\31\36\2\u0092\2\30\3\2\2\2\4 \3\2\2\2"+
		"\6Q\3\2\2\2\bS\3\2\2\2\nh\3\2\2\2\f\177\3\2\2\2\16\u0081\3\2\2\2\20\u0083"+
		"\3\2\2\2\22\u0085\3\2\2\2\24\u0087\3\2\2\2\26\u0089\3\2\2\2\30\31\7\b"+
		"\2\2\31\32\7\22\2\2\32\33\7&\2\2\33\34\5\4\3\2\34\3\3\2\2\2\35\36\5\6"+
		"\4\2\36\37\7&\2\2\37!\3\2\2\2 \35\3\2\2\2!\"\3\2\2\2\" \3\2\2\2\"#\3\2"+
		"\2\2#\5\3\2\2\2$%\5\f\7\2%&\7\22\2\2&\'\7!\2\2\'(\5\n\6\2(R\3\2\2\2)*"+
		"\7\22\2\2*+\7!\2\2+R\5\n\6\2,-\7\t\2\2-.\7\"\2\2./\5\n\6\2/\60\7#\2\2"+
		"\60\63\5\b\5\2\61\62\7\n\2\2\62\64\5\b\5\2\63\61\3\2\2\2\63\64\3\2\2\2"+
		"\64R\3\2\2\2\65\66\7\16\2\2\66\67\7\"\2\2\678\5\n\6\289\7#\2\29:\5\b\5"+
		"\2:R\3\2\2\2;<\7\13\2\2<=\7\22\2\2=>\7\f\2\2>?\7\r\2\2?@\7\"\2\2@A\7\21"+
		"\2\2AB\7&\2\2BC\7\21\2\2CD\7&\2\2DE\7\21\2\2EF\7#\2\2FR\5\b\5\2GR\5\b"+
		"\5\2HI\7\17\2\2IJ\7\"\2\2JK\7\22\2\2KR\7#\2\2LM\7\20\2\2MN\7\"\2\2NO\5"+
		"\n\6\2OP\7#\2\2PR\3\2\2\2Q$\3\2\2\2Q)\3\2\2\2Q,\3\2\2\2Q\65\3\2\2\2Q;"+
		"\3\2\2\2QG\3\2\2\2QH\3\2\2\2QL\3\2\2\2R\7\3\2\2\2SW\7$\2\2TU\5\6\4\2U"+
		"V\7&\2\2VX\3\2\2\2WT\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2["+
		"\\\7%\2\2\\\t\3\2\2\2]^\b\6\1\2^_\5\16\b\2_`\5\n\6\13`i\3\2\2\2ab\7\""+
		"\2\2bc\5\n\6\2cd\7#\2\2di\3\2\2\2ei\7\22\2\2fi\7\3\2\2gi\7\21\2\2h]\3"+
		"\2\2\2ha\3\2\2\2he\3\2\2\2hf\3\2\2\2hg\3\2\2\2i|\3\2\2\2jk\f\n\2\2kl\5"+
		"\20\t\2lm\5\n\6\13m{\3\2\2\2no\f\t\2\2op\5\22\n\2pq\5\n\6\nq{\3\2\2\2"+
		"rs\f\b\2\2st\5\26\f\2tu\5\n\6\tu{\3\2\2\2vw\f\7\2\2wx\5\24\13\2xy\5\n"+
		"\6\by{\3\2\2\2zj\3\2\2\2zn\3\2\2\2zr\3\2\2\2zv\3\2\2\2{~\3\2\2\2|z\3\2"+
		"\2\2|}\3\2\2\2}\13\3\2\2\2~|\3\2\2\2\177\u0080\t\2\2\2\u0080\r\3\2\2\2"+
		"\u0081\u0082\t\3\2\2\u0082\17\3\2\2\2\u0083\u0084\t\4\2\2\u0084\21\3\2"+
		"\2\2\u0085\u0086\t\5\2\2\u0086\23\3\2\2\2\u0087\u0088\t\6\2\2\u0088\25"+
		"\3\2\2\2\u0089\u008a\t\7\2\2\u008a\27\3\2\2\2\t\"\63QYhz|";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}