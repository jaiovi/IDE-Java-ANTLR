package ANTLR;

// Generated from .\MatrixLang.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MatrixLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		ID=18, NUM=19, WS=20;
	public static final int
		RULE_prog = 0, RULE_body = 1, RULE_variable = 2, RULE_variable_list = 3, 
		RULE_proceso = 4, RULE_operacion = 5, RULE_matrix = 6, RULE_column = 7, 
		RULE_tk_main = 8, RULE_tk_int = 9, RULE_tk_matrix = 10, RULE_tK_ID = 11, 
		RULE_tk_NUM = 12, RULE_tk_add = 13, RULE_tk_sub = 14, RULE_tk_mult = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "body", "variable", "variable_list", "proceso", "operacion", 
			"matrix", "column", "tk_main", "tk_int", "tk_matrix", "tK_ID", "tk_NUM", 
			"tk_add", "tk_sub", "tk_mult"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "';'", "','", "'='", "'write'", "'('", "')'", "'^'", 
			"'['", "']'", "'main'", "'int'", "'matriz'", "'+'", "'-'", "'*'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "ID", "NUM", "WS"
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
	public String getGrammarFileName() { return "MatrixLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MatrixLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public Tk_mainContext tk_main() {
			return getRuleContext(Tk_mainContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			tk_main();
			setState(33);
			match(T__0);
			setState(34);
			body();
			setState(35);
			match(T__1);
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
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<ProcesoContext> proceso() {
			return getRuleContexts(ProcesoContext.class);
		}
		public ProcesoContext proceso(int i) {
			return getRuleContext(ProcesoContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitBody(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__12) | (1L << T__13) | (1L << ID))) != 0)) {
				{
				setState(39);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__12:
				case T__13:
					{
					setState(37);
					variable();
					}
					break;
				case T__5:
				case ID:
					{
					setState(38);
					proceso();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(43);
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

	public static class VariableContext extends ParserRuleContext {
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	 
		public VariableContext() { }
		public void copyFrom(VariableContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclareMatContext extends VariableContext {
		public Tk_matrixContext tk_matrix() {
			return getRuleContext(Tk_matrixContext.class,0);
		}
		public Variable_listContext variable_list() {
			return getRuleContext(Variable_listContext.class,0);
		}
		public DeclareMatContext(VariableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterDeclareMat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitDeclareMat(this);
		}
	}
	public static class DeclareIntContext extends VariableContext {
		public Tk_intContext tk_int() {
			return getRuleContext(Tk_intContext.class,0);
		}
		public Variable_listContext variable_list() {
			return getRuleContext(Variable_listContext.class,0);
		}
		public DeclareIntContext(VariableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterDeclareInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitDeclareInt(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variable);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				_localctx = new DeclareIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				tk_int();
				setState(45);
				variable_list();
				setState(46);
				match(T__2);
				}
				break;
			case T__13:
				_localctx = new DeclareMatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				tk_matrix();
				setState(49);
				variable_list();
				setState(50);
				match(T__2);
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

	public static class Variable_listContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MatrixLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MatrixLangParser.ID, i);
		}
		public Variable_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterVariable_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitVariable_list(this);
		}
	}

	public final Variable_listContext variable_list() throws RecognitionException {
		Variable_listContext _localctx = new Variable_listContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variable_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(ID);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(55);
				match(T__3);
				setState(56);
				match(ID);
				}
				}
				setState(61);
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

	public static class ProcesoContext extends ParserRuleContext {
		public ProcesoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proceso; }
	 
		public ProcesoContext() { }
		public void copyFrom(ProcesoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DefineOpContext extends ProcesoContext {
		public TK_IDContext tK_ID() {
			return getRuleContext(TK_IDContext.class,0);
		}
		public OperacionContext operacion() {
			return getRuleContext(OperacionContext.class,0);
		}
		public DefineOpContext(ProcesoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterDefineOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitDefineOp(this);
		}
	}
	public static class WriteOnConsoleContext extends ProcesoContext {
		public TK_IDContext tK_ID() {
			return getRuleContext(TK_IDContext.class,0);
		}
		public WriteOnConsoleContext(ProcesoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterWriteOnConsole(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitWriteOnConsole(this);
		}
	}
	public static class DefineMatContext extends ProcesoContext {
		public TK_IDContext tK_ID() {
			return getRuleContext(TK_IDContext.class,0);
		}
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public DefineMatContext(ProcesoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterDefineMat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitDefineMat(this);
		}
	}
	public static class DefineIntContext extends ProcesoContext {
		public TK_IDContext tK_ID() {
			return getRuleContext(TK_IDContext.class,0);
		}
		public Tk_NUMContext tk_NUM() {
			return getRuleContext(Tk_NUMContext.class,0);
		}
		public DefineIntContext(ProcesoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterDefineInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitDefineInt(this);
		}
	}

	public final ProcesoContext proceso() throws RecognitionException {
		ProcesoContext _localctx = new ProcesoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_proceso);
		try {
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new DefineIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				tK_ID();
				setState(63);
				match(T__4);
				setState(64);
				tk_NUM();
				setState(65);
				match(T__2);
				}
				break;
			case 2:
				_localctx = new DefineMatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				tK_ID();
				setState(68);
				match(T__4);
				setState(69);
				matrix();
				setState(70);
				match(T__2);
				}
				break;
			case 3:
				_localctx = new DefineOpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				tK_ID();
				setState(73);
				match(T__4);
				setState(74);
				operacion(0);
				setState(75);
				match(T__2);
				}
				break;
			case 4:
				_localctx = new WriteOnConsoleContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				match(T__5);
				setState(78);
				tK_ID();
				setState(79);
				match(T__2);
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

	public static class OperacionContext extends ParserRuleContext {
		public OperacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operacion; }
	 
		public OperacionContext() { }
		public void copyFrom(OperacionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubstractionContext extends OperacionContext {
		public List<OperacionContext> operacion() {
			return getRuleContexts(OperacionContext.class);
		}
		public OperacionContext operacion(int i) {
			return getRuleContext(OperacionContext.class,i);
		}
		public Tk_subContext tk_sub() {
			return getRuleContext(Tk_subContext.class,0);
		}
		public SubstractionContext(OperacionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterSubstraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitSubstraction(this);
		}
	}
	public static class VariableOpContext extends OperacionContext {
		public TK_IDContext tK_ID() {
			return getRuleContext(TK_IDContext.class,0);
		}
		public VariableOpContext(OperacionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterVariableOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitVariableOp(this);
		}
	}
	public static class ParenthesisContext extends OperacionContext {
		public OperacionContext operacion() {
			return getRuleContext(OperacionContext.class,0);
		}
		public ParenthesisContext(OperacionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitParenthesis(this);
		}
	}
	public static class MultiplicationContext extends OperacionContext {
		public List<OperacionContext> operacion() {
			return getRuleContexts(OperacionContext.class);
		}
		public OperacionContext operacion(int i) {
			return getRuleContext(OperacionContext.class,i);
		}
		public Tk_multContext tk_mult() {
			return getRuleContext(Tk_multContext.class,0);
		}
		public MultiplicationContext(OperacionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitMultiplication(this);
		}
	}
	public static class AdditionContext extends OperacionContext {
		public List<OperacionContext> operacion() {
			return getRuleContexts(OperacionContext.class);
		}
		public OperacionContext operacion(int i) {
			return getRuleContext(OperacionContext.class,i);
		}
		public Tk_addContext tk_add() {
			return getRuleContext(Tk_addContext.class,0);
		}
		public AdditionContext(OperacionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterAddition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitAddition(this);
		}
	}
	public static class MatrixOpContext extends OperacionContext {
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public MatrixOpContext(OperacionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterMatrixOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitMatrixOp(this);
		}
	}
	public static class TransposeContext extends OperacionContext {
		public OperacionContext operacion() {
			return getRuleContext(OperacionContext.class,0);
		}
		public TransposeContext(OperacionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterTranspose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitTranspose(this);
		}
	}

	public final OperacionContext operacion() throws RecognitionException {
		return operacion(0);
	}

	private OperacionContext operacion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OperacionContext _localctx = new OperacionContext(_ctx, _parentState);
		OperacionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_operacion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(84);
				match(T__6);
				setState(85);
				operacion(0);
				setState(86);
				match(T__7);
				}
				break;
			case T__9:
				{
				_localctx = new MatrixOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				matrix();
				}
				break;
			case ID:
				{
				_localctx = new VariableOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				tK_ID();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(106);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationContext(new OperacionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operacion);
						setState(92);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(93);
						tk_mult();
						setState(94);
						operacion(6);
						}
						break;
					case 2:
						{
						_localctx = new AdditionContext(new OperacionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operacion);
						setState(96);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(97);
						tk_add();
						setState(98);
						operacion(5);
						}
						break;
					case 3:
						{
						_localctx = new SubstractionContext(new OperacionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operacion);
						setState(100);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(101);
						tk_sub();
						setState(102);
						operacion(4);
						}
						break;
					case 4:
						{
						_localctx = new TransposeContext(new OperacionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operacion);
						setState(104);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(105);
						match(T__8);
						}
						break;
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class MatrixContext extends ParserRuleContext {
		public List<ColumnContext> column() {
			return getRuleContexts(ColumnContext.class);
		}
		public ColumnContext column(int i) {
			return getRuleContext(ColumnContext.class,i);
		}
		public MatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterMatrix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitMatrix(this);
		}
	}

	public final MatrixContext matrix() throws RecognitionException {
		MatrixContext _localctx = new MatrixContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__9);
			setState(112);
			column();
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(113);
				match(T__2);
				setState(114);
				column();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
			match(T__10);
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

	public static class ColumnContext extends ParserRuleContext {
		public List<TerminalNode> NUM() { return getTokens(MatrixLangParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(MatrixLangParser.NUM, i);
		}
		public ColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitColumn(this);
		}
	}

	public final ColumnContext column() throws RecognitionException {
		ColumnContext _localctx = new ColumnContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_column);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(NUM);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(123);
				match(T__3);
				setState(124);
				match(NUM);
				}
				}
				setState(129);
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

	public static class Tk_mainContext extends ParserRuleContext {
		public Tk_mainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tk_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterTk_main(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitTk_main(this);
		}
	}

	public final Tk_mainContext tk_main() throws RecognitionException {
		Tk_mainContext _localctx = new Tk_mainContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tk_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(T__11);
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

	public static class Tk_intContext extends ParserRuleContext {
		public Tk_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tk_int; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterTk_int(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitTk_int(this);
		}
	}

	public final Tk_intContext tk_int() throws RecognitionException {
		Tk_intContext _localctx = new Tk_intContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tk_int);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__12);
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

	public static class Tk_matrixContext extends ParserRuleContext {
		public Tk_matrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tk_matrix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterTk_matrix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitTk_matrix(this);
		}
	}

	public final Tk_matrixContext tk_matrix() throws RecognitionException {
		Tk_matrixContext _localctx = new Tk_matrixContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tk_matrix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__13);
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

	public static class TK_IDContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MatrixLangParser.ID, 0); }
		public TK_IDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tK_ID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterTK_ID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitTK_ID(this);
		}
	}

	public final TK_IDContext tK_ID() throws RecognitionException {
		TK_IDContext _localctx = new TK_IDContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tK_ID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(ID);
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

	public static class Tk_NUMContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(MatrixLangParser.NUM, 0); }
		public Tk_NUMContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tk_NUM; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterTk_NUM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitTk_NUM(this);
		}
	}

	public final Tk_NUMContext tk_NUM() throws RecognitionException {
		Tk_NUMContext _localctx = new Tk_NUMContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tk_NUM);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(NUM);
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

	public static class Tk_addContext extends ParserRuleContext {
		public Tk_addContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tk_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterTk_add(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitTk_add(this);
		}
	}

	public final Tk_addContext tk_add() throws RecognitionException {
		Tk_addContext _localctx = new Tk_addContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tk_add);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__14);
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

	public static class Tk_subContext extends ParserRuleContext {
		public Tk_subContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tk_sub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterTk_sub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitTk_sub(this);
		}
	}

	public final Tk_subContext tk_sub() throws RecognitionException {
		Tk_subContext _localctx = new Tk_subContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tk_sub);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__15);
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

	public static class Tk_multContext extends ParserRuleContext {
		public Tk_multContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tk_mult; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).enterTk_mult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixLangListener ) ((MatrixLangListener)listener).exitTk_mult(this);
		}
	}

	public final Tk_multContext tk_mult() throws RecognitionException {
		Tk_multContext _localctx = new Tk_multContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tk_mult);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(T__16);
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
		case 5:
			return operacion_sempred((OperacionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean operacion_sempred(OperacionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u0095\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\7\3*\n\3\f\3\16\3-\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4\67\n\4\3\5\3\5\3\5\7\5<\n\5\f\5\16\5?\13\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6T\n\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7]\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\7\7m\n\7\f\7\16\7p\13\7\3\b\3\b\3\b\3\b\7\bv"+
		"\n\b\f\b\16\by\13\b\3\b\3\b\3\t\3\t\3\t\7\t\u0080\n\t\f\t\16\t\u0083\13"+
		"\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\21\2\3\f\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\2\2\u0093"+
		"\2\"\3\2\2\2\4+\3\2\2\2\6\66\3\2\2\2\b8\3\2\2\2\nS\3\2\2\2\f\\\3\2\2\2"+
		"\16q\3\2\2\2\20|\3\2\2\2\22\u0084\3\2\2\2\24\u0086\3\2\2\2\26\u0088\3"+
		"\2\2\2\30\u008a\3\2\2\2\32\u008c\3\2\2\2\34\u008e\3\2\2\2\36\u0090\3\2"+
		"\2\2 \u0092\3\2\2\2\"#\5\22\n\2#$\7\3\2\2$%\5\4\3\2%&\7\4\2\2&\3\3\2\2"+
		"\2\'*\5\6\4\2(*\5\n\6\2)\'\3\2\2\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2"+
		"\2\2,\5\3\2\2\2-+\3\2\2\2./\5\24\13\2/\60\5\b\5\2\60\61\7\5\2\2\61\67"+
		"\3\2\2\2\62\63\5\26\f\2\63\64\5\b\5\2\64\65\7\5\2\2\65\67\3\2\2\2\66."+
		"\3\2\2\2\66\62\3\2\2\2\67\7\3\2\2\28=\7\24\2\29:\7\6\2\2:<\7\24\2\2;9"+
		"\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\t\3\2\2\2?=\3\2\2\2@A\5\30\r\2"+
		"AB\7\7\2\2BC\5\32\16\2CD\7\5\2\2DT\3\2\2\2EF\5\30\r\2FG\7\7\2\2GH\5\16"+
		"\b\2HI\7\5\2\2IT\3\2\2\2JK\5\30\r\2KL\7\7\2\2LM\5\f\7\2MN\7\5\2\2NT\3"+
		"\2\2\2OP\7\b\2\2PQ\5\30\r\2QR\7\5\2\2RT\3\2\2\2S@\3\2\2\2SE\3\2\2\2SJ"+
		"\3\2\2\2SO\3\2\2\2T\13\3\2\2\2UV\b\7\1\2VW\7\t\2\2WX\5\f\7\2XY\7\n\2\2"+
		"Y]\3\2\2\2Z]\5\16\b\2[]\5\30\r\2\\U\3\2\2\2\\Z\3\2\2\2\\[\3\2\2\2]n\3"+
		"\2\2\2^_\f\7\2\2_`\5 \21\2`a\5\f\7\bam\3\2\2\2bc\f\6\2\2cd\5\34\17\2d"+
		"e\5\f\7\7em\3\2\2\2fg\f\5\2\2gh\5\36\20\2hi\5\f\7\6im\3\2\2\2jk\f\b\2"+
		"\2km\7\13\2\2l^\3\2\2\2lb\3\2\2\2lf\3\2\2\2lj\3\2\2\2mp\3\2\2\2nl\3\2"+
		"\2\2no\3\2\2\2o\r\3\2\2\2pn\3\2\2\2qr\7\f\2\2rw\5\20\t\2st\7\5\2\2tv\5"+
		"\20\t\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{"+
		"\7\r\2\2{\17\3\2\2\2|\u0081\7\25\2\2}~\7\6\2\2~\u0080\7\25\2\2\177}\3"+
		"\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\21\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\7\16\2\2\u0085\23\3\2\2\2"+
		"\u0086\u0087\7\17\2\2\u0087\25\3\2\2\2\u0088\u0089\7\20\2\2\u0089\27\3"+
		"\2\2\2\u008a\u008b\7\24\2\2\u008b\31\3\2\2\2\u008c\u008d\7\25\2\2\u008d"+
		"\33\3\2\2\2\u008e\u008f\7\21\2\2\u008f\35\3\2\2\2\u0090\u0091\7\22\2\2"+
		"\u0091\37\3\2\2\2\u0092\u0093\7\23\2\2\u0093!\3\2\2\2\f)+\66=S\\lnw\u0081";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}