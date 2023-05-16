import javax.swing.*;
import java.lang.Math;
//щось на кшталт Singleton
public final class ActionsExecutor {
    private static ActionsExecutor instance;

    private static final ActionFunction<Double, String> addAction = (num1, num2) ->
            round(String.valueOf(num1 + num2));
    private static final ActionFunction<Double, String> minusAction = (num1, num2) ->
            round(String.valueOf(num1 - num2));
    private static final ActionFunction<Double, String> multiplyAction = (num1, num2) ->
            round(String.valueOf(num1 * num2));
    private static final ActionFunction<Double, String> divideAction = (num1, num2) ->
            num2 == 0 ? "Error" : round(String.valueOf(num1 / num2));
    private static final ActionFunction<Double, String> powerAction = (num1, num2) ->
            round(String.valueOf(Math.pow(num1, num2)));

    public static String calculateResult(CalculatorLabel label) {
            switch (label.getActionData()) {
                case "+" -> {
                    return addAction.accept(label.getFirstNumberData(), Double.valueOf(label.getText()));
                }
                case "-" -> {
                    return minusAction.accept(label.getFirstNumberData(), Double.valueOf(label.getText()));
                }
                case "*" -> {
                    return multiplyAction.accept(label.getFirstNumberData(), Double.valueOf(label.getText()));
                }
                case "/" -> {
                    return divideAction.accept(label.getFirstNumberData(), Double.valueOf(label.getText()));
                }
                case "^" -> {
                    return powerAction.accept(label.getFirstNumberData(), Double.valueOf(label.getText()));
                }
            }
        return null;
    }
    public static void getResult(CalculatorLabel label) {
        if (label.getActionData() != null) {
            label.setText(calculateResult(label));
        }
    }

    public static void memorizeAction(CalculatorLabel label, String action) {
        label.setFirstNumberData(Double.valueOf(label.getText()));
        label.setText("0");
        label.setActionData(action);
    }

    public static void acOperation(CalculatorLabel label) {
        label.setFirstNumberData(0.0);
        label.setActionData(null);
        label.setText("0");
    }

    private static String round(String result) {
        if (result.endsWith(".0")) {
            char[] tmp_arr = result.toCharArray();
            return String.copyValueOf(tmp_arr, 0, tmp_arr.length - 2);
        } else {
            return result;
        }
    }

    private ActionsExecutor() {
    }

    public static ActionsExecutor getInstance() {
        if (instance == null) {
            instance = new ActionsExecutor();
        }
        return instance;
    }
}