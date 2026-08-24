import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/** Exercício 2: conversão de Fahrenheit para Celsius. */
public class Ex2_FahrenheitCelsius extends JFrame {
    private final JTextField fahrenheitField = new JTextField(10);
    private final JLabel resultLabel = new JLabel("Informe uma temperatura.");

    public Ex2_FahrenheitCelsius() {
        super("Conversão de temperatura");
        setLayout(new FlowLayout(FlowLayout.LEFT, 12, 18));
        JButton convertButton = new JButton("Converter");
        convertButton.addActionListener(this::convert);
        fahrenheitField.addActionListener(this::convert);
        add(new JLabel("Fahrenheit:"));
        add(fahrenheitField);
        add(convertButton);
        add(resultLabel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationByPlatform(true);
    }

    private void convert(ActionEvent event) {
        try {
            double fahrenheit = Double.parseDouble(fahrenheitField.getText().trim());
            double celsius = (5.0 / 9.0) * (fahrenheit - 32);
            resultLabel.setText(String.format("Celsius: %.2f °C", celsius));
        } catch (NumberFormatException exception) {
            resultLabel.setText("Digite um número válido.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex2_FahrenheitCelsius().setVisible(true));
    }
}
