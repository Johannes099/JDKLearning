package view.quiz;


import view.RoundedButtonUI;
import view.RoundedTextFieldUI;

import javax.swing.*;
import java.awt.*;

public class QuizLayout {
    private JButton beenden, weiter;
    private JTextField antwort;
    private JLabel titleLabel, frage;

    public QuizLayout() {
        weiter = new JButton("Weiter");
        weiter.setUI(new RoundedButtonUI(40));
        weiter.setPreferredSize(new Dimension(285, 50));
        weiter.setBackground(Color.GREEN);
        weiter.setForeground(Color.BLACK);

        beenden = new JButton("Beenden");
        beenden.setUI(new RoundedButtonUI(40));
        beenden.setPreferredSize(new Dimension(285, 50));
        beenden.setBackground(Color.RED);
        beenden.setForeground(Color.BLACK);

        frage = new JLabel("Frage 1");
        frage.setPreferredSize(new Dimension(285 * 3, 55));
        frage.setBackground(new Color(220, 220, 220));

        antwort = new JTextField();
        antwort.setUI(new RoundedTextFieldUI(40));
        antwort.setPreferredSize(new Dimension(285 * 3, 55));
        antwort.setBackground(new Color(220, 220, 220));
    }

    public JPanel buildPanel() {
        JPanel root = new JPanel(new GridLayout(6, 1, 0, 18));
        root.setBackground(Color.WHITE);
        root.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        titleLabel = new JLabel("Frage 1", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.PLAIN, 52));

        JLabel subtitle = new JLabel(
                "<html><div style='text-align:center;'>Geben Sie die Antworten Für die Fragen ein<br>für die erste Frage ein</div></html>",
                SwingConstants.CENTER
        );
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 34));

        JPanel frageBlock = new JPanel(new GridLayout(2, 1, 0, 8));
        frageBlock.setBackground(Color.WHITE);
        JLabel frageLabel = new JLabel("Frage");
        frageLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        frageLabel.setForeground(new Color(80, 80, 80));
        frageBlock.add(frageLabel);
        frageBlock.add(frage);

        JPanel antwortBlock = new JPanel(new GridLayout(2, 1, 0, 8));
        antwortBlock.setBackground(Color.WHITE);
        JLabel antwortLabel = new JLabel("Antwort");
        antwortLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        antwortLabel.setForeground(new Color(80, 80, 80));
        antwortBlock.add(antwortLabel);
        antwortBlock.add(antwort);

        JPanel buttons = new JPanel(new GridLayout(1, 3, 20, 0));
        buttons.setBackground(Color.WHITE);
        buttons.add(beenden);
        buttons.add(new JLabel(""));
        buttons.add(weiter);

        JPanel spacer = new JPanel(new GridLayout(1, 1));
        spacer.setBackground(Color.WHITE);

        root.add(titleLabel);
        root.add(subtitle);
        root.add(frageBlock);
        root.add(antwortBlock);
        root.add(spacer);
        root.add(buttons);

        return root;
    }

    public JButton getBeenden() { return beenden; }
    public JButton getWeiter() { return weiter; }
    public JLabel getFrage() { return frage; }
    public JTextField getAntwort() { return antwort; }
    public JLabel getTitleLabel() { return titleLabel; }
}
