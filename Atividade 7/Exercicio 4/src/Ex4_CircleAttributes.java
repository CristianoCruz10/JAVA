import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/** Exercício 4: desenha um círculo aleatório e apresenta seus atributos. */
public class Ex4_CircleAttributes extends JFrame {
    private final JTextArea attributes = new JTextArea(5, 20);
    private final CirclePanel circlePanel = new CirclePanel(attributes);

    public Ex4_CircleAttributes() {
        super("Círculo e atributos");
        attributes.setEditable(false);
        JButton newCircle = new JButton("Novo círculo");
        newCircle.addActionListener(this::generateCircle);
        add(circlePanel, BorderLayout.CENTER);
        add(new JScrollPane(attributes), BorderLayout.EAST);
        add(newCircle, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationByPlatform(true);
        generateCircle(null);
    }

    private void generateCircle(ActionEvent event) {
        circlePanel.generateCircle();
    }

    private static class CirclePanel extends JPanel {
        private final JTextArea attributes;
        private int radius;

        CirclePanel(JTextArea attributes) {
            this.attributes = attributes;
            setPreferredSize(new Dimension(380, 300));
            setBackground(Color.WHITE);
        }

        void generateCircle() {
            radius = ThreadLocalRandom.current().nextInt(25, 121);
            int diameter = 2 * radius;
            double area = Math.PI * radius * radius;
            double circumference = 2 * Math.PI * radius;
            attributes.setText(String.format("Raio: %d\nDiâmetro: %d\nÁrea: %.2f\nCircunferência: %.2f",
                    radius, diameter, area, circumference));
            repaint();
        }

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            if (radius == 0) return;
            int diameter = 2 * radius;
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;
            graphics.setColor(new Color(78, 145, 214));
            graphics.fillOval(x, y, diameter, diameter);
            graphics.setColor(Color.BLACK);
            graphics.drawOval(x, y, diameter, diameter);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex4_CircleAttributes().setVisible(true));
    }
}
