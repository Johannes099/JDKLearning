package view.quiz;
import model.eingabe.*;
import view.errors.*;

import model.eingabe.CsvWriter;
import view.eingabe.EingabeLayout;
import view.menu.menuFrame;

import javax.swing.*;
import java.io.IOException;

public class QuizController {
    private final QuizLayout ui;
    private final CsvReader reader = new CsvReader("fragen.csv");
    private final JFrame frame;
    private int frageNummer = 0; // fix: was 1, rows are 0-indexed
    int falsch = 0;
    int richtig = 0;

    public QuizController(QuizLayout ui, JFrame frame) {
        this.ui = ui;
        this.frame = frame;

        ui.getWeiter().addActionListener(e -> onWeiter());
        ui.getBeenden().addActionListener(e -> onBeenden());

        ladeFrage();
    }

    private void ladeFrage() {
        try {
            String frage = reader.read(frageNummer, 0);
            if (frage != null) {
                ui.setFrage(frage);
                ui.getTitleLabel().setText("Frage " + (frageNummer + 1));
            } else {
                ui.setWeiter("Menu");
            }
        } catch (IOException ex) {
            System.err.println("Fehler beim Lesen: " + ex.getMessage());
        }
    }

    private void onWeiter() {
        String a = ui.getAntwort().getText().trim(); // fix: removed getFrage().getText() since frage is a JLabel
        if (ui.getWeiter().getText().equals("Menu")) {
            if (a.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Bitte Antwort ausfüllen.");
                return;
            }

            try {
                String richtigeAntwort = reader.read(frageNummer, 1);
                if (richtigeAntwort != null && richtigeAntwort.equals(a)) {
                    this.richtig++;
                } else {
                    this.falsch++;
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Fehler beim Lesen: " + ex.getMessage());
                return;
            }
            frame.dispose();
            new ErrorsFrame(this.richtig, this.falsch);
            return;
        }

        if (a.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Bitte Antwort ausfüllen.");
            return;
        }

        try {
            String richtigeAntwort = reader.read(frageNummer, 1);
            if (richtigeAntwort != null && richtigeAntwort.equals(a)) {
                this.richtig++;
            } else {
                this.falsch++;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Fehler beim Lesen: " + ex.getMessage());
            return;
        }

        frageNummer++;
        ladeFrage();
        ui.getAntwort().setText(""); // clear answer field for next question
    }

    private void onBeenden() {
        frame.dispose();
        new menuFrame();
    }
}