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
		EVAL=13, DEF=14, NUMERO=15, BOOL=16, SEQ_NUM=17, SEQ_BOOL=18, SEQ=19, 
		T=20, F=21, BREAK=22, IF=23, THEN=24, ENDIF=25, ELSE=26, WHILE=27, DO=28, 
		ENDWHILE=29, FORALL=30, EXISTS=31, AVANZA=32, MOSTRAR=33, NUM=34, VAR=35, 
		DOSPTOS=36, PA=37, PC=38, CA=39, CC=40, LA=41, LC=42, PyC=43, COMA=44, 
		POR=45, SUMA=46, RESTA=47, IGUAL=48, IGUALL=49, DISTINTO=50, MENORIGUAL=51, 
		MAYORIGUAL=52, MENOR=53, MAYOR=54, NO=55, AND=56, OR=57, COMENTARIO_BLOQUE=58, 
		COMENTARIO_LINEA=59;
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
			"FPROCEDIMIENTO", "EVAL", "DEF", "NUMERO", "BOOL", "SEQ_NUM", "SEQ_BOOL", 
			"SEQ", "T", "F", "BREAK", "IF", "THEN", "ENDIF", "ELSE", "WHILE", "DO", 
			"ENDWHILE", "FORALL", "EXISTS", "AVANZA", "MOSTRAR", "NUM", "VAR", "DOSPTOS", 
			"PA", "PC", "CA", "CC", "LA", "LC", "PyC", "COMA", "POR", "SUMA", "RESTA", 
			"IGUAL", "IGUALL", "DISTINTO", "MENORIGUAL", "MAYORIGUAL", "MENOR", "MAYOR", 
			"NO", "AND", "OR", "COMENTARIO_BLOQUE", "COMENTARIO_LINEA"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", "'\t'", null, "'VARIABLES'", "'PROGRAMA'", "'SUBPROGRAMAS'", 
			"'INSTRUCCIONES'", "'FUNCION'", "'FFUNCION'", "'dev'", "'PROCEDIMIENTO'", 
			"'FPROCEDIMIENTO'", "'EVAL'", "'DEF'", "'NUM'", "'LOG'", "'SEQ(NUM)'", 
			"'SEQ(BOOL)'", "'SEQ'", null, null, "'ruptura'", "'si'", "'entonces'", 
			"'fsi'", "'sino'", "'mientras'", "'hacer'", "'fmientras'", "'PARATODO'", 
			"'EXISTE'", "'avance'", "'mostrar'", null, null, "':'", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "';'", "','", "'*'", "'+'", "'-'", "'='", 
			"'=='", "'!='", "'<='", "'>='", "'<'", "'>'", "'!'", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BLANCO", "TABULADOR", "FIN_LINEA", "VARIABLES", "PROGRAMA", "SUBPROGRAMAS", 
			"INSTRUCCIONES", "FUNCION", "FFUNCION", "RETURN", "PROCEDIMIENTO", "FPROCEDIMIENTO", 
			"EVAL", "DEF", "NUMERO", "BOOL", "SEQ_NUM", "SEQ_BOOL", "SEQ", "T", "F", 
			"BREAK", "IF", "THEN", "ENDIF", "ELSE", "WHILE", "DO", "ENDWHILE", "FORALL", 
			"EXISTS", "AVANZA", "MOSTRAR", "NUM", "VAR", "DOSPTOS", "PA", "PC", "CA", 
			"CC", "LA", "LC", "PyC", "COMA", "POR", "SUMA", "RESTA", "IGUAL", "IGUALL", 
			"DISTINTO", "MENORIGUAL", "MAYORIGUAL", "MENOR", "MAYOR", "NO", "AND", 
			"OR", "COMENTARIO_BLOQUE", "COMENTARIO_LINEA"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2=\u01d9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\5\4\u0087\n\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0120\n\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\5\30\u0128\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 "+
		"\3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3"+
		"#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\6%\u0180\n%\r%\16%\u0181\3&\3"+
		"&\3&\3&\7&\u0188\n&\f&\16&\u018b\13&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3"+
		",\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3"+
		"\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38\39\39\3:\3"+
		":\3;\3;\3;\3<\3<\3<\3=\3=\3=\3=\7=\u01c3\n=\f=\16=\u01c6\13=\3=\3=\3="+
		"\3=\3=\3>\3>\3>\3>\7>\u01d1\n>\f>\16>\u01d4\13>\3>\3>\3>\3>\4\u01c4\u01d2"+
		"\2?\3\3\5\4\7\5\t\2\13\2\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16"+
		"\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35"+
		"=\36?\37A C!E\"G#I$K%M&O\'Q(S)U*W+Y,[-]._/a\60c\61e\62g\63i\64k\65m\66"+
		"o\67q8s9u:w;y<{=\3\2\4\3\2\62;\4\2C\\c|\2\u01df\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2"+
		"\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2"+
		"w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\3}\3\2\2\2\5\u0081\3\2\2\2\7\u0086\3\2"+
		"\2\2\t\u008c\3\2\2\2\13\u008e\3\2\2\2\r\u0090\3\2\2\2\17\u009a\3\2\2\2"+
		"\21\u00a3\3\2\2\2\23\u00b0\3\2\2\2\25\u00be\3\2\2\2\27\u00c6\3\2\2\2\31"+
		"\u00cf\3\2\2\2\33\u00d3\3\2\2\2\35\u00e1\3\2\2\2\37\u00f0\3\2\2\2!\u00f5"+
		"\3\2\2\2#\u00f9\3\2\2\2%\u00fd\3\2\2\2\'\u0101\3\2\2\2)\u010a\3\2\2\2"+
		"+\u0114\3\2\2\2-\u011f\3\2\2\2/\u0127\3\2\2\2\61\u0129\3\2\2\2\63\u0131"+
		"\3\2\2\2\65\u0134\3\2\2\2\67\u013d\3\2\2\29\u0141\3\2\2\2;\u0146\3\2\2"+
		"\2=\u014f\3\2\2\2?\u0155\3\2\2\2A\u015f\3\2\2\2C\u0168\3\2\2\2E\u016f"+
		"\3\2\2\2G\u0176\3\2\2\2I\u017f\3\2\2\2K\u0183\3\2\2\2M\u018c\3\2\2\2O"+
		"\u018e\3\2\2\2Q\u0190\3\2\2\2S\u0192\3\2\2\2U\u0194\3\2\2\2W\u0196\3\2"+
		"\2\2Y\u0198\3\2\2\2[\u019a\3\2\2\2]\u019c\3\2\2\2_\u019e\3\2\2\2a\u01a0"+
		"\3\2\2\2c\u01a2\3\2\2\2e\u01a4\3\2\2\2g\u01a6\3\2\2\2i\u01a9\3\2\2\2k"+
		"\u01ac\3\2\2\2m\u01af\3\2\2\2o\u01b2\3\2\2\2q\u01b4\3\2\2\2s\u01b6\3\2"+
		"\2\2u\u01b8\3\2\2\2w\u01bb\3\2\2\2y\u01be\3\2\2\2{\u01cc\3\2\2\2}~\7\""+
		"\2\2~\177\3\2\2\2\177\u0080\b\2\2\2\u0080\4\3\2\2\2\u0081\u0082\7\13\2"+
		"\2\u0082\u0083\3\2\2\2\u0083\u0084\b\3\2\2\u0084\6\3\2\2\2\u0085\u0087"+
		"\7\17\2\2\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2"+
		"\u0088\u0089\7\f\2\2\u0089\u008a\3\2\2\2\u008a\u008b\b\4\2\2\u008b\b\3"+
		"\2\2\2\u008c\u008d\t\2\2\2\u008d\n\3\2\2\2\u008e\u008f\t\3\2\2\u008f\f"+
		"\3\2\2\2\u0090\u0091\7X\2\2\u0091\u0092\7C\2\2\u0092\u0093\7T\2\2\u0093"+
		"\u0094\7K\2\2\u0094\u0095\7C\2\2\u0095\u0096\7D\2\2\u0096\u0097\7N\2\2"+
		"\u0097\u0098\7G\2\2\u0098\u0099\7U\2\2\u0099\16\3\2\2\2\u009a\u009b\7"+
		"R\2\2\u009b\u009c\7T\2\2\u009c\u009d\7Q\2\2\u009d\u009e\7I\2\2\u009e\u009f"+
		"\7T\2\2\u009f\u00a0\7C\2\2\u00a0\u00a1\7O\2\2\u00a1\u00a2\7C\2\2\u00a2"+
		"\20\3\2\2\2\u00a3\u00a4\7U\2\2\u00a4\u00a5\7W\2\2\u00a5\u00a6\7D\2\2\u00a6"+
		"\u00a7\7R\2\2\u00a7\u00a8\7T\2\2\u00a8\u00a9\7Q\2\2\u00a9\u00aa\7I\2\2"+
		"\u00aa\u00ab\7T\2\2\u00ab\u00ac\7C\2\2\u00ac\u00ad\7O\2\2\u00ad\u00ae"+
		"\7C\2\2\u00ae\u00af\7U\2\2\u00af\22\3\2\2\2\u00b0\u00b1\7K\2\2\u00b1\u00b2"+
		"\7P\2\2\u00b2\u00b3\7U\2\2\u00b3\u00b4\7V\2\2\u00b4\u00b5\7T\2\2\u00b5"+
		"\u00b6\7W\2\2\u00b6\u00b7\7E\2\2\u00b7\u00b8\7E\2\2\u00b8\u00b9\7K\2\2"+
		"\u00b9\u00ba\7Q\2\2\u00ba\u00bb\7P\2\2\u00bb\u00bc\7G\2\2\u00bc\u00bd"+
		"\7U\2\2\u00bd\24\3\2\2\2\u00be\u00bf\7H\2\2\u00bf\u00c0\7W\2\2\u00c0\u00c1"+
		"\7P\2\2\u00c1\u00c2\7E\2\2\u00c2\u00c3\7K\2\2\u00c3\u00c4\7Q\2\2\u00c4"+
		"\u00c5\7P\2\2\u00c5\26\3\2\2\2\u00c6\u00c7\7H\2\2\u00c7\u00c8\7H\2\2\u00c8"+
		"\u00c9\7W\2\2\u00c9\u00ca\7P\2\2\u00ca\u00cb\7E\2\2\u00cb\u00cc\7K\2\2"+
		"\u00cc\u00cd\7Q\2\2\u00cd\u00ce\7P\2\2\u00ce\30\3\2\2\2\u00cf\u00d0\7"+
		"f\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2\7x\2\2\u00d2\32\3\2\2\2\u00d3\u00d4"+
		"\7R\2\2\u00d4\u00d5\7T\2\2\u00d5\u00d6\7Q\2\2\u00d6\u00d7\7E\2\2\u00d7"+
		"\u00d8\7G\2\2\u00d8\u00d9\7F\2\2\u00d9\u00da\7K\2\2\u00da\u00db\7O\2\2"+
		"\u00db\u00dc\7K\2\2\u00dc\u00dd\7G\2\2\u00dd\u00de\7P\2\2\u00de\u00df"+
		"\7V\2\2\u00df\u00e0\7Q\2\2\u00e0\34\3\2\2\2\u00e1\u00e2\7H\2\2\u00e2\u00e3"+
		"\7R\2\2\u00e3\u00e4\7T\2\2\u00e4\u00e5\7Q\2\2\u00e5\u00e6\7E\2\2\u00e6"+
		"\u00e7\7G\2\2\u00e7\u00e8\7F\2\2\u00e8\u00e9\7K\2\2\u00e9\u00ea\7O\2\2"+
		"\u00ea\u00eb\7K\2\2\u00eb\u00ec\7G\2\2\u00ec\u00ed\7P\2\2\u00ed\u00ee"+
		"\7V\2\2\u00ee\u00ef\7Q\2\2\u00ef\36\3\2\2\2\u00f0\u00f1\7G\2\2\u00f1\u00f2"+
		"\7X\2\2\u00f2\u00f3\7C\2\2\u00f3\u00f4\7N\2\2\u00f4 \3\2\2\2\u00f5\u00f6"+
		"\7F\2\2\u00f6\u00f7\7G\2\2\u00f7\u00f8\7H\2\2\u00f8\"\3\2\2\2\u00f9\u00fa"+
		"\7P\2\2\u00fa\u00fb\7W\2\2\u00fb\u00fc\7O\2\2\u00fc$\3\2\2\2\u00fd\u00fe"+
		"\7N\2\2\u00fe\u00ff\7Q\2\2\u00ff\u0100\7I\2\2\u0100&\3\2\2\2\u0101\u0102"+
		"\7U\2\2\u0102\u0103\7G\2\2\u0103\u0104\7S\2\2\u0104\u0105\7*\2\2\u0105"+
		"\u0106\7P\2\2\u0106\u0107\7W\2\2\u0107\u0108\7O\2\2\u0108\u0109\7+\2\2"+
		"\u0109(\3\2\2\2\u010a\u010b\7U\2\2\u010b\u010c\7G\2\2\u010c\u010d\7S\2"+
		"\2\u010d\u010e\7*\2\2\u010e\u010f\7D\2\2\u010f\u0110\7Q\2\2\u0110\u0111"+
		"\7Q\2\2\u0111\u0112\7N\2\2\u0112\u0113\7+\2\2\u0113*\3\2\2\2\u0114\u0115"+
		"\7U\2\2\u0115\u0116\7G\2\2\u0116\u0117\7S\2\2\u0117,\3\2\2\2\u0118\u0120"+
		"\7V\2\2\u0119\u011a\7e\2\2\u011a\u011b\7k\2\2\u011b\u011c\7g\2\2\u011c"+
		"\u011d\7t\2\2\u011d\u011e\7v\2\2\u011e\u0120\7q\2\2\u011f\u0118\3\2\2"+
		"\2\u011f\u0119\3\2\2\2\u0120.\3\2\2\2\u0121\u0128\7H\2\2\u0122\u0123\7"+
		"h\2\2\u0123\u0124\7c\2\2\u0124\u0125\7n\2\2\u0125\u0126\7u\2\2\u0126\u0128"+
		"\7q\2\2\u0127\u0121\3\2\2\2\u0127\u0122\3\2\2\2\u0128\60\3\2\2\2\u0129"+
		"\u012a\7t\2\2\u012a\u012b\7w\2\2\u012b\u012c\7r\2\2\u012c\u012d\7v\2\2"+
		"\u012d\u012e\7w\2\2\u012e\u012f\7t\2\2\u012f\u0130\7c\2\2\u0130\62\3\2"+
		"\2\2\u0131\u0132\7u\2\2\u0132\u0133\7k\2\2\u0133\64\3\2\2\2\u0134\u0135"+
		"\7g\2\2\u0135\u0136\7p\2\2\u0136\u0137\7v\2\2\u0137\u0138\7q\2\2\u0138"+
		"\u0139\7p\2\2\u0139\u013a\7e\2\2\u013a\u013b\7g\2\2\u013b\u013c\7u\2\2"+
		"\u013c\66\3\2\2\2\u013d\u013e\7h\2\2\u013e\u013f\7u\2\2\u013f\u0140\7"+
		"k\2\2\u01408\3\2\2\2\u0141\u0142\7u\2\2\u0142\u0143\7k\2\2\u0143\u0144"+
		"\7p\2\2\u0144\u0145\7q\2\2\u0145:\3\2\2\2\u0146\u0147\7o\2\2\u0147\u0148"+
		"\7k\2\2\u0148\u0149\7g\2\2\u0149\u014a\7p\2\2\u014a\u014b\7v\2\2\u014b"+
		"\u014c\7t\2\2\u014c\u014d\7c\2\2\u014d\u014e\7u\2\2\u014e<\3\2\2\2\u014f"+
		"\u0150\7j\2\2\u0150\u0151\7c\2\2\u0151\u0152\7e\2\2\u0152\u0153\7g\2\2"+
		"\u0153\u0154\7t\2\2\u0154>\3\2\2\2\u0155\u0156\7h\2\2\u0156\u0157\7o\2"+
		"\2\u0157\u0158\7k\2\2\u0158\u0159\7g\2\2\u0159\u015a\7p\2\2\u015a\u015b"+
		"\7v\2\2\u015b\u015c\7t\2\2\u015c\u015d\7c\2\2\u015d\u015e\7u\2\2\u015e"+
		"@\3\2\2\2\u015f\u0160\7R\2\2\u0160\u0161\7C\2\2\u0161\u0162\7T\2\2\u0162"+
		"\u0163\7C\2\2\u0163\u0164\7V\2\2\u0164\u0165\7Q\2\2\u0165\u0166\7F\2\2"+
		"\u0166\u0167\7Q\2\2\u0167B\3\2\2\2\u0168\u0169\7G\2\2\u0169\u016a\7Z\2"+
		"\2\u016a\u016b\7K\2\2\u016b\u016c\7U\2\2\u016c\u016d\7V\2\2\u016d\u016e"+
		"\7G\2\2\u016eD\3\2\2\2\u016f\u0170\7c\2\2\u0170\u0171\7x\2\2\u0171\u0172"+
		"\7c\2\2\u0172\u0173\7p\2\2\u0173\u0174\7e\2\2\u0174\u0175\7g\2\2\u0175"+
		"F\3\2\2\2\u0176\u0177\7o\2\2\u0177\u0178\7q\2\2\u0178\u0179\7u\2\2\u0179"+
		"\u017a\7v\2\2\u017a\u017b\7t\2\2\u017b\u017c\7c\2\2\u017c\u017d\7t\2\2"+
		"\u017dH\3\2\2\2\u017e\u0180\5\t\5\2\u017f\u017e\3\2\2\2\u0180\u0181\3"+
		"\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182J\3\2\2\2\u0183\u0189"+
		"\5\13\6\2\u0184\u0188\5\13\6\2\u0185\u0188\5\t\5\2\u0186\u0188\7a\2\2"+
		"\u0187\u0184\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0186\3\2\2\2\u0188\u018b"+
		"\3\2\2\2\u0189\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018aL\3\2\2\2\u018b"+
		"\u0189\3\2\2\2\u018c\u018d\7<\2\2\u018dN\3\2\2\2\u018e\u018f\7*\2\2\u018f"+
		"P\3\2\2\2\u0190\u0191\7+\2\2\u0191R\3\2\2\2\u0192\u0193\7]\2\2\u0193T"+
		"\3\2\2\2\u0194\u0195\7_\2\2\u0195V\3\2\2\2\u0196\u0197\7}\2\2\u0197X\3"+
		"\2\2\2\u0198\u0199\7\177\2\2\u0199Z\3\2\2\2\u019a\u019b\7=\2\2\u019b\\"+
		"\3\2\2\2\u019c\u019d\7.\2\2\u019d^\3\2\2\2\u019e\u019f\7,\2\2\u019f`\3"+
		"\2\2\2\u01a0\u01a1\7-\2\2\u01a1b\3\2\2\2\u01a2\u01a3\7/\2\2\u01a3d\3\2"+
		"\2\2\u01a4\u01a5\7?\2\2\u01a5f\3\2\2\2\u01a6\u01a7\7?\2\2\u01a7\u01a8"+
		"\7?\2\2\u01a8h\3\2\2\2\u01a9\u01aa\7#\2\2\u01aa\u01ab\7?\2\2\u01abj\3"+
		"\2\2\2\u01ac\u01ad\7>\2\2\u01ad\u01ae\7?\2\2\u01ael\3\2\2\2\u01af\u01b0"+
		"\7@\2\2\u01b0\u01b1\7?\2\2\u01b1n\3\2\2\2\u01b2\u01b3\7>\2\2\u01b3p\3"+
		"\2\2\2\u01b4\u01b5\7@\2\2\u01b5r\3\2\2\2\u01b6\u01b7\7#\2\2\u01b7t\3\2"+
		"\2\2\u01b8\u01b9\7(\2\2\u01b9\u01ba\7(\2\2\u01bav\3\2\2\2\u01bb\u01bc"+
		"\7~\2\2\u01bc\u01bd\7~\2\2\u01bdx\3\2\2\2\u01be\u01bf\7\61\2\2\u01bf\u01c0"+
		"\7,\2\2\u01c0\u01c4\3\2\2\2\u01c1\u01c3\13\2\2\2\u01c2\u01c1\3\2\2\2\u01c3"+
		"\u01c6\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5\u01c7\3\2"+
		"\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01c8\7,\2\2\u01c8\u01c9\7\61\2\2\u01c9"+
		"\u01ca\3\2\2\2\u01ca\u01cb\b=\2\2\u01cbz\3\2\2\2\u01cc\u01cd\7\61\2\2"+
		"\u01cd\u01ce\7\61\2\2\u01ce\u01d2\3\2\2\2\u01cf\u01d1\13\2\2\2\u01d0\u01cf"+
		"\3\2\2\2\u01d1\u01d4\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3"+
		"\u01d5\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d5\u01d6\5\7\4\2\u01d6\u01d7\3\2"+
		"\2\2\u01d7\u01d8\b>\2\2\u01d8|\3\2\2\2\13\2\u0086\u011f\u0127\u0181\u0187"+
		"\u0189\u01c4\u01d2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}