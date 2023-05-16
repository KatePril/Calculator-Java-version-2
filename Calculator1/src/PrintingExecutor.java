import javax.swing.*;
import java.util.Objects;

//також версія Singleton
public final class PrintingExecutor {
    private static PrintingExecutor instance;

    //Можна вважати проявом принципу Барбари Лісков, адже JLabel це батьківський клас, а CalculatorLabel дочірній
    private static ActionPredicate<String> checkBeginning = (labelText, expression) -> Objects.equals(labelText, expression);
    private static ActionPredicate<String> checkContainment = (labelText, expression) -> labelText.contains(expression);
    private static ActionPredicate<String> checkMinus = (labelText, expression) -> labelText.startsWith(expression);

    public static void printNumber(JLabel label, String number) {
        if (checkBeginning.test(label.getText(), "Error") || checkBeginning.test(label.getText(), "0")) {
            label.setText(number);
        } else if (checkBeginning.test(label.getText(), "-0")) {
            label.setText("-" + number);
        }else {
            label.setText(label.getText() + number);
        }
    }

    public static void printPoint(JLabel label) {
        if (!checkContainment.test(label.getText(), ".")) {
            label.setText(label.getText() + ".");
        }
    }

    public static void printMinus(JLabel label) {
        if (checkMinus.test(label.getText(), "-")) {
            char[] tmp_arr = label.getText().toCharArray();
            label.setText(String.copyValueOf(tmp_arr, 1, tmp_arr.length - 1));
        } else {
            label.setText("-" + label.getText());
        }
    }

    private PrintingExecutor() {
    }

    public static PrintingExecutor getInstance() {
        if (instance == null) {
            instance = new PrintingExecutor();
        }
        return instance;
    }
}
