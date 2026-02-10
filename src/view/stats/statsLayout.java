//package view.stats;
//
//import view.RoundedButtonUI;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class statsLayout extends JPanel {
//    public JButton menu;
//    public JLabel heading, subheading, err, skip, correct;
//    public JPanel headings, legend, stats;
//    public statsLayout(){
//        this.setLayout(new BorderLayout());
//        this.headings = new JPanel();
//        this.legend = new JPanel();
//        this.stats = new JPanel();
//        this.headings.setLayout(new BoxLayout(headings, BoxLayout.Y_AXIS));
//        this.legend.setLayout(new BoxLayout(legend, BoxLayout.Y_AXIS));
//        this.stats.setLayout(new BoxLayout(stats, BoxLayout.X_AXIS));
//
//        this.heading = new JLabel("Statistik");
//        this.subheading = new JLabel("Die Punktezahlt wird je nach Modus unterschiedlich berechnet");
//
//
//
//        this.quiz = new JButton("Quiz");
//        this.game = new JButton("Game");
//        this.enter = new JButton("Eingabe");
//        this.stats = new JButton("Stats");
//        stats.setUI(new RoundedButtonUI(40));
//        this.stats.setPreferredSize(new Dimension(285, 80));
//        this.stats.setBackground(Color.BLUE);
//        this.errors = new JButton("Errors");
//        this.errors.setPreferredSize(new Dimension(285, 80));
//        this.buttonRow.add(quiz);
//        this.buttonRow.add(game);
//        this.buttonRow.add(enter);
//        this.mode.add(buttonRow);
//        this.statsRow.add(stats, BorderLayout.EAST);
//        this.statsRow.add(errors, BorderLayout.WEST);
//        this.info.add(statsRow, BorderLayout.CENTER);
//        this.info.add(Box.createHorizontalStrut(0), BorderLayout.SOUTH);
//        this.info.add(Box.createVerticalStrut(0), BorderLayout.EAST);
//        this.info.add(Box.createVerticalStrut(0), BorderLayout.WEST);
//
//
//
//        this.add(welcome, BorderLayout.NORTH);
//        this.add(mode, BorderLayout.CENTER);
//        this.add(info, BorderLayout.SOUTH);
//
//    }
//}
