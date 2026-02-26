package view.stats;

import javax.swing.*;

public class statsFrame extends JFrame {
    public statsLayout statsLayout;
    public statsFrame(){
        this.statsLayout = new statsLayout();
        this.setTitle("JDKLearning Tool");

        this.setSize(1500, 800);
        this.setLocationRelativeTo(null);
        this.add(statsLayout);
        this.setVisible(true);

    }
}
