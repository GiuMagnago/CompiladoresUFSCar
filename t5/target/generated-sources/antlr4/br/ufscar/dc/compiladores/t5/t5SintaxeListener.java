// Generated from br\u005Cufscar\dc\compiladores\t5\t5Sintaxe.g4 by ANTLR 4.10.1
package br.ufscar.dc.compiladores.t5;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link t5SintaxeParser}.
 */
public interface t5SintaxeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(t5SintaxeParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(t5SintaxeParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(t5SintaxeParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(t5SintaxeParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void enterDecl_local_global(t5SintaxeParser.Decl_local_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void exitDecl_local_global(t5SintaxeParser.Decl_local_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_local(t5SintaxeParser.Declaracao_localContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_local(t5SintaxeParser.Declaracao_localContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#variavel}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(t5SintaxeParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#variavel}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(t5SintaxeParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(t5SintaxeParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(t5SintaxeParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void enterDimensao(t5SintaxeParser.DimensaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void exitDimensao(t5SintaxeParser.DimensaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(t5SintaxeParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(t5SintaxeParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico(t5SintaxeParser.Tipo_basicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico(t5SintaxeParser.Tipo_basicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico_ident(t5SintaxeParser.Tipo_basico_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico_ident(t5SintaxeParser.Tipo_basico_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void enterTipo_estendido(t5SintaxeParser.Tipo_estendidoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void exitTipo_estendido(t5SintaxeParser.Tipo_estendidoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void enterValor_constante(t5SintaxeParser.Valor_constanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void exitValor_constante(t5SintaxeParser.Valor_constanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#registro}.
	 * @param ctx the parse tree
	 */
	void enterRegistro(t5SintaxeParser.RegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#registro}.
	 * @param ctx the parse tree
	 */
	void exitRegistro(t5SintaxeParser.RegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_global(t5SintaxeParser.Declaracao_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_global(t5SintaxeParser.Declaracao_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(t5SintaxeParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(t5SintaxeParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(t5SintaxeParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(t5SintaxeParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(t5SintaxeParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(t5SintaxeParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(t5SintaxeParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(t5SintaxeParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeia(t5SintaxeParser.CmdLeiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeia(t5SintaxeParser.CmdLeiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscreva(t5SintaxeParser.CmdEscrevaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscreva(t5SintaxeParser.CmdEscrevaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void enterCmdSe(t5SintaxeParser.CmdSeContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void exitCmdSe(t5SintaxeParser.CmdSeContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void enterCmdCaso(t5SintaxeParser.CmdCasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void exitCmdCaso(t5SintaxeParser.CmdCasoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void enterCmdPara(t5SintaxeParser.CmdParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void exitCmdPara(t5SintaxeParser.CmdParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdEnquanto(t5SintaxeParser.CmdEnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdEnquanto(t5SintaxeParser.CmdEnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void enterCmdFaca(t5SintaxeParser.CmdFacaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void exitCmdFaca(t5SintaxeParser.CmdFacaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtribuicao(t5SintaxeParser.CmdAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtribuicao(t5SintaxeParser.CmdAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void enterCmdChamada(t5SintaxeParser.CmdChamadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void exitCmdChamada(t5SintaxeParser.CmdChamadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void enterCmdRetorne(t5SintaxeParser.CmdRetorneContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void exitCmdRetorne(t5SintaxeParser.CmdRetorneContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#selecao}.
	 * @param ctx the parse tree
	 */
	void enterSelecao(t5SintaxeParser.SelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#selecao}.
	 * @param ctx the parse tree
	 */
	void exitSelecao(t5SintaxeParser.SelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void enterItem_selecao(t5SintaxeParser.Item_selecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void exitItem_selecao(t5SintaxeParser.Item_selecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#constantes}.
	 * @param ctx the parse tree
	 */
	void enterConstantes(t5SintaxeParser.ConstantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#constantes}.
	 * @param ctx the parse tree
	 */
	void exitConstantes(t5SintaxeParser.ConstantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void enterNumero_intervalo(t5SintaxeParser.Numero_intervaloContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void exitNumero_intervalo(t5SintaxeParser.Numero_intervaloContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void enterOp_unario(t5SintaxeParser.Op_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void exitOp_unario(t5SintaxeParser.Op_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExp_aritmetica(t5SintaxeParser.Exp_aritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExp_aritmetica(t5SintaxeParser.Exp_aritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(t5SintaxeParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(t5SintaxeParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(t5SintaxeParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(t5SintaxeParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#op1}.
	 * @param ctx the parse tree
	 */
	void enterOp1(t5SintaxeParser.Op1Context ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#op1}.
	 * @param ctx the parse tree
	 */
	void exitOp1(t5SintaxeParser.Op1Context ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#op2}.
	 * @param ctx the parse tree
	 */
	void enterOp2(t5SintaxeParser.Op2Context ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#op2}.
	 * @param ctx the parse tree
	 */
	void exitOp2(t5SintaxeParser.Op2Context ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#op3}.
	 * @param ctx the parse tree
	 */
	void enterOp3(t5SintaxeParser.Op3Context ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#op3}.
	 * @param ctx the parse tree
	 */
	void exitOp3(t5SintaxeParser.Op3Context ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#parcela}.
	 * @param ctx the parse tree
	 */
	void enterParcela(t5SintaxeParser.ParcelaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#parcela}.
	 * @param ctx the parse tree
	 */
	void exitParcela(t5SintaxeParser.ParcelaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_unario(t5SintaxeParser.Parcela_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_unario(t5SintaxeParser.Parcela_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_nao_unario(t5SintaxeParser.Parcela_nao_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_nao_unario(t5SintaxeParser.Parcela_nao_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void enterExp_relacional(t5SintaxeParser.Exp_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void exitExp_relacional(t5SintaxeParser.Exp_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void enterOp_relacional(t5SintaxeParser.Op_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void exitOp_relacional(t5SintaxeParser.Op_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(t5SintaxeParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(t5SintaxeParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void enterTermo_logico(t5SintaxeParser.Termo_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void exitTermo_logico(t5SintaxeParser.Termo_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void enterFator_logico(t5SintaxeParser.Fator_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void exitFator_logico(t5SintaxeParser.Fator_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void enterParcela_logica(t5SintaxeParser.Parcela_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void exitParcela_logica(t5SintaxeParser.Parcela_logicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_1(t5SintaxeParser.Op_logico_1Context ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_1(t5SintaxeParser.Op_logico_1Context ctx);
	/**
	 * Enter a parse tree produced by {@link t5SintaxeParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_2(t5SintaxeParser.Op_logico_2Context ctx);
	/**
	 * Exit a parse tree produced by {@link t5SintaxeParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_2(t5SintaxeParser.Op_logico_2Context ctx);
}