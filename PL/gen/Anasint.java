// Generated from C:/Users/Enrique/Desktop/PL/src\Anasint.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Anasint extends Parser {
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
	public static final int
		RULE_programa = 0, RULE_variables = 1, RULE_subprogramas = 2, RULE_instrucciones = 3, 
		RULE_declaracion_variables = 4, RULE_identificador = 5, RULE_elementales = 6, 
		RULE_secuencias = 7, RULE_tipos = 8, RULE_tipos_elementales = 9, RULE_tipos_no_elementales = 10, 
		RULE_declaracion_subprogramas = 11, RULE_funcion = 12, RULE_procedimiento = 13, 
		RULE_params = 14, RULE_expr = 15, RULE_expr_integer = 16, RULE_expr_bool = 17, 
		RULE_expr_seq = 18, RULE_expr_avanza = 19, RULE_expr_func = 20, RULE_declaracion_instrucciones = 21, 
		RULE_asignacion = 22, RULE_condicion = 23, RULE_blq_sino = 24, RULE_iteracion = 25, 
		RULE_mostrar = 26, RULE_asertos = 27, RULE_cuantificador = 28, RULE_cuantificadorUniversal = 29, 
		RULE_cuantificadorExistencial = 30, RULE_cuantificacion = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "variables", "subprogramas", "instrucciones", "declaracion_variables", 
			"identificador", "elementales", "secuencias", "tipos", "tipos_elementales", 
			"tipos_no_elementales", "declaracion_subprogramas", "funcion", "procedimiento", 
			"params", "expr", "expr_integer", "expr_bool", "expr_seq", "expr_avanza", 
			"expr_func", "declaracion_instrucciones", "asignacion", "condicion", 
			"blq_sino", "iteracion", "mostrar", "asertos", "cuantificador", "cuantificadorUniversal", 
			"cuantificadorExistencial", "cuantificacion"
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

	@Override
	public String getGrammarFileName() { return "Anasint.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Anasint(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode PROGRAMA() { return getToken(Anasint.PROGRAMA, 0); }
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public SubprogramasContext subprogramas() {
			return getRuleContext(SubprogramasContext.class,0);
		}
		public InstruccionesContext instrucciones() {
			return getRuleContext(InstruccionesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Anasint.EOF, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(PROGRAMA);
			setState(65);
			variables();
			setState(66);
			subprogramas();
			setState(67);
			instrucciones();
			setState(68);
			match(EOF);
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

	public static class VariablesContext extends ParserRuleContext {
		public TerminalNode VARIABLES() { return getToken(Anasint.VARIABLES, 0); }
		public List<Declaracion_variablesContext> declaracion_variables() {
			return getRuleContexts(Declaracion_variablesContext.class);
		}
		public Declaracion_variablesContext declaracion_variables(int i) {
			return getRuleContext(Declaracion_variablesContext.class,i);
		}
		public VariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariablesContext variables() throws RecognitionException {
		VariablesContext _localctx = new VariablesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_variables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(VARIABLES);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR) {
				{
				{
				setState(71);
				declaracion_variables();
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class SubprogramasContext extends ParserRuleContext {
		public TerminalNode SUBPROGRAMAS() { return getToken(Anasint.SUBPROGRAMAS, 0); }
		public List<Declaracion_subprogramasContext> declaracion_subprogramas() {
			return getRuleContexts(Declaracion_subprogramasContext.class);
		}
		public Declaracion_subprogramasContext declaracion_subprogramas(int i) {
			return getRuleContext(Declaracion_subprogramasContext.class,i);
		}
		public SubprogramasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subprogramas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterSubprogramas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitSubprogramas(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitSubprogramas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubprogramasContext subprogramas() throws RecognitionException {
		SubprogramasContext _localctx = new SubprogramasContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_subprogramas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(SUBPROGRAMAS);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCION || _la==PROCEDIMIENTO) {
				{
				{
				setState(78);
				declaracion_subprogramas();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class InstruccionesContext extends ParserRuleContext {
		public TerminalNode INSTRUCCIONES() { return getToken(Anasint.INSTRUCCIONES, 0); }
		public List<Declaracion_instruccionesContext> declaracion_instrucciones() {
			return getRuleContexts(Declaracion_instruccionesContext.class);
		}
		public Declaracion_instruccionesContext declaracion_instrucciones(int i) {
			return getRuleContext(Declaracion_instruccionesContext.class,i);
		}
		public InstruccionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucciones; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterInstrucciones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitInstrucciones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitInstrucciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionesContext instrucciones() throws RecognitionException {
		InstruccionesContext _localctx = new InstruccionesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instrucciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(INSTRUCCIONES);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BREAK) | (1L << IF) | (1L << WHILE) | (1L << MOSTRAR) | (1L << VAR) | (1L << LA))) != 0)) {
				{
				{
				setState(85);
				declaracion_instrucciones();
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Declaracion_variablesContext extends ParserRuleContext {
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public TerminalNode PyC() { return getToken(Anasint.PyC, 0); }
		public Declaracion_variablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion_variables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterDeclaracion_variables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitDeclaracion_variables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitDeclaracion_variables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracion_variablesContext declaracion_variables() throws RecognitionException {
		Declaracion_variablesContext _localctx = new Declaracion_variablesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaracion_variables);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			identificador();
			setState(92);
			match(PyC);
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

	public static class IdentificadorContext extends ParserRuleContext {
		public ElementalesContext elementales() {
			return getRuleContext(ElementalesContext.class,0);
		}
		public SecuenciasContext secuencias() {
			return getRuleContext(SecuenciasContext.class,0);
		}
		public IdentificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identificador; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterIdentificador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitIdentificador(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitIdentificador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentificadorContext identificador() throws RecognitionException {
		IdentificadorContext _localctx = new IdentificadorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_identificador);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				elementales();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				secuencias();
				}
				break;
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

	public static class ElementalesContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(Anasint.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(Anasint.VAR, i);
		}
		public TerminalNode DOSPTOS() { return getToken(Anasint.DOSPTOS, 0); }
		public Tipos_elementalesContext tipos_elementales() {
			return getRuleContext(Tipos_elementalesContext.class,0);
		}
		public List<TerminalNode> COMA() { return getTokens(Anasint.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(Anasint.COMA, i);
		}
		public ElementalesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementales; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterElementales(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitElementales(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitElementales(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementalesContext elementales() throws RecognitionException {
		ElementalesContext _localctx = new ElementalesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_elementales);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(98);
					match(VAR);
					setState(99);
					match(COMA);
					}
					} 
				}
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(105);
			match(VAR);
			setState(106);
			match(DOSPTOS);
			setState(107);
			tipos_elementales();
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

	public static class SecuenciasContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(Anasint.VAR, 0); }
		public TerminalNode DOSPTOS() { return getToken(Anasint.DOSPTOS, 0); }
		public Tipos_no_elementalesContext tipos_no_elementales() {
			return getRuleContext(Tipos_no_elementalesContext.class,0);
		}
		public SecuenciasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_secuencias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterSecuencias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitSecuencias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitSecuencias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SecuenciasContext secuencias() throws RecognitionException {
		SecuenciasContext _localctx = new SecuenciasContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_secuencias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(VAR);
			setState(110);
			match(DOSPTOS);
			setState(111);
			tipos_no_elementales();
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

	public static class TiposContext extends ParserRuleContext {
		public Tipos_elementalesContext tipos_elementales() {
			return getRuleContext(Tipos_elementalesContext.class,0);
		}
		public Tipos_no_elementalesContext tipos_no_elementales() {
			return getRuleContext(Tipos_no_elementalesContext.class,0);
		}
		public TiposContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterTipos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitTipos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitTipos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TiposContext tipos() throws RecognitionException {
		TiposContext _localctx = new TiposContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tipos);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERO:
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				tipos_elementales();
				}
				break;
			case SEQ_NUM:
			case SEQ_BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				tipos_no_elementales();
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

	public static class Tipos_elementalesContext extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(Anasint.NUMERO, 0); }
		public TerminalNode BOOL() { return getToken(Anasint.BOOL, 0); }
		public Tipos_elementalesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipos_elementales; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterTipos_elementales(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitTipos_elementales(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitTipos_elementales(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipos_elementalesContext tipos_elementales() throws RecognitionException {
		Tipos_elementalesContext _localctx = new Tipos_elementalesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tipos_elementales);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_la = _input.LA(1);
			if ( !(_la==NUMERO || _la==BOOL) ) {
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

	public static class Tipos_no_elementalesContext extends ParserRuleContext {
		public TerminalNode SEQ_NUM() { return getToken(Anasint.SEQ_NUM, 0); }
		public TerminalNode SEQ_BOOL() { return getToken(Anasint.SEQ_BOOL, 0); }
		public Tipos_no_elementalesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipos_no_elementales; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterTipos_no_elementales(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitTipos_no_elementales(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitTipos_no_elementales(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipos_no_elementalesContext tipos_no_elementales() throws RecognitionException {
		Tipos_no_elementalesContext _localctx = new Tipos_no_elementalesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tipos_no_elementales);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_la = _input.LA(1);
			if ( !(_la==SEQ_NUM || _la==SEQ_BOOL) ) {
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

	public static class Declaracion_subprogramasContext extends ParserRuleContext {
		public FuncionContext funcion() {
			return getRuleContext(FuncionContext.class,0);
		}
		public ProcedimientoContext procedimiento() {
			return getRuleContext(ProcedimientoContext.class,0);
		}
		public Declaracion_subprogramasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion_subprogramas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterDeclaracion_subprogramas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitDeclaracion_subprogramas(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitDeclaracion_subprogramas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracion_subprogramasContext declaracion_subprogramas() throws RecognitionException {
		Declaracion_subprogramasContext _localctx = new Declaracion_subprogramasContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_declaracion_subprogramas);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNCION:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				funcion();
				}
				break;
			case PROCEDIMIENTO:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				procedimiento();
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

	public static class FuncionContext extends ParserRuleContext {
		public TerminalNode FUNCION() { return getToken(Anasint.FUNCION, 0); }
		public TerminalNode VAR() { return getToken(Anasint.VAR, 0); }
		public List<TerminalNode> PA() { return getTokens(Anasint.PA); }
		public TerminalNode PA(int i) {
			return getToken(Anasint.PA, i);
		}
		public List<TerminalNode> PC() { return getTokens(Anasint.PC); }
		public TerminalNode PC(int i) {
			return getToken(Anasint.PC, i);
		}
		public TerminalNode RETURN() { return getToken(Anasint.RETURN, 0); }
		public List<ParamsContext> params() {
			return getRuleContexts(ParamsContext.class);
		}
		public ParamsContext params(int i) {
			return getRuleContext(ParamsContext.class,i);
		}
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public InstruccionesContext instrucciones() {
			return getRuleContext(InstruccionesContext.class,0);
		}
		public TerminalNode FFUNCION() { return getToken(Anasint.FFUNCION, 0); }
		public FuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterFuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitFuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncionContext funcion() throws RecognitionException {
		FuncionContext _localctx = new FuncionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_funcion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(FUNCION);
			setState(126);
			match(VAR);
			setState(127);
			match(PA);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERO) | (1L << BOOL) | (1L << SEQ_NUM) | (1L << SEQ_BOOL))) != 0)) {
				{
				setState(128);
				params();
				}
			}

			setState(131);
			match(PC);
			setState(132);
			match(RETURN);
			setState(133);
			match(PA);
			setState(134);
			params();
			setState(135);
			match(PC);
			setState(136);
			variables();
			setState(137);
			instrucciones();
			setState(138);
			match(FFUNCION);
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

	public static class ProcedimientoContext extends ParserRuleContext {
		public TerminalNode PROCEDIMIENTO() { return getToken(Anasint.PROCEDIMIENTO, 0); }
		public TerminalNode VAR() { return getToken(Anasint.VAR, 0); }
		public TerminalNode PA() { return getToken(Anasint.PA, 0); }
		public TerminalNode PC() { return getToken(Anasint.PC, 0); }
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public InstruccionesContext instrucciones() {
			return getRuleContext(InstruccionesContext.class,0);
		}
		public TerminalNode FPROCEDIMIENTO() { return getToken(Anasint.FPROCEDIMIENTO, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public ProcedimientoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedimiento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterProcedimiento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitProcedimiento(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitProcedimiento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedimientoContext procedimiento() throws RecognitionException {
		ProcedimientoContext _localctx = new ProcedimientoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_procedimiento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(PROCEDIMIENTO);
			setState(141);
			match(VAR);
			setState(142);
			match(PA);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERO) | (1L << BOOL) | (1L << SEQ_NUM) | (1L << SEQ_BOOL))) != 0)) {
				{
				setState(143);
				params();
				}
			}

			setState(146);
			match(PC);
			setState(147);
			variables();
			setState(148);
			instrucciones();
			setState(149);
			match(FPROCEDIMIENTO);
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

	public static class ParamsContext extends ParserRuleContext {
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public TerminalNode VAR() { return getToken(Anasint.VAR, 0); }
		public TerminalNode COMA() { return getToken(Anasint.COMA, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_params);
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				tipos();
				setState(152);
				match(VAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				tipos();
				setState(155);
				match(VAR);
				setState(156);
				match(COMA);
				setState(157);
				params();
				}
				break;
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
		public Expr_integerContext expr_integer() {
			return getRuleContext(Expr_integerContext.class,0);
		}
		public Expr_boolContext expr_bool() {
			return getRuleContext(Expr_boolContext.class,0);
		}
		public Expr_seqContext expr_seq() {
			return getRuleContext(Expr_seqContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expr);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				expr_integer(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				expr_bool(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				expr_seq();
				}
				break;
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

	public static class Expr_integerContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(Anasint.VAR, 0); }
		public TerminalNode CA() { return getToken(Anasint.CA, 0); }
		public List<Expr_integerContext> expr_integer() {
			return getRuleContexts(Expr_integerContext.class);
		}
		public Expr_integerContext expr_integer(int i) {
			return getRuleContext(Expr_integerContext.class,i);
		}
		public TerminalNode CC() { return getToken(Anasint.CC, 0); }
		public Expr_funcContext expr_func() {
			return getRuleContext(Expr_funcContext.class,0);
		}
		public TerminalNode NUM() { return getToken(Anasint.NUM, 0); }
		public TerminalNode POR() { return getToken(Anasint.POR, 0); }
		public TerminalNode SUMA() { return getToken(Anasint.SUMA, 0); }
		public TerminalNode RESTA() { return getToken(Anasint.RESTA, 0); }
		public Expr_integerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterExpr_integer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitExpr_integer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitExpr_integer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_integerContext expr_integer() throws RecognitionException {
		return expr_integer(0);
	}

	private Expr_integerContext expr_integer(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr_integerContext _localctx = new Expr_integerContext(_ctx, _parentState);
		Expr_integerContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr_integer, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(167);
				match(VAR);
				setState(168);
				match(CA);
				setState(169);
				expr_integer(0);
				setState(170);
				match(CC);
				}
				break;
			case 2:
				{
				setState(172);
				expr_func();
				}
				break;
			case 3:
				{
				setState(173);
				match(NUM);
				}
				break;
			case 4:
				{
				setState(174);
				match(VAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr_integerContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr_integer);
					setState(177);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(178);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << POR) | (1L << SUMA) | (1L << RESTA))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(179);
					expr_integer(6);
					}
					} 
				}
				setState(184);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class Expr_boolContext extends ParserRuleContext {
		public TerminalNode T() { return getToken(Anasint.T, 0); }
		public TerminalNode F() { return getToken(Anasint.F, 0); }
		public List<TerminalNode> VAR() { return getTokens(Anasint.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(Anasint.VAR, i);
		}
		public TerminalNode IGUALL() { return getToken(Anasint.IGUALL, 0); }
		public TerminalNode DISTINTO() { return getToken(Anasint.DISTINTO, 0); }
		public List<Expr_seqContext> expr_seq() {
			return getRuleContexts(Expr_seqContext.class);
		}
		public Expr_seqContext expr_seq(int i) {
			return getRuleContext(Expr_seqContext.class,i);
		}
		public List<Expr_integerContext> expr_integer() {
			return getRuleContexts(Expr_integerContext.class);
		}
		public Expr_integerContext expr_integer(int i) {
			return getRuleContext(Expr_integerContext.class,i);
		}
		public TerminalNode MENORIGUAL() { return getToken(Anasint.MENORIGUAL, 0); }
		public TerminalNode MAYORIGUAL() { return getToken(Anasint.MAYORIGUAL, 0); }
		public TerminalNode MENOR() { return getToken(Anasint.MENOR, 0); }
		public TerminalNode MAYOR() { return getToken(Anasint.MAYOR, 0); }
		public TerminalNode NO() { return getToken(Anasint.NO, 0); }
		public List<Expr_boolContext> expr_bool() {
			return getRuleContexts(Expr_boolContext.class);
		}
		public Expr_boolContext expr_bool(int i) {
			return getRuleContext(Expr_boolContext.class,i);
		}
		public TerminalNode CA() { return getToken(Anasint.CA, 0); }
		public TerminalNode CC() { return getToken(Anasint.CC, 0); }
		public Expr_funcContext expr_func() {
			return getRuleContext(Expr_funcContext.class,0);
		}
		public TerminalNode AND() { return getToken(Anasint.AND, 0); }
		public TerminalNode OR() { return getToken(Anasint.OR, 0); }
		public Expr_boolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterExpr_bool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitExpr_bool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitExpr_bool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_boolContext expr_bool() throws RecognitionException {
		return expr_bool(0);
	}

	private Expr_boolContext expr_bool(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr_boolContext _localctx = new Expr_boolContext(_ctx, _parentState);
		Expr_boolContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr_bool, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(186);
				match(T);
				}
				break;
			case 2:
				{
				setState(187);
				match(F);
				}
				break;
			case 3:
				{
				setState(188);
				match(VAR);
				setState(189);
				_la = _input.LA(1);
				if ( !(_la==IGUALL || _la==DISTINTO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(190);
				match(VAR);
				}
				break;
			case 4:
				{
				setState(191);
				expr_seq();
				setState(192);
				_la = _input.LA(1);
				if ( !(_la==IGUALL || _la==DISTINTO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(193);
				expr_seq();
				}
				break;
			case 5:
				{
				setState(195);
				expr_integer(0);
				setState(196);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IGUALL) | (1L << DISTINTO) | (1L << MENORIGUAL) | (1L << MAYORIGUAL) | (1L << MENOR) | (1L << MAYOR))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(197);
				expr_integer(0);
				}
				break;
			case 6:
				{
				setState(199);
				match(NO);
				setState(200);
				expr_bool(5);
				}
				break;
			case 7:
				{
				setState(201);
				match(VAR);
				setState(202);
				match(CA);
				setState(203);
				expr_integer(0);
				setState(204);
				match(CC);
				}
				break;
			case 8:
				{
				setState(206);
				expr_func();
				}
				break;
			case 9:
				{
				setState(207);
				match(VAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(216);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new Expr_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_bool);
						setState(210);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(211);
						_la = _input.LA(1);
						if ( !(_la==IGUALL || _la==DISTINTO) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(212);
						expr_bool(9);
						}
						break;
					case 2:
						{
						_localctx = new Expr_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_bool);
						setState(213);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(214);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(215);
						expr_bool(5);
						}
						break;
					}
					} 
				}
				setState(220);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class Expr_seqContext extends ParserRuleContext {
		public TerminalNode CA() { return getToken(Anasint.CA, 0); }
		public TerminalNode CC() { return getToken(Anasint.CC, 0); }
		public List<Expr_integerContext> expr_integer() {
			return getRuleContexts(Expr_integerContext.class);
		}
		public Expr_integerContext expr_integer(int i) {
			return getRuleContext(Expr_integerContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(Anasint.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(Anasint.COMA, i);
		}
		public List<Expr_boolContext> expr_bool() {
			return getRuleContexts(Expr_boolContext.class);
		}
		public Expr_boolContext expr_bool(int i) {
			return getRuleContext(Expr_boolContext.class,i);
		}
		public Expr_funcContext expr_func() {
			return getRuleContext(Expr_funcContext.class,0);
		}
		public TerminalNode VAR() { return getToken(Anasint.VAR, 0); }
		public Expr_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterExpr_seq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitExpr_seq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitExpr_seq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_seqContext expr_seq() throws RecognitionException {
		Expr_seqContext _localctx = new Expr_seqContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expr_seq);
		try {
			int _alt;
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				match(CA);
				setState(222);
				match(CC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(CA);
				setState(229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(224);
						expr_integer(0);
						setState(225);
						match(COMA);
						}
						} 
					}
					setState(231);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				setState(232);
				expr_integer(0);
				setState(233);
				match(CC);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(235);
				match(CA);
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(236);
						expr_bool(0);
						setState(237);
						match(COMA);
						}
						} 
					}
					setState(243);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				{
				setState(244);
				expr_bool(0);
				}
				setState(245);
				match(CC);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(247);
				expr_func();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(248);
				match(VAR);
				}
				break;
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

	public static class Expr_avanzaContext extends ParserRuleContext {
		public TerminalNode LA() { return getToken(Anasint.LA, 0); }
		public TerminalNode AVANZA() { return getToken(Anasint.AVANZA, 0); }
		public TerminalNode DOSPTOS() { return getToken(Anasint.DOSPTOS, 0); }
		public Expr_funcContext expr_func() {
			return getRuleContext(Expr_funcContext.class,0);
		}
		public TerminalNode LC() { return getToken(Anasint.LC, 0); }
		public Expr_avanzaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_avanza; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterExpr_avanza(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitExpr_avanza(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitExpr_avanza(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_avanzaContext expr_avanza() throws RecognitionException {
		Expr_avanzaContext _localctx = new Expr_avanzaContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expr_avanza);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(LA);
			setState(252);
			match(AVANZA);
			setState(253);
			match(DOSPTOS);
			setState(254);
			expr_func();
			setState(255);
			match(LC);
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

	public static class Expr_funcContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(Anasint.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(Anasint.VAR, i);
		}
		public TerminalNode PA() { return getToken(Anasint.PA, 0); }
		public TerminalNode PC() { return getToken(Anasint.PC, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(Anasint.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(Anasint.COMA, i);
		}
		public Expr_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterExpr_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitExpr_func(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitExpr_func(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_funcContext expr_func() throws RecognitionException {
		Expr_funcContext _localctx = new Expr_funcContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expr_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(VAR);
			setState(258);
			match(PA);
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(259);
				match(VAR);
				}
				break;
			case 2:
				{
				setState(260);
				expr();
				}
				break;
			}
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T) | (1L << F) | (1L << NUM) | (1L << VAR) | (1L << CA) | (1L << COMA) | (1L << NO))) != 0)) {
				{
				setState(266);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COMA:
					{
					setState(263);
					match(COMA);
					setState(264);
					match(VAR);
					}
					break;
				case T:
				case F:
				case NUM:
				case VAR:
				case CA:
				case NO:
					{
					setState(265);
					expr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(271);
			match(PC);
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

	public static class Declaracion_instruccionesContext extends ParserRuleContext {
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public CondicionContext condicion() {
			return getRuleContext(CondicionContext.class,0);
		}
		public IteracionContext iteracion() {
			return getRuleContext(IteracionContext.class,0);
		}
		public TerminalNode BREAK() { return getToken(Anasint.BREAK, 0); }
		public TerminalNode PyC() { return getToken(Anasint.PyC, 0); }
		public TerminalNode RETURN() { return getToken(Anasint.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public MostrarContext mostrar() {
			return getRuleContext(MostrarContext.class,0);
		}
		public AsertosContext asertos() {
			return getRuleContext(AsertosContext.class,0);
		}
		public Expr_funcContext expr_func() {
			return getRuleContext(Expr_funcContext.class,0);
		}
		public Declaracion_instruccionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion_instrucciones; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterDeclaracion_instrucciones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitDeclaracion_instrucciones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitDeclaracion_instrucciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracion_instruccionesContext declaracion_instrucciones() throws RecognitionException {
		Declaracion_instruccionesContext _localctx = new Declaracion_instruccionesContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_declaracion_instrucciones);
		try {
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				asignacion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
				condicion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(275);
				iteracion();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(276);
				match(BREAK);
				setState(277);
				match(PyC);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(278);
				match(RETURN);
				setState(279);
				expr();
				setState(280);
				match(PyC);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(282);
				mostrar();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(283);
				asertos();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(284);
				expr_func();
				setState(285);
				match(PyC);
				}
				break;
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

	public static class AsignacionContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(Anasint.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(Anasint.VAR, i);
		}
		public TerminalNode IGUAL() { return getToken(Anasint.IGUAL, 0); }
		public TerminalNode PyC() { return getToken(Anasint.PyC, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(Anasint.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(Anasint.COMA, i);
		}
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_asignacion);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(289);
					match(VAR);
					setState(290);
					match(COMA);
					}
					} 
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(296);
			match(VAR);
			setState(297);
			match(IGUAL);
			setState(305);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(300);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						setState(298);
						match(VAR);
						}
						break;
					case 2:
						{
						setState(299);
						expr();
						}
						break;
					}
					setState(302);
					match(COMA);
					}
					} 
				}
				setState(307);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			setState(310);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(308);
				match(VAR);
				}
				break;
			case 2:
				{
				setState(309);
				expr();
				}
				break;
			}
			setState(312);
			match(PyC);
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

	public static class CondicionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(Anasint.IF, 0); }
		public TerminalNode PA() { return getToken(Anasint.PA, 0); }
		public Expr_boolContext expr_bool() {
			return getRuleContext(Expr_boolContext.class,0);
		}
		public TerminalNode PC() { return getToken(Anasint.PC, 0); }
		public TerminalNode THEN() { return getToken(Anasint.THEN, 0); }
		public TerminalNode ENDIF() { return getToken(Anasint.ENDIF, 0); }
		public List<Declaracion_instruccionesContext> declaracion_instrucciones() {
			return getRuleContexts(Declaracion_instruccionesContext.class);
		}
		public Declaracion_instruccionesContext declaracion_instrucciones(int i) {
			return getRuleContext(Declaracion_instruccionesContext.class,i);
		}
		public Blq_sinoContext blq_sino() {
			return getRuleContext(Blq_sinoContext.class,0);
		}
		public CondicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterCondicion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitCondicion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitCondicion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondicionContext condicion() throws RecognitionException {
		CondicionContext _localctx = new CondicionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_condicion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(IF);
			setState(315);
			match(PA);
			setState(316);
			expr_bool(0);
			setState(317);
			match(PC);
			setState(318);
			match(THEN);
			setState(320); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(319);
				declaracion_instrucciones();
				}
				}
				setState(322); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BREAK) | (1L << IF) | (1L << WHILE) | (1L << MOSTRAR) | (1L << VAR) | (1L << LA))) != 0) );
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(324);
				blq_sino();
				}
			}

			setState(327);
			match(ENDIF);
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

	public static class Blq_sinoContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(Anasint.ELSE, 0); }
		public List<Declaracion_instruccionesContext> declaracion_instrucciones() {
			return getRuleContexts(Declaracion_instruccionesContext.class);
		}
		public Declaracion_instruccionesContext declaracion_instrucciones(int i) {
			return getRuleContext(Declaracion_instruccionesContext.class,i);
		}
		public Blq_sinoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blq_sino; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterBlq_sino(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitBlq_sino(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitBlq_sino(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Blq_sinoContext blq_sino() throws RecognitionException {
		Blq_sinoContext _localctx = new Blq_sinoContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_blq_sino);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(ELSE);
			setState(331); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(330);
				declaracion_instrucciones();
				}
				}
				setState(333); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BREAK) | (1L << IF) | (1L << WHILE) | (1L << MOSTRAR) | (1L << VAR) | (1L << LA))) != 0) );
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

	public static class IteracionContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(Anasint.WHILE, 0); }
		public TerminalNode PA() { return getToken(Anasint.PA, 0); }
		public Expr_boolContext expr_bool() {
			return getRuleContext(Expr_boolContext.class,0);
		}
		public TerminalNode PC() { return getToken(Anasint.PC, 0); }
		public TerminalNode DO() { return getToken(Anasint.DO, 0); }
		public TerminalNode ENDWHILE() { return getToken(Anasint.ENDWHILE, 0); }
		public Expr_avanzaContext expr_avanza() {
			return getRuleContext(Expr_avanzaContext.class,0);
		}
		public List<Declaracion_instruccionesContext> declaracion_instrucciones() {
			return getRuleContexts(Declaracion_instruccionesContext.class);
		}
		public Declaracion_instruccionesContext declaracion_instrucciones(int i) {
			return getRuleContext(Declaracion_instruccionesContext.class,i);
		}
		public IteracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iteracion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterIteracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitIteracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitIteracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IteracionContext iteracion() throws RecognitionException {
		IteracionContext _localctx = new IteracionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_iteracion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(WHILE);
			setState(336);
			match(PA);
			setState(337);
			expr_bool(0);
			setState(338);
			match(PC);
			setState(339);
			match(DO);
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(340);
				expr_avanza();
				}
				break;
			}
			setState(344); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(343);
				declaracion_instrucciones();
				}
				}
				setState(346); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BREAK) | (1L << IF) | (1L << WHILE) | (1L << MOSTRAR) | (1L << VAR) | (1L << LA))) != 0) );
			setState(348);
			match(ENDWHILE);
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

	public static class MostrarContext extends ParserRuleContext {
		public TerminalNode MOSTRAR() { return getToken(Anasint.MOSTRAR, 0); }
		public TerminalNode PA() { return getToken(Anasint.PA, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PC() { return getToken(Anasint.PC, 0); }
		public TerminalNode PyC() { return getToken(Anasint.PyC, 0); }
		public List<TerminalNode> COMA() { return getTokens(Anasint.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(Anasint.COMA, i);
		}
		public MostrarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mostrar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterMostrar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitMostrar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitMostrar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MostrarContext mostrar() throws RecognitionException {
		MostrarContext _localctx = new MostrarContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_mostrar);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			match(MOSTRAR);
			setState(351);
			match(PA);
			setState(357);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(352);
					expr();
					setState(353);
					match(COMA);
					}
					} 
				}
				setState(359);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			setState(360);
			expr();
			setState(361);
			match(PC);
			setState(362);
			match(PyC);
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

	public static class AsertosContext extends ParserRuleContext {
		public TerminalNode LA() { return getToken(Anasint.LA, 0); }
		public TerminalNode LC() { return getToken(Anasint.LC, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CuantificadorContext cuantificador() {
			return getRuleContext(CuantificadorContext.class,0);
		}
		public AsertosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asertos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterAsertos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitAsertos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitAsertos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsertosContext asertos() throws RecognitionException {
		AsertosContext _localctx = new AsertosContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_asertos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(LA);
			setState(367);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T:
			case F:
			case NUM:
			case VAR:
			case CA:
			case NO:
				{
				setState(365);
				expr();
				}
				break;
			case FORALL:
			case EXISTS:
				{
				setState(366);
				cuantificador();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(369);
			match(LC);
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

	public static class CuantificadorContext extends ParserRuleContext {
		public CuantificadorUniversalContext cuantificadorUniversal() {
			return getRuleContext(CuantificadorUniversalContext.class,0);
		}
		public CuantificadorExistencialContext cuantificadorExistencial() {
			return getRuleContext(CuantificadorExistencialContext.class,0);
		}
		public CuantificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuantificador; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterCuantificador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitCuantificador(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitCuantificador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CuantificadorContext cuantificador() throws RecognitionException {
		CuantificadorContext _localctx = new CuantificadorContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_cuantificador);
		try {
			setState(373);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FORALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(371);
				cuantificadorUniversal();
				}
				break;
			case EXISTS:
				enterOuterAlt(_localctx, 2);
				{
				setState(372);
				cuantificadorExistencial();
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

	public static class CuantificadorUniversalContext extends ParserRuleContext {
		public TerminalNode FORALL() { return getToken(Anasint.FORALL, 0); }
		public CuantificacionContext cuantificacion() {
			return getRuleContext(CuantificacionContext.class,0);
		}
		public CuantificadorUniversalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuantificadorUniversal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterCuantificadorUniversal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitCuantificadorUniversal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitCuantificadorUniversal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CuantificadorUniversalContext cuantificadorUniversal() throws RecognitionException {
		CuantificadorUniversalContext _localctx = new CuantificadorUniversalContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_cuantificadorUniversal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			match(FORALL);
			setState(376);
			cuantificacion();
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

	public static class CuantificadorExistencialContext extends ParserRuleContext {
		public TerminalNode EXISTS() { return getToken(Anasint.EXISTS, 0); }
		public CuantificacionContext cuantificacion() {
			return getRuleContext(CuantificacionContext.class,0);
		}
		public CuantificadorExistencialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuantificadorExistencial; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterCuantificadorExistencial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitCuantificadorExistencial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitCuantificadorExistencial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CuantificadorExistencialContext cuantificadorExistencial() throws RecognitionException {
		CuantificadorExistencialContext _localctx = new CuantificadorExistencialContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_cuantificadorExistencial);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(EXISTS);
			setState(379);
			cuantificacion();
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

	public static class CuantificacionContext extends ParserRuleContext {
		public TerminalNode PA() { return getToken(Anasint.PA, 0); }
		public TerminalNode VAR() { return getToken(Anasint.VAR, 0); }
		public TerminalNode DOSPTOS() { return getToken(Anasint.DOSPTOS, 0); }
		public TerminalNode CA() { return getToken(Anasint.CA, 0); }
		public List<Expr_integerContext> expr_integer() {
			return getRuleContexts(Expr_integerContext.class);
		}
		public Expr_integerContext expr_integer(int i) {
			return getRuleContext(Expr_integerContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(Anasint.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(Anasint.COMA, i);
		}
		public TerminalNode CC() { return getToken(Anasint.CC, 0); }
		public Expr_boolContext expr_bool() {
			return getRuleContext(Expr_boolContext.class,0);
		}
		public TerminalNode PC() { return getToken(Anasint.PC, 0); }
		public CuantificacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuantificacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterCuantificacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitCuantificacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitCuantificacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CuantificacionContext cuantificacion() throws RecognitionException {
		CuantificacionContext _localctx = new CuantificacionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_cuantificacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(PA);
			setState(382);
			match(VAR);
			setState(383);
			match(DOSPTOS);
			setState(384);
			match(CA);
			setState(385);
			expr_integer(0);
			setState(386);
			match(COMA);
			setState(387);
			expr_integer(0);
			setState(388);
			match(CC);
			setState(389);
			match(COMA);
			setState(390);
			expr_bool(0);
			setState(391);
			match(PC);
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
		case 16:
			return expr_integer_sempred((Expr_integerContext)_localctx, predIndex);
		case 17:
			return expr_bool_sempred((Expr_boolContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_integer_sempred(Expr_integerContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean expr_bool_sempred(Expr_boolContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u018c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\7\3K\n\3\f\3\16\3N\13\3\3\4\3\4\7"+
		"\4R\n\4\f\4\16\4U\13\4\3\5\3\5\7\5Y\n\5\f\5\16\5\\\13\5\3\6\3\6\3\6\3"+
		"\7\3\7\5\7c\n\7\3\b\3\b\7\bg\n\b\f\b\16\bj\13\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\5\nv\n\n\3\13\3\13\3\f\3\f\3\r\3\r\5\r~\n\r\3\16\3"+
		"\16\3\16\3\16\5\16\u0084\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\5\17\u0093\n\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00a2\n\20\3\21\3\21\3\21\5\21"+
		"\u00a7\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00b2\n"+
		"\22\3\22\3\22\3\22\7\22\u00b7\n\22\f\22\16\22\u00ba\13\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00d3\n\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\7\23\u00db\n\23\f\23\16\23\u00de\13\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\7\24\u00e6\n\24\f\24\16\24\u00e9\13\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\7\24\u00f2\n\24\f\24\16\24\u00f5\13\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u00fc\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\5\26\u0108\n\26\3\26\3\26\3\26\7\26\u010d\n\26\f\26\16\26\u0110"+
		"\13\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\5\27\u0122\n\27\3\30\3\30\7\30\u0126\n\30\f\30\16\30\u0129"+
		"\13\30\3\30\3\30\3\30\3\30\5\30\u012f\n\30\3\30\7\30\u0132\n\30\f\30\16"+
		"\30\u0135\13\30\3\30\3\30\5\30\u0139\n\30\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\6\31\u0143\n\31\r\31\16\31\u0144\3\31\5\31\u0148\n\31\3\31"+
		"\3\31\3\32\3\32\6\32\u014e\n\32\r\32\16\32\u014f\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\5\33\u0158\n\33\3\33\6\33\u015b\n\33\r\33\16\33\u015c\3\33\3"+
		"\33\3\34\3\34\3\34\3\34\3\34\7\34\u0166\n\34\f\34\16\34\u0169\13\34\3"+
		"\34\3\34\3\34\3\34\3\35\3\35\3\35\5\35\u0172\n\35\3\35\3\35\3\36\3\36"+
		"\5\36\u0178\n\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\2\4\"$\"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@\2\b\3\2\21\22\3\2\23\24\3\2/\61\3\2\63\64\3\2\638\3\2:"+
		";\2\u01a1\2B\3\2\2\2\4H\3\2\2\2\6O\3\2\2\2\bV\3\2\2\2\n]\3\2\2\2\fb\3"+
		"\2\2\2\16h\3\2\2\2\20o\3\2\2\2\22u\3\2\2\2\24w\3\2\2\2\26y\3\2\2\2\30"+
		"}\3\2\2\2\32\177\3\2\2\2\34\u008e\3\2\2\2\36\u00a1\3\2\2\2 \u00a6\3\2"+
		"\2\2\"\u00b1\3\2\2\2$\u00d2\3\2\2\2&\u00fb\3\2\2\2(\u00fd\3\2\2\2*\u0103"+
		"\3\2\2\2,\u0121\3\2\2\2.\u0127\3\2\2\2\60\u013c\3\2\2\2\62\u014b\3\2\2"+
		"\2\64\u0151\3\2\2\2\66\u0160\3\2\2\28\u016e\3\2\2\2:\u0177\3\2\2\2<\u0179"+
		"\3\2\2\2>\u017c\3\2\2\2@\u017f\3\2\2\2BC\7\7\2\2CD\5\4\3\2DE\5\6\4\2E"+
		"F\5\b\5\2FG\7\2\2\3G\3\3\2\2\2HL\7\6\2\2IK\5\n\6\2JI\3\2\2\2KN\3\2\2\2"+
		"LJ\3\2\2\2LM\3\2\2\2M\5\3\2\2\2NL\3\2\2\2OS\7\b\2\2PR\5\30\r\2QP\3\2\2"+
		"\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\7\3\2\2\2US\3\2\2\2VZ\7\t\2\2WY\5,\27"+
		"\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\t\3\2\2\2\\Z\3\2\2\2]^\5"+
		"\f\7\2^_\7-\2\2_\13\3\2\2\2`c\5\16\b\2ac\5\20\t\2b`\3\2\2\2ba\3\2\2\2"+
		"c\r\3\2\2\2de\7%\2\2eg\7.\2\2fd\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2"+
		"ik\3\2\2\2jh\3\2\2\2kl\7%\2\2lm\7&\2\2mn\5\24\13\2n\17\3\2\2\2op\7%\2"+
		"\2pq\7&\2\2qr\5\26\f\2r\21\3\2\2\2sv\5\24\13\2tv\5\26\f\2us\3\2\2\2ut"+
		"\3\2\2\2v\23\3\2\2\2wx\t\2\2\2x\25\3\2\2\2yz\t\3\2\2z\27\3\2\2\2{~\5\32"+
		"\16\2|~\5\34\17\2}{\3\2\2\2}|\3\2\2\2~\31\3\2\2\2\177\u0080\7\n\2\2\u0080"+
		"\u0081\7%\2\2\u0081\u0083\7\'\2\2\u0082\u0084\5\36\20\2\u0083\u0082\3"+
		"\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\7(\2\2\u0086"+
		"\u0087\7\f\2\2\u0087\u0088\7\'\2\2\u0088\u0089\5\36\20\2\u0089\u008a\7"+
		"(\2\2\u008a\u008b\5\4\3\2\u008b\u008c\5\b\5\2\u008c\u008d\7\13\2\2\u008d"+
		"\33\3\2\2\2\u008e\u008f\7\r\2\2\u008f\u0090\7%\2\2\u0090\u0092\7\'\2\2"+
		"\u0091\u0093\5\36\20\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094"+
		"\3\2\2\2\u0094\u0095\7(\2\2\u0095\u0096\5\4\3\2\u0096\u0097\5\b\5\2\u0097"+
		"\u0098\7\16\2\2\u0098\35\3\2\2\2\u0099\u009a\5\22\n\2\u009a\u009b\7%\2"+
		"\2\u009b\u00a2\3\2\2\2\u009c\u009d\5\22\n\2\u009d\u009e\7%\2\2\u009e\u009f"+
		"\7.\2\2\u009f\u00a0\5\36\20\2\u00a0\u00a2\3\2\2\2\u00a1\u0099\3\2\2\2"+
		"\u00a1\u009c\3\2\2\2\u00a2\37\3\2\2\2\u00a3\u00a7\5\"\22\2\u00a4\u00a7"+
		"\5$\23\2\u00a5\u00a7\5&\24\2\u00a6\u00a3\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6"+
		"\u00a5\3\2\2\2\u00a7!\3\2\2\2\u00a8\u00a9\b\22\1\2\u00a9\u00aa\7%\2\2"+
		"\u00aa\u00ab\7)\2\2\u00ab\u00ac\5\"\22\2\u00ac\u00ad\7*\2\2\u00ad\u00b2"+
		"\3\2\2\2\u00ae\u00b2\5*\26\2\u00af\u00b2\7$\2\2\u00b0\u00b2\7%\2\2\u00b1"+
		"\u00a8\3\2\2\2\u00b1\u00ae\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b0\3\2"+
		"\2\2\u00b2\u00b8\3\2\2\2\u00b3\u00b4\f\7\2\2\u00b4\u00b5\t\4\2\2\u00b5"+
		"\u00b7\5\"\22\b\u00b6\u00b3\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3"+
		"\2\2\2\u00b8\u00b9\3\2\2\2\u00b9#\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc"+
		"\b\23\1\2\u00bc\u00d3\7\26\2\2\u00bd\u00d3\7\27\2\2\u00be\u00bf\7%\2\2"+
		"\u00bf\u00c0\t\5\2\2\u00c0\u00d3\7%\2\2\u00c1\u00c2\5&\24\2\u00c2\u00c3"+
		"\t\5\2\2\u00c3\u00c4\5&\24\2\u00c4\u00d3\3\2\2\2\u00c5\u00c6\5\"\22\2"+
		"\u00c6\u00c7\t\6\2\2\u00c7\u00c8\5\"\22\2\u00c8\u00d3\3\2\2\2\u00c9\u00ca"+
		"\79\2\2\u00ca\u00d3\5$\23\7\u00cb\u00cc\7%\2\2\u00cc\u00cd\7)\2\2\u00cd"+
		"\u00ce\5\"\22\2\u00ce\u00cf\7*\2\2\u00cf\u00d3\3\2\2\2\u00d0\u00d3\5*"+
		"\26\2\u00d1\u00d3\7%\2\2\u00d2\u00bb\3\2\2\2\u00d2\u00bd\3\2\2\2\u00d2"+
		"\u00be\3\2\2\2\u00d2\u00c1\3\2\2\2\u00d2\u00c5\3\2\2\2\u00d2\u00c9\3\2"+
		"\2\2\u00d2\u00cb\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3"+
		"\u00dc\3\2\2\2\u00d4\u00d5\f\n\2\2\u00d5\u00d6\t\5\2\2\u00d6\u00db\5$"+
		"\23\13\u00d7\u00d8\f\6\2\2\u00d8\u00d9\t\7\2\2\u00d9\u00db\5$\23\7\u00da"+
		"\u00d4\3\2\2\2\u00da\u00d7\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2"+
		"\2\2\u00dc\u00dd\3\2\2\2\u00dd%\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e0"+
		"\7)\2\2\u00e0\u00fc\7*\2\2\u00e1\u00e7\7)\2\2\u00e2\u00e3\5\"\22\2\u00e3"+
		"\u00e4\7.\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e2\3\2\2\2\u00e6\u00e9\3\2"+
		"\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00ea\u00eb\5\"\22\2\u00eb\u00ec\7*\2\2\u00ec\u00fc\3\2"+
		"\2\2\u00ed\u00f3\7)\2\2\u00ee\u00ef\5$\23\2\u00ef\u00f0\7.\2\2\u00f0\u00f2"+
		"\3\2\2\2\u00f1\u00ee\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\5$"+
		"\23\2\u00f7\u00f8\7*\2\2\u00f8\u00fc\3\2\2\2\u00f9\u00fc\5*\26\2\u00fa"+
		"\u00fc\7%\2\2\u00fb\u00df\3\2\2\2\u00fb\u00e1\3\2\2\2\u00fb\u00ed\3\2"+
		"\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc\'\3\2\2\2\u00fd\u00fe"+
		"\7+\2\2\u00fe\u00ff\7\"\2\2\u00ff\u0100\7&\2\2\u0100\u0101\5*\26\2\u0101"+
		"\u0102\7,\2\2\u0102)\3\2\2\2\u0103\u0104\7%\2\2\u0104\u0107\7\'\2\2\u0105"+
		"\u0108\7%\2\2\u0106\u0108\5 \21\2\u0107\u0105\3\2\2\2\u0107\u0106\3\2"+
		"\2\2\u0108\u010e\3\2\2\2\u0109\u010a\7.\2\2\u010a\u010d\7%\2\2\u010b\u010d"+
		"\5 \21\2\u010c\u0109\3\2\2\2\u010c\u010b\3\2\2\2\u010d\u0110\3\2\2\2\u010e"+
		"\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\3\2\2\2\u0110\u010e\3\2"+
		"\2\2\u0111\u0112\7(\2\2\u0112+\3\2\2\2\u0113\u0122\5.\30\2\u0114\u0122"+
		"\5\60\31\2\u0115\u0122\5\64\33\2\u0116\u0117\7\30\2\2\u0117\u0122\7-\2"+
		"\2\u0118\u0119\7\f\2\2\u0119\u011a\5 \21\2\u011a\u011b\7-\2\2\u011b\u0122"+
		"\3\2\2\2\u011c\u0122\5\66\34\2\u011d\u0122\58\35\2\u011e\u011f\5*\26\2"+
		"\u011f\u0120\7-\2\2\u0120\u0122\3\2\2\2\u0121\u0113\3\2\2\2\u0121\u0114"+
		"\3\2\2\2\u0121\u0115\3\2\2\2\u0121\u0116\3\2\2\2\u0121\u0118\3\2\2\2\u0121"+
		"\u011c\3\2\2\2\u0121\u011d\3\2\2\2\u0121\u011e\3\2\2\2\u0122-\3\2\2\2"+
		"\u0123\u0124\7%\2\2\u0124\u0126\7.\2\2\u0125\u0123\3\2\2\2\u0126\u0129"+
		"\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012a\3\2\2\2\u0129"+
		"\u0127\3\2\2\2\u012a\u012b\7%\2\2\u012b\u0133\7\62\2\2\u012c\u012f\7%"+
		"\2\2\u012d\u012f\5 \21\2\u012e\u012c\3\2\2\2\u012e\u012d\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u0132\7.\2\2\u0131\u012e\3\2\2\2\u0132\u0135\3\2"+
		"\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0138\3\2\2\2\u0135"+
		"\u0133\3\2\2\2\u0136\u0139\7%\2\2\u0137\u0139\5 \21\2\u0138\u0136\3\2"+
		"\2\2\u0138\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013b\7-\2\2\u013b"+
		"/\3\2\2\2\u013c\u013d\7\31\2\2\u013d\u013e\7\'\2\2\u013e\u013f\5$\23\2"+
		"\u013f\u0140\7(\2\2\u0140\u0142\7\32\2\2\u0141\u0143\5,\27\2\u0142\u0141"+
		"\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\u0147\3\2\2\2\u0146\u0148\5\62\32\2\u0147\u0146\3\2\2\2\u0147\u0148\3"+
		"\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\7\33\2\2\u014a\61\3\2\2\2\u014b"+
		"\u014d\7\34\2\2\u014c\u014e\5,\27\2\u014d\u014c\3\2\2\2\u014e\u014f\3"+
		"\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\63\3\2\2\2\u0151"+
		"\u0152\7\35\2\2\u0152\u0153\7\'\2\2\u0153\u0154\5$\23\2\u0154\u0155\7"+
		"(\2\2\u0155\u0157\7\36\2\2\u0156\u0158\5(\25\2\u0157\u0156\3\2\2\2\u0157"+
		"\u0158\3\2\2\2\u0158\u015a\3\2\2\2\u0159\u015b\5,\27\2\u015a\u0159\3\2"+
		"\2\2\u015b\u015c\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u015f\7\37\2\2\u015f\65\3\2\2\2\u0160\u0161\7#\2"+
		"\2\u0161\u0167\7\'\2\2\u0162\u0163\5 \21\2\u0163\u0164\7.\2\2\u0164\u0166"+
		"\3\2\2\2\u0165\u0162\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0167"+
		"\u0168\3\2\2\2\u0168\u016a\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016b\5 "+
		"\21\2\u016b\u016c\7(\2\2\u016c\u016d\7-\2\2\u016d\67\3\2\2\2\u016e\u0171"+
		"\7+\2\2\u016f\u0172\5 \21\2\u0170\u0172\5:\36\2\u0171\u016f\3\2\2\2\u0171"+
		"\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0174\7,\2\2\u01749\3\2\2\2\u0175"+
		"\u0178\5<\37\2\u0176\u0178\5> \2\u0177\u0175\3\2\2\2\u0177\u0176\3\2\2"+
		"\2\u0178;\3\2\2\2\u0179\u017a\7 \2\2\u017a\u017b\5@!\2\u017b=\3\2\2\2"+
		"\u017c\u017d\7!\2\2\u017d\u017e\5@!\2\u017e?\3\2\2\2\u017f\u0180\7\'\2"+
		"\2\u0180\u0181\7%\2\2\u0181\u0182\7&\2\2\u0182\u0183\7)\2\2\u0183\u0184"+
		"\5\"\22\2\u0184\u0185\7.\2\2\u0185\u0186\5\"\22\2\u0186\u0187\7*\2\2\u0187"+
		"\u0188\7.\2\2\u0188\u0189\5$\23\2\u0189\u018a\7(\2\2\u018aA\3\2\2\2%L"+
		"SZbhu}\u0083\u0092\u00a1\u00a6\u00b1\u00b8\u00d2\u00da\u00dc\u00e7\u00f3"+
		"\u00fb\u0107\u010c\u010e\u0121\u0127\u012e\u0133\u0138\u0144\u0147\u014f"+
		"\u0157\u015c\u0167\u0171\u0177";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}