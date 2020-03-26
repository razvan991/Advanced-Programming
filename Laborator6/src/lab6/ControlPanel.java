package lab6;

import javax.swing.*;
import java.awt.*;

//De pe slide-uri
public class ControlPanel extends JPanel {
    private final MainFrame frame;
    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");
    JButton resetButton = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    //adaugarea butoanelor load save reset
    private void init() {
        add(loadButton);
        add(saveButton);
        add(resetButton);
    }
}
