package view.quiz;

import view.quiz.QuizController;

import javax.swing.*;

public class QuizFrame extends JFrame {

    public QuizFrame() {
        setTitle("Eingabe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        QuizLayout layout = new QuizLayout();
        setContentPane(layout.buildPanel());

        new QuizController(layout, this);

        setSize(1500, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
