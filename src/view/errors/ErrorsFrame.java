package view.errors;

import javax.swing.*;

public class ErrorsFrame extends JFrame {

    public ErrorsFrame() {
        setTitle("Ergebnis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new ErrorsLayout());

        setSize(1500, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public ErrorsFrame(int richtig, int falsch) {
        setTitle("Ergebnis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ErrorsLayout layout = new ErrorsLayout();
        layout.setRichtig(richtig);
        layout.setFalsch(falsch);

        setContentPane(layout);
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}