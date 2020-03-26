package lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int height = screenSize.height / 3;
    int width = screenSize.width / 4;
    static ConfigPanel form;
    DrawingPanel drawArea;
    ControlPanel control;

    //Actiuni butoane (reset , load , save, draw)
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == control.resetButton) {
                drawArea.clear();
            } else if (e.getSource() == control.loadButton) {
                try {
                    load();
                } catch (IOException e1) {
                    System.out.println("Fisierul nu exista sau formatul nu este bun.");
                }
            } else if (e.getSource() == control.saveButton) {
                try {
                    save();
                } catch (IOException e1) {
                    System.out.println("Destinatia nu exista sau nu ai drept de salvare.");
                }
            } else if (e.getSource() == form.drawButton) {
                int repeat = Integer.parseInt(form.shapesNo.getText());
                int sides = Integer.valueOf((Integer) form.sidesNoValue.getSelectedItem());
                drawArea.drawShapeRandom(repeat, sides);
                repaint();
            }
        }
    };
    //constructor (titlu , init , adaugare componente)
    public MainFrame() {
        super("JAVA Paint");
        rootPane.setBorder(BorderFactory.createTitledBorder("Drawing panel"));
        rootPane.setPreferredSize(new Dimension(width, height));
        init();
        addComponents();
        this.pack();
    }
    //adaugarea componentelor in pag(configpanel,zona de desen,panou de control cu actiunile butoanelor)
    private void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        form = new ConfigPanel(this);
        drawArea = new DrawingPanel();
        control = new ControlPanel(this);
        form.drawButton.addActionListener(actionListener);
        control.resetButton.addActionListener(actionListener);
        control.saveButton.addActionListener(actionListener);
        control.loadButton.addActionListener(actionListener);
    }
    //adaugarea componentelor
    private void addComponents(){
        add(form, BorderLayout.NORTH);
        add(drawArea, BorderLayout.CENTER);
        add(control, BorderLayout.SOUTH);
    }
    //save file
    public void save() throws IOException {
        ImageIO.write(drawArea.getImage(), "PNG", new File("lab6_Paint.png"));
    }
    //load file
    public void load() throws IOException {
        drawArea.setImage(ImageIO.read(new File("lab6_Paint.png")));
        repaint();
    }
}
