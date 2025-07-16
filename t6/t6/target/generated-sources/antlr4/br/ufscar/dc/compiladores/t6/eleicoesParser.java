// Generated from br\u005Cufscar\dc\compiladores\t6\eleicoes.g4 by ANTLR 4.10.1
package br.ufscar.dc.compiladores.t6;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class eleicoesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, STRING=7, COMENTARIO=8, 
		WS=9;
	public static final int
		RULE_programa = 0, RULE_candidatoDecl = 1, RULE_urnaDecl = 2, RULE_votoDecl = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "candidatoDecl", "urnaDecl", "votoDecl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'candidato'", "'urna'", "'{'", "'}'", "'voto'", "'em'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "STRING", "COMENTARIO", "WS"
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
	public String getGrammarFileName() { return "eleicoes.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public eleicoesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(eleicoesParser.EOF, 0); }
		public List<CandidatoDeclContext> candidatoDecl() {
			return getRuleContexts(CandidatoDeclContext.class);
		}
		public CandidatoDeclContext candidatoDecl(int i) {
			return getRuleContext(CandidatoDeclContext.class,i);
		}
		public List<UrnaDeclContext> urnaDecl() {
			return getRuleContexts(UrnaDeclContext.class);
		}
		public UrnaDeclContext urnaDecl(int i) {
			return getRuleContext(UrnaDeclContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof eleicoesListener ) ((eleicoesListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof eleicoesListener ) ((eleicoesListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof eleicoesVisitor ) return ((eleicoesVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(10);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(8);
					candidatoDecl();
					}
					break;
				case T__1:
					{
					setState(9);
					urnaDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(12); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==T__1 );
			setState(14);
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

	public static class CandidatoDeclContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(eleicoesParser.STRING, 0); }
		public CandidatoDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_candidatoDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof eleicoesListener ) ((eleicoesListener)listener).enterCandidatoDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof eleicoesListener ) ((eleicoesListener)listener).exitCandidatoDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof eleicoesVisitor ) return ((eleicoesVisitor<? extends T>)visitor).visitCandidatoDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CandidatoDeclContext candidatoDecl() throws RecognitionException {
		CandidatoDeclContext _localctx = new CandidatoDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_candidatoDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(T__0);
			setState(17);
			match(STRING);
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

	public static class UrnaDeclContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(eleicoesParser.STRING, 0); }
		public List<VotoDeclContext> votoDecl() {
			return getRuleContexts(VotoDeclContext.class);
		}
		public VotoDeclContext votoDecl(int i) {
			return getRuleContext(VotoDeclContext.class,i);
		}
		public UrnaDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_urnaDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof eleicoesListener ) ((eleicoesListener)listener).enterUrnaDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof eleicoesListener ) ((eleicoesListener)listener).exitUrnaDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof eleicoesVisitor ) return ((eleicoesVisitor<? extends T>)visitor).visitUrnaDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UrnaDeclContext urnaDecl() throws RecognitionException {
		UrnaDeclContext _localctx = new UrnaDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_urnaDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			match(T__1);
			setState(20);
			match(STRING);
			setState(21);
			match(T__2);
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(22);
				votoDecl();
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
			match(T__3);
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

	public static class VotoDeclContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(eleicoesParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(eleicoesParser.STRING, i);
		}
		public VotoDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_votoDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof eleicoesListener ) ((eleicoesListener)listener).enterVotoDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof eleicoesListener ) ((eleicoesListener)listener).exitVotoDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof eleicoesVisitor ) return ((eleicoesVisitor<? extends T>)visitor).visitVotoDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VotoDeclContext votoDecl() throws RecognitionException {
		VotoDeclContext _localctx = new VotoDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_votoDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__4);
			setState(31);
			match(STRING);
			setState(32);
			match(T__5);
			setState(33);
			match(STRING);
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

	public static final String _serializedATN =
		"\u0004\u0001\t$\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0004"+
		"\u0000\u000b\b\u0000\u000b\u0000\f\u0000\f\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002\u0018\b\u0002\n\u0002\f\u0002\u001b\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0000\u0000\u0004\u0000\u0002\u0004\u0006\u0000\u0000\"\u0000"+
		"\n\u0001\u0000\u0000\u0000\u0002\u0010\u0001\u0000\u0000\u0000\u0004\u0013"+
		"\u0001\u0000\u0000\u0000\u0006\u001e\u0001\u0000\u0000\u0000\b\u000b\u0003"+
		"\u0002\u0001\u0000\t\u000b\u0003\u0004\u0002\u0000\n\b\u0001\u0000\u0000"+
		"\u0000\n\t\u0001\u0000\u0000\u0000\u000b\f\u0001\u0000\u0000\u0000\f\n"+
		"\u0001\u0000\u0000\u0000\f\r\u0001\u0000\u0000\u0000\r\u000e\u0001\u0000"+
		"\u0000\u0000\u000e\u000f\u0005\u0000\u0000\u0001\u000f\u0001\u0001\u0000"+
		"\u0000\u0000\u0010\u0011\u0005\u0001\u0000\u0000\u0011\u0012\u0005\u0007"+
		"\u0000\u0000\u0012\u0003\u0001\u0000\u0000\u0000\u0013\u0014\u0005\u0002"+
		"\u0000\u0000\u0014\u0015\u0005\u0007\u0000\u0000\u0015\u0019\u0005\u0003"+
		"\u0000\u0000\u0016\u0018\u0003\u0006\u0003\u0000\u0017\u0016\u0001\u0000"+
		"\u0000\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000"+
		"\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u001c\u0001\u0000"+
		"\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001c\u001d\u0005\u0004"+
		"\u0000\u0000\u001d\u0005\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0005"+
		"\u0000\u0000\u001f \u0005\u0007\u0000\u0000 !\u0005\u0006\u0000\u0000"+
		"!\"\u0005\u0007\u0000\u0000\"\u0007\u0001\u0000\u0000\u0000\u0003\n\f"+
		"\u0019";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}