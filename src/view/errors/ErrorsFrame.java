package view.errors;
import javax.swing.*;
import java.io.IOException;
import model.eingabe.CsvReader;
import view.menu.menuFrame;

public class ErrorsFrame extends JFrame {
    private final CsvReader reader = new CsvReader("errors.csv");
    private int richtigZP = 0;
    private int falschZP = 0;
    public ErrorsFrame() {
        setTitle("Ergebnis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ErrorsLayout layout = new ErrorsLayout();
        try{
            if((reader.read(0, 1) != null) && (reader.read(0, 0)!= null)) {
                this.richtigZP = Integer.parseInt(reader.read(0, 1));
                this.falschZP = Integer.parseInt(reader.read(0, 0));

            }
            else {
                JOptionPane.showMessageDialog(this, "Keine Gespeicherten Daten! Bitte starten Sie zuerst ein Quiz:");
                this.dispose();
                menuFrame menu = new menuFrame();
            }
        }catch (IOException ex){
            JOptionPane.showMessageDialog(this, "Fehler beim Lesen: " + ex.getMessage());
            return;
        }

        layout.setRichtig(richtigZP);
        layout.setFalsch(falschZP);
        setContentPane(layout);

        setSize(1500, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public ErrorsFrame(int richtig, int falsch) {
        setTitle("Ergebnis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ErrorsLayout layout = new ErrorsLayout();
        layout.setRichtig(richtig);
        layout.setFalsch(falsch);

        setContentPane(layout);
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}