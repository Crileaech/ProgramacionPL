// Generated from C:/Users/Enrique/Desktop/PL/src\Analex.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Analex extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BLANCO=1, TABULADOR=2, FIN_LINEA=3, VARIABLES=4, PROGRAMA=5, SUBPROGRAMAS=6, 
		INSTRUCCIONES=7, FUNCION=8, FFUNCION=9, RETURN=10, PROCEDIMIENTO=11, FPROCEDIMIENTO=12, 
		EVAL=13, DEF=14, NUMERO=15, BOOL=16, SEQUEN=17, T=18, F=19, BREAK=20, 
		IF=21, THEN=22, ENDIF=23, ELSE=24, WHILE=25, DO=26, ENDWHILE=27, FORALL=28, 
		EXIST=29, AVANZA=30, NUM=31, VAR=32, DOSPTOS=33, PA=34, PC=35, CA=36, 
		CC=37, LLAVEA=38, LLAVEC=39, PyC=40, COMA=41, SUMA=42, RESTA=43, POR=44, 
		IGUAL=45, IGUALL=46, DISTINTO=47, MENORIGUAL=48, MAYORIGUAL=49, MENOR=50, 
		MAYOR=51, NO=52, AND=53, OR=54, COMENTARIO_BLOQUE=55, COMENTARIO_LINEA=56;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"BLANCO", "TABULADOR", "FIN_LINEA", "DIGITO", "LETRA", "VARIABLES", "PROGRAMA", 
			"SUBPROGRAMAS", "INSTRUCCIONES", "FUNCION", "FFUNCION", "RETURN", "PROCEDIMIENTO", 
			"FPROCEDIMIENTO", "EVAL", "DEF", "NUMERO", "BOOL", "SEQUEN", "T", "F", 
			"BREAK", "IF", "THEN", "ENDIF", "ELSE", "WHILE", "DO", "ENDWHILE", "FORALL", 
			"EXIST", "AVANZA", "NUM", "VAR", "DOSPTOS", "PA", "PC", "CA", "CC", "LLAVEA", 
			"LLAVEC", "PyC", "COMA", "SUMA", "RESTA", "POR", "IGUAL", "IGUALL", "DISTINTO", 
			"MENORIGUAL", "MAYORIGUAL", "MENOR", "MAYOR", "NO", "AND", "OR", "COMENTARIO_BLOQUE", 
			"COMENTARIO_LINEA"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", "'\t'", null, "'VARIABLES'", "'PROGRAMA'", "'SUBPROGRAMAS'", 
			"'INSTRUCCIONES'", "'FUNCION'", "'FFUNCION'", "'dev'", "'PROCEDIMIENTO'", 
			"'FPROCEDIMIENTO'", "'EVAL'", "'DEF'", "'NUM'", "'LOG'", "'SEQ'", null, 
			null, "'ruptura'", "'si'", "'entonces'", "'fsi'", "'sino'", "'mientras'", 
			"'hacer'", "'fmientras'", "'PARATODO'", "'EXISTE'", "'avance'", null, 
			null, "':'", "'('", "')'", "'['", "']'", "'{'", "'}'", "';'", "','", 
			"'+'", "'-'", "'*'", "'='", "'=='", "'!='", "'<='", "'>='", "'<'", "'>'", 
			"'!'", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BLANCO", "TABULADOR", "FIN_LINEA", "VARIABLES", "PROGRAMA", "SUBPROGRAMAS", 
			"INSTRUCCIONES", "FUNCION", "FFUNCION", "RETURN", "PROCEDIMIENTO", "FPROCEDIMIENTO", 
			"EVAL", "DEF", "NUMERO", "BOOL", "SEQUEN", "T", "F", "BREAK", "IF", "THEN", 
			"ENDIF", "ELSE", "WHILE", "DO", "ENDWHILE", "FORALL", "EXIST", "AVANZA", 
			"NUM", "VAR", "DOSPTOS", "PA", "PC", "CA", "CC", "LLAVEA", "LLAVEC", 
			"PyC", "COMA", "SUMA", "RESTA", "POR", "IGUAL", "IGUALL", "DISTINTO", 
			"MENORIGUAL", "MAYORIGUAL", "MENOR", "MAYOR", "NO", "AND", "OR", "COMENTARIO_BLOQUE", 
			"COMENTARIO_LINEA"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public Analex(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Analex.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2:\u01b8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\4\5\4\u0081\n\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\5\25\u0107\n\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u010f\n\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!"+
		"\3!\3\"\6\"\u015f\n\"\r\"\16\"\u0160\3#\3#\3#\3#\7#\u0167\n#\f#\16#\u016a"+
		"\13#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3."+
		"\3.\3/\3/\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\38\39\39\39\3:\3:\3:\3"+
		":\7:\u01a2\n:\f:\16:\u01a5\13:\3:\3:\3:\3:\3:\3;\3;\3;\3;\7;\u01b0\n;"+
		"\f;\16;\u01b3\13;\3;\3;\3;\3;\4\u01a3\u01b1\2<\3\3\5\4\7\5\t\2\13\2\r"+
		"\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23)\24"+
		"+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36?\37A C!E\"G#I$K%M&O\'"+
		"Q(S)U*W+Y,[-]._/a\60c\61e\62g\63i\64k\65m\66o\67q8s9u:\3\2\4\3\2\62;\4"+
		"\2C\\c|\2\u01be\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3"+
		"\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2"+
		"\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\3w\3\2\2\2\5{\3\2\2\2\7\u0080\3\2"+
		"\2\2\t\u0086\3\2\2\2\13\u0088\3\2\2\2\r\u008a\3\2\2\2\17\u0094\3\2\2\2"+
		"\21\u009d\3\2\2\2\23\u00aa\3\2\2\2\25\u00b8\3\2\2\2\27\u00c0\3\2\2\2\31"+
		"\u00c9\3\2\2\2\33\u00cd\3\2\2\2\35\u00db\3\2\2\2\37\u00ea\3\2\2\2!\u00ef"+
		"\3\2\2\2#\u00f3\3\2\2\2%\u00f7\3\2\2\2\'\u00fb\3\2\2\2)\u0106\3\2\2\2"+
		"+\u010e\3\2\2\2-\u0110\3\2\2\2/\u0118\3\2\2\2\61\u011b\3\2\2\2\63\u0124"+
		"\3\2\2\2\65\u0128\3\2\2\2\67\u012d\3\2\2\29\u0136\3\2\2\2;\u013c\3\2\2"+
		"\2=\u0146\3\2\2\2?\u014f\3\2\2\2A\u0156\3\2\2\2C\u015e\3\2\2\2E\u0162"+
		"\3\2\2\2G\u016b\3\2\2\2I\u016d\3\2\2\2K\u016f\3\2\2\2M\u0171\3\2\2\2O"+
		"\u0173\3\2\2\2Q\u0175\3\2\2\2S\u0177\3\2\2\2U\u0179\3\2\2\2W\u017b\3\2"+
		"\2\2Y\u017d\3\2\2\2[\u017f\3\2\2\2]\u0181\3\2\2\2_\u0183\3\2\2\2a\u0185"+
		"\3\2\2\2c\u0188\3\2\2\2e\u018b\3\2\2\2g\u018e\3\2\2\2i\u0191\3\2\2\2k"+
		"\u0193\3\2\2\2m\u0195\3\2\2\2o\u0197\3\2\2\2q\u019a\3\2\2\2s\u019d\3\2"+
		"\2\2u\u01ab\3\2\2\2wx\7\"\2\2xy\3\2\2\2yz\b\2\2\2z\4\3\2\2\2{|\7\13\2"+
		"\2|}\3\2\2\2}~\b\3\2\2~\6\3\2\2\2\177\u0081\7\17\2\2\u0080\177\3\2\2\2"+
		"\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\7\f\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\u0085\b\4\2\2\u0085\b\3\2\2\2\u0086\u0087\t\2\2\2\u0087"+
		"\n\3\2\2\2\u0088\u0089\t\3\2\2\u0089\f\3\2\2\2\u008a\u008b\7X\2\2\u008b"+
		"\u008c\7C\2\2\u008c\u008d\7T\2\2\u008d\u008e\7K\2\2\u008e\u008f\7C\2\2"+
		"\u008f\u0090\7D\2\2\u0090\u0091\7N\2\2\u0091\u0092\7G\2\2\u0092\u0093"+
		"\7U\2\2\u0093\16\3\2\2\2\u0094\u0095\7R\2\2\u0095\u0096\7T\2\2\u0096\u0097"+
		"\7Q\2\2\u0097\u0098\7I\2\2\u0098\u0099\7T\2\2\u0099\u009a\7C\2\2\u009a"+
		"\u009b\7O\2\2\u009b\u009c\7C\2\2\u009c\20\3\2\2\2\u009d\u009e\7U\2\2\u009e"+
		"\u009f\7W\2\2\u009f\u00a0\7D\2\2\u00a0\u00a1\7R\2\2\u00a1\u00a2\7T\2\2"+
		"\u00a2\u00a3\7Q\2\2\u00a3\u00a4\7I\2\2\u00a4\u00a5\7T\2\2\u00a5\u00a6"+
		"\7C\2\2\u00a6\u00a7\7O\2\2\u00a7\u00a8\7C\2\2\u00a8\u00a9\7U\2\2\u00a9"+
		"\22\3\2\2\2\u00aa\u00ab\7K\2\2\u00ab\u00ac\7P\2\2\u00ac\u00ad\7U\2\2\u00ad"+
		"\u00ae\7V\2\2\u00ae\u00af\7T\2\2\u00af\u00b0\7W\2\2\u00b0\u00b1\7E\2\2"+
		"\u00b1\u00b2\7E\2\2\u00b2\u00b3\7K\2\2\u00b3\u00b4\7Q\2\2\u00b4\u00b5"+
		"\7P\2\2\u00b5\u00b6\7G\2\2\u00b6\u00b7\7U\2\2\u00b7\24\3\2\2\2\u00b8\u00b9"+
		"\7H\2\2\u00b9\u00ba\7W\2\2\u00ba\u00bb\7P\2\2\u00bb\u00bc\7E\2\2\u00bc"+
		"\u00bd\7K\2\2\u00bd\u00be\7Q\2\2\u00be\u00bf\7P\2\2\u00bf\26\3\2\2\2\u00c0"+
		"\u00c1\7H\2\2\u00c1\u00c2\7H\2\2\u00c2\u00c3\7W\2\2\u00c3\u00c4\7P\2\2"+
		"\u00c4\u00c5\7E\2\2\u00c5\u00c6\7K\2\2\u00c6\u00c7\7Q\2\2\u00c7\u00c8"+
		"\7P\2\2\u00c8\30\3\2\2\2\u00c9\u00ca\7f\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cc"+
		"\7x\2\2\u00cc\32\3\2\2\2\u00cd\u00ce\7R\2\2\u00ce\u00cf\7T\2\2\u00cf\u00d0"+
		"\7Q\2\2\u00d0\u00d1\7E\2\2\u00d1\u00d2\7G\2\2\u00d2\u00d3\7F\2\2\u00d3"+
		"\u00d4\7K\2\2\u00d4\u00d5\7O\2\2\u00d5\u00d6\7K\2\2\u00d6\u00d7\7G\2\2"+
		"\u00d7\u00d8\7P\2\2\u00d8\u00d9\7V\2\2\u00d9\u00da\7Q\2\2\u00da\34\3\2"+
		"\2\2\u00db\u00dc\7H\2\2\u00dc\u00dd\7R\2\2\u00dd\u00de\7T\2\2\u00de\u00df"+
		"\7Q\2\2\u00df\u00e0\7E\2\2\u00e0\u00e1\7G\2\2\u00e1\u00e2\7F\2\2\u00e2"+
		"\u00e3\7K\2\2\u00e3\u00e4\7O\2\2\u00e4\u00e5\7K\2\2\u00e5\u00e6\7G\2\2"+
		"\u00e6\u00e7\7P\2\2\u00e7\u00e8\7V\2\2\u00e8\u00e9\7Q\2\2\u00e9\36\3\2"+
		"\2\2\u00ea\u00eb\7G\2\2\u00eb\u00ec\7X\2\2\u00ec\u00ed\7C\2\2\u00ed\u00ee"+
		"\7N\2\2\u00ee \3\2\2\2\u00ef\u00f0\7F\2\2\u00f0\u00f1\7G\2\2\u00f1\u00f2"+
		"\7H\2\2\u00f2\"\3\2\2\2\u00f3\u00f4\7P\2\2\u00f4\u00f5\7W\2\2\u00f5\u00f6"+
		"\7O\2\2\u00f6$\3\2\2\2\u00f7\u00f8\7N\2\2\u00f8\u00f9\7Q\2\2\u00f9\u00fa"+
		"\7I\2\2\u00fa&\3\2\2\2\u00fb\u00fc\7U\2\2\u00fc\u00fd\7G\2\2\u00fd\u00fe"+
		"\7S\2\2\u00fe(\3\2\2\2\u00ff\u0107\7V\2\2\u0100\u0101\7e\2\2\u0101\u0102"+
		"\7k\2\2\u0102\u0103\7g\2\2\u0103\u0104\7t\2\2\u0104\u0105\7v\2\2\u0105"+
		"\u0107\7q\2\2\u0106\u00ff\3\2\2\2\u0106\u0100\3\2\2\2\u0107*\3\2\2\2\u0108"+
		"\u010f\7H\2\2\u0109\u010a\7h\2\2\u010a\u010b\7c\2\2\u010b\u010c\7n\2\2"+
		"\u010c\u010d\7u\2\2\u010d\u010f\7q\2\2\u010e\u0108\3\2\2\2\u010e\u0109"+
		"\3\2\2\2\u010f,\3\2\2\2\u0110\u0111\7t\2\2\u0111\u0112\7w\2\2\u0112\u0113"+
		"\7r\2\2\u0113\u0114\7v\2\2\u0114\u0115\7w\2\2\u0115\u0116\7t\2\2\u0116"+
		"\u0117\7c\2\2\u0117.\3\2\2\2\u0118\u0119\7u\2\2\u0119\u011a\7k\2\2\u011a"+
		"\60\3\2\2\2\u011b\u011c\7g\2\2\u011c\u011d\7p\2\2\u011d\u011e\7v\2\2\u011e"+
		"\u011f\7q\2\2\u011f\u0120\7p\2\2\u0120\u0121\7e\2\2\u0121\u0122\7g\2\2"+
		"\u0122\u0123\7u\2\2\u0123\62\3\2\2\2\u0124\u0125\7h\2\2\u0125\u0126\7"+
		"u\2\2\u0126\u0127\7k\2\2\u0127\64\3\2\2\2\u0128\u0129\7u\2\2\u0129\u012a"+
		"\7k\2\2\u012a\u012b\7p\2\2\u012b\u012c\7q\2\2\u012c\66\3\2\2\2\u012d\u012e"+
		"\7o\2\2\u012e\u012f\7k\2\2\u012f\u0130\7g\2\2\u0130\u0131\7p\2\2\u0131"+
		"\u0132\7v\2\2\u0132\u0133\7t\2\2\u0133\u0134\7c\2\2\u0134\u0135\7u\2\2"+
		"\u01358\3\2\2\2\u0136\u0137\7j\2\2\u0137\u0138\7c\2\2\u0138\u0139\7e\2"+
		"\2\u0139\u013a\7g\2\2\u013a\u013b\7t\2\2\u013b:\3\2\2\2\u013c\u013d\7"+
		"h\2\2\u013d\u013e\7o\2\2\u013e\u013f\7k\2\2\u013f\u0140\7g\2\2\u0140\u0141"+
		"\7p\2\2\u0141\u0142\7v\2\2\u0142\u0143\7t\2\2\u0143\u0144\7c\2\2\u0144"+
		"\u0145\7u\2\2\u0145<\3\2\2\2\u0146\u0147\7R\2\2\u0147\u0148\7C\2\2\u0148"+
		"\u0149\7T\2\2\u0149\u014a\7C\2\2\u014a\u014b\7V\2\2\u014b\u014c\7Q\2\2"+
		"\u014c\u014d\7F\2\2\u014d\u014e\7Q\2\2\u014e>\3\2\2\2\u014f\u0150\7G\2"+
		"\2\u0150\u0151\7Z\2\2\u0151\u0152\7K\2\2\u0152\u0153\7U\2\2\u0153\u0154"+
		"\7V\2\2\u0154\u0155\7G\2\2\u0155@\3\2\2\2\u0156\u0157\7c\2\2\u0157\u0158"+
		"\7x\2\2\u0158\u0159\7c\2\2\u0159\u015a\7p\2\2\u015a\u015b\7e\2\2\u015b"+
		"\u015c\7g\2\2\u015cB\3\2\2\2\u015d\u015f\5\t\5\2\u015e\u015d\3\2\2\2\u015f"+
		"\u0160\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161D\3\2\2\2"+
		"\u0162\u0168\5\13\6\2\u0163\u0167\5\13\6\2\u0164\u0167\5\t\5\2\u0165\u0167"+
		"\7a\2\2\u0166\u0163\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0165\3\2\2\2\u0167"+
		"\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169F\3\2\2\2"+
		"\u016a\u0168\3\2\2\2\u016b\u016c\7<\2\2\u016cH\3\2\2\2\u016d\u016e\7*"+
		"\2\2\u016eJ\3\2\2\2\u016f\u0170\7+\2\2\u0170L\3\2\2\2\u0171\u0172\7]\2"+
		"\2\u0172N\3\2\2\2\u0173\u0174\7_\2\2\u0174P\3\2\2\2\u0175\u0176\7}\2\2"+
		"\u0176R\3\2\2\2\u0177\u0178\7\177\2\2\u0178T\3\2\2\2\u0179\u017a\7=\2"+
		"\2\u017aV\3\2\2\2\u017b\u017c\7.\2\2\u017cX\3\2\2\2\u017d\u017e\7-\2\2"+
		"\u017eZ\3\2\2\2\u017f\u0180\7/\2\2\u0180\\\3\2\2\2\u0181\u0182\7,\2\2"+
		"\u0182^\3\2\2\2\u0183\u0184\7?\2\2\u0184`\3\2\2\2\u0185\u0186\7?\2\2\u0186"+
		"\u0187\7?\2\2\u0187b\3\2\2\2\u0188\u0189\7#\2\2\u0189\u018a\7?\2\2\u018a"+
		"d\3\2\2\2\u018b\u018c\7>\2\2\u018c\u018d\7?\2\2\u018df\3\2\2\2\u018e\u018f"+
		"\7@\2\2\u018f\u0190\7?\2\2\u0190h\3\2\2\2\u0191\u0192\7>\2\2\u0192j\3"+
		"\2\2\2\u0193\u0194\7@\2\2\u0194l\3\2\2\2\u0195\u0196\7#\2\2\u0196n\3\2"+
		"\2\2\u0197\u0198\7(\2\2\u0198\u0199\7(\2\2\u0199p\3\2\2\2\u019a\u019b"+
		"\7~\2\2\u019b\u019c\7~\2\2\u019cr\3\2\2\2\u019d\u019e\7\61\2\2\u019e\u019f"+
		"\7,\2\2\u019f\u01a3\3\2\2\2\u01a0\u01a2\13\2\2\2\u01a1\u01a0\3\2\2\2\u01a2"+
		"\u01a5\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a4\u01a6\3\2"+
		"\2\2\u01a5\u01a3\3\2\2\2\u01a6\u01a7\7,\2\2\u01a7\u01a8\7\61\2\2\u01a8"+
		"\u01a9\3\2\2\2\u01a9\u01aa\b:\2\2\u01aat\3\2\2\2\u01ab\u01ac\7\61\2\2"+
		"\u01ac\u01ad\7\61\2\2\u01ad\u01b1\3\2\2\2\u01ae\u01b0\13\2\2\2\u01af\u01ae"+
		"\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2"+
		"\u01b4\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4\u01b5\5\7\4\2\u01b5\u01b6\3\2"+
		"\2\2\u01b6\u01b7\b;\2\2\u01b7v\3\2\2\2\13\2\u0080\u0106\u010e\u0160\u0166"+
		"\u0168\u01a3\u01b1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}