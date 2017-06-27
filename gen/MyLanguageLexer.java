// Generated from C:/Users/Birte/IdeaProjects/ProjectMod8/src\MyLanguage.g4 by ANTLR 4.7
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOOLEAN=1, INTEGER=2, CLASS=3, IF=4, ELSE=5, FOR=6, IN=7, RANGE=8, WHILE=9, 
		READ=10, PRINT=11, ID=12, NUMBER=13, BOOL=14, CHAR=15, TRUE=16, FALSE=17, 
		MIN=18, PLUS=19, NOT=20, TIMES=21, DIV=22, LT=23, LE=24, GT=25, GE=26, 
		EQ=27, NE=28, AND=29, OR=30, IS=31, LEFT=32, RIGHT=33, LPAR=34, RPAR=35, 
		SEMI=36, WS=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BOOLEAN", "INTEGER", "CLASS", "IF", "ELSE", "FOR", "IN", "RANGE", "WHILE", 
		"READ", "PRINT", "ID", "NUMBER", "BOOL", "CHAR", "TRUE", "FALSE", "MIN", 
		"PLUS", "NOT", "TIMES", "DIV", "LT", "LE", "GT", "GE", "EQ", "NE", "AND", 
		"OR", "IS", "LEFT", "RIGHT", "LPAR", "RPAR", "SEMI", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'boolean'", "'int'", "'class'", "'if'", "'else'", "'for'", "'in'", 
		"'range'", "'while'", "'read'", "'print'", null, null, null, null, "'true'", 
		"'false'", "'-'", "'+'", "'!'", "'*'", "'/'", "'<'", "'<='", "'>'", "'>='", 
		"'=='", "'!='", "'&&'", "'||'", "'='", "'('", "')'", "'{'", "'}'", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BOOLEAN", "INTEGER", "CLASS", "IF", "ELSE", "FOR", "IN", "RANGE", 
		"WHILE", "READ", "PRINT", "ID", "NUMBER", "BOOL", "CHAR", "TRUE", "FALSE", 
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


	public MyLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MyLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u00d3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7"+
		"\r\u0089\n\r\f\r\16\r\u008c\13\r\3\16\6\16\u008f\n\16\r\16\16\16\u0090"+
		"\3\17\3\17\5\17\u0095\n\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$"+
		"\3$\3%\3%\3&\3&\3&\3&\2\2\'\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'\3\2\5\3\2\62;\4\2C\\c|\5"+
		"\2\13\f\17\17\"\"\2\u00d6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5U\3\2\2\2"+
		"\7Y\3\2\2\2\t_\3\2\2\2\13b\3\2\2\2\rg\3\2\2\2\17k\3\2\2\2\21n\3\2\2\2"+
		"\23t\3\2\2\2\25z\3\2\2\2\27\177\3\2\2\2\31\u0085\3\2\2\2\33\u008e\3\2"+
		"\2\2\35\u0094\3\2\2\2\37\u0096\3\2\2\2!\u0098\3\2\2\2#\u009d\3\2\2\2%"+
		"\u00a3\3\2\2\2\'\u00a5\3\2\2\2)\u00a7\3\2\2\2+\u00a9\3\2\2\2-\u00ab\3"+
		"\2\2\2/\u00ad\3\2\2\2\61\u00af\3\2\2\2\63\u00b2\3\2\2\2\65\u00b4\3\2\2"+
		"\2\67\u00b7\3\2\2\29\u00ba\3\2\2\2;\u00bd\3\2\2\2=\u00c0\3\2\2\2?\u00c3"+
		"\3\2\2\2A\u00c5\3\2\2\2C\u00c7\3\2\2\2E\u00c9\3\2\2\2G\u00cb\3\2\2\2I"+
		"\u00cd\3\2\2\2K\u00cf\3\2\2\2MN\7d\2\2NO\7q\2\2OP\7q\2\2PQ\7n\2\2QR\7"+
		"g\2\2RS\7c\2\2ST\7p\2\2T\4\3\2\2\2UV\7k\2\2VW\7p\2\2WX\7v\2\2X\6\3\2\2"+
		"\2YZ\7e\2\2Z[\7n\2\2[\\\7c\2\2\\]\7u\2\2]^\7u\2\2^\b\3\2\2\2_`\7k\2\2"+
		"`a\7h\2\2a\n\3\2\2\2bc\7g\2\2cd\7n\2\2de\7u\2\2ef\7g\2\2f\f\3\2\2\2gh"+
		"\7h\2\2hi\7q\2\2ij\7t\2\2j\16\3\2\2\2kl\7k\2\2lm\7p\2\2m\20\3\2\2\2no"+
		"\7t\2\2op\7c\2\2pq\7p\2\2qr\7i\2\2rs\7g\2\2s\22\3\2\2\2tu\7y\2\2uv\7j"+
		"\2\2vw\7k\2\2wx\7n\2\2xy\7g\2\2y\24\3\2\2\2z{\7t\2\2{|\7g\2\2|}\7c\2\2"+
		"}~\7f\2\2~\26\3\2\2\2\177\u0080\7r\2\2\u0080\u0081\7t\2\2\u0081\u0082"+
		"\7k\2\2\u0082\u0083\7p\2\2\u0083\u0084\7v\2\2\u0084\30\3\2\2\2\u0085\u008a"+
		"\5\37\20\2\u0086\u0089\5\37\20\2\u0087\u0089\5\33\16\2\u0088\u0086\3\2"+
		"\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\32\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008f\t\2\2"+
		"\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091"+
		"\3\2\2\2\u0091\34\3\2\2\2\u0092\u0095\5!\21\2\u0093\u0095\5#\22\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\36\3\2\2\2\u0096\u0097\t\3\2"+
		"\2\u0097 \3\2\2\2\u0098\u0099\7v\2\2\u0099\u009a\7t\2\2\u009a\u009b\7"+
		"w\2\2\u009b\u009c\7g\2\2\u009c\"\3\2\2\2\u009d\u009e\7h\2\2\u009e\u009f"+
		"\7c\2\2\u009f\u00a0\7n\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a2\7g\2\2\u00a2"+
		"$\3\2\2\2\u00a3\u00a4\7/\2\2\u00a4&\3\2\2\2\u00a5\u00a6\7-\2\2\u00a6("+
		"\3\2\2\2\u00a7\u00a8\7#\2\2\u00a8*\3\2\2\2\u00a9\u00aa\7,\2\2\u00aa,\3"+
		"\2\2\2\u00ab\u00ac\7\61\2\2\u00ac.\3\2\2\2\u00ad\u00ae\7>\2\2\u00ae\60"+
		"\3\2\2\2\u00af\u00b0\7>\2\2\u00b0\u00b1\7?\2\2\u00b1\62\3\2\2\2\u00b2"+
		"\u00b3\7@\2\2\u00b3\64\3\2\2\2\u00b4\u00b5\7@\2\2\u00b5\u00b6\7?\2\2\u00b6"+
		"\66\3\2\2\2\u00b7\u00b8\7?\2\2\u00b8\u00b9\7?\2\2\u00b98\3\2\2\2\u00ba"+
		"\u00bb\7#\2\2\u00bb\u00bc\7?\2\2\u00bc:\3\2\2\2\u00bd\u00be\7(\2\2\u00be"+
		"\u00bf\7(\2\2\u00bf<\3\2\2\2\u00c0\u00c1\7~\2\2\u00c1\u00c2\7~\2\2\u00c2"+
		">\3\2\2\2\u00c3\u00c4\7?\2\2\u00c4@\3\2\2\2\u00c5\u00c6\7*\2\2\u00c6B"+
		"\3\2\2\2\u00c7\u00c8\7+\2\2\u00c8D\3\2\2\2\u00c9\u00ca\7}\2\2\u00caF\3"+
		"\2\2\2\u00cb\u00cc\7\177\2\2\u00ccH\3\2\2\2\u00cd\u00ce\7=\2\2\u00ceJ"+
		"\3\2\2\2\u00cf\u00d0\t\4\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\b&\2\2\u00d2"+
		"L\3\2\2\2\7\2\u0088\u008a\u0090\u0094\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}