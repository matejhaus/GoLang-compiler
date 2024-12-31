package antlr4;// Generated from GoLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GoLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GoLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GoLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GoLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#importList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportList(GoLangParser.ImportListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#importSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportSpec(GoLangParser.ImportSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(GoLangParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#ifBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfBlock(GoLangParser.IfBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#elseIfBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfBlock(GoLangParser.ElseIfBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(GoLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(GoLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(GoLangParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(GoLangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#forBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForBlock(GoLangParser.ForBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#forHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForHeader(GoLangParser.ForHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#simpleStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStmt(GoLangParser.SimpleStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#incrementDecrement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrementDecrement(GoLangParser.IncrementDecrementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#funcDeclar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDeclar(GoLangParser.FuncDeclarContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(GoLangParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(GoLangParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult(GoLangParser.ResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#typeDeclar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclar(GoLangParser.TypeDeclarContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#varDeclar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclar(GoLangParser.VarDeclarContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(GoLangParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#sliceDeclar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSliceDeclar(GoLangParser.SliceDeclarContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#sliceInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSliceInit(GoLangParser.SliceInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#matrixDeclar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixDeclar(GoLangParser.MatrixDeclarContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#arrayDimensions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDimensions(GoLangParser.ArrayDimensionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#matrixInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixInit(GoLangParser.MatrixInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#matrixRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixRow(GoLangParser.MatrixRowContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#matrixAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixAccess(GoLangParser.MatrixAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(GoLangParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(GoLangParser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(GoLangParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoLangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(GoLangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesizedExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpression(GoLangParser.ParenthesizedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constantExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(GoLangParser.ConstantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpression(GoLangParser.ArrayExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(GoLangParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(GoLangParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(GoLangParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicativeExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(GoLangParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code matrixExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixExpression(GoLangParser.MatrixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(GoLangParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCallExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallExpression(GoLangParser.FuncCallExpressionContext ctx);
}