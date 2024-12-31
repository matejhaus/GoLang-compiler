package antlr4;// Generated from GoLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GoLangParser}.
 */
public interface GoLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GoLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GoLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GoLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#importList}.
	 * @param ctx the parse tree
	 */
	void enterImportList(GoLangParser.ImportListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#importList}.
	 * @param ctx the parse tree
	 */
	void exitImportList(GoLangParser.ImportListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#importSpec}.
	 * @param ctx the parse tree
	 */
	void enterImportSpec(GoLangParser.ImportSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#importSpec}.
	 * @param ctx the parse tree
	 */
	void exitImportSpec(GoLangParser.ImportSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(GoLangParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(GoLangParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfBlock(GoLangParser.IfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfBlock(GoLangParser.IfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#elseIfBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseIfBlock(GoLangParser.ElseIfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#elseIfBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseIfBlock(GoLangParser.ElseIfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(GoLangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(GoLangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GoLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GoLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(GoLangParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(GoLangParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(GoLangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(GoLangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#forBlock}.
	 * @param ctx the parse tree
	 */
	void enterForBlock(GoLangParser.ForBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#forBlock}.
	 * @param ctx the parse tree
	 */
	void exitForBlock(GoLangParser.ForBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#forHeader}.
	 * @param ctx the parse tree
	 */
	void enterForHeader(GoLangParser.ForHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#forHeader}.
	 * @param ctx the parse tree
	 */
	void exitForHeader(GoLangParser.ForHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#simpleStmt}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStmt(GoLangParser.SimpleStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#simpleStmt}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStmt(GoLangParser.SimpleStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#incrementDecrement}.
	 * @param ctx the parse tree
	 */
	void enterIncrementDecrement(GoLangParser.IncrementDecrementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#incrementDecrement}.
	 * @param ctx the parse tree
	 */
	void exitIncrementDecrement(GoLangParser.IncrementDecrementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#funcDeclar}.
	 * @param ctx the parse tree
	 */
	void enterFuncDeclar(GoLangParser.FuncDeclarContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#funcDeclar}.
	 * @param ctx the parse tree
	 */
	void exitFuncDeclar(GoLangParser.FuncDeclarContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(GoLangParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(GoLangParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(GoLangParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(GoLangParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult(GoLangParser.ResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult(GoLangParser.ResultContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#typeDeclar}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclar(GoLangParser.TypeDeclarContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#typeDeclar}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclar(GoLangParser.TypeDeclarContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#varDeclar}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclar(GoLangParser.VarDeclarContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#varDeclar}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclar(GoLangParser.VarDeclarContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(GoLangParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(GoLangParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#sliceDeclar}.
	 * @param ctx the parse tree
	 */
	void enterSliceDeclar(GoLangParser.SliceDeclarContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#sliceDeclar}.
	 * @param ctx the parse tree
	 */
	void exitSliceDeclar(GoLangParser.SliceDeclarContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#sliceInit}.
	 * @param ctx the parse tree
	 */
	void enterSliceInit(GoLangParser.SliceInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#sliceInit}.
	 * @param ctx the parse tree
	 */
	void exitSliceInit(GoLangParser.SliceInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#matrixDeclar}.
	 * @param ctx the parse tree
	 */
	void enterMatrixDeclar(GoLangParser.MatrixDeclarContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#matrixDeclar}.
	 * @param ctx the parse tree
	 */
	void exitMatrixDeclar(GoLangParser.MatrixDeclarContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#arrayDimensions}.
	 * @param ctx the parse tree
	 */
	void enterArrayDimensions(GoLangParser.ArrayDimensionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#arrayDimensions}.
	 * @param ctx the parse tree
	 */
	void exitArrayDimensions(GoLangParser.ArrayDimensionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#matrixInit}.
	 * @param ctx the parse tree
	 */
	void enterMatrixInit(GoLangParser.MatrixInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#matrixInit}.
	 * @param ctx the parse tree
	 */
	void exitMatrixInit(GoLangParser.MatrixInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#matrixRow}.
	 * @param ctx the parse tree
	 */
	void enterMatrixRow(GoLangParser.MatrixRowContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#matrixRow}.
	 * @param ctx the parse tree
	 */
	void exitMatrixRow(GoLangParser.MatrixRowContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#matrixAccess}.
	 * @param ctx the parse tree
	 */
	void enterMatrixAccess(GoLangParser.MatrixAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#matrixAccess}.
	 * @param ctx the parse tree
	 */
	void exitMatrixAccess(GoLangParser.MatrixAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(GoLangParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(GoLangParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(GoLangParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(GoLangParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(GoLangParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(GoLangParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GoLangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GoLangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesizedExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpression(GoLangParser.ParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesizedExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpression(GoLangParser.ParenthesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(GoLangParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(GoLangParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpression(GoLangParser.ArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpression(GoLangParser.ArrayExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(GoLangParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(GoLangParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(GoLangParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(GoLangParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(GoLangParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(GoLangParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicativeExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(GoLangParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicativeExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(GoLangParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code matrixExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixExpression(GoLangParser.MatrixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code matrixExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixExpression(GoLangParser.MatrixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(GoLangParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(GoLangParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpression(GoLangParser.FuncCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallExpression}
	 * labeled alternative in {@link GoLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpression(GoLangParser.FuncCallExpressionContext ctx);
}