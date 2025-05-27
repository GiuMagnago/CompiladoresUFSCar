// Generated from br\u005Cufscar\dc\compiladores\t4\t4Sintaxe.g4 by ANTLR 4.10.1
package br.ufscar.dc.compiladores.t4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link t4SintaxeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface t4SintaxeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(t4SintaxeParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#declaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes(t4SintaxeParser.DeclaracoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#decl_local_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_local_global(t4SintaxeParser.Decl_local_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#declaracao_local}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_local(t4SintaxeParser.Declaracao_localContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#variavel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(t4SintaxeParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#identificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(t4SintaxeParser.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#dimensao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimensao(t4SintaxeParser.DimensaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(t4SintaxeParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#tipo_basico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico(t4SintaxeParser.Tipo_basicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico_ident(t4SintaxeParser.Tipo_basico_identContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#tipo_estendido}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_estendido(t4SintaxeParser.Tipo_estendidoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#valor_constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor_constante(t4SintaxeParser.Valor_constanteContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#registro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegistro(t4SintaxeParser.RegistroContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#declaracao_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_global(t4SintaxeParser.Declaracao_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(t4SintaxeParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(t4SintaxeParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#corpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpo(t4SintaxeParser.CorpoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(t4SintaxeParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#cmdLeia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdLeia(t4SintaxeParser.CmdLeiaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#cmdEscreva}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEscreva(t4SintaxeParser.CmdEscrevaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#cmdSe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdSe(t4SintaxeParser.CmdSeContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#cmdCaso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdCaso(t4SintaxeParser.CmdCasoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#cmdPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdPara(t4SintaxeParser.CmdParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEnquanto(t4SintaxeParser.CmdEnquantoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#cmdFaca}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdFaca(t4SintaxeParser.CmdFacaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdAtribuicao(t4SintaxeParser.CmdAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#cmdChamada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdChamada(t4SintaxeParser.CmdChamadaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#cmdRetorne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdRetorne(t4SintaxeParser.CmdRetorneContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelecao(t4SintaxeParser.SelecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#item_selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_selecao(t4SintaxeParser.Item_selecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#constantes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantes(t4SintaxeParser.ConstantesContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#numero_intervalo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero_intervalo(t4SintaxeParser.Numero_intervaloContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#op_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_unario(t4SintaxeParser.Op_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_aritmetica(t4SintaxeParser.Exp_aritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(t4SintaxeParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(t4SintaxeParser.FatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#op1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp1(t4SintaxeParser.Op1Context ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp2(t4SintaxeParser.Op2Context ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#op3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp3(t4SintaxeParser.Op3Context ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#parcela}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela(t4SintaxeParser.ParcelaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#parcela_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_unario(t4SintaxeParser.Parcela_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_nao_unario(t4SintaxeParser.Parcela_nao_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#exp_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_relacional(t4SintaxeParser.Exp_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#op_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_relacional(t4SintaxeParser.Op_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao(t4SintaxeParser.ExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#termo_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo_logico(t4SintaxeParser.Termo_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#fator_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator_logico(t4SintaxeParser.Fator_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#parcela_logica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_logica(t4SintaxeParser.Parcela_logicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#op_logico_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico_1(t4SintaxeParser.Op_logico_1Context ctx);
	/**
	 * Visit a parse tree produced by {@link t4SintaxeParser#op_logico_2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico_2(t4SintaxeParser.Op_logico_2Context ctx);
}