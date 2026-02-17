package controller.game;

import model.game.Question;
import model.game.QuestionLoader;
import view.game.GameSetupLayout;
import view.game.HangmanFrame;


import javax.swing.*;

public class GameSetupController {

    private final GameSetupLayout ui;
    private final JFrame frame;

    public GameSetupController(GameSetupLayout ui, JFrame frame) {
        this.ui = ui;
        this.frame = frame;

        ui.getStart().addActionListener(e -> start());
    }

    private void start() {

        if(!ui.getCsv().isSelected() && !ui.getStandard().isSelected()){
            JOptionPane.showMessageDialog(frame,"Bitte Modus wählen");
            return;
        }

        Question[] fragen;

        if(ui.getCsv().isSelected()){
            // CSV liefert jetzt direkt Question[]
            fragen = QuestionLoader.loadFromCsv("fragen.csv");
        } else {
            fragen = QuestionLoader.loadStandard();
        }

        if(fragen.length == 0){
            JOptionPane.showMessageDialog(frame,"Keine Fragen vorhanden");
            return;
        }

        String auswahl = (String) ui.getAmount().getSelectedItem();

        if(!auswahl.equals("Alle")){
            int anzahl = Integer.parseInt(auswahl);

            if(anzahl < fragen.length){
                Question[] neu = new Question[anzahl];

                for(int i = 0; i < anzahl; i++){
                    neu[i] = fragen[i];
                }

                fragen = neu;
            }
        }

        frame.dispose();
        new HangmanFrame(fragen);
    }
}


