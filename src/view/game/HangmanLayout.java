package view.game;

import view.RoundedButtonUI;
import view.RoundedTextFieldUI;

import javax.swing.*;
import java.awt.*;

public class HangmanLayout {

    private JLabel wortAnzeige;
    private JLabel frageLabel;
    private JLabel frageTextLabel;   // NEU
    private JTextField eingabe;
    private JButton weiter;
    private JButton beenden;
    private JLabel fehler;
    private HangmanPanel hangmanPanel;

    public JPanel buildPanel(){


        JPanel root = new JPanel(new GridLayout(1,2));
        root.setBackground(Color.WHITE);

        JPanel left = new JPanel(new GridLayout(6,1,20,20));
        left.setBorder(BorderFactory.createEmptyBorder(80,120,80,120));
        left.setBackground(Color.WHITE);

        frageLabel = new JLabel("", SwingConstants.CENTER);
        frageLabel.setFont(new Font("SansSerif", Font.PLAIN, 28));

        wortAnzeige = new JLabel("", SwingConstants.CENTER);
        wortAnzeige.setFont(new Font("SansSerif", Font.BOLD, 26));
        wortAnzeige.setHorizontalAlignment(SwingConstants.LEFT);

        eingabe = new JTextField();
        eingabe.setHorizontalAlignment(SwingConstants.CENTER);
        eingabe.setUI(new RoundedTextFieldUI(40));

        weiter = new JButton("Bestätigen");
        weiter.setUI(new RoundedButtonUI(40));
        weiter.setBackground(Color.GREEN);

        beenden = new JButton("Beenden");
        beenden.setUI(new RoundedButtonUI(40));
        beenden.setBackground(Color.RED);


        JPanel buttonPanel = new JPanel(new GridLayout(1,2,20,0));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(weiter);
        buttonPanel.add(beenden);

        fehler = new JLabel("Fehler: 0 / 6", SwingConstants.CENTER);

        left.add(frageLabel);
        left.add(wortAnzeige);
        left.add(eingabe);
        left.add(buttonPanel);
        left.add(fehler);
        left.add(new JLabel(""));

        // Linke Seite
        JPanel right = new JPanel(new GridLayout(3,1));
        right.setBackground(Color.WHITE);

        JPanel obenLeer = new JPanel();
        obenLeer.setBackground(Color.WHITE);

        JPanel mitte = new JPanel(new GridLayout(1,1));
        mitte.setBackground(Color.WHITE);

        JPanel untenLeer = new JPanel();
        untenLeer.setBackground(Color.WHITE);

        hangmanPanel = new HangmanPanel();
        hangmanPanel.setBackground(Color.WHITE);

        mitte.add(hangmanPanel);

        right.add(obenLeer);
        right.add(mitte);
        right.add(untenLeer);

        root.add(left);
        root.add(right);

        return root;
    }

    public JLabel getFrageLabel(){ return frageLabel; }
    public JLabel getFrageTextLabel(){ return frageTextLabel; }  // NEU
    public JTextField getEingabe(){ return eingabe; }
    public JButton getWeiter(){ return weiter; }
    public JButton getBeenden(){ return beenden; }
    public JLabel getFehler(){ return fehler; }
    public HangmanPanel getHangmanPanel(){ return hangmanPanel; }
    public JLabel getWortAnzeige(){ return wortAnzeige; }
}

