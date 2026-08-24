import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

/** Exercício 1: interface de impressora. */
public class Ex1_PrinterGUI extends JFrame {
    public Ex1_PrinterGUI() {
        super("Printer");
        setLayout(new BorderLayout(12, 12));

        JPanel options = new JPanel(new GridBagLayout());
        options.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 8));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.anchor = GridBagConstraints.WEST;

        c.gridx = 0; c.gridy = 0; c.gridwidth = 3;
        options.add(new JLabel("Printer: MyPrinter"), c);

        JPanel printWhat = new JPanel(new GridLayout(3, 1));
        printWhat.setBorder(BorderFactory.createTitledBorder("Print"));
        printWhat.add(new JCheckBox("Image"));
        printWhat.add(new JCheckBox("Text"));
        printWhat.add(new JCheckBox("Code"));
        c.gridx = 0; c.gridy = 1; c.gridwidth = 1;
        options.add(printWhat, c);

        JPanel range = new JPanel(new GridLayout(3, 1));
        range.setBorder(BorderFactory.createTitledBorder("Range"));
        ButtonGroup group = new ButtonGroup();
        for (String text : new String[] {"Selection", "All", "Applet"}) {
            JRadioButton button = new JRadioButton(text, "All".equals(text));
            group.add(button);
            range.add(button);
        }
        c.gridx = 1;
        options.add(range, c);

        c.gridx = 0; c.gridy = 2;
        options.add(new JLabel("Print Quality:"), c);
        c.gridx = 1;
        options.add(new JComboBox<>(new String[] {"Low", "Medium", "High"}), c);
        c.gridx = 2;
        options.add(new JCheckBox("Print to File"), c);

        JPanel buttons = new JPanel(new GridLayout(4, 1, 8, 12));
        buttons.setBorder(BorderFactory.createEmptyBorder(18, 0, 18, 18));
        for (String text : new String[] {"OK", "Cancel", "Setup...", "Help"}) {
            JButton button = new JButton(text);
            if ("OK".equals(text)) {
                button.addActionListener(event -> printDocument());
            }
            buttons.add(button);
        }
        add(options, BorderLayout.CENTER);
        add(buttons, BorderLayout.EAST);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationByPlatform(true);
    }

    private void printDocument() {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setJobName("MyPrinter");
        printJob.setPrintable((Graphics graphics, PageFormat pageFormat, int pageIndex) -> {
            if (pageIndex > 0) {
                return java.awt.print.Printable.NO_SUCH_PAGE;
            }

            Graphics2D page = (Graphics2D) graphics.create();
            page.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            page.drawString("Documento enviado pela interface MyPrinter", 72, 72);
            page.drawString("Selecionei a impressão pelo botão OK.", 72, 96);
            page.dispose();
            return java.awt.print.Printable.PAGE_EXISTS;
        });

        if (!printJob.printDialog()) {
            return;
        }
        try {
            printJob.print();
            JOptionPane.showMessageDialog(this, "Documento enviado para impressão.");
        } catch (PrinterException exception) {
            JOptionPane.showMessageDialog(this,
                    "Não foi possível imprimir: " + exception.getMessage(),
                    "Erro de impressão", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex1_PrinterGUI().setVisible(true));
    }
}
