import javax.swing.*;

public class CalculatorLabel extends JLabel {
    private Double firstNumberData;
    private String actionData;

    public CalculatorLabel() {
        setText("0");
        setFont(new java.awt.Font("Arial", 34, 24));
    }

    public Double getFirstNumberData() {
        return firstNumberData;
    }

    public void setFirstNumberData(Double firstNumberData) {
        this.firstNumberData = firstNumberData;
    }

    public String getActionData() {
        return actionData;
    }

    public void setActionData(String actionData) {
        this.actionData = actionData;
    }
}
