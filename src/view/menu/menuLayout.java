package view.menu;

import view.RoundedButtonUI;

import javax.swing.*;
import java.awt.*;

public class menuLayout extends JPanel {
    public JButton quiz, game, enter, stats, errors;
    public JLabel welcome;
    public JPanel mode, info, buttonRow, statsRow;

    public menuLayout(){
        // Main panel uses GridLayout with 3 rows
        this.setLayout(new GridLayout(3, 1, 0, 20));
        this.setBackground(Color.WHITE);

        // Initialize panels
        this.mode = new JPanel();
        this.info = new JPanel();
        this.buttonRow = new JPanel();
        this.statsRow = new JPanel();

        // Configure welcome label
        this.welcome = new JLabel("Willkommen zum JDKLearing-Tool");
        this.welcome.setFont(new Font("Arial", Font.PLAIN, 48));
        this.welcome.setHorizontalAlignment(SwingConstants.CENTER);

        // Configure mode panel (center buttons)
        this.mode.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        this.mode.setBackground(Color.WHITE);

        // Configure button row
        this.buttonRow.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        this.buttonRow.setBackground(Color.WHITE);

        // Configure stats row - use BorderLayout to position buttons at edges
        this.statsRow.setLayout(new BorderLayout());
        this.statsRow.setBackground(Color.WHITE);

        // Create Quiz button
        this.quiz = new JButton("Quiz");
        quiz.setUI(new RoundedButtonUI(40));
        this.quiz.setBackground(Color.LIGHT_GRAY);
        this.quiz.setPreferredSize(new Dimension(280, 150));
        this.quiz.setFont(new Font("Arial", Font.PLAIN, 36));

        // Create Game button
        this.game = new JButton("Game");
        game.setUI(new RoundedButtonUI(40));
        this.game.setPreferredSize(new Dimension(280, 150));
        this.game.setBackground(Color.LIGHT_GRAY);
        this.game.setFont(new Font("Arial", Font.PLAIN, 36));

        // Create Eingabe button
        this.enter = new JButton("Eingabe");
        enter.setUI(new RoundedButtonUI(40));
        this.enter.setPreferredSize(new Dimension(280, 150));
        this.enter.setBackground(Color.LIGHT_GRAY);
        this.enter.setFont(new Font("Arial", Font.PLAIN, 36));

        // Create Statistik button
        this.stats = new JButton("Statistik");
        stats.setUI(new RoundedButtonUI(40));
        this.stats.setPreferredSize(new Dimension(250, 70));
        this.stats.setBackground(Color.BLUE);
        this.stats.setForeground(Color.BLACK);
        this.stats.setFont(new Font("Arial", Font.PLAIN, 28));

        // Create Fehler button
        this.errors = new JButton("Fehler");
        errors.setUI(new RoundedButtonUI(40));
        this.errors.setPreferredSize(new Dimension(250, 70));
        this.errors.setBackground(Color.RED);
        this.errors.setForeground(Color.BLACK);
        this.errors.setFont(new Font("Arial", Font.PLAIN, 28));

        // Add buttons to button row
        this.buttonRow.add(quiz);
        this.buttonRow.add(game);
        this.buttonRow.add(enter);

        // Add button row to mode panel
        this.mode.add(buttonRow);

        // Add bottom buttons to stats row using BorderLayout
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setBackground(Color.WHITE);
        leftPanel.add(errors);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.add(stats);

        this.statsRow.add(leftPanel, BorderLayout.WEST);
        this.statsRow.add(rightPanel, BorderLayout.EAST);

        // Configure info panel
        this.info.setLayout(new BorderLayout());
        this.info.setBackground(Color.WHITE);
        this.info.add(statsRow, BorderLayout.SOUTH);

        // Add all components to main panel
        this.add(welcome);
        this.add(mode);
        this.add(info);

        // Action listener for enter button
        enter.addActionListener(e -> {
            java.awt.Window w = SwingUtilities.getWindowAncestor(this);
            if (w != null) w.dispose();
            new view.eingabe.EingabeFrame();
        });

        stats.addActionListener(es -> {
            java.awt.Window w = SwingUtilities.getWindowAncestor(this);
            if (w != null) w.dispose();
            new view.stats.statsFrame();
        });

        quiz.addActionListener(eq -> {
            java.awt.Window w = SwingUtilities.getWindowAncestor(this);
            if (w != null) w.dispose();
            new view.quiz.QuizFrame();
        });

        errors.addActionListener(ee -> {
            java.awt.Window w = SwingUtilities.getWindowAncestor(this);
            if (w != null) w.dispose();
            new view.errors.ErrorsFrame();
        });
    }
}