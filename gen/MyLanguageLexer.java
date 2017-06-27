// Generated from C:/Users/Eric/IdeaProjects/ProjectMod8/src\MyLanguage.g4 by ANTLR 4.7
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
		BOOL=1, BOOLEAN=2, INTEGER=3, TRUE=4, FALSE=5, CLASS=6, IF=7, ELSE=8, 
		FOR=9, IN=10, RANGE=11, WHILE=12, READ=13, PRINT=14, NUMBER=15, ID=16, 
		CHAR=17, MIN=18, PLUS=19, NOT=20, TIMES=21, DIV=22, LT=23, LE=24, GT=25, 
		GE=26, EQ=27, NE=28, AND=29, OR=30, IS=31, LEFT=32, RIGHT=33, LPAR=34, 
		RPAR=35, SEMI=36, WS=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BOOL", "BOOLEAN", "INTEGER", "TRUE", "FALSE", "CLASS", "IF", "ELSE", 
		"FOR", "IN", "RANGE", "WHILE", "READ", "PRINT", "NUMBER", "ID", "CHAR", 
		"MIN", "PLUS", "NOT", "TIMES", "DIV", "LT", "LE", "GT", "GE", "EQ", "NE", 
		"AND", "OR", "IS", "LEFT", "RIGHT", "LPAR", "RPAR", "SEMI", "WS"
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
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\5\2P\n\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\6\20\u0096"+
		"\n\20\r\20\16\20\u0097\3\21\3\21\3\21\7\21\u009d\n\21\f\21\16\21\u00a0"+
		"\13\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3"+
		"%\3%\3&\3&\3&\3&\2\2\'\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'\3\2\5\3\2\62;\4\2C\\c|\5\2\13\f"+
		"\17\17\"\"\2\u00d6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3O\3\2\2\2\5Q\3\2\2\2\7Y\3\2"+
		"\2\2\t]\3\2\2\2\13b\3\2\2\2\rh\3\2\2\2\17n\3\2\2\2\21q\3\2\2\2\23v\3\2"+
		"\2\2\25z\3\2\2\2\27}\3\2\2\2\31\u0083\3\2\2\2\33\u0089\3\2\2\2\35\u008e"+
		"\3\2\2\2\37\u0095\3\2\2\2!\u0099\3\2\2\2#\u00a1\3\2\2\2%\u00a3\3\2\2\2"+
		"\'\u00a5\3\2\2\2)\u00a7\3\2\2\2+\u00a9\3\2\2\2-\u00ab\3\2\2\2/\u00ad\3"+
		"\2\2\2\61\u00af\3\2\2\2\63\u00b2\3\2\2\2\65\u00b4\3\2\2\2\67\u00b7\3\2"+
		"\2\29\u00ba\3\2\2\2;\u00bd\3\2\2\2=\u00c0\3\2\2\2?\u00c3\3\2\2\2A\u00c5"+
		"\3\2\2\2C\u00c7\3\2\2\2E\u00c9\3\2\2\2G\u00cb\3\2\2\2I\u00cd\3\2\2\2K"+
		"\u00cf\3\2\2\2MP\5\t\5\2NP\5\13\6\2OM\3\2\2\2ON\3\2\2\2P\4\3\2\2\2QR\7"+
		"d\2\2RS\7q\2\2ST\7q\2\2TU\7n\2\2UV\7g\2\2VW\7c\2\2WX\7p\2\2X\6\3\2\2\2"+
		"YZ\7k\2\2Z[\7p\2\2[\\\7v\2\2\\\b\3\2\2\2]^\7v\2\2^_\7t\2\2_`\7w\2\2`a"+
		"\7g\2\2a\n\3\2\2\2bc\7h\2\2cd\7c\2\2de\7n\2\2ef\7u\2\2fg\7g\2\2g\f\3\2"+
		"\2\2hi\7e\2\2ij\7n\2\2jk\7c\2\2kl\7u\2\2lm\7u\2\2m\16\3\2\2\2no\7k\2\2"+
		"op\7h\2\2p\20\3\2\2\2qr\7g\2\2rs\7n\2\2st\7u\2\2tu\7g\2\2u\22\3\2\2\2"+
		"vw\7h\2\2wx\7q\2\2xy\7t\2\2y\24\3\2\2\2z{\7k\2\2{|\7p\2\2|\26\3\2\2\2"+
		"}~\7t\2\2~\177\7c\2\2\177\u0080\7p\2\2\u0080\u0081\7i\2\2\u0081\u0082"+
		"\7g\2\2\u0082\30\3\2\2\2\u0083\u0084\7y\2\2\u0084\u0085\7j\2\2\u0085\u0086"+
		"\7k\2\2\u0086\u0087\7n\2\2\u0087\u0088\7g\2\2\u0088\32\3\2\2\2\u0089\u008a"+
		"\7t\2\2\u008a\u008b\7g\2\2\u008b\u008c\7c\2\2\u008c\u008d\7f\2\2\u008d"+
		"\34\3\2\2\2\u008e\u008f\7r\2\2\u008f\u0090\7t\2\2\u0090\u0091\7k\2\2\u0091"+
		"\u0092\7p\2\2\u0092\u0093\7v\2\2\u0093\36\3\2\2\2\u0094\u0096\t\2\2\2"+
		"\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098"+
		"\3\2\2\2\u0098 \3\2\2\2\u0099\u009e\5#\22\2\u009a\u009d\5#\22\2\u009b"+
		"\u009d\5\37\20\2\u009c\u009a\3\2\2\2\u009c\u009b\3\2\2\2\u009d\u00a0\3"+
		"\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\"\3\2\2\2\u00a0\u009e"+
		"\3\2\2\2\u00a1\u00a2\t\3\2\2\u00a2$\3\2\2\2\u00a3\u00a4\7/\2\2\u00a4&"+
		"\3\2\2\2\u00a5\u00a6\7-\2\2\u00a6(\3\2\2\2\u00a7\u00a8\7#\2\2\u00a8*\3"+
		"\2\2\2\u00a9\u00aa\7,\2\2\u00aa,\3\2\2\2\u00ab\u00ac\7\61\2\2\u00ac.\3"+
		"\2\2\2\u00ad\u00ae\7>\2\2\u00ae\60\3\2\2\2\u00af\u00b0\7>\2\2\u00b0\u00b1"+
		"\7?\2\2\u00b1\62\3\2\2\2\u00b2\u00b3\7@\2\2\u00b3\64\3\2\2\2\u00b4\u00b5"+
		"\7@\2\2\u00b5\u00b6\7?\2\2\u00b6\66\3\2\2\2\u00b7\u00b8\7?\2\2\u00b8\u00b9"+
		"\7?\2\2\u00b98\3\2\2\2\u00ba\u00bb\7#\2\2\u00bb\u00bc\7?\2\2\u00bc:\3"+
		"\2\2\2\u00bd\u00be\7(\2\2\u00be\u00bf\7(\2\2\u00bf<\3\2\2\2\u00c0\u00c1"+
		"\7~\2\2\u00c1\u00c2\7~\2\2\u00c2>\3\2\2\2\u00c3\u00c4\7?\2\2\u00c4@\3"+
		"\2\2\2\u00c5\u00c6\7*\2\2\u00c6B\3\2\2\2\u00c7\u00c8\7+\2\2\u00c8D\3\2"+
		"\2\2\u00c9\u00ca\7}\2\2\u00caF\3\2\2\2\u00cb\u00cc\7\177\2\2\u00ccH\3"+
		"\2\2\2\u00cd\u00ce\7=\2\2\u00ceJ\3\2\2\2\u00cf\u00d0\t\4\2\2\u00d0\u00d1"+
		"\3\2\2\2\u00d1\u00d2\b&\2\2\u00d2L\3\2\2\2\7\2O\u0097\u009c\u009e\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}