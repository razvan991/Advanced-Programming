package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {

    private BufferedImage image;
    private Graphics2D graphics;
    private int currentMouseX, currentMouseY;

    public DrawingPanel() {
        this.setBorder(BorderFactory.createTitledBorder("Drawing paper:"));
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentMouseX = e.getX();
                currentMouseY = e.getY();
                if(graphics != null) {
                    int stroke = Integer.parseInt(MainFrame.form.shapesStroke.getText());
                    int sides = Integer.valueOf((Integer) MainFrame.form.sidesNoValue.getSelectedItem());
                    drawShapeAt(currentMouseX, currentMouseY, stroke, sides);
                    repaint();
                }
            }
        });
    }
    //desenarea unei componente
    protected void paintComponent(Graphics g) {
        if(image == null) {
            image = new BufferedImage(470, 230, BufferedImage.TYPE_INT_ARGB);
            graphics = image.createGraphics();
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }
    //stergere desen
    public void clear() {
        graphics.setPaint(Color.white);
        graphics.fillRect(0, 0, getSize().width, getSize().height);
        graphics.setPaint(Color.black);
        repaint();
    }
    //Desenarea unei imagini la pozitia apasata cu click
    public void drawShapeAt(int x, int y, int stroke, int sides) {
        Random rand = new Random();
        graphics.setColor(randColor());
        if(sides!=0)
            graphics.fillPolygon(new RegularPolygon(x, y, stroke, sides));
        else
            graphics.fillOval(x-(stroke/2),y-(stroke/2),stroke+20,stroke+20);
    }
    //Desenarea random a unei figuri
    public void drawShapeRandom(int repeatNo, int sides) {
        while (repeatNo>0) {
            Random rand = new Random();
            graphics.setColor(randColor());
            int random_x = rand.nextInt(getWidth() - 5);
            int random_y = rand.nextInt(getHeight() - 20);
            int random_radius = rand.nextInt(18-5) + 10;
            int random_circle_radius = rand.nextInt(50-5) + 10;
            if(sides!=0)
                graphics.fillPolygon(new RegularPolygon(random_x, random_y, random_radius, sides));
            else
                graphics.fillOval(random_x,random_y,random_circle_radius,random_circle_radius);
            repeatNo--;
        }
    }

    public Color randColor() {
        Random random = new Random();
        float r = (float) (random.nextFloat() / 2f + 0.5);
        float g = (float) (random.nextFloat() / 2f + 0.5);
        float b = (float) (random.nextFloat() / 2f + 0.5);
        float a = (float) 0.5;
        Color color = new Color(r, g, b, a);
        return color;
    }
        //de pe slide-uri

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

}
