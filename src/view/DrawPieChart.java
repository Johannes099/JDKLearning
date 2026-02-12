package view;

import javax.swing.*;
import java.awt.*;

public class DrawPieChart extends JPanel {
    private int errors;
    private int correct;
    private int skipped;
    private int total;

    // Colors for each section
    private static final Color CORRECT_COLOR = new Color(76, 175, 80);  // Green
    private static final Color ERROR_COLOR = new Color(244, 67, 54);    // Red
    private static final Color SKIPPED_COLOR = new Color(158, 158, 158); // Gray

    public DrawPieChart(int errors, int correct, int skipped) {
        this.errors = errors;
        this.correct = correct;
        this.skipped = skipped;
        this.total = errors + correct + skipped;

        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smoother circles
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (total == 0) {
            // Draw empty circle if no data
            g2d.setColor(Color.LIGHT_GRAY);
            int diameter = Math.min(getWidth(), getHeight()) - 40;
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;
            g2d.fillOval(x, y, diameter, diameter);
            return;
        }

        // Calculate angles for each section
        int correctAngle = (int) Math.round((correct * 360.0) / total);
        int errorAngle = (int) Math.round((errors * 360.0) / total);
        int skippedAngle = 360 - correctAngle - errorAngle; // Remaining angle

        // Calculate position and size
        int diameter = Math.min(getWidth(), getHeight()) - 40;
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;

        int startAngle = 0;

        // Draw correct section (green)
        if (correct > 0) {
            g2d.setColor(CORRECT_COLOR);
            g2d.fillArc(x, y, diameter, diameter, startAngle, correctAngle);
            startAngle += correctAngle;
        }

        // Draw error section (red)
        if (errors > 0) {
            g2d.setColor(ERROR_COLOR);
            g2d.fillArc(x, y, diameter, diameter, startAngle, errorAngle);
            startAngle += errorAngle;
        }

        // Draw skipped section (gray)
        if (skipped > 0) {
            g2d.setColor(SKIPPED_COLOR);
            g2d.fillArc(x, y, diameter, diameter, startAngle, skippedAngle);
        }

        // Draw legend
        drawLegend(g2d);
    }

    private void drawLegend(Graphics2D g2d) {
        int legendX = 10;
        int legendY = getHeight() - 80;
        int boxSize = 15;
        int spacing = 25;

        g2d.setFont(new Font("Arial", Font.PLAIN, 12));

        // Correct
        g2d.setColor(CORRECT_COLOR);
        g2d.fillRect(legendX, legendY, boxSize, boxSize);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Correct: " + correct, legendX + boxSize + 5, legendY + 12);

        // Errors
        legendY += spacing;
        g2d.setColor(ERROR_COLOR);
        g2d.fillRect(legendX, legendY, boxSize, boxSize);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Errors: " + errors, legendX + boxSize + 5, legendY + 12);

        // Skipped
        legendY += spacing;
        g2d.setColor(SKIPPED_COLOR);
        g2d.fillRect(legendX, legendY, boxSize, boxSize);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Skipped: " + skipped, legendX + boxSize + 5, legendY + 12);
    }

    // Update method if you want to change values after creation
    public void updateData(int errors, int correct, int skipped) {
        this.errors = errors;
        this.correct = correct;
        this.skipped = skipped;
        this.total = errors + correct + skipped;
        repaint();
    }
}