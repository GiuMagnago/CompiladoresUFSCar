// Generated from java-escape by ANTLR 4.11.1
package br.ufscar.dc.compiladores.t2;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link t2SintaxeParser}.
 */
public interface t2SintaxeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(t2SintaxeParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(t2SintaxeParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(t2SintaxeParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(t2SintaxeParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void enterDecl_local_global(t2SintaxeParser.Decl_local_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void exitDecl_local_global(t2SintaxeParser.Decl_local_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_local(t2SintaxeParser.Declaracao_localContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_local(t2SintaxeParser.Declaracao_localContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#variavel}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(t2SintaxeParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#variavel}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(t2SintaxeParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(t2SintaxeParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(t2SintaxeParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void enterDimensao(t2SintaxeParser.DimensaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void exitDimensao(t2SintaxeParser.DimensaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(t2SintaxeParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(t2SintaxeParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico(t2SintaxeParser.Tipo_basicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico(t2SintaxeParser.Tipo_basicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico_ident(t2SintaxeParser.Tipo_basico_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico_ident(t2SintaxeParser.Tipo_basico_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void enterTipo_estendido(t2SintaxeParser.Tipo_estendidoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void exitTipo_estendido(t2SintaxeParser.Tipo_estendidoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void enterValor_constante(t2SintaxeParser.Valor_constanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void exitValor_constante(t2SintaxeParser.Valor_constanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#registro}.
	 * @param ctx the parse tree
	 */
	void enterRegistro(t2SintaxeParser.RegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#registro}.
	 * @param ctx the parse tree
	 */
	void exitRegistro(t2SintaxeParser.RegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_global(t2SintaxeParser.Declaracao_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_global(t2SintaxeParser.Declaracao_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(t2SintaxeParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(t2SintaxeParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(t2SintaxeParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(t2SintaxeParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(t2SintaxeParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(t2SintaxeParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(t2SintaxeParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(t2SintaxeParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeia(t2SintaxeParser.CmdLeiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeia(t2SintaxeParser.CmdLeiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscreva(t2SintaxeParser.CmdEscrevaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscreva(t2SintaxeParser.CmdEscrevaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void enterCmdSe(t2SintaxeParser.CmdSeContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void exitCmdSe(t2SintaxeParser.CmdSeContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void enterCmdCaso(t2SintaxeParser.CmdCasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void exitCmdCaso(t2SintaxeParser.CmdCasoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void enterCmdPara(t2SintaxeParser.CmdParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void exitCmdPara(t2SintaxeParser.CmdParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdEnquanto(t2SintaxeParser.CmdEnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdEnquanto(t2SintaxeParser.CmdEnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void enterCmdFaca(t2SintaxeParser.CmdFacaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void exitCmdFaca(t2SintaxeParser.CmdFacaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtribuicao(t2SintaxeParser.CmdAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtribuicao(t2SintaxeParser.CmdAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void enterCmdChamada(t2SintaxeParser.CmdChamadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void exitCmdChamada(t2SintaxeParser.CmdChamadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void enterCmdRetorne(t2SintaxeParser.CmdRetorneContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void exitCmdRetorne(t2SintaxeParser.CmdRetorneContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#selecao}.
	 * @param ctx the parse tree
	 */
	void enterSelecao(t2SintaxeParser.SelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#selecao}.
	 * @param ctx the parse tree
	 */
	void exitSelecao(t2SintaxeParser.SelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void enterItem_selecao(t2SintaxeParser.Item_selecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void exitItem_selecao(t2SintaxeParser.Item_selecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#constantes}.
	 * @param ctx the parse tree
	 */
	void enterConstantes(t2SintaxeParser.ConstantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#constantes}.
	 * @param ctx the parse tree
	 */
	void exitConstantes(t2SintaxeParser.ConstantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void enterNumero_intervalo(t2SintaxeParser.Numero_intervaloContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void exitNumero_intervalo(t2SintaxeParser.Numero_intervaloContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void enterOp_unario(t2SintaxeParser.Op_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void exitOp_unario(t2SintaxeParser.Op_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExp_aritmetica(t2SintaxeParser.Exp_aritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExp_aritmetica(t2SintaxeParser.Exp_aritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(t2SintaxeParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(t2SintaxeParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(t2SintaxeParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(t2SintaxeParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#op1}.
	 * @param ctx the parse tree
	 */
	void enterOp1(t2SintaxeParser.Op1Context ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#op1}.
	 * @param ctx the parse tree
	 */
	void exitOp1(t2SintaxeParser.Op1Context ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#op2}.
	 * @param ctx the parse tree
	 */
	void enterOp2(t2SintaxeParser.Op2Context ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#op2}.
	 * @param ctx the parse tree
	 */
	void exitOp2(t2SintaxeParser.Op2Context ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#op3}.
	 * @param ctx the parse tree
	 */
	void enterOp3(t2SintaxeParser.Op3Context ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#op3}.
	 * @param ctx the parse tree
	 */
	void exitOp3(t2SintaxeParser.Op3Context ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#parcela}.
	 * @param ctx the parse tree
	 */
	void enterParcela(t2SintaxeParser.ParcelaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#parcela}.
	 * @param ctx the parse tree
	 */
	void exitParcela(t2SintaxeParser.ParcelaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_unario(t2SintaxeParser.Parcela_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_unario(t2SintaxeParser.Parcela_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_nao_unario(t2SintaxeParser.Parcela_nao_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_nao_unario(t2SintaxeParser.Parcela_nao_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void enterExp_relacional(t2SintaxeParser.Exp_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void exitExp_relacional(t2SintaxeParser.Exp_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void enterOp_relacional(t2SintaxeParser.Op_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void exitOp_relacional(t2SintaxeParser.Op_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(t2SintaxeParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(t2SintaxeParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void enterTermo_logico(t2SintaxeParser.Termo_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void exitTermo_logico(t2SintaxeParser.Termo_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void enterFator_logico(t2SintaxeParser.Fator_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void exitFator_logico(t2SintaxeParser.Fator_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void enterParcela_logica(t2SintaxeParser.Parcela_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void exitParcela_logica(t2SintaxeParser.Parcela_logicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_1(t2SintaxeParser.Op_logico_1Context ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_1(t2SintaxeParser.Op_logico_1Context ctx);
	/**
	 * Enter a parse tree produced by {@link t2SintaxeParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_2(t2SintaxeParser.Op_logico_2Context ctx);
	/**
	 * Exit a parse tree produced by {@link t2SintaxeParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_2(t2SintaxeParser.Op_logico_2Context ctx);
}