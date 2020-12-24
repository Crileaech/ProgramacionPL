// Generated from /home/enrfercor/Escritorio/PL/ProgramacionPL-juatosfer1/src/Anasint.g4 by ANTLR 4.9
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
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

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
		RULE_variable = 11, RULE_declaracion_subprogramas = 12, RULE_funcion = 13, 
		RULE_procedimiento = 14, RULE_params = 15, RULE_expr = 16, RULE_expr_integer = 17, 
		RULE_expr_bool = 18, RULE_expr_seq = 19, RULE_expr_sacar_elem = 20, RULE_expr_avanza = 21, 
		RULE_expr_func = 22, RULE_declaracion_instrucciones = 23, RULE_devolucion = 24, 
		RULE_asignacion = 25, RULE_condicion = 26, RULE_blq_sino = 27, RULE_iteracion = 28, 
		RULE_mostrar = 29, RULE_asertos = 30, RULE_cuantificador = 31, RULE_cuantificadorUniversal = 32, 
		RULE_cuantificadorExistencial = 33, RULE_cuantificacion = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "variables", "subprogramas", "instrucciones", "declaracion_variables", 
			"identificador", "elementales", "secuencias", "tipos", "tipos_elementales", 
			"tipos_no_elementales", "variable", "declaracion_subprogramas", "funcion", 
			"procedimiento", "params", "expr", "expr_integer", "expr_bool", "expr_seq", 
			"expr_sacar_elem", "expr_avanza", "expr_func", "declaracion_instrucciones", 
			"devolucion", "asignacion", "condicion", "blq_sino", "iteracion", "mostrar", 
			"asertos", "cuantificador", "cuantificadorUniversal", "cuantificadorExistencial", 
			"cuantificacion"
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
			setState(70);
			match(PROGRAMA);
			setState(71);
			variables();
			setState(72);
			subprogramas();
			setState(73);
			instrucciones();
			setState(74);
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
			setState(76);
			match(VARIABLES);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR) {
				{
				{
				setState(77);
				declaracion_variables();
				}
				}
				setState(82);
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
			setState(83);
			match(SUBPROGRAMAS);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCION || _la==PROCEDIMIENTO) {
				{
				{
				setState(84);
				declaracion_subprogramas();
				}
				}
				setState(89);
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
			setState(90);
			match(INSTRUCCIONES);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BREAK) | (1L << IF) | (1L << WHILE) | (1L << MOSTRAR) | (1L << VAR) | (1L << LA))) != 0)) {
				{
				{
				setState(91);
				declaracion_instrucciones();
				}
				}
				setState(96);
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
			setState(97);
			identificador();
			setState(98);
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
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				elementales();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
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
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(104);
					match(VAR);
					setState(105);
					match(COMA);
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(111);
			match(VAR);
			setState(112);
			match(DOSPTOS);
			setState(113);
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
			setState(115);
			match(VAR);
			setState(116);
			match(DOSPTOS);
			setState(117);
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
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERO:
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				tipos_elementales();
				}
				break;
			case SEQ_NUM:
			case SEQ_BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
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
			setState(123);
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
			setState(125);
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(Anasint.VAR, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(VAR);
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
		enterRule(_localctx, 24, RULE_declaracion_subprogramas);
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNCION:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				funcion();
				}
				break;
			case PROCEDIMIENTO:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
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
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
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
		enterRule(_localctx, 26, RULE_funcion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(FUNCION);
			setState(134);
			variable();
			setState(135);
			match(PA);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERO) | (1L << BOOL) | (1L << SEQ_NUM) | (1L << SEQ_BOOL))) != 0)) {
				{
				setState(136);
				params();
				}
			}

			setState(139);
			match(PC);
			setState(140);
			match(RETURN);
			setState(141);
			match(PA);
			setState(142);
			params();
			setState(143);
			match(PC);
			setState(144);
			variables();
			setState(145);
			instrucciones();
			setState(146);
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
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
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
		enterRule(_localctx, 28, RULE_procedimiento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(PROCEDIMIENTO);
			setState(149);
			variable();
			setState(150);
			match(PA);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERO) | (1L << BOOL) | (1L << SEQ_NUM) | (1L << SEQ_BOOL))) != 0)) {
				{
				setState(151);
				params();
				}
			}

			setState(154);
			match(PC);
			setState(155);
			variables();
			setState(156);
			instrucciones();
			setState(157);
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
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
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
		enterRule(_localctx, 30, RULE_params);
		try {
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				tipos();
				setState(160);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				tipos();
				setState(163);
				variable();
				setState(164);
				match(COMA);
				setState(165);
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
		public Expr_funcContext expr_func() {
			return getRuleContext(Expr_funcContext.class,0);
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
		enterRule(_localctx, 32, RULE_expr);
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				expr_integer(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				expr_bool(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				expr_seq();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				expr_func();
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
		public Expr_integerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_integer; }
	 
		public Expr_integerContext() { }
		public void copyFrom(Expr_integerContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OpIntegerContext extends Expr_integerContext {
		public List<Expr_integerContext> expr_integer() {
			return getRuleContexts(Expr_integerContext.class);
		}
		public Expr_integerContext expr_integer(int i) {
			return getRuleContext(Expr_integerContext.class,i);
		}
		public TerminalNode POR() { return getToken(Anasint.POR, 0); }
		public TerminalNode SUMA() { return getToken(Anasint.SUMA, 0); }
		public TerminalNode RESTA() { return getToken(Anasint.RESTA, 0); }
		public OpIntegerContext(Expr_integerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterOpInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitOpInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitOpInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprFuncIntContext extends Expr_integerContext {
		public Expr_funcContext expr_func() {
			return getRuleContext(Expr_funcContext.class,0);
		}
		public ExprFuncIntContext(Expr_integerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterExprFuncInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitExprFuncInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitExprFuncInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SacarElemIntegerContext extends Expr_integerContext {
		public Expr_sacar_elemContext expr_sacar_elem() {
			return getRuleContext(Expr_sacar_elemContext.class,0);
		}
		public SacarElemIntegerContext(Expr_integerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterSacarElemInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitSacarElemInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitSacarElemInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumContext extends Expr_integerContext {
		public TerminalNode NUM() { return getToken(Anasint.NUM, 0); }
		public NumContext(Expr_integerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParentesisOpIntegerContext extends Expr_integerContext {
		public TerminalNode PA() { return getToken(Anasint.PA, 0); }
		public List<Expr_integerContext> expr_integer() {
			return getRuleContexts(Expr_integerContext.class);
		}
		public Expr_integerContext expr_integer(int i) {
			return getRuleContext(Expr_integerContext.class,i);
		}
		public TerminalNode PC() { return getToken(Anasint.PC, 0); }
		public TerminalNode POR() { return getToken(Anasint.POR, 0); }
		public TerminalNode SUMA() { return getToken(Anasint.SUMA, 0); }
		public TerminalNode RESTA() { return getToken(Anasint.RESTA, 0); }
		public ParentesisOpIntegerContext(Expr_integerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterParentesisOpInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitParentesisOpInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitParentesisOpInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarIntContext extends Expr_integerContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VarIntContext(Expr_integerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterVarInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitVarInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitVarInt(this);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr_integer, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new SacarElemIntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(176);
				expr_sacar_elem();
				}
				break;
			case 2:
				{
				_localctx = new ParentesisOpIntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
				match(PA);
				setState(178);
				expr_integer(0);
				setState(179);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << POR) | (1L << SUMA) | (1L << RESTA))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(180);
				expr_integer(0);
				setState(181);
				match(PC);
				}
				break;
			case 3:
				{
				_localctx = new ExprFuncIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				expr_func();
				}
				break;
			case 4:
				{
				_localctx = new NumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				match(NUM);
				}
				break;
			case 5:
				{
				_localctx = new VarIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
				variable();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OpIntegerContext(new Expr_integerContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expr_integer);
					setState(188);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(189);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << POR) | (1L << SUMA) | (1L << RESTA))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(190);
					expr_integer(5);
					}
					} 
				}
				setState(195);
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
		public Expr_boolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_bool; }
	 
		public Expr_boolContext() { }
		public void copyFrom(Expr_boolContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NegacionBoolContext extends Expr_boolContext {
		public TerminalNode NO() { return getToken(Anasint.NO, 0); }
		public Expr_boolContext expr_bool() {
			return getRuleContext(Expr_boolContext.class,0);
		}
		public NegacionBoolContext(Expr_boolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterNegacionBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitNegacionBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitNegacionBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParentesisOpBoolContext extends Expr_boolContext {
		public TerminalNode PA() { return getToken(Anasint.PA, 0); }
		public List<Expr_boolContext> expr_bool() {
			return getRuleContexts(Expr_boolContext.class);
		}
		public Expr_boolContext expr_bool(int i) {
			return getRuleContext(Expr_boolContext.class,i);
		}
		public TerminalNode PC() { return getToken(Anasint.PC, 0); }
		public TerminalNode AND() { return getToken(Anasint.AND, 0); }
		public TerminalNode OR() { return getToken(Anasint.OR, 0); }
		public ParentesisOpBoolContext(Expr_boolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterParentesisOpBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitParentesisOpBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitParentesisOpBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueContext extends Expr_boolContext {
		public TerminalNode T() { return getToken(Anasint.T, 0); }
		public TrueContext(Expr_boolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseContext extends Expr_boolContext {
		public TerminalNode F() { return getToken(Anasint.F, 0); }
		public FalseContext(Expr_boolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpBoolContext extends Expr_boolContext {
		public List<Expr_boolContext> expr_bool() {
			return getRuleContexts(Expr_boolContext.class);
		}
		public Expr_boolContext expr_bool(int i) {
			return getRuleContext(Expr_boolContext.class,i);
		}
		public TerminalNode AND() { return getToken(Anasint.AND, 0); }
		public TerminalNode OR() { return getToken(Anasint.OR, 0); }
		public OpBoolContext(Expr_boolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterOpBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitOpBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitOpBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompararIntegerContext extends Expr_boolContext {
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
		public TerminalNode IGUALL() { return getToken(Anasint.IGUALL, 0); }
		public TerminalNode DISTINTO() { return getToken(Anasint.DISTINTO, 0); }
		public CompararIntegerContext(Expr_boolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterCompararInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitCompararInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitCompararInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SacarElemBoolContext extends Expr_boolContext {
		public Expr_sacar_elemContext expr_sacar_elem() {
			return getRuleContext(Expr_sacar_elemContext.class,0);
		}
		public SacarElemBoolContext(Expr_boolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterSacarElemBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitSacarElemBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitSacarElemBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarBoolContext extends Expr_boolContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VarBoolContext(Expr_boolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterVarBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitVarBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitVarBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprFuncBoolContext extends Expr_boolContext {
		public Expr_funcContext expr_func() {
			return getRuleContext(Expr_funcContext.class,0);
		}
		public ExprFuncBoolContext(Expr_boolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterExprFuncBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitExprFuncBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitExprFuncBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompararBoolContext extends Expr_boolContext {
		public List<Expr_boolContext> expr_bool() {
			return getRuleContexts(Expr_boolContext.class);
		}
		public Expr_boolContext expr_bool(int i) {
			return getRuleContext(Expr_boolContext.class,i);
		}
		public TerminalNode IGUALL() { return getToken(Anasint.IGUALL, 0); }
		public TerminalNode DISTINTO() { return getToken(Anasint.DISTINTO, 0); }
		public CompararBoolContext(Expr_boolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterCompararBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitCompararBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitCompararBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompararSeqContext extends Expr_boolContext {
		public List<Expr_seqContext> expr_seq() {
			return getRuleContexts(Expr_seqContext.class);
		}
		public Expr_seqContext expr_seq(int i) {
			return getRuleContext(Expr_seqContext.class,i);
		}
		public TerminalNode IGUALL() { return getToken(Anasint.IGUALL, 0); }
		public TerminalNode DISTINTO() { return getToken(Anasint.DISTINTO, 0); }
		public CompararSeqContext(Expr_boolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterCompararSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitCompararSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitCompararSeq(this);
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
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expr_bool, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(197);
				match(T);
				}
				break;
			case 2:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				match(F);
				}
				break;
			case 3:
				{
				_localctx = new SacarElemBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				expr_sacar_elem();
				}
				break;
			case 4:
				{
				_localctx = new ParentesisOpBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				match(PA);
				setState(201);
				expr_bool(0);
				setState(202);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(203);
				expr_bool(0);
				setState(204);
				match(PC);
				}
				break;
			case 5:
				{
				_localctx = new CompararSeqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				expr_seq();
				setState(207);
				_la = _input.LA(1);
				if ( !(_la==IGUALL || _la==DISTINTO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(208);
				expr_seq();
				}
				break;
			case 6:
				{
				_localctx = new CompararIntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210);
				expr_integer(0);
				setState(211);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IGUALL) | (1L << DISTINTO) | (1L << MENORIGUAL) | (1L << MAYORIGUAL) | (1L << MENOR) | (1L << MAYOR))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(212);
				expr_integer(0);
				}
				break;
			case 7:
				{
				_localctx = new NegacionBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				match(NO);
				setState(215);
				expr_bool(3);
				}
				break;
			case 8:
				{
				_localctx = new ExprFuncBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				expr_func();
				}
				break;
			case 9:
				{
				_localctx = new VarBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				variable();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(228);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(226);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new CompararBoolContext(new Expr_boolContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr_bool);
						setState(220);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(221);
						_la = _input.LA(1);
						if ( !(_la==IGUALL || _la==DISTINTO) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(222);
						expr_bool(9);
						}
						break;
					case 2:
						{
						_localctx = new OpBoolContext(new Expr_boolContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr_bool);
						setState(223);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(224);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(225);
						expr_bool(7);
						}
						break;
					}
					} 
				}
				setState(230);
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
		public Expr_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_seq; }
	 
		public Expr_seqContext() { }
		public void copyFrom(Expr_seqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprFuncSeqContext extends Expr_seqContext {
		public Expr_funcContext expr_func() {
			return getRuleContext(Expr_funcContext.class,0);
		}
		public ExprFuncSeqContext(Expr_seqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterExprFuncSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitExprFuncSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitExprFuncSeq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VaciaSeqContext extends Expr_seqContext {
		public TerminalNode CA() { return getToken(Anasint.CA, 0); }
		public TerminalNode CC() { return getToken(Anasint.CC, 0); }
		public VaciaSeqContext(Expr_seqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterVaciaSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitVaciaSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitVaciaSeq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SeqContext extends Expr_seqContext {
		public TerminalNode CA() { return getToken(Anasint.CA, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CC() { return getToken(Anasint.CC, 0); }
		public List<TerminalNode> COMA() { return getTokens(Anasint.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(Anasint.COMA, i);
		}
		public SeqContext(Expr_seqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitSeq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarSeqContext extends Expr_seqContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VarSeqContext(Expr_seqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterVarSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitVarSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitVarSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_seqContext expr_seq() throws RecognitionException {
		Expr_seqContext _localctx = new Expr_seqContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expr_seq);
		try {
			int _alt;
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new VaciaSeqContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				match(CA);
				setState(232);
				match(CC);
				}
				break;
			case 2:
				_localctx = new SeqContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				match(CA);
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(234);
						expr();
						setState(235);
						match(COMA);
						}
						} 
					}
					setState(241);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				setState(242);
				expr();
				setState(243);
				match(CC);
				}
				break;
			case 3:
				_localctx = new ExprFuncSeqContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(245);
				expr_func();
				}
				break;
			case 4:
				_localctx = new VarSeqContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(246);
				variable();
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

	public static class Expr_sacar_elemContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode CA() { return getToken(Anasint.CA, 0); }
		public Expr_integerContext expr_integer() {
			return getRuleContext(Expr_integerContext.class,0);
		}
		public TerminalNode CC() { return getToken(Anasint.CC, 0); }
		public Expr_sacar_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_sacar_elem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterExpr_sacar_elem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitExpr_sacar_elem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitExpr_sacar_elem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_sacar_elemContext expr_sacar_elem() throws RecognitionException {
		Expr_sacar_elemContext _localctx = new Expr_sacar_elemContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expr_sacar_elem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			variable();
			setState(250);
			match(CA);
			setState(251);
			expr_integer(0);
			setState(252);
			match(CC);
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
		enterRule(_localctx, 42, RULE_expr_avanza);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(LA);
			setState(255);
			match(AVANZA);
			setState(256);
			match(DOSPTOS);
			setState(257);
			expr_func();
			setState(258);
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
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
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
		enterRule(_localctx, 44, RULE_expr_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			variable();
			setState(261);
			match(PA);
			{
			setState(262);
			expr();
			}
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(263);
				match(COMA);
				setState(264);
				expr();
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(270);
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
		public Declaracion_instruccionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion_instrucciones; }
	 
		public Declaracion_instruccionesContext() { }
		public void copyFrom(Declaracion_instruccionesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AsertoContext extends Declaracion_instruccionesContext {
		public AsertosContext asertos() {
			return getRuleContext(AsertosContext.class,0);
		}
		public AsertoContext(Declaracion_instruccionesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterAserto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitAserto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitAserto(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprfunContext extends Declaracion_instruccionesContext {
		public Expr_funcContext expr_func() {
			return getRuleContext(Expr_funcContext.class,0);
		}
		public TerminalNode PyC() { return getToken(Anasint.PyC, 0); }
		public ExprfunContext(Declaracion_instruccionesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterExprfun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitExprfun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitExprfun(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DevContext extends Declaracion_instruccionesContext {
		public DevolucionContext devolucion() {
			return getRuleContext(DevolucionContext.class,0);
		}
		public DevContext(Declaracion_instruccionesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterDev(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitDev(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitDev(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakContext extends Declaracion_instruccionesContext {
		public TerminalNode BREAK() { return getToken(Anasint.BREAK, 0); }
		public TerminalNode PyC() { return getToken(Anasint.PyC, 0); }
		public BreakContext(Declaracion_instruccionesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitBreak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowContext extends Declaracion_instruccionesContext {
		public MostrarContext mostrar() {
			return getRuleContext(MostrarContext.class,0);
		}
		public ShowContext(Declaracion_instruccionesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterShow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitShow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitShow(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ItContext extends Declaracion_instruccionesContext {
		public IteracionContext iteracion() {
			return getRuleContext(IteracionContext.class,0);
		}
		public ItContext(Declaracion_instruccionesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterIt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitIt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitIt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondContext extends Declaracion_instruccionesContext {
		public CondicionContext condicion() {
			return getRuleContext(CondicionContext.class,0);
		}
		public CondContext(Declaracion_instruccionesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AsigContext extends Declaracion_instruccionesContext {
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public AsigContext(Declaracion_instruccionesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterAsig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitAsig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitAsig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracion_instruccionesContext declaracion_instrucciones() throws RecognitionException {
		Declaracion_instruccionesContext _localctx = new Declaracion_instruccionesContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_declaracion_instrucciones);
		try {
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new AsigContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				asignacion();
				}
				break;
			case 2:
				_localctx = new CondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				condicion();
				}
				break;
			case 3:
				_localctx = new ItContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(274);
				iteracion();
				}
				break;
			case 4:
				_localctx = new BreakContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(275);
				match(BREAK);
				setState(276);
				match(PyC);
				}
				break;
			case 5:
				_localctx = new DevContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(277);
				devolucion();
				}
				break;
			case 6:
				_localctx = new ShowContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(278);
				mostrar();
				}
				break;
			case 7:
				_localctx = new AsertoContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(279);
				asertos();
				}
				break;
			case 8:
				_localctx = new ExprfunContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(280);
				expr_func();
				setState(281);
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

	public static class DevolucionContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(Anasint.RETURN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PyC() { return getToken(Anasint.PyC, 0); }
		public List<TerminalNode> COMA() { return getTokens(Anasint.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(Anasint.COMA, i);
		}
		public DevolucionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_devolucion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterDevolucion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitDevolucion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitDevolucion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DevolucionContext devolucion() throws RecognitionException {
		DevolucionContext _localctx = new DevolucionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_devolucion);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(RETURN);
			setState(291);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(286);
					expr();
					setState(287);
					match(COMA);
					}
					} 
				}
				setState(293);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(294);
			expr();
			setState(295);
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

	public static class AsignacionContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
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
		enterRule(_localctx, 50, RULE_asignacion);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(297);
					variable();
					setState(298);
					match(COMA);
					}
					} 
				}
				setState(304);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(305);
			variable();
			setState(306);
			match(IGUAL);
			setState(312);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(307);
					expr();
					setState(308);
					match(COMA);
					}
					} 
				}
				setState(314);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			{
			setState(315);
			expr();
			}
			setState(316);
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
		enterRule(_localctx, 52, RULE_condicion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(IF);
			setState(319);
			match(PA);
			setState(320);
			expr_bool(0);
			setState(321);
			match(PC);
			setState(322);
			match(THEN);
			setState(324); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(323);
				declaracion_instrucciones();
				}
				}
				setState(326); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BREAK) | (1L << IF) | (1L << WHILE) | (1L << MOSTRAR) | (1L << VAR) | (1L << LA))) != 0) );
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(328);
				blq_sino();
				}
			}

			setState(331);
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
		enterRule(_localctx, 54, RULE_blq_sino);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			match(ELSE);
			setState(335); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(334);
				declaracion_instrucciones();
				}
				}
				setState(337); 
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
		enterRule(_localctx, 56, RULE_iteracion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(WHILE);
			setState(340);
			match(PA);
			setState(341);
			expr_bool(0);
			setState(342);
			match(PC);
			setState(343);
			match(DO);
			setState(345);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(344);
				expr_avanza();
				}
				break;
			}
			setState(348); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(347);
				declaracion_instrucciones();
				}
				}
				setState(350); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BREAK) | (1L << IF) | (1L << WHILE) | (1L << MOSTRAR) | (1L << VAR) | (1L << LA))) != 0) );
			setState(352);
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
		enterRule(_localctx, 58, RULE_mostrar);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(MOSTRAR);
			setState(355);
			match(PA);
			setState(361);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(356);
					expr();
					setState(357);
					match(COMA);
					}
					} 
				}
				setState(363);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(364);
			expr();
			setState(365);
			match(PC);
			setState(366);
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
		public Expr_boolContext expr_bool() {
			return getRuleContext(Expr_boolContext.class,0);
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
		enterRule(_localctx, 60, RULE_asertos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			match(LA);
			setState(371);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T:
			case F:
			case NUM:
			case VAR:
			case PA:
			case CA:
			case NO:
				{
				setState(369);
				expr_bool(0);
				}
				break;
			case FORALL:
			case EXISTS:
				{
				setState(370);
				cuantificador();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(373);
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
		enterRule(_localctx, 62, RULE_cuantificador);
		try {
			setState(377);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FORALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(375);
				cuantificadorUniversal();
				}
				break;
			case EXISTS:
				enterOuterAlt(_localctx, 2);
				{
				setState(376);
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
		enterRule(_localctx, 64, RULE_cuantificadorUniversal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			match(FORALL);
			setState(380);
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
		enterRule(_localctx, 66, RULE_cuantificadorExistencial);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			match(EXISTS);
			setState(383);
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
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
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
		enterRule(_localctx, 68, RULE_cuantificacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			match(PA);
			setState(386);
			variable();
			setState(387);
			match(DOSPTOS);
			setState(388);
			match(CA);
			setState(389);
			expr_integer(0);
			setState(390);
			match(COMA);
			setState(391);
			expr_integer(0);
			setState(392);
			match(CC);
			setState(393);
			match(COMA);
			setState(394);
			expr_bool(0);
			setState(395);
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
		case 17:
			return expr_integer_sempred((Expr_integerContext)_localctx, predIndex);
		case 18:
			return expr_bool_sempred((Expr_boolContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_integer_sempred(Expr_integerContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean expr_bool_sempred(Expr_boolContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u0190\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\7\3Q\n\3\f\3\16"+
		"\3T\13\3\3\4\3\4\7\4X\n\4\f\4\16\4[\13\4\3\5\3\5\7\5_\n\5\f\5\16\5b\13"+
		"\5\3\6\3\6\3\6\3\7\3\7\5\7i\n\7\3\b\3\b\7\bm\n\b\f\b\16\bp\13\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\5\n|\n\n\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\5\16\u0086\n\16\3\17\3\17\3\17\3\17\5\17\u008c\n\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u009b"+
		"\n\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00aa\n\21\3\22\3\22\3\22\3\22\5\22\u00b0\n\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00bd\n\23\3\23\3\23\3\23"+
		"\7\23\u00c2\n\23\f\23\16\23\u00c5\13\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u00dd\n\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00e5\n"+
		"\24\f\24\16\24\u00e8\13\24\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u00f0\n"+
		"\25\f\25\16\25\u00f3\13\25\3\25\3\25\3\25\3\25\3\25\5\25\u00fa\n\25\3"+
		"\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\3\30\7\30\u010c\n\30\f\30\16\30\u010f\13\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u011e\n\31\3\32\3\32"+
		"\3\32\3\32\7\32\u0124\n\32\f\32\16\32\u0127\13\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\7\33\u012f\n\33\f\33\16\33\u0132\13\33\3\33\3\33\3\33\3\33"+
		"\3\33\7\33\u0139\n\33\f\33\16\33\u013c\13\33\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\6\34\u0147\n\34\r\34\16\34\u0148\3\34\5\34\u014c"+
		"\n\34\3\34\3\34\3\35\3\35\6\35\u0152\n\35\r\35\16\35\u0153\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\5\36\u015c\n\36\3\36\6\36\u015f\n\36\r\36\16\36\u0160"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3\37\7\37\u016a\n\37\f\37\16\37\u016d\13"+
		"\37\3\37\3\37\3\37\3\37\3 \3 \3 \5 \u0176\n \3 \3 \3!\3!\5!\u017c\n!\3"+
		"\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\2\4$&%\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF\2\b\3"+
		"\2\21\22\3\2\23\24\3\2/\61\3\2:;\3\2\63\64\3\2\638\2\u019f\2H\3\2\2\2"+
		"\4N\3\2\2\2\6U\3\2\2\2\b\\\3\2\2\2\nc\3\2\2\2\fh\3\2\2\2\16n\3\2\2\2\20"+
		"u\3\2\2\2\22{\3\2\2\2\24}\3\2\2\2\26\177\3\2\2\2\30\u0081\3\2\2\2\32\u0085"+
		"\3\2\2\2\34\u0087\3\2\2\2\36\u0096\3\2\2\2 \u00a9\3\2\2\2\"\u00af\3\2"+
		"\2\2$\u00bc\3\2\2\2&\u00dc\3\2\2\2(\u00f9\3\2\2\2*\u00fb\3\2\2\2,\u0100"+
		"\3\2\2\2.\u0106\3\2\2\2\60\u011d\3\2\2\2\62\u011f\3\2\2\2\64\u0130\3\2"+
		"\2\2\66\u0140\3\2\2\28\u014f\3\2\2\2:\u0155\3\2\2\2<\u0164\3\2\2\2>\u0172"+
		"\3\2\2\2@\u017b\3\2\2\2B\u017d\3\2\2\2D\u0180\3\2\2\2F\u0183\3\2\2\2H"+
		"I\7\7\2\2IJ\5\4\3\2JK\5\6\4\2KL\5\b\5\2LM\7\2\2\3M\3\3\2\2\2NR\7\6\2\2"+
		"OQ\5\n\6\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\5\3\2\2\2TR\3\2\2"+
		"\2UY\7\b\2\2VX\5\32\16\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\7\3"+
		"\2\2\2[Y\3\2\2\2\\`\7\t\2\2]_\5\60\31\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2"+
		"`a\3\2\2\2a\t\3\2\2\2b`\3\2\2\2cd\5\f\7\2de\7-\2\2e\13\3\2\2\2fi\5\16"+
		"\b\2gi\5\20\t\2hf\3\2\2\2hg\3\2\2\2i\r\3\2\2\2jk\7%\2\2km\7.\2\2lj\3\2"+
		"\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\7%\2\2rs\7&\2"+
		"\2st\5\24\13\2t\17\3\2\2\2uv\7%\2\2vw\7&\2\2wx\5\26\f\2x\21\3\2\2\2y|"+
		"\5\24\13\2z|\5\26\f\2{y\3\2\2\2{z\3\2\2\2|\23\3\2\2\2}~\t\2\2\2~\25\3"+
		"\2\2\2\177\u0080\t\3\2\2\u0080\27\3\2\2\2\u0081\u0082\7%\2\2\u0082\31"+
		"\3\2\2\2\u0083\u0086\5\34\17\2\u0084\u0086\5\36\20\2\u0085\u0083\3\2\2"+
		"\2\u0085\u0084\3\2\2\2\u0086\33\3\2\2\2\u0087\u0088\7\n\2\2\u0088\u0089"+
		"\5\30\r\2\u0089\u008b\7\'\2\2\u008a\u008c\5 \21\2\u008b\u008a\3\2\2\2"+
		"\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\7(\2\2\u008e\u008f"+
		"\7\f\2\2\u008f\u0090\7\'\2\2\u0090\u0091\5 \21\2\u0091\u0092\7(\2\2\u0092"+
		"\u0093\5\4\3\2\u0093\u0094\5\b\5\2\u0094\u0095\7\13\2\2\u0095\35\3\2\2"+
		"\2\u0096\u0097\7\r\2\2\u0097\u0098\5\30\r\2\u0098\u009a\7\'\2\2\u0099"+
		"\u009b\5 \21\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u009d\7(\2\2\u009d\u009e\5\4\3\2\u009e\u009f\5\b\5\2\u009f"+
		"\u00a0\7\16\2\2\u00a0\37\3\2\2\2\u00a1\u00a2\5\22\n\2\u00a2\u00a3\5\30"+
		"\r\2\u00a3\u00aa\3\2\2\2\u00a4\u00a5\5\22\n\2\u00a5\u00a6\5\30\r\2\u00a6"+
		"\u00a7\7.\2\2\u00a7\u00a8\5 \21\2\u00a8\u00aa\3\2\2\2\u00a9\u00a1\3\2"+
		"\2\2\u00a9\u00a4\3\2\2\2\u00aa!\3\2\2\2\u00ab\u00b0\5$\23\2\u00ac\u00b0"+
		"\5&\24\2\u00ad\u00b0\5(\25\2\u00ae\u00b0\5.\30\2\u00af\u00ab\3\2\2\2\u00af"+
		"\u00ac\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0#\3\2\2\2"+
		"\u00b1\u00b2\b\23\1\2\u00b2\u00bd\5*\26\2\u00b3\u00b4\7\'\2\2\u00b4\u00b5"+
		"\5$\23\2\u00b5\u00b6\t\4\2\2\u00b6\u00b7\5$\23\2\u00b7\u00b8\7(\2\2\u00b8"+
		"\u00bd\3\2\2\2\u00b9\u00bd\5.\30\2\u00ba\u00bd\7$\2\2\u00bb\u00bd\5\30"+
		"\r\2\u00bc\u00b1\3\2\2\2\u00bc\u00b3\3\2\2\2\u00bc\u00b9\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00c3\3\2\2\2\u00be\u00bf\f\6"+
		"\2\2\u00bf\u00c0\t\4\2\2\u00c0\u00c2\5$\23\7\u00c1\u00be\3\2\2\2\u00c2"+
		"\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4%\3\2\2\2"+
		"\u00c5\u00c3\3\2\2\2\u00c6\u00c7\b\24\1\2\u00c7\u00dd\7\26\2\2\u00c8\u00dd"+
		"\7\27\2\2\u00c9\u00dd\5*\26\2\u00ca\u00cb\7\'\2\2\u00cb\u00cc\5&\24\2"+
		"\u00cc\u00cd\t\5\2\2\u00cd\u00ce\5&\24\2\u00ce\u00cf\7(\2\2\u00cf\u00dd"+
		"\3\2\2\2\u00d0\u00d1\5(\25\2\u00d1\u00d2\t\6\2\2\u00d2\u00d3\5(\25\2\u00d3"+
		"\u00dd\3\2\2\2\u00d4\u00d5\5$\23\2\u00d5\u00d6\t\7\2\2\u00d6\u00d7\5$"+
		"\23\2\u00d7\u00dd\3\2\2\2\u00d8\u00d9\79\2\2\u00d9\u00dd\5&\24\5\u00da"+
		"\u00dd\5.\30\2\u00db\u00dd\5\30\r\2\u00dc\u00c6\3\2\2\2\u00dc\u00c8\3"+
		"\2\2\2\u00dc\u00c9\3\2\2\2\u00dc\u00ca\3\2\2\2\u00dc\u00d0\3\2\2\2\u00dc"+
		"\u00d4\3\2\2\2\u00dc\u00d8\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00db\3\2"+
		"\2\2\u00dd\u00e6\3\2\2\2\u00de\u00df\f\n\2\2\u00df\u00e0\t\6\2\2\u00e0"+
		"\u00e5\5&\24\13\u00e1\u00e2\f\b\2\2\u00e2\u00e3\t\5\2\2\u00e3\u00e5\5"+
		"&\24\t\u00e4\u00de\3\2\2\2\u00e4\u00e1\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6"+
		"\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\'\3\2\2\2\u00e8\u00e6\3\2\2\2"+
		"\u00e9\u00ea\7)\2\2\u00ea\u00fa\7*\2\2\u00eb\u00f1\7)\2\2\u00ec\u00ed"+
		"\5\"\22\2\u00ed\u00ee\7.\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00ec\3\2\2\2\u00f0"+
		"\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\3\2"+
		"\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\5\"\22\2\u00f5\u00f6\7*\2\2\u00f6"+
		"\u00fa\3\2\2\2\u00f7\u00fa\5.\30\2\u00f8\u00fa\5\30\r\2\u00f9\u00e9\3"+
		"\2\2\2\u00f9\u00eb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa"+
		")\3\2\2\2\u00fb\u00fc\5\30\r\2\u00fc\u00fd\7)\2\2\u00fd\u00fe\5$\23\2"+
		"\u00fe\u00ff\7*\2\2\u00ff+\3\2\2\2\u0100\u0101\7+\2\2\u0101\u0102\7\""+
		"\2\2\u0102\u0103\7&\2\2\u0103\u0104\5.\30\2\u0104\u0105\7,\2\2\u0105-"+
		"\3\2\2\2\u0106\u0107\5\30\r\2\u0107\u0108\7\'\2\2\u0108\u010d\5\"\22\2"+
		"\u0109\u010a\7.\2\2\u010a\u010c\5\"\22\2\u010b\u0109\3\2\2\2\u010c\u010f"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u0110\u0111\7(\2\2\u0111/\3\2\2\2\u0112\u011e\5\64\33\2"+
		"\u0113\u011e\5\66\34\2\u0114\u011e\5:\36\2\u0115\u0116\7\30\2\2\u0116"+
		"\u011e\7-\2\2\u0117\u011e\5\62\32\2\u0118\u011e\5<\37\2\u0119\u011e\5"+
		"> \2\u011a\u011b\5.\30\2\u011b\u011c\7-\2\2\u011c\u011e\3\2\2\2\u011d"+
		"\u0112\3\2\2\2\u011d\u0113\3\2\2\2\u011d\u0114\3\2\2\2\u011d\u0115\3\2"+
		"\2\2\u011d\u0117\3\2\2\2\u011d\u0118\3\2\2\2\u011d\u0119\3\2\2\2\u011d"+
		"\u011a\3\2\2\2\u011e\61\3\2\2\2\u011f\u0125\7\f\2\2\u0120\u0121\5\"\22"+
		"\2\u0121\u0122\7.\2\2\u0122\u0124\3\2\2\2\u0123\u0120\3\2\2\2\u0124\u0127"+
		"\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0128\3\2\2\2\u0127"+
		"\u0125\3\2\2\2\u0128\u0129\5\"\22\2\u0129\u012a\7-\2\2\u012a\63\3\2\2"+
		"\2\u012b\u012c\5\30\r\2\u012c\u012d\7.\2\2\u012d\u012f\3\2\2\2\u012e\u012b"+
		"\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131"+
		"\u0133\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0134\5\30\r\2\u0134\u013a\7"+
		"\62\2\2\u0135\u0136\5\"\22\2\u0136\u0137\7.\2\2\u0137\u0139\3\2\2\2\u0138"+
		"\u0135\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2"+
		"\2\2\u013b\u013d\3\2\2\2\u013c\u013a\3\2\2\2\u013d\u013e\5\"\22\2\u013e"+
		"\u013f\7-\2\2\u013f\65\3\2\2\2\u0140\u0141\7\31\2\2\u0141\u0142\7\'\2"+
		"\2\u0142\u0143\5&\24\2\u0143\u0144\7(\2\2\u0144\u0146\7\32\2\2\u0145\u0147"+
		"\5\60\31\2\u0146\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0146\3\2\2\2"+
		"\u0148\u0149\3\2\2\2\u0149\u014b\3\2\2\2\u014a\u014c\58\35\2\u014b\u014a"+
		"\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\7\33\2\2"+
		"\u014e\67\3\2\2\2\u014f\u0151\7\34\2\2\u0150\u0152\5\60\31\2\u0151\u0150"+
		"\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154"+
		"9\3\2\2\2\u0155\u0156\7\35\2\2\u0156\u0157\7\'\2\2\u0157\u0158\5&\24\2"+
		"\u0158\u0159\7(\2\2\u0159\u015b\7\36\2\2\u015a\u015c\5,\27\2\u015b\u015a"+
		"\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015e\3\2\2\2\u015d\u015f\5\60\31\2"+
		"\u015e\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161"+
		"\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\7\37\2\2\u0163;\3\2\2\2\u0164"+
		"\u0165\7#\2\2\u0165\u016b\7\'\2\2\u0166\u0167\5\"\22\2\u0167\u0168\7."+
		"\2\2\u0168\u016a\3\2\2\2\u0169\u0166\3\2\2\2\u016a\u016d\3\2\2\2\u016b"+
		"\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016e\3\2\2\2\u016d\u016b\3\2"+
		"\2\2\u016e\u016f\5\"\22\2\u016f\u0170\7(\2\2\u0170\u0171\7-\2\2\u0171"+
		"=\3\2\2\2\u0172\u0175\7+\2\2\u0173\u0176\5&\24\2\u0174\u0176\5@!\2\u0175"+
		"\u0173\3\2\2\2\u0175\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\7,"+
		"\2\2\u0178?\3\2\2\2\u0179\u017c\5B\"\2\u017a\u017c\5D#\2\u017b\u0179\3"+
		"\2\2\2\u017b\u017a\3\2\2\2\u017cA\3\2\2\2\u017d\u017e\7 \2\2\u017e\u017f"+
		"\5F$\2\u017fC\3\2\2\2\u0180\u0181\7!\2\2\u0181\u0182\5F$\2\u0182E\3\2"+
		"\2\2\u0183\u0184\7\'\2\2\u0184\u0185\5\30\r\2\u0185\u0186\7&\2\2\u0186"+
		"\u0187\7)\2\2\u0187\u0188\5$\23\2\u0188\u0189\7.\2\2\u0189\u018a\5$\23"+
		"\2\u018a\u018b\7*\2\2\u018b\u018c\7.\2\2\u018c\u018d\5&\24\2\u018d\u018e"+
		"\7(\2\2\u018eG\3\2\2\2!RY`hn{\u0085\u008b\u009a\u00a9\u00af\u00bc\u00c3"+
		"\u00dc\u00e4\u00e6\u00f1\u00f9\u010d\u011d\u0125\u0130\u013a\u0148\u014b"+
		"\u0153\u015b\u0160\u016b\u0175\u017b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}