// Generated from br\u005Cufscar\dc\compiladores\t4\t4Sintaxe.g4 by ANTLR 4.10.1
package br.ufscar.dc.compiladores.t4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link t4SintaxeParser}.
 */
public interface t4SintaxeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(t4SintaxeParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(t4SintaxeParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(t4SintaxeParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(t4SintaxeParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void enterDecl_local_global(t4SintaxeParser.Decl_local_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void exitDecl_local_global(t4SintaxeParser.Decl_local_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_local(t4SintaxeParser.Declaracao_localContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_local(t4SintaxeParser.Declaracao_localContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#variavel}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(t4SintaxeParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#variavel}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(t4SintaxeParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(t4SintaxeParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(t4SintaxeParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void enterDimensao(t4SintaxeParser.DimensaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void exitDimensao(t4SintaxeParser.DimensaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(t4SintaxeParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(t4SintaxeParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico(t4SintaxeParser.Tipo_basicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico(t4SintaxeParser.Tipo_basicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico_ident(t4SintaxeParser.Tipo_basico_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico_ident(t4SintaxeParser.Tipo_basico_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void enterTipo_estendido(t4SintaxeParser.Tipo_estendidoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void exitTipo_estendido(t4SintaxeParser.Tipo_estendidoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void enterValor_constante(t4SintaxeParser.Valor_constanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void exitValor_constante(t4SintaxeParser.Valor_constanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#registro}.
	 * @param ctx the parse tree
	 */
	void enterRegistro(t4SintaxeParser.RegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#registro}.
	 * @param ctx the parse tree
	 */
	void exitRegistro(t4SintaxeParser.RegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_global(t4SintaxeParser.Declaracao_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_global(t4SintaxeParser.Declaracao_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(t4SintaxeParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(t4SintaxeParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(t4SintaxeParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(t4SintaxeParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(t4SintaxeParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(t4SintaxeParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(t4SintaxeParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(t4SintaxeParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeia(t4SintaxeParser.CmdLeiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeia(t4SintaxeParser.CmdLeiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscreva(t4SintaxeParser.CmdEscrevaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscreva(t4SintaxeParser.CmdEscrevaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void enterCmdSe(t4SintaxeParser.CmdSeContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void exitCmdSe(t4SintaxeParser.CmdSeContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void enterCmdCaso(t4SintaxeParser.CmdCasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void exitCmdCaso(t4SintaxeParser.CmdCasoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void enterCmdPara(t4SintaxeParser.CmdParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void exitCmdPara(t4SintaxeParser.CmdParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdEnquanto(t4SintaxeParser.CmdEnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdEnquanto(t4SintaxeParser.CmdEnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void enterCmdFaca(t4SintaxeParser.CmdFacaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void exitCmdFaca(t4SintaxeParser.CmdFacaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtribuicao(t4SintaxeParser.CmdAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtribuicao(t4SintaxeParser.CmdAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void enterCmdChamada(t4SintaxeParser.CmdChamadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void exitCmdChamada(t4SintaxeParser.CmdChamadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void enterCmdRetorne(t4SintaxeParser.CmdRetorneContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void exitCmdRetorne(t4SintaxeParser.CmdRetorneContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#selecao}.
	 * @param ctx the parse tree
	 */
	void enterSelecao(t4SintaxeParser.SelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#selecao}.
	 * @param ctx the parse tree
	 */
	void exitSelecao(t4SintaxeParser.SelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void enterItem_selecao(t4SintaxeParser.Item_selecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void exitItem_selecao(t4SintaxeParser.Item_selecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#constantes}.
	 * @param ctx the parse tree
	 */
	void enterConstantes(t4SintaxeParser.ConstantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#constantes}.
	 * @param ctx the parse tree
	 */
	void exitConstantes(t4SintaxeParser.ConstantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void enterNumero_intervalo(t4SintaxeParser.Numero_intervaloContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void exitNumero_intervalo(t4SintaxeParser.Numero_intervaloContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void enterOp_unario(t4SintaxeParser.Op_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void exitOp_unario(t4SintaxeParser.Op_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExp_aritmetica(t4SintaxeParser.Exp_aritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExp_aritmetica(t4SintaxeParser.Exp_aritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(t4SintaxeParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(t4SintaxeParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(t4SintaxeParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(t4SintaxeParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#op1}.
	 * @param ctx the parse tree
	 */
	void enterOp1(t4SintaxeParser.Op1Context ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#op1}.
	 * @param ctx the parse tree
	 */
	void exitOp1(t4SintaxeParser.Op1Context ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#op2}.
	 * @param ctx the parse tree
	 */
	void enterOp2(t4SintaxeParser.Op2Context ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#op2}.
	 * @param ctx the parse tree
	 */
	void exitOp2(t4SintaxeParser.Op2Context ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#op3}.
	 * @param ctx the parse tree
	 */
	void enterOp3(t4SintaxeParser.Op3Context ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#op3}.
	 * @param ctx the parse tree
	 */
	void exitOp3(t4SintaxeParser.Op3Context ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#parcela}.
	 * @param ctx the parse tree
	 */
	void enterParcela(t4SintaxeParser.ParcelaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#parcela}.
	 * @param ctx the parse tree
	 */
	void exitParcela(t4SintaxeParser.ParcelaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_unario(t4SintaxeParser.Parcela_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_unario(t4SintaxeParser.Parcela_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_nao_unario(t4SintaxeParser.Parcela_nao_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_nao_unario(t4SintaxeParser.Parcela_nao_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void enterExp_relacional(t4SintaxeParser.Exp_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void exitExp_relacional(t4SintaxeParser.Exp_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void enterOp_relacional(t4SintaxeParser.Op_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void exitOp_relacional(t4SintaxeParser.Op_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(t4SintaxeParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(t4SintaxeParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void enterTermo_logico(t4SintaxeParser.Termo_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void exitTermo_logico(t4SintaxeParser.Termo_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void enterFator_logico(t4SintaxeParser.Fator_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void exitFator_logico(t4SintaxeParser.Fator_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void enterParcela_logica(t4SintaxeParser.Parcela_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void exitParcela_logica(t4SintaxeParser.Parcela_logicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_1(t4SintaxeParser.Op_logico_1Context ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_1(t4SintaxeParser.Op_logico_1Context ctx);
	/**
	 * Enter a parse tree produced by {@link t4SintaxeParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_2(t4SintaxeParser.Op_logico_2Context ctx);
	/**
	 * Exit a parse tree produced by {@link t4SintaxeParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_2(t4SintaxeParser.Op_logico_2Context ctx);
}