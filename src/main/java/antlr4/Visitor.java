package antlr4;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Visitor extends GoLangBaseVisitor<Object> {
    private Hashtable<String, Object> variables = new Hashtable<>();

    public Visitor() {
        variables.put("Print", new Function<Object[], Object>() {
            @Override
            public Object apply(Object[] objects) {
                print(objects);
                return null;
            }
        });

        variables.put("Println", new Function<Object[], Object>() {
            @Override
            public Object apply(Object[] objects) {
                printLine(objects);
                return null;
            }
        });
    }

    // Metoda pro vypsání objektů bez nového řádku
    private void print(Object[] objects) {
        for (Object obj : objects) {
            System.out.print(obj + " ");
        }
    }

    // Metoda pro vypsání objektů s novým řádkem
    private void printLine(Object[] objects) {
        for (Object obj : objects) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    @Override
    public Object visitVarDeclar(GoLangParser.VarDeclarContext ctx) {
        var varName = ctx.IDENTIFIER().getText();

        // Určení typu proměnné
        var declaredType = ctx.varType() != null ?ctx.varType().getText() : "unknown";

        Object value = null;

        if (ctx.expression() != null) {
            value = visit(ctx.expression());

            // Kontrola kompatibility typu
            if (!isCorrectType(declaredType, value)) {
                System.out.println(String.format("Nelze přiřadit %s s hodnotou %s do %s", varName, value, declaredType));
            }
        }
        variables.put(varName,value);

        return variables.get(varName);
    }

    // Pomocná metoda pro kontrolu typu
    private boolean isCorrectType(String declaredType, Object value) {
        if (declaredType.equals("int") && value instanceof Integer) {
            return true;
        } else if (declaredType.equals("float64") && value instanceof Float) {
            return true;
        } else if (declaredType.equals("string") && value instanceof String) {
            return true;
        } else if (declaredType.equals("bool") && value instanceof Boolean) {
            return true;
        }
        return false;
    }

    @Override
    public Object visitAssignment(GoLangParser.AssignmentContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        Object value = visit(ctx.expression());

        variables.put(varName, value);

        return null;
    }

    @Override
    public Object visitIdentifierExpression(GoLangParser.IdentifierExpressionContext ctx) {
        String varName = ctx.IDENTIFIER().getText();

        Object value = variables.get(varName);

        if (value == null) {
            throw new RuntimeException("Proměnná s názvem " + varName + " není definována");
        }

        return variables.get(varName);
    }

    @Override
    public Object visitType(GoLangParser.TypeContext ctx) {
        if (ctx.INTEGER() != null) {
            return Integer.parseInt(ctx.INTEGER().getText());
        }

        if (ctx.FLOAT() != null) {
            return Float.parseFloat(ctx.FLOAT().getText());
        }

        if (ctx.STRING() != null) {
            String s = ctx.STRING().getText();
            return s.substring(1, s.length() - 1);
        }

        if (ctx.BOOL() != null) {
            return ctx.BOOL().getText().equals("TRUE");
        }

        throw new RuntimeException("Unknown type");
    }

    @Override
    public Object visitAdditiveExpression(GoLangParser.AdditiveExpressionContext ctx) {
        Object left = visit(ctx.expression(0));
        Object right = visit(ctx.expression(1));

        String op = ctx.ADDING_OPERATOR().getText();

        switch (op) {
            case "+":
                return add(left, right);
            case "-":
                return subtract(left, right);
            default:
                throw new RuntimeException("Nepodporovaný operátor: " + op);
        }
    }

    @Override
    public Object visitMultiplicativeExpression(GoLangParser.MultiplicativeExpressionContext ctx) {
        Object left = visit(ctx.expression(0));
        Object right = visit(ctx.expression(1));

        String op = ctx.MULTIPLYING_OPERATOR().getText();

        switch (op) {
            case "*":
                return multiply(left, right);
            case "/":
                return divide(left, right);
            case "%":
                return mod(left, right);
            default:
                throw new RuntimeException("Nepodporovaný operátor: " + op);
        }
    }

    @Override
    public Object visitComparisonExpression(GoLangParser.ComparisonExpressionContext ctx) {
        Object left = visit(ctx.expression(0));
        Object right = visit(ctx.expression(1));

        String op = ctx.COMPARE_OPERATOR().getText();

        switch (op) {
            case "<":
                return lessThan(left, right);
            case "<=":
                return lessThanEquals(left, right);
            case ">":
                return greaterThan(left, right);
            case ">=":
                return greaterThanEquals(left, right);
            case "==":
                return equalsEquals(left, right);
            case "!=":
                return notEquals(left, right);
            default:
                throw new RuntimeException("Nepodporované porovnání: " + op);
        }
    }

    @Override
    public Object visitIfBlock(GoLangParser.IfBlockContext ctx) {
        Object conditionResult = visit(ctx.expression());

        if (checkBoolean(conditionResult)) {
            visit(ctx.block());
        } else if (ctx.elseIfBlock() != null) {
            visit(ctx.elseIfBlock());
        }

        return null;
    }

    @Override
    public Object visitFuncDeclar(GoLangParser.FuncDeclarContext ctx) {
        String procName = ctx.IDENTIFIER().getText();
        List<String> parameters = ctx.paramList() != null
                ? ctx.paramList().param().stream()
                .map(param -> param.IDENTIFIER().getText())
                .collect(Collectors.toList())
                : new ArrayList<>();

        variables.put(procName, ctx);

        if ("main".equals(procName)) {
            visit(ctx.block());
        }

        return null;
    }

    public Object visitFuncCall(GoLangParser.FuncCallContext context) {
        String procName = context.IDENTIFIER().getText();
        Object[] args = context.expression().stream().map(this::visit).toArray();

        Object value = variables.get(procName);

        if (value != null && variables.get(procName) instanceof Function) {
            Function<Object[], Object> func = (Function<Object[], Object>) variables.get(procName);
            return func.apply(args);
        } else if (value != null && variables.get(procName) instanceof GoLangParser.FuncDeclarContext) {
            GoLangParser.FuncDeclarContext procContext = (GoLangParser.FuncDeclarContext) variables.get(procName);
            List<String> parameters = procContext.paramList() != null ?
                    procContext.paramList().param().stream().map(p -> p.IDENTIFIER().getText()).collect(Collectors.toList()) :
                    new ArrayList<>();
            if (parameters.size() != args.length) {
                System.out.println("Incorrect number of arguments for procedure: " + procName);
            }
            Hashtable<String, Object> localVariables = new Hashtable<>();
            for (int i = 0; i < parameters.size(); i++) {
                localVariables.put(parameters.get(i), args[i]);
            }
            Hashtable<String, Object> previousVariables = new Hashtable<>(variables);
            variables = localVariables;
            visit(procContext.block());
            Object returnValue = variables.get("_returnValue");
            variables = previousVariables;
            return returnValue;
        } else {
            System.out.println("Procedure named " + procName + " is not declared");
        }
        return null;

    }

    @Override
    public Object visitForBlock(GoLangParser.ForBlockContext ctx) {
        if (ctx.forHeader() != null) {
            GoLangParser.ForHeaderContext header = ctx.forHeader();

            if (header.varDeclar() != null || header.simpleStmt(0) != null) {
                visit(header.varDeclar() != null ? header.varDeclar() : header.simpleStmt(0));
            }

            while (header.expression() == null || (Boolean) visit(header.expression())) {
                visit(ctx.block());

                if (header.simpleStmt(1) != null) {
                    visit(header.simpleStmt(1));
                }
            }
        } else if (ctx.expression() != null) {
            while ((Boolean) visit(ctx.expression())) {
                visit(ctx.block());
            }
        }

        return null;
    }

    @Override
    public Object visitSliceDeclar(GoLangParser.SliceDeclarContext ctx) {
        String arrayName = ctx.IDENTIFIER().getText();
        int size = Integer.parseInt(ctx.INTEGER().getText());
        String arrayType = ctx.varType().getText();

        Object[] array = new Object[size];
        variables.put(arrayName, array);

        if (ctx.sliceInit() != null) {
            List<GoLangParser.ExpressionContext> initializationValues = ctx.sliceInit().expression();
            for (int i = 0; i < initializationValues.size(); i++) {
                Object value = visit(initializationValues.get(i));
                if (!isCorrectType(arrayType, value)) {
                    System.out.println("Špatný datový typ");
                }

                if (i < size) {
                    array[i] = value;
                } else {
                    System.out.println("Překročena velikost pole");
                }
            }
        }
        return null;
    }

    @Override
    public Object visitArrayAccess(GoLangParser.ArrayAccessContext ctx) {
        String arrayName = ctx.IDENTIFIER().getText();
        int index = (int) (visit(ctx.expression()) != null ? visit(ctx.expression()) : null);

        if (!variables.containsKey(arrayName)) {
            System.out.println("Pole s názvem " + arrayName + " neexistuje");
        }

        Object[] array = (Object[]) variables.get(arrayName);

        return array[index];
    }

    @Override
    public Object visitReturnStatement(GoLangParser.ReturnStatementContext ctx) {
        variables.put("_returnValue", visit(ctx.expression()));
        return variables.get("_returnValue");
    }

    @Override
    public Object visitMatrixDeclar(GoLangParser.MatrixDeclarContext ctx) {
        String matrixName = ctx.IDENTIFIER().getText();
        int rows = Integer.parseInt(ctx.arrayDimensions().INTEGER(0).getText());
        int cols = Integer.parseInt(ctx.arrayDimensions().INTEGER(1).getText());
        String matrixType = ctx.varType().getText();

        Object[][] matrix = new Object[rows][cols];
        variables.put(matrixName, matrix);

        if (ctx.matrixInit() != null) {
            int count = 0;
            for (int i = 0; i < rows; i++) {
                List<GoLangParser.ExpressionContext> initializationValues = ctx.matrixInit().matrixRow(i).expression();
                count=0;
                for (int j = 0; j < cols; j++) {
                    if (count < initializationValues.size()) {
                        Object value = visit(initializationValues.get(count));
                        if (!isCorrectType(matrixType, value)) {
                            System.out.println("Špatný datový typ");
                        }
                        matrix[i][j] = value;
                        count++;
                    } else {
                        System.out.println("Nedostatek inicializačních hodnot pro matici");
                        return null;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Object visitMatrixAccess(GoLangParser.MatrixAccessContext ctx) {
        String matrixName = ctx.IDENTIFIER().getText();
        int rowIndex = (int) (visit(ctx.expression(0)) != null ? visit(ctx.expression(0)) : null);
        int colIndex = (int) (visit(ctx.expression(1)) != null ? visit(ctx.expression(1)) : null);

        if (!variables.containsKey(matrixName)) {
            System.out.println("Matice s názvem " + matrixName + " neexistuje");
            return null;
        }

        Object[][] matrix = (Object[][]) variables.get(matrixName);

        if (rowIndex < 0 || rowIndex >= matrix.length || colIndex < 0 || colIndex >= matrix[0].length) {
            System.out.println("Neplatný index pro přístup k matici");
            return null;
        }

        return matrix[rowIndex][colIndex];
    }

    private Object add(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (Integer) left + (Integer) right;
        }
        if (left instanceof Float && right instanceof Float) {
            return (Float) left + (Float) right;
        }
        if (left instanceof Integer && right instanceof Float) {
            return (Integer) left + (Float) right;
        }
        if (left instanceof Float && right instanceof Integer) {
            return (Float) left + (Integer) right;
        }
        if (left instanceof String || right instanceof String) {
            return left.toString() + right.toString();
        }
        throw new RuntimeException();
    }

    private Object subtract(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (Integer) left - (Integer) right;
        }

        if (left instanceof Float && right instanceof Float) {
            return (Float) left - (Float) right;
        }

        if (left instanceof Integer && right instanceof Float) {
            return (Integer) left - (Float) right;
        }

        if (left instanceof Float && right instanceof Integer) {
            return (Float) left - (Integer) right;
        }

        throw new RuntimeException();
    }

    private Object multiply(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (Integer) left * (Integer) right;
        }

        if (left instanceof Float && right instanceof Float) {
            return (Float) left * (Float) right;
        }

        if (left instanceof Integer && right instanceof Float) {
            return (Integer) left * (Float) right;
        }

        if (left instanceof Float && right instanceof Integer) {
            return (Float) left * (Integer) right;
        }

        throw new RuntimeException();
    }

    private Object divide(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (Integer) left / (Integer) right;
        }

        if (left instanceof Float && right instanceof Float) {
            return (Float) left / (Float) right;
        }

        if (left instanceof Integer && right instanceof Float) {
            return (Integer) left / (Float) right;
        }

        if (left instanceof Float && right instanceof Integer) {
            return (Float) left / (Integer) right;
        }

        throw new RuntimeException();
    }

    private Object mod(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (Integer) left % (Integer) right;
        }

        if (left instanceof Float && right instanceof Float) {
            return (Float) left % (Float) right;
        }

        if (left instanceof Integer && right instanceof Float) {
            return (Integer) left % (Float) right;
        }

        if (left instanceof Float && right instanceof Integer) {
            return (Float) left % (Integer) right;
        }

        throw new RuntimeException();
    }

    private boolean lessThan(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (Integer) left < (Integer) right;
        }

        if (left instanceof Float && right instanceof Float) {
            return (Float) left < (Float) right;
        }

        if (left instanceof Integer && right instanceof Float) {
            return (Integer) left < (Float) right;
        }

        if (left instanceof Float && right instanceof Integer) {
            return (Float) left < (Integer) right;
        }

        throw new RuntimeException();
    }

    private boolean lessThanEquals(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (Integer) left <= (Integer) right;
        }

        if (left instanceof Float && right instanceof Float) {
            return (Float) left <= (Float) right;
        }

        if (left instanceof Integer && right instanceof Float) {
            return (Integer) left <= (Float) right;
        }

        if (left instanceof Float && right instanceof Integer) {
            return (Float) left <= (Integer) right;
        }

        throw new RuntimeException();
    }

    private boolean greaterThan(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (Integer) left > (Integer) right;
        }

        if (left instanceof Float && right instanceof Float) {
            return (Float) left > (Float) right;
        }

        if (left instanceof Integer && right instanceof Float) {
            return (Integer) left > (Float) right;
        }

        if (left instanceof Float && right instanceof Integer) {
            return (Float) left > (Integer) right;
        }

        throw new RuntimeException();
    }

    private boolean greaterThanEquals(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (Integer) left >= (Integer) right;
        }

        if (left instanceof Float && right instanceof Float) {
            return (Float) left >= (Float) right;
        }

        if (left instanceof Integer && right instanceof Float) {
            return (Integer) left >= (Float) right;
        }

        if (left instanceof Float && right instanceof Integer) {
            return (Float) left >= (Integer) right;
        }

        throw new RuntimeException();
    }

    private boolean equalsEquals(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (Integer) left == (Integer) right;
        }

        if (left instanceof Float && right instanceof Float) {
            return (Float) left == (Float) right;
        }

        throw new RuntimeException("Nelze porovnat");
    }

    private boolean notEquals(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return !((Integer) left).equals((Integer) right);
        }

        if (left instanceof Float && right instanceof Float) {
            return !((Float) left).equals((Float) right);
        }

        if (left instanceof Integer && right instanceof Float) {
            return !((Integer) left).equals((Float) right);
        }

        if (left instanceof Float && right instanceof Integer) {
            return !((Float) left).equals((Integer) right);
        }

        throw new RuntimeException();
    }

    private Boolean checkBoolean(Object o) {
        if (o instanceof Boolean) {
            return (Boolean) o;
        }
        return null;
    }
}
