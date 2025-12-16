package view.menu;

import javax.swing.*;

public class menuFrame extends JFrame {
    public menuLayout menuLayout;
    public menuFrame(){
        this.menuLayout = new menuLayout();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("JDKLearning Tool");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(menuLayout);
        this.setVisible(true);

    }
}
