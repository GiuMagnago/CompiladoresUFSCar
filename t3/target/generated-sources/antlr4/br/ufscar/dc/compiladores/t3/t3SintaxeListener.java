// Generated from br\u005Cufscar\dc\compiladores\t3\t3Sintaxe.g4 by ANTLR 4.10.1
package br.ufscar.dc.compiladores.t3;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link t3SintaxeParser}.
 */
public interface t3SintaxeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(t3SintaxeParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(t3SintaxeParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(t3SintaxeParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(t3SintaxeParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void enterDecl_local_global(t3SintaxeParser.Decl_local_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void exitDecl_local_global(t3SintaxeParser.Decl_local_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_local(t3SintaxeParser.Declaracao_localContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_local(t3SintaxeParser.Declaracao_localContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#variavel}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(t3SintaxeParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#variavel}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(t3SintaxeParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(t3SintaxeParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(t3SintaxeParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void enterDimensao(t3SintaxeParser.DimensaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void exitDimensao(t3SintaxeParser.DimensaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(t3SintaxeParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(t3SintaxeParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico(t3SintaxeParser.Tipo_basicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico(t3SintaxeParser.Tipo_basicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico_ident(t3SintaxeParser.Tipo_basico_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico_ident(t3SintaxeParser.Tipo_basico_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void enterTipo_estendido(t3SintaxeParser.Tipo_estendidoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void exitTipo_estendido(t3SintaxeParser.Tipo_estendidoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void enterValor_constante(t3SintaxeParser.Valor_constanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void exitValor_constante(t3SintaxeParser.Valor_constanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#registro}.
	 * @param ctx the parse tree
	 */
	void enterRegistro(t3SintaxeParser.RegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#registro}.
	 * @param ctx the parse tree
	 */
	void exitRegistro(t3SintaxeParser.RegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_global(t3SintaxeParser.Declaracao_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_global(t3SintaxeParser.Declaracao_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(t3SintaxeParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(t3SintaxeParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(t3SintaxeParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(t3SintaxeParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(t3SintaxeParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(t3SintaxeParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(t3SintaxeParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(t3SintaxeParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeia(t3SintaxeParser.CmdLeiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeia(t3SintaxeParser.CmdLeiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscreva(t3SintaxeParser.CmdEscrevaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscreva(t3SintaxeParser.CmdEscrevaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void enterCmdSe(t3SintaxeParser.CmdSeContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void exitCmdSe(t3SintaxeParser.CmdSeContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void enterCmdCaso(t3SintaxeParser.CmdCasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void exitCmdCaso(t3SintaxeParser.CmdCasoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void enterCmdPara(t3SintaxeParser.CmdParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void exitCmdPara(t3SintaxeParser.CmdParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdEnquanto(t3SintaxeParser.CmdEnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdEnquanto(t3SintaxeParser.CmdEnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void enterCmdFaca(t3SintaxeParser.CmdFacaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void exitCmdFaca(t3SintaxeParser.CmdFacaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtribuicao(t3SintaxeParser.CmdAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtribuicao(t3SintaxeParser.CmdAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void enterCmdChamada(t3SintaxeParser.CmdChamadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void exitCmdChamada(t3SintaxeParser.CmdChamadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void enterCmdRetorne(t3SintaxeParser.CmdRetorneContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void exitCmdRetorne(t3SintaxeParser.CmdRetorneContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#selecao}.
	 * @param ctx the parse tree
	 */
	void enterSelecao(t3SintaxeParser.SelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#selecao}.
	 * @param ctx the parse tree
	 */
	void exitSelecao(t3SintaxeParser.SelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void enterItem_selecao(t3SintaxeParser.Item_selecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void exitItem_selecao(t3SintaxeParser.Item_selecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#constantes}.
	 * @param ctx the parse tree
	 */
	void enterConstantes(t3SintaxeParser.ConstantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#constantes}.
	 * @param ctx the parse tree
	 */
	void exitConstantes(t3SintaxeParser.ConstantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void enterNumero_intervalo(t3SintaxeParser.Numero_intervaloContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void exitNumero_intervalo(t3SintaxeParser.Numero_intervaloContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void enterOp_unario(t3SintaxeParser.Op_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void exitOp_unario(t3SintaxeParser.Op_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExp_aritmetica(t3SintaxeParser.Exp_aritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExp_aritmetica(t3SintaxeParser.Exp_aritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(t3SintaxeParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(t3SintaxeParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(t3SintaxeParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(t3SintaxeParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#op1}.
	 * @param ctx the parse tree
	 */
	void enterOp1(t3SintaxeParser.Op1Context ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#op1}.
	 * @param ctx the parse tree
	 */
	void exitOp1(t3SintaxeParser.Op1Context ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#op2}.
	 * @param ctx the parse tree
	 */
	void enterOp2(t3SintaxeParser.Op2Context ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#op2}.
	 * @param ctx the parse tree
	 */
	void exitOp2(t3SintaxeParser.Op2Context ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#op3}.
	 * @param ctx the parse tree
	 */
	void enterOp3(t3SintaxeParser.Op3Context ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#op3}.
	 * @param ctx the parse tree
	 */
	void exitOp3(t3SintaxeParser.Op3Context ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#parcela}.
	 * @param ctx the parse tree
	 */
	void enterParcela(t3SintaxeParser.ParcelaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#parcela}.
	 * @param ctx the parse tree
	 */
	void exitParcela(t3SintaxeParser.ParcelaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_unario(t3SintaxeParser.Parcela_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_unario(t3SintaxeParser.Parcela_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_nao_unario(t3SintaxeParser.Parcela_nao_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_nao_unario(t3SintaxeParser.Parcela_nao_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void enterExp_relacional(t3SintaxeParser.Exp_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void exitExp_relacional(t3SintaxeParser.Exp_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void enterOp_relacional(t3SintaxeParser.Op_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void exitOp_relacional(t3SintaxeParser.Op_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(t3SintaxeParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(t3SintaxeParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void enterTermo_logico(t3SintaxeParser.Termo_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void exitTermo_logico(t3SintaxeParser.Termo_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void enterFator_logico(t3SintaxeParser.Fator_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void exitFator_logico(t3SintaxeParser.Fator_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void enterParcela_logica(t3SintaxeParser.Parcela_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void exitParcela_logica(t3SintaxeParser.Parcela_logicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_1(t3SintaxeParser.Op_logico_1Context ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_1(t3SintaxeParser.Op_logico_1Context ctx);
	/**
	 * Enter a parse tree produced by {@link t3SintaxeParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_2(t3SintaxeParser.Op_logico_2Context ctx);
	/**
	 * Exit a parse tree produced by {@link t3SintaxeParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_2(t3SintaxeParser.Op_logico_2Context ctx);
}