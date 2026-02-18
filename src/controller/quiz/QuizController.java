package view.quiz;

import model.eingabe.CsvWriter;
import view.eingabe.EingabeLayout;
import view.menu.menuFrame;

import javax.swing.*;
import java.io.IOException;

public class QuizController {
    private final QuizLayout ui;
    private final CsvWriter csv;
    private final JFrame frame;
    private int frageNummer = 1;

    public QuizController(QuizLayout ui, JFrame frame, String csvPath) {
        this.ui = ui;
        this.frame = frame;
        this.csv = new CsvWriter(csvPath);

        ui.getWeiter().addActionListener(e -> onWeiter());
        ui.getBeenden().addActionListener(e -> onBeenden());
    }

    private void onWeiter() {
        String f = ui.getFrage().getText().trim();
        String a = ui.getAntwort().getText().trim();

        if (f.isEmpty() || a.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Bitte Frage und Antwort ausfüllen.");
            return;
        }

        try {
            csv.appendRow(f, a);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Fehler beim Speichern: " + ex.getMessage());
            return;
        }

        frageNummer++;
        ui.getTitleLabel().setText("Frage " + frageNummer);

        ui.getFrage().setText("");
        ui.getAntwort().setText("");
        ui.getFrage().requestFocusInWindow();
    }

    private void onBeenden() {
        frame.dispose();
        new menuFrame();
    }
}
