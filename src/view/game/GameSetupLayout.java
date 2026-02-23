package view.game;

import view.RoundedButtonUI;

import javax.swing.*;
import java.awt.*;

public class GameSetupLayout {

    private JRadioButton csv;
    private JRadioButton standard;
    private JComboBox<String> amount;
    private JButton start;
    private JButton beenden;

    public JPanel buildPanel() {

        JPanel root = new JPanel(new GridLayout(4,1,20,20));
        root.setBorder(BorderFactory.createEmptyBorder(60,80,60,80));
        root.setBackground(Color.WHITE);

        JLabel title = new JLabel("Hangman", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.PLAIN, 40));

        csv = new JRadioButton("Selbstgemachte Fragen (CSV)");
        standard = new JRadioButton("Standard Fragen");

        ButtonGroup group = new ButtonGroup();
        group.add(csv);
        group.add(standard);

        JPanel radioPanel = new JPanel(new GridLayout(2,1));
        radioPanel.setBackground(Color.WHITE);
        radioPanel.add(csv);
        radioPanel.add(standard);

        amount = new JComboBox<>(new String[]{"5","10","Alle"});

        start = new JButton("Start");
        start.setUI(new RoundedButtonUI(40));
        start.setBackground(Color.GREEN);

        beenden = new JButton("Beenden");
        beenden.setUI(new RoundedButtonUI(40));
        beenden.setBackground(Color.RED);

        JPanel buttonPanel = new JPanel(new GridLayout(1,2,20,0));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(beenden);
        buttonPanel.add(start);

        root.add(title);
        root.add(radioPanel);
        root.add(amount);
        root.add(buttonPanel);

        return root;
    }

    public JRadioButton getCsv(){ return csv; }
    public JRadioButton getStandard(){ return standard; }
    public JComboBox<String> getAmount(){ return amount; }
    public JButton getStart(){ return start; }
    public JButton getBeenden(){ return beenden; }
}
