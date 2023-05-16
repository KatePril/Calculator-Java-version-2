import javax.swing.*;
import java.awt.*;

public class CalculatorButton extends JButton {
    private Color[] availableColors = {new Color(255, 108, 108),
            new Color(78, 255, 121),
            new Color(39, 164, 68),
            new Color(0, 105, 27),};

    public CalculatorButton(String text, int width, int height, int color) {
        setText(text);
        setFont(new java.awt.Font("Arial", 34, 15));
        setSize(width, height);
        setBackground(availableColors[color]);
    }
}
