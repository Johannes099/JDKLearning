package view.game;

import controller.game.GameSetupController;

import javax.swing.*;

public class GameSetupFrame extends JFrame {

    public GameSetupFrame() {
        setTitle("Hangman Setup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GameSetupLayout layout = new GameSetupLayout();
        setContentPane(layout.buildPanel());

        new GameSetupController(layout, this);

        setSize(900,600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

