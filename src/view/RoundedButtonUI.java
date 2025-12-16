package view;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;


public class RoundedButtonUI extends BasicButtonUI {

    private final int radius;

    public RoundedButtonUI(int radius) {
        this.radius = radius;
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        c.setOpaque(false);
        c.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        c.setBackground(new Color(60, 130, 245));
        c.setForeground(Color.WHITE);
        c.setFont(c.getFont().deriveFont(Font.PLAIN, 14f));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Background
        g2.setColor(b.getModel().isPressed() ? b.getBackground().darker() : b.getBackground());
        g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), radius, radius);

        // Text
        g2.setColor(b.getForeground());
        FontMetrics fm = g2.getFontMetrics();
        int x = (c.getWidth() - fm.stringWidth(b.getText())) / 2;
        int y = (c.getHeight() + fm.getAscent()) / 2 - 2;
        g2.drawString(b.getText(), x, y);

        g2.dispose();
    }
}
