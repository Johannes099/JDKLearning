package view.eingabe;

import view.eingabe.EingabeController;

import javax.swing.*;

public class EingabeFrame extends JFrame {

    public EingabeFrame() {
        setTitle("Eingabe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EingabeLayout layout = new EingabeLayout();
        setContentPane(layout.buildPanel());

        new EingabeController(layout, this, "fragen.csv");

        setSize(1500, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
