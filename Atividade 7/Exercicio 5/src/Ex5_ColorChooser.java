import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeListener;

/** Exercício 5: seletor RGB personalizado. */
public class Ex5_ColorChooser extends JFrame {
    public Ex5_ColorChooser() {
        super("Seletor de cores RGB");
        ColorPreview preview = new ColorPreview();
        add(new MyColorChooser(preview), BorderLayout.NORTH);
        add(preview, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationByPlatform(true);
    }

    static class MyColorChooser extends JPanel {
        private final JSlider red = slider(128);
        private final JSlider green = slider(128);
        private final JSlider blue = slider(128);
        private final JTextField redValue = field();
        private final JTextField greenValue = field();
        private final JTextField blueValue = field();
        private final ColorPreview preview;

        MyColorChooser(ColorPreview preview) {
            this.preview = preview;
            setBorder(BorderFactory.createTitledBorder("Componentes RGB"));
            setLayout(new java.awt.GridLayout(3, 1, 4, 4));
            add(row("Vermelho:", red, redValue));
            add(row("Verde:", green, greenValue));
            add(row("Azul:", blue, blueValue));
            ChangeListener listener = event -> updateColor();
            red.addChangeListener(listener);
            green.addChangeListener(listener);
            blue.addChangeListener(listener);
            updateColor();
        }

        private JSlider slider(int value) { return new JSlider(0, 255, value); }
        private JTextField field() { JTextField field = new JTextField(3); field.setEditable(false); return field; }
        private JPanel row(String label, JSlider slider, JTextField field) {
            JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
            row.add(new JLabel(label)); row.add(slider); row.add(field);
            return row;
        }
        private void updateColor() {
            redValue.setText(String.valueOf(red.getValue()));
            greenValue.setText(String.valueOf(green.getValue()));
            blueValue.setText(String.valueOf(blue.getValue()));
            preview.setColor(new Color(red.getValue(), green.getValue(), blue.getValue()));
        }
    }

    private static class ColorPreview extends JPanel {
        private Color color = new Color(128, 128, 128);
        ColorPreview() { setPreferredSize(new Dimension(360, 180)); }
        void setColor(Color color) { this.color = color; repaint(); }
        @Override protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            graphics.setColor(color);
            graphics.fillRect(30, 30, getWidth() - 60, getHeight() - 60);
            graphics.setColor(Color.BLACK);
            graphics.drawRect(30, 30, getWidth() - 61, getHeight() - 61);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex5_ColorChooser().setVisible(true));
    }
}
