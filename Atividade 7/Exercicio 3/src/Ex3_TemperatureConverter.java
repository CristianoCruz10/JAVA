import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/** Exercício 3: conversão entre Fahrenheit, Celsius e Kelvin. */
public class Ex3_TemperatureConverter extends JFrame {
    private final JTextField inputField = new JTextField(8);
    private final JComboBox<String> from = new JComboBox<>(new String[] {"Fahrenheit", "Celsius", "Kelvin"});
    private final JComboBox<String> to = new JComboBox<>(new String[] {"Celsius", "Fahrenheit", "Kelvin"});
    private final JLabel result = new JLabel("Informe um valor e escolha as escalas.");

    public Ex3_TemperatureConverter() {
        super("Conversor de temperatura");
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 18));
        JButton convert = new JButton("Converter");
        convert.addActionListener(this::convert);
        inputField.addActionListener(this::convert);
        add(inputField); add(from); add(new JLabel("para")); add(to); add(convert); add(result);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationByPlatform(true);
    }

    private void convert(ActionEvent event) {
        try {
            double value = Double.parseDouble(inputField.getText().trim());
            double celsius = toCelsius(value, (String) from.getSelectedItem());
            double converted = fromCelsius(celsius, (String) to.getSelectedItem());
            result.setText(String.format("Resultado: %.2f %s", converted, symbol((String) to.getSelectedItem())));
        } catch (NumberFormatException exception) {
            result.setText("Digite um número válido.");
        }
    }

    private double toCelsius(double value, String scale) {
        if ("Fahrenheit".equals(scale)) return (value - 32) * 5.0 / 9.0;
        if ("Kelvin".equals(scale)) return value - 273.15;
        return value;
    }

    private double fromCelsius(double celsius, String scale) {
        if ("Fahrenheit".equals(scale)) return celsius * 9.0 / 5.0 + 32;
        if ("Kelvin".equals(scale)) return celsius + 273.15;
        return celsius;
    }

    private String symbol(String scale) {
        return "Fahrenheit".equals(scale) ? "°F" : "Kelvin".equals(scale) ? "K" : "°C";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex3_TemperatureConverter().setVisible(true));
    }
}
