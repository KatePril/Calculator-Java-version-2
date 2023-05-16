import javax.swing.*;
import java.awt.*;

public class ButtonField extends JPanel {
    private CalculatorButton[] calculatorButtons = {new CalculatorButton("AC", 100, 100, 0),
            new CalculatorButton("C", 100, 100, 0),
            new CalculatorButton("-/+", 100, 100, 2),
            new CalculatorButton("/", 100, 100, 2),
            new CalculatorButton("7", 100, 100, 1),
            new CalculatorButton("8", 100, 100, 1),
            new CalculatorButton("9", 100, 100, 1),
            new CalculatorButton("*", 100, 100, 2),
            new CalculatorButton("4", 100, 100, 1),
            new CalculatorButton("5", 100, 100, 1),
            new CalculatorButton("6", 100, 100, 1),
            new CalculatorButton("-", 100, 100, 2),
            new CalculatorButton("1", 100, 100, 1),
            new CalculatorButton("2", 100, 100, 1),
            new CalculatorButton("3", 100, 100, 1),
            new CalculatorButton("+", 100, 100, 2),
            new CalculatorButton(".", 100, 100, 2),
            new CalculatorButton("0", 100, 100, 1),
            new CalculatorButton("=", 100, 100, 3),
            new CalculatorButton("^", 100, 100, 2)};
    public ButtonField() {
        setSize(400, 500);
        setLayout(new GridLayout(5, 5, 10, 10));
        for (CalculatorButton button : calculatorButtons) {
            add(button);
        }
    }

    public CalculatorButton[] getCalculatorButtons() {
        return calculatorButtons;
    }
}
