package controller.game;

import model.game.HangmanLogic;
import model.game.Question;
import view.game.HangmanLayout;
import view.menu.menuFrame;

import javax.swing.*;
import java.util.Random;

public class HangmanController {

    private final HangmanLayout ui;
    private final JFrame frame;
    private final Question[] fragen;

    private HangmanLogic logic;

    public HangmanController(HangmanLayout ui, JFrame frame, Question[] fragen){
        this.ui = ui;
        this.frame = frame;
        this.fragen = fragen;

        startSpiel();

        ui.getWeiter().addActionListener(e -> pruefen());
        ui.getBeenden().addActionListener(e -> beenden());
    }

    private void startSpiel(){

        if(fragen.length == 0){
            JOptionPane.showMessageDialog(frame,"Keine Fragen vorhanden");
            frame.dispose();
            new menuFrame();
            return;
        }

        Random rand = new Random();
        int zufall = rand.nextInt(fragen.length);

        Question aktuelle = fragen[zufall];

        logic = new HangmanLogic(aktuelle.getAntwort());

        ui.getFrageLabel().setText(aktuelle.getFrage());
        ui.getWortAnzeige().setText(logic.getAnzeige());
        ui.getFehler().setText("Fehler: 0 / 6");
        ui.getEingabe().setText("");
        ui.getHangmanPanel().setFehler(0);
    }

    private void pruefen(){

        String input = ui.getEingabe().getText().trim();
        if(input.isEmpty()) return;

        logic.pruefe(input);

        ui.getWortAnzeige().setText(logic.getAnzeige());

        int f = logic.getFehler();
        ui.getFehler().setText("Fehler: " + f + " / 6");
        ui.getHangmanPanel().setFehler(f);

        if(logic.geloest()){
            JOptionPane.showMessageDialog(frame,"Gewonnen!");
            frame.dispose();
            new menuFrame();
            return;
        }

        if(logic.gameOver()){
            JOptionPane.showMessageDialog(frame,
                    "Game Over! Wort war: " + logic.getWort());
            frame.dispose();
            new menuFrame();
        }

        ui.getEingabe().setText("");
    }

    private void beenden(){
        frame.dispose();
        new menuFrame();
    }
}