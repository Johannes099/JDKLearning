package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.JTextComponent;

public class RoundedTextFieldUI extends BasicTextFieldUI {

    private final int radius;

    public RoundedTextFieldUI(int radius) {
        this.radius = radius;
    }

    @Override
    protected void installDefaults() {
        super.installDefaults();

        JTextComponent c = getComponent();
        c.setOpaque(false); // wir zeichnen Hintergrund selbst
        c.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        c.setBackground(Color.WHITE);
        c.setForeground(Color.BLACK);
        c.setFont(c.getFont().deriveFont(Font.PLAIN, 14f));
        c.setCaretColor(c.getForeground());
    }

    @Override
    protected void paintSafely(Graphics g) {
        JTextComponent c = getComponent();
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = c.getWidth();
        int h = c.getHeight();

        // Hintergrund
        g2.setColor(c.getBackground());
        g2.fillRoundRect(0, 0, w - 1, h - 1, radius, radius);

        // Border (leicht grau)
        g2.setColor(new Color(200, 200, 200));
        g2.drawRoundRect(0, 0, w - 1, h - 1, radius, radius);

        g2.dispose();

        // Text + Caret + Selection
        super.paintSafely(g);
    }
}
