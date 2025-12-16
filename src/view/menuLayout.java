package view;
import model.RoundedButtonUI;

import javax.swing.*;
import java.awt.*;

public class menuLayout extends JPanel {
    public JButton quiz, game, enter, stats, errors;
    public JLabel welcome;
    public JPanel mode, info, buttonRow, statsRow;
    public menuLayout(){
        this.setLayout(new BorderLayout());
        this.mode = new JPanel();
        this.info = new JPanel();
        this.buttonRow = new JPanel();
        this.statsRow = new JPanel();
        this.mode = new JPanel(new GridBagLayout());
        this.buttonRow.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.statsRow.setLayout(new BorderLayout());
        this.info.setLayout(new BorderLayout(50, 50));

        this.welcome = new JLabel("Welcome to the JDK Learning Tool");



        this.quiz = new JButton("Quiz");
        this.game = new JButton("Game");
        this.enter = new JButton("Eingabe");
        this.stats = new JButton("Stats");
        stats.setUI(new RoundedButtonUI(40));
        this.stats.setPreferredSize(new Dimension(285, 80));
        this.stats.setBackground(Color.BLUE);
        this.errors = new JButton("Errors");
        this.errors.setPreferredSize(new Dimension(285, 80));
        this.buttonRow.add(quiz);
        this.buttonRow.add(game);
        this.buttonRow.add(enter);
        this.mode.add(buttonRow);
        this.statsRow.add(stats, BorderLayout.EAST);
        this.statsRow.add(errors, BorderLayout.WEST);
        this.info.add(statsRow, BorderLayout.CENTER);
        this.info.add(Box.createHorizontalStrut(0), BorderLayout.SOUTH);
        this.info.add(Box.createVerticalStrut(0), BorderLayout.EAST);
        this.info.add(Box.createVerticalStrut(0), BorderLayout.WEST);



        this.add(welcome, BorderLayout.NORTH);
        this.add(mode, BorderLayout.CENTER);
        this.add(info, BorderLayout.SOUTH);

    }
}
