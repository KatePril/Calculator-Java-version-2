import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {
    private ButtonField buttonField = new ButtonField();
    private CalculatorLabel label = new CalculatorLabel();

    private  final int WIDTH = 400;
    private  final int HEIGHT = 500;
    private  final int MIN_WIDTH = 340;
    private  final int MIN_HEIGHT = 298;

    public CalculatorFrame() {
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFrameSize();

        addLabel();

        add(buttonField, BorderLayout.CENTER);
        setButtonsAction(buttonField.getCalculatorButtons());
    }

    private void setFrameSize() {
        setSize(WIDTH, HEIGHT);
        setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
    }

    private void addLabel() {
        JPanel panelForLabel = new JPanel();
        panelForLabel.add(label);
        add(panelForLabel, BorderLayout.NORTH);
        label.setMinimumSize(new Dimension(340, label.getHeight()));

    }

    // навмисно зробила buttons параметром, аби кожного разу не повторювати buttonField.getCalculatorButtons()
    private void setButtonsAction(CalculatorButton[] buttons) {
        buttons[0].addActionListener(e -> ActionsExecutor.acOperation(label));
        buttons[1].addActionListener(e -> label.setText("0"));
        buttons[2].addActionListener(e -> PrintingExecutor.printMinus(label));
        buttons[3].addActionListener(e -> ActionsExecutor.memorizeAction(label, buttons[3].getText()));

        buttons[4].addActionListener(e -> PrintingExecutor.printNumber(label, buttons[4].getText()));
        buttons[5].addActionListener(e -> PrintingExecutor.printNumber(label, buttons[5].getText()));
        buttons[6].addActionListener(e -> PrintingExecutor.printNumber(label, buttons[6].getText()));
        buttons[7].addActionListener(e -> ActionsExecutor.memorizeAction(label, buttons[7].getText()));

        buttons[8].addActionListener(e -> PrintingExecutor.printNumber(label, buttons[8].getText()));
        buttons[9].addActionListener(e -> PrintingExecutor.printNumber(label, buttons[9].getText()));
        buttons[10].addActionListener(e -> PrintingExecutor.printNumber(label, buttons[10].getText()));
        buttons[11].addActionListener(e -> ActionsExecutor.memorizeAction(label, buttons[11].getText()));

        buttons[12].addActionListener(e -> PrintingExecutor.printNumber(label, buttons[12].getText()));
        buttons[13].addActionListener(e -> PrintingExecutor.printNumber(label, buttons[13].getText()));
        buttons[14].addActionListener(e -> PrintingExecutor.printNumber(label, buttons[14].getText()));
        buttons[15].addActionListener(e -> ActionsExecutor.memorizeAction(label, buttons[15].getText()));

        buttons[16].addActionListener(e -> PrintingExecutor.printPoint(label));
        buttons[17].addActionListener(e -> PrintingExecutor.printNumber(label, buttons[17].getText()));
        buttons[18].addActionListener(e -> ActionsExecutor.getResult(label));
        buttons[19].addActionListener(e -> ActionsExecutor.memorizeAction(label, buttons[19].getText()));
    }
}
