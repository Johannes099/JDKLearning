package view.game;

import controller.game.HangmanController;
import model.game.Question;

import javax.swing.*;

public class HangmanFrame extends JFrame {

    public HangmanFrame(Question[] fragen){
        setTitle("Hangman");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        HangmanLayout layout = new HangmanLayout();
        setContentPane(layout.buildPanel());

        new HangmanController(layout,this,fragen);

        setSize(1000,700);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

