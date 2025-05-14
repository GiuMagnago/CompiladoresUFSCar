// Generated from br\u005Cufscar\dc\compiladores\t3\t3Sintaxe.g4 by ANTLR 4.10.1
package br.ufscar.dc.compiladores.t3;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link t3SintaxeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface t3SintaxeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(t3SintaxeParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#declaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes(t3SintaxeParser.DeclaracoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#decl_local_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_local_global(t3SintaxeParser.Decl_local_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#declaracao_local}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_local(t3SintaxeParser.Declaracao_localContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#variavel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(t3SintaxeParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#identificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(t3SintaxeParser.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#dimensao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimensao(t3SintaxeParser.DimensaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(t3SintaxeParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#tipo_basico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico(t3SintaxeParser.Tipo_basicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico_ident(t3SintaxeParser.Tipo_basico_identContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#tipo_estendido}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_estendido(t3SintaxeParser.Tipo_estendidoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#valor_constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor_constante(t3SintaxeParser.Valor_constanteContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#registro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegistro(t3SintaxeParser.RegistroContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#declaracao_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_global(t3SintaxeParser.Declaracao_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(t3SintaxeParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(t3SintaxeParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#corpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpo(t3SintaxeParser.CorpoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(t3SintaxeParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#cmdLeia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdLeia(t3SintaxeParser.CmdLeiaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#cmdEscreva}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEscreva(t3SintaxeParser.CmdEscrevaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#cmdSe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdSe(t3SintaxeParser.CmdSeContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#cmdCaso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdCaso(t3SintaxeParser.CmdCasoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#cmdPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdPara(t3SintaxeParser.CmdParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEnquanto(t3SintaxeParser.CmdEnquantoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#cmdFaca}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdFaca(t3SintaxeParser.CmdFacaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdAtribuicao(t3SintaxeParser.CmdAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#cmdChamada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdChamada(t3SintaxeParser.CmdChamadaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#cmdRetorne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdRetorne(t3SintaxeParser.CmdRetorneContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelecao(t3SintaxeParser.SelecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#item_selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_selecao(t3SintaxeParser.Item_selecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#constantes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantes(t3SintaxeParser.ConstantesContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#numero_intervalo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero_intervalo(t3SintaxeParser.Numero_intervaloContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#op_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_unario(t3SintaxeParser.Op_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_aritmetica(t3SintaxeParser.Exp_aritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(t3SintaxeParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(t3SintaxeParser.FatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#op1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp1(t3SintaxeParser.Op1Context ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp2(t3SintaxeParser.Op2Context ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#op3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp3(t3SintaxeParser.Op3Context ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#parcela}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela(t3SintaxeParser.ParcelaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#parcela_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_unario(t3SintaxeParser.Parcela_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_nao_unario(t3SintaxeParser.Parcela_nao_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#exp_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_relacional(t3SintaxeParser.Exp_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#op_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_relacional(t3SintaxeParser.Op_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao(t3SintaxeParser.ExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#termo_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo_logico(t3SintaxeParser.Termo_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#fator_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator_logico(t3SintaxeParser.Fator_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#parcela_logica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_logica(t3SintaxeParser.Parcela_logicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#op_logico_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico_1(t3SintaxeParser.Op_logico_1Context ctx);
	/**
	 * Visit a parse tree produced by {@link t3SintaxeParser#op_logico_2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico_2(t3SintaxeParser.Op_logico_2Context ctx);
}