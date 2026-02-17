package controller.game;

import model.game.HangmanLogic;
import model.game.Question;          // NEU
import view.game.HangmanLayout;
import view.menu.menuFrame;

import javax.swing.*;

public class HangmanController {

    private final HangmanLayout ui;
    private final JFrame frame;
    private final Question[] fragen;   // geändert

    private int index = 0;
    private HangmanLogic logic;

    public HangmanController(HangmanLayout ui, JFrame frame, Question[] fragen){
        this.ui = ui;
        this.frame = frame;
        this.fragen = fragen;

        startRunde();

        ui.getWeiter().addActionListener(e -> pruefen());
        ui.getBeenden().addActionListener(e -> beenden());
    }

    private void startRunde(){
        if(index >= fragen.length){
            JOptionPane.showMessageDialog(frame,"Gewonnen!");
            frame.dispose();
            new menuFrame();
            return;
        }

        Question aktuelle = fragen[index];

        logic = new HangmanLogic(aktuelle.getAntwort());

        ui.getFrageLabel().setText("Frage " + (index+1) + " von " + fragen.length);

        // HIER steht jetzt die echte Frage
        ui.getFrageTextLabel().setText(aktuelle.getFrage());

        ui.getFehler().setText("Fehler: 0 / 6");
        ui.getEingabe().setText("");
        ui.getHangmanPanel().setFehler(0);
    }

    private void pruefen(){

        String input = ui.getEingabe().getText().trim();
        if(input.isEmpty()) return;

        if(logic.pruefe(input)){
            index++;
            startRunde();
        } else {
            int f = logic.getFehler();
            ui.getFehler().setText("Fehler: " + f + " / 6");
            ui.getHangmanPanel().setFehler(f);

            if(logic.gameOver()){
                JOptionPane.showMessageDialog(frame,
                        "Game Over! Wort war: " + logic.getWort());
                frame.dispose();
                new menuFrame();
            }
        }

        ui.getEingabe().setText("");
    }

    private void beenden(){
        frame.dispose();
        new menuFrame();
    }
}


