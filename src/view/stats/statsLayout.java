package view.stats;

import view.RoundedButtonUI;

import javax.swing.*;
import java.awt.*;

public class statsLayout extends JPanel {
    public JButton menu;
    public JLabel heading, subheading;
    public JPanel headings, legend, stats, chartPanel, contentPanel, leftSection;

    public statsLayout(){
        // Main panel uses GridLayout with 2 rows
        this.setLayout(new GridLayout(2, 1, 0, 0));
        this.setBackground(Color.WHITE);

        // Initialize panels
        this.headings = new JPanel();
        this.stats = new JPanel();
        this.contentPanel = new JPanel();
        this.leftSection = new JPanel();
        this.legend = new JPanel();
        this.chartPanel = new JPanel();

        // Configure headings panel
        this.headings.setLayout(new BoxLayout(headings, BoxLayout.Y_AXIS));
        this.headings.setBackground(Color.WHITE);

        // Create heading labels
        this.heading = new JLabel("Statistik");
        this.heading.setFont(new Font("Arial", Font.PLAIN, 60));
        this.heading.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.subheading = new JLabel("Deine Punktzahl wird in einem Diagramm dargestellt");
        this.subheading.setFont(new Font("Arial", Font.PLAIN, 30));
        this.subheading.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add heading labels
        this.headings.add(Box.createVerticalStrut(20));
        this.headings.add(heading);
        this.headings.add(Box.createVerticalStrut(10));
        this.headings.add(subheading);

        // Configure stats panel (bottom half)
        this.stats.setLayout(new BorderLayout());
        this.stats.setBackground(Color.WHITE);

        // Configure content panel (holds left section and chart side by side)
        this.contentPanel.setLayout(new GridLayout(1, 2, 0, 0));
        this.contentPanel.setBackground(Color.WHITE);

        // Configure left section (holds legend and menu button)
        this.leftSection.setLayout(new BorderLayout());
        this.leftSection.setBackground(Color.WHITE);

        // Configure legend panel
        this.legend.setLayout(new GridBagLayout());
        this.legend.setBackground(Color.WHITE);

        // Create a container for all legend items
        JPanel legendItemsContainer = new JPanel();
        legendItemsContainer.setLayout(new BoxLayout(legendItemsContainer, BoxLayout.Y_AXIS));
        legendItemsContainer.setBackground(Color.WHITE);

        // Create legend items
        legendItemsContainer.add(createLegendItem("Fehler", Color.RED));
        legendItemsContainer.add(Box.createVerticalStrut(25));
        legendItemsContainer.add(createLegendItem("Übersprungen", new Color(135, 171, 245)));
        legendItemsContainer.add(Box.createVerticalStrut(25));
        legendItemsContainer.add(createLegendItem("Richtig", new Color(102, 204, 103)));

        this.legend.add(legendItemsContainer);

        // Create menu button panel
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 20));
        menuPanel.setBackground(Color.WHITE);

        this.menu = new JButton("Menü");
        this.menu.setUI(new RoundedButtonUI(40));
        this.menu.setPreferredSize(new Dimension(250, 70));
        this.menu.setBackground(Color.RED);
        this.menu.setForeground(Color.BLACK);
        this.menu.setFont(new Font("Arial", Font.PLAIN, 32));

        menuPanel.add(menu);

        // Add legend and menu to left section
        this.leftSection.add(legend, BorderLayout.CENTER);
        this.leftSection.add(menuPanel, BorderLayout.SOUTH);

        // Configure chart panel (right side) - placeholder circle that fills the space
        this.chartPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                // Calculate diameter to fill the available space
                int width = getWidth();
                int height = getHeight();
                int diameter = (int)(Math.min(width, height) * 0.95); // Use 95% of available space
                int x = (width - diameter) / 2;
                int y = (height - diameter) / 2;

                // Draw placeholder circle
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.fillOval(x, y, diameter, diameter);
            }
        };
        this.chartPanel.setBackground(Color.WHITE);

        // Add left section and chart to content panel
        this.contentPanel.add(leftSection);
        this.contentPanel.add(chartPanel);

        // Add content to stats panel
        this.stats.add(contentPanel, BorderLayout.CENTER);

        // Add all to main panel
        this.add(headings);
        this.add(stats);

        menu.addActionListener(mn -> {
            java.awt.Window w = SwingUtilities.getWindowAncestor(this);
            if (w != null) w.dispose();
            new view.menu.menuFrame();
        });
    }

    private JPanel createLegendItem(String text, Color color) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 0));
        panel.setBackground(Color.WHITE);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Create color box
        JPanel colorBox = new JPanel();
        colorBox.setBackground(color);
        colorBox.setPreferredSize(new Dimension(50, 50));

        // Create text label
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 32));

        panel.add(colorBox);
        panel.add(label);

        return panel;

    }
}