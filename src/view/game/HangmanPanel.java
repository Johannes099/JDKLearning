package view.game;

import javax.swing.*;
import java.awt.*;

public class HangmanPanel extends JPanel {

    private int fehler = 0;

    public void setFehler(int fehler) {
        this.fehler = fehler;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(4));

        g2.drawLine(50, 250, 200, 250);
        g2.drawLine(125, 250, 125, 50);
        g2.drawLine(125, 50, 200, 50);
        g2.drawLine(200, 50, 200, 80);

        // Kopf
        if (fehler >= 1)
            g2.drawOval(175, 80, 50, 50);

        // Körper
        if (fehler >= 2)
            g2.drawLine(200, 130, 200, 180);

        // Rechter Arm
        if (fehler >= 3)
            g2.drawLine(200, 140, 170, 160);

        // Linker Arm
        if (fehler >= 4)
            g2.drawLine(200, 140, 230, 160);

        // Rechtes Bein
        if (fehler >= 5)
            g2.drawLine(200, 180, 170, 210);

        // Linkes Bein
        if (fehler >= 6)
            g2.drawLine(200, 180, 230, 210);
    }
}

