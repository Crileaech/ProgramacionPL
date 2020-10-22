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
		EVAL=13, DEF=14, NUMERO=15, BOOL=16, SEQUEN=17, TIPO=18, T=19, F=20, BREAK=21, 
		IF=22, THEN=23, ENDIF=24, ELSE=25, WHILE=26, DO=27, ENDWHILE=28, FORALL=29, 
		EXIST=30, AVANZA=31, NUM=32, VAR=33, DOSPTOS=34, PA=35, PC=36, CA=37, 
		CC=38, LLAVEA=39, LLAVEC=40, PyC=41, COMA=42, SUMA=43, RESTA=44, POR=45, 
		IGUAL=46, IGUALL=47, DISTINTO=48, MENORIGUAL=49, MAYORIGUAL=50, MENOR=51, 
		MAYOR=52, NO=53, AND=54, OR=55, COMENTARIO_BLOQUE=56, COMENTARIO_LINEA=57;
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
			"FPROCEDIMIENTO", "EVAL", "DEF", "NUMERO", "BOOL", "SEQUEN", "TIPO", 
			"T", "F", "BREAK", "IF", "THEN", "ENDIF", "ELSE", "WHILE", "DO", "ENDWHILE", 
			"FORALL", "EXIST", "AVANZA", "NUM", "VAR", "DOSPTOS", "PA", "PC", "CA", 
			"CC", "LLAVEA", "LLAVEC", "PyC", "COMA", "SUMA", "RESTA", "POR", "IGUAL", 
			"IGUALL", "DISTINTO", "MENORIGUAL", "MAYORIGUAL", "MENOR", "MAYOR", "NO", 
			"AND", "OR", "COMENTARIO_BLOQUE", "COMENTARIO_LINEA"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", "'\t'", null, "'VARIABLES'", "'PROGRAMA'", "'SUBPROGRAMAS'", 
			"'INSTRUCCIONES'", "'FUNCION'", "'FFUNCION'", "'dev'", "'PROCEDIMIENTO'", 
			"'FPROCEDIMIENTO'", "'EVAL'", "'DEF'", "'NUM'", "'LOG'", "'SEQ'", null, 
			null, null, "'ruptura'", "'si'", "'entonces'", "'fsi'", "'sino'", "'mientras'", 
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
			"EVAL", "DEF", "NUMERO", "BOOL", "SEQUEN", "TIPO", "T", "F", "BREAK", 
			"IF", "THEN", "ENDIF", "ELSE", "WHILE", "DO", "ENDWHILE", "FORALL", "EXIST", 
			"AVANZA", "NUM", "VAR", "DOSPTOS", "PA", "PC", "CA", "CC", "LLAVEA", 
			"LLAVEC", "PyC", "COMA", "SUMA", "RESTA", "POR", "IGUAL", "IGUALL", "DISTINTO", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2;\u01be\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\5\4\u0083\n\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\5\25\u0105"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u010e\n\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\5\27\u0116\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\6#\u0166\n#\r#\16#\u0167\3$\3$\3$\7$\u016d"+
		"\n$\f$\16$\u0170\13$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3"+
		",\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63"+
		"\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\39\3:\3"+
		":\3:\3;\3;\3;\3;\7;\u01a8\n;\f;\16;\u01ab\13;\3;\3;\3;\3;\3;\3<\3<\3<"+
		"\3<\7<\u01b6\n<\f<\16<\u01b9\13<\3<\3<\3<\3<\4\u01a9\u01b7\2=\3\3\5\4"+
		"\7\5\t\2\13\2\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17!\20"+
		"#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36?\37"+
		"A C!E\"G#I$K%M&O\'Q(S)U*W+Y,[-]._/a\60c\61e\62g\63i\64k\65m\66o\67q8s"+
		"9u:w;\3\2\4\3\2\62;\4\2C\\c|\2\u01c5\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\3y"+
		"\3\2\2\2\5}\3\2\2\2\7\u0082\3\2\2\2\t\u0088\3\2\2\2\13\u008a\3\2\2\2\r"+
		"\u008c\3\2\2\2\17\u0096\3\2\2\2\21\u009f\3\2\2\2\23\u00ac\3\2\2\2\25\u00ba"+
		"\3\2\2\2\27\u00c2\3\2\2\2\31\u00cb\3\2\2\2\33\u00cf\3\2\2\2\35\u00dd\3"+
		"\2\2\2\37\u00ec\3\2\2\2!\u00f1\3\2\2\2#\u00f5\3\2\2\2%\u00f9\3\2\2\2\'"+
		"\u00fd\3\2\2\2)\u0104\3\2\2\2+\u010d\3\2\2\2-\u0115\3\2\2\2/\u0117\3\2"+
		"\2\2\61\u011f\3\2\2\2\63\u0122\3\2\2\2\65\u012b\3\2\2\2\67\u012f\3\2\2"+
		"\29\u0134\3\2\2\2;\u013d\3\2\2\2=\u0143\3\2\2\2?\u014d\3\2\2\2A\u0156"+
		"\3\2\2\2C\u015d\3\2\2\2E\u0165\3\2\2\2G\u0169\3\2\2\2I\u0171\3\2\2\2K"+
		"\u0173\3\2\2\2M\u0175\3\2\2\2O\u0177\3\2\2\2Q\u0179\3\2\2\2S\u017b\3\2"+
		"\2\2U\u017d\3\2\2\2W\u017f\3\2\2\2Y\u0181\3\2\2\2[\u0183\3\2\2\2]\u0185"+
		"\3\2\2\2_\u0187\3\2\2\2a\u0189\3\2\2\2c\u018b\3\2\2\2e\u018e\3\2\2\2g"+
		"\u0191\3\2\2\2i\u0194\3\2\2\2k\u0197\3\2\2\2m\u0199\3\2\2\2o\u019b\3\2"+
		"\2\2q\u019d\3\2\2\2s\u01a0\3\2\2\2u\u01a3\3\2\2\2w\u01b1\3\2\2\2yz\7\""+
		"\2\2z{\3\2\2\2{|\b\2\2\2|\4\3\2\2\2}~\7\13\2\2~\177\3\2\2\2\177\u0080"+
		"\b\3\2\2\u0080\6\3\2\2\2\u0081\u0083\7\17\2\2\u0082\u0081\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\f\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\u0087\b\4\2\2\u0087\b\3\2\2\2\u0088\u0089\t\2\2\2\u0089\n\3"+
		"\2\2\2\u008a\u008b\t\3\2\2\u008b\f\3\2\2\2\u008c\u008d\7X\2\2\u008d\u008e"+
		"\7C\2\2\u008e\u008f\7T\2\2\u008f\u0090\7K\2\2\u0090\u0091\7C\2\2\u0091"+
		"\u0092\7D\2\2\u0092\u0093\7N\2\2\u0093\u0094\7G\2\2\u0094\u0095\7U\2\2"+
		"\u0095\16\3\2\2\2\u0096\u0097\7R\2\2\u0097\u0098\7T\2\2\u0098\u0099\7"+
		"Q\2\2\u0099\u009a\7I\2\2\u009a\u009b\7T\2\2\u009b\u009c\7C\2\2\u009c\u009d"+
		"\7O\2\2\u009d\u009e\7C\2\2\u009e\20\3\2\2\2\u009f\u00a0\7U\2\2\u00a0\u00a1"+
		"\7W\2\2\u00a1\u00a2\7D\2\2\u00a2\u00a3\7R\2\2\u00a3\u00a4\7T\2\2\u00a4"+
		"\u00a5\7Q\2\2\u00a5\u00a6\7I\2\2\u00a6\u00a7\7T\2\2\u00a7\u00a8\7C\2\2"+
		"\u00a8\u00a9\7O\2\2\u00a9\u00aa\7C\2\2\u00aa\u00ab\7U\2\2\u00ab\22\3\2"+
		"\2\2\u00ac\u00ad\7K\2\2\u00ad\u00ae\7P\2\2\u00ae\u00af\7U\2\2\u00af\u00b0"+
		"\7V\2\2\u00b0\u00b1\7T\2\2\u00b1\u00b2\7W\2\2\u00b2\u00b3\7E\2\2\u00b3"+
		"\u00b4\7E\2\2\u00b4\u00b5\7K\2\2\u00b5\u00b6\7Q\2\2\u00b6\u00b7\7P\2\2"+
		"\u00b7\u00b8\7G\2\2\u00b8\u00b9\7U\2\2\u00b9\24\3\2\2\2\u00ba\u00bb\7"+
		"H\2\2\u00bb\u00bc\7W\2\2\u00bc\u00bd\7P\2\2\u00bd\u00be\7E\2\2\u00be\u00bf"+
		"\7K\2\2\u00bf\u00c0\7Q\2\2\u00c0\u00c1\7P\2\2\u00c1\26\3\2\2\2\u00c2\u00c3"+
		"\7H\2\2\u00c3\u00c4\7H\2\2\u00c4\u00c5\7W\2\2\u00c5\u00c6\7P\2\2\u00c6"+
		"\u00c7\7E\2\2\u00c7\u00c8\7K\2\2\u00c8\u00c9\7Q\2\2\u00c9\u00ca\7P\2\2"+
		"\u00ca\30\3\2\2\2\u00cb\u00cc\7f\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7"+
		"x\2\2\u00ce\32\3\2\2\2\u00cf\u00d0\7R\2\2\u00d0\u00d1\7T\2\2\u00d1\u00d2"+
		"\7Q\2\2\u00d2\u00d3\7E\2\2\u00d3\u00d4\7G\2\2\u00d4\u00d5\7F\2\2\u00d5"+
		"\u00d6\7K\2\2\u00d6\u00d7\7O\2\2\u00d7\u00d8\7K\2\2\u00d8\u00d9\7G\2\2"+
		"\u00d9\u00da\7P\2\2\u00da\u00db\7V\2\2\u00db\u00dc\7Q\2\2\u00dc\34\3\2"+
		"\2\2\u00dd\u00de\7H\2\2\u00de\u00df\7R\2\2\u00df\u00e0\7T\2\2\u00e0\u00e1"+
		"\7Q\2\2\u00e1\u00e2\7E\2\2\u00e2\u00e3\7G\2\2\u00e3\u00e4\7F\2\2\u00e4"+
		"\u00e5\7K\2\2\u00e5\u00e6\7O\2\2\u00e6\u00e7\7K\2\2\u00e7\u00e8\7G\2\2"+
		"\u00e8\u00e9\7P\2\2\u00e9\u00ea\7V\2\2\u00ea\u00eb\7Q\2\2\u00eb\36\3\2"+
		"\2\2\u00ec\u00ed\7G\2\2\u00ed\u00ee\7X\2\2\u00ee\u00ef\7C\2\2\u00ef\u00f0"+
		"\7N\2\2\u00f0 \3\2\2\2\u00f1\u00f2\7F\2\2\u00f2\u00f3\7G\2\2\u00f3\u00f4"+
		"\7H\2\2\u00f4\"\3\2\2\2\u00f5\u00f6\7P\2\2\u00f6\u00f7\7W\2\2\u00f7\u00f8"+
		"\7O\2\2\u00f8$\3\2\2\2\u00f9\u00fa\7N\2\2\u00fa\u00fb\7Q\2\2\u00fb\u00fc"+
		"\7I\2\2\u00fc&\3\2\2\2\u00fd\u00fe\7U\2\2\u00fe\u00ff\7G\2\2\u00ff\u0100"+
		"\7S\2\2\u0100(\3\2\2\2\u0101\u0105\5\'\24\2\u0102\u0105\5#\22\2\u0103"+
		"\u0105\5%\23\2\u0104\u0101\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0103\3\2"+
		"\2\2\u0105*\3\2\2\2\u0106\u010e\7V\2\2\u0107\u0108\7e\2\2\u0108\u0109"+
		"\7k\2\2\u0109\u010a\7g\2\2\u010a\u010b\7t\2\2\u010b\u010c\7v\2\2\u010c"+
		"\u010e\7q\2\2\u010d\u0106\3\2\2\2\u010d\u0107\3\2\2\2\u010e,\3\2\2\2\u010f"+
		"\u0116\7H\2\2\u0110\u0111\7h\2\2\u0111\u0112\7c\2\2\u0112\u0113\7n\2\2"+
		"\u0113\u0114\7u\2\2\u0114\u0116\7q\2\2\u0115\u010f\3\2\2\2\u0115\u0110"+
		"\3\2\2\2\u0116.\3\2\2\2\u0117\u0118\7t\2\2\u0118\u0119\7w\2\2\u0119\u011a"+
		"\7r\2\2\u011a\u011b\7v\2\2\u011b\u011c\7w\2\2\u011c\u011d\7t\2\2\u011d"+
		"\u011e\7c\2\2\u011e\60\3\2\2\2\u011f\u0120\7u\2\2\u0120\u0121\7k\2\2\u0121"+
		"\62\3\2\2\2\u0122\u0123\7g\2\2\u0123\u0124\7p\2\2\u0124\u0125\7v\2\2\u0125"+
		"\u0126\7q\2\2\u0126\u0127\7p\2\2\u0127\u0128\7e\2\2\u0128\u0129\7g\2\2"+
		"\u0129\u012a\7u\2\2\u012a\64\3\2\2\2\u012b\u012c\7h\2\2\u012c\u012d\7"+
		"u\2\2\u012d\u012e\7k\2\2\u012e\66\3\2\2\2\u012f\u0130\7u\2\2\u0130\u0131"+
		"\7k\2\2\u0131\u0132\7p\2\2\u0132\u0133\7q\2\2\u01338\3\2\2\2\u0134\u0135"+
		"\7o\2\2\u0135\u0136\7k\2\2\u0136\u0137\7g\2\2\u0137\u0138\7p\2\2\u0138"+
		"\u0139\7v\2\2\u0139\u013a\7t\2\2\u013a\u013b\7c\2\2\u013b\u013c\7u\2\2"+
		"\u013c:\3\2\2\2\u013d\u013e\7j\2\2\u013e\u013f\7c\2\2\u013f\u0140\7e\2"+
		"\2\u0140\u0141\7g\2\2\u0141\u0142\7t\2\2\u0142<\3\2\2\2\u0143\u0144\7"+
		"h\2\2\u0144\u0145\7o\2\2\u0145\u0146\7k\2\2\u0146\u0147\7g\2\2\u0147\u0148"+
		"\7p\2\2\u0148\u0149\7v\2\2\u0149\u014a\7t\2\2\u014a\u014b\7c\2\2\u014b"+
		"\u014c\7u\2\2\u014c>\3\2\2\2\u014d\u014e\7R\2\2\u014e\u014f\7C\2\2\u014f"+
		"\u0150\7T\2\2\u0150\u0151\7C\2\2\u0151\u0152\7V\2\2\u0152\u0153\7Q\2\2"+
		"\u0153\u0154\7F\2\2\u0154\u0155\7Q\2\2\u0155@\3\2\2\2\u0156\u0157\7G\2"+
		"\2\u0157\u0158\7Z\2\2\u0158\u0159\7K\2\2\u0159\u015a\7U\2\2\u015a\u015b"+
		"\7V\2\2\u015b\u015c\7G\2\2\u015cB\3\2\2\2\u015d\u015e\7c\2\2\u015e\u015f"+
		"\7x\2\2\u015f\u0160\7c\2\2\u0160\u0161\7p\2\2\u0161\u0162\7e\2\2\u0162"+
		"\u0163\7g\2\2\u0163D\3\2\2\2\u0164\u0166\5\t\5\2\u0165\u0164\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168F\3\2\2\2"+
		"\u0169\u016e\5\13\6\2\u016a\u016d\5\13\6\2\u016b\u016d\5\t\5\2\u016c\u016a"+
		"\3\2\2\2\u016c\u016b\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016c\3\2\2\2\u016e"+
		"\u016f\3\2\2\2\u016fH\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0172\7<\2\2\u0172"+
		"J\3\2\2\2\u0173\u0174\7*\2\2\u0174L\3\2\2\2\u0175\u0176\7+\2\2\u0176N"+
		"\3\2\2\2\u0177\u0178\7]\2\2\u0178P\3\2\2\2\u0179\u017a\7_\2\2\u017aR\3"+
		"\2\2\2\u017b\u017c\7}\2\2\u017cT\3\2\2\2\u017d\u017e\7\177\2\2\u017eV"+
		"\3\2\2\2\u017f\u0180\7=\2\2\u0180X\3\2\2\2\u0181\u0182\7.\2\2\u0182Z\3"+
		"\2\2\2\u0183\u0184\7-\2\2\u0184\\\3\2\2\2\u0185\u0186\7/\2\2\u0186^\3"+
		"\2\2\2\u0187\u0188\7,\2\2\u0188`\3\2\2\2\u0189\u018a\7?\2\2\u018ab\3\2"+
		"\2\2\u018b\u018c\7?\2\2\u018c\u018d\7?\2\2\u018dd\3\2\2\2\u018e\u018f"+
		"\7#\2\2\u018f\u0190\7?\2\2\u0190f\3\2\2\2\u0191\u0192\7>\2\2\u0192\u0193"+
		"\7?\2\2\u0193h\3\2\2\2\u0194\u0195\7@\2\2\u0195\u0196\7?\2\2\u0196j\3"+
		"\2\2\2\u0197\u0198\7>\2\2\u0198l\3\2\2\2\u0199\u019a\7@\2\2\u019an\3\2"+
		"\2\2\u019b\u019c\7#\2\2\u019cp\3\2\2\2\u019d\u019e\7(\2\2\u019e\u019f"+
		"\7(\2\2\u019fr\3\2\2\2\u01a0\u01a1\7~\2\2\u01a1\u01a2\7~\2\2\u01a2t\3"+
		"\2\2\2\u01a3\u01a4\7\61\2\2\u01a4\u01a5\7,\2\2\u01a5\u01a9\3\2\2\2\u01a6"+
		"\u01a8\13\2\2\2\u01a7\u01a6\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01aa\3"+
		"\2\2\2\u01a9\u01a7\3\2\2\2\u01aa\u01ac\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ac"+
		"\u01ad\7,\2\2\u01ad\u01ae\7\61\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\b;"+
		"\2\2\u01b0v\3\2\2\2\u01b1\u01b2\7\61\2\2\u01b2\u01b3\7\61\2\2\u01b3\u01b7"+
		"\3\2\2\2\u01b4\u01b6\13\2\2\2\u01b5\u01b4\3\2\2\2\u01b6\u01b9\3\2\2\2"+
		"\u01b7\u01b8\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b8\u01ba\3\2\2\2\u01b9\u01b7"+
		"\3\2\2\2\u01ba\u01bb\5\7\4\2\u01bb\u01bc\3\2\2\2\u01bc\u01bd\b<\2\2\u01bd"+
		"x\3\2\2\2\f\2\u0082\u0104\u010d\u0115\u0167\u016c\u016e\u01a9\u01b7\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}