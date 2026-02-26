package view.errors;

import view.RoundedButtonUI;

import javax.swing.*;
import java.awt.*;

public class ErrorsLayout extends JPanel {
    private JButton menue;
    private JLabel richtigZahl, falschZahl;

    public ErrorsLayout() {
        this.setLayout(new GridLayout(6, 1, 0, 18));
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        menue = new JButton("Menü");
        menue.setUI(new RoundedButtonUI(40));
        menue.setPreferredSize(new Dimension(285, 50));
        menue.setBackground(Color.RED);
        menue.setForeground(Color.BLACK);

        JLabel titleLabel = new JLabel("Ergebnis", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.PLAIN, 52));

        JLabel subtitle = new JLabel("Folgende Wörter wurden falsch geschrieben", SwingConstants.CENTER);
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 34));

        // Richtig row
        JPanel richtigRow = new JPanel(new GridLayout(1, 3, 20, 0));
        richtigRow.setBackground(Color.WHITE);

        JLabel richtigBox = new JLabel("Richtig", SwingConstants.CENTER);
        richtigBox.setOpaque(true);
        richtigBox.setBackground(Color.GREEN);
        richtigBox.setFont(new Font("SansSerif", Font.PLAIN, 28));

        richtigZahl = new JLabel("0", SwingConstants.CENTER);
        richtigZahl.setFont(new Font("SansSerif", Font.PLAIN, 28));

        richtigRow.add(richtigBox);
        richtigRow.add(new JLabel(""));
        richtigRow.add(richtigZahl);

        // Falsch row
        JPanel falschRow = new JPanel(new GridLayout(1, 3, 20, 0));
        falschRow.setBackground(Color.WHITE);

        JLabel falschBox = new JLabel("Falsch", SwingConstants.CENTER);
        falschBox.setOpaque(true);
        falschBox.setBackground(Color.RED);
        falschBox.setFont(new Font("SansSerif", Font.PLAIN, 28));

        falschZahl = new JLabel("0", SwingConstants.CENTER);
        falschZahl.setFont(new Font("SansSerif", Font.PLAIN, 28));

        falschRow.add(falschBox);
        falschRow.add(new JLabel(""));
        falschRow.add(falschZahl);

        // Button row
        JPanel buttons = new JPanel(new GridLayout(1, 3, 20, 0));
        buttons.setBackground(Color.WHITE);
        buttons.add(new JLabel(""));
        buttons.add(menue);
        buttons.add(new JLabel(""));

        this.add(titleLabel);
        this.add(subtitle);
        this.add(richtigRow);
        this.add(falschRow);
        this.add(new JLabel(""));
        this.add(buttons);

        menue.addActionListener(ee -> {
            java.awt.Window w = SwingUtilities.getWindowAncestor(this);
            if (w != null) w.dispose();
            new view.menu.menuFrame();
        });
    }

    public JButton getMenue() { return menue; }
    public void setRichtig(int n) { richtigZahl.setText(String.valueOf(n)); }
    public void setFalsch(int n) { falschZahl.setText(String.valueOf(n)); }
}