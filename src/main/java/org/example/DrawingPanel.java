package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D graphics;
    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }

    /**
     * uses direct drawing into an offscreen Image filled with white with the tools in the graphics
     * librarii: java.awt.image.BufferedImage -> pt creare si manipulare imaginii
     *           java.awt.*-> pt elemntul de tip Graphics2D
     *
     */
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }


    /**
     * initializeaza un mouse pentru acest panel care sa astepte click ul utilozatorului
     * librarii: java.awt.event.MouseAdapter -> pt initalizarea mouseului care "asculta"
     *           java.awt.event.MouseEvent -> preluarea cordonatelor in care s a dat click pt a le transmite fnctiei care va desena :drawShape()
     */
    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            }
        });
    }

    /**
     * functia genreaza niste valori random pt raza si culoarea formai ce va fi desenata
     * apoi cu nr de laturi setat de utilizator preluat din configPanel va apela constructorul clasei RegularPolygon pt a crea forma
     * forma este umpluta cu functia fill cu culoarea setata d efunctia strColor()
     * @param x cordonata y a centului poligonului ce va fi desenat
     * @param y cordonata y a centului poligonului ce va fi desenat
     *
     */
    private void drawShape(int x, int y) {
        Random rand = new Random();
        int radius = rand.nextInt(100);

        ConfigPanel configPanel=new ConfigPanel(frame);
        int sides =(int) configPanel.sidesField.getValue();

        int r = rand.nextInt(128) + 128;
        int g = rand.nextInt(128) + 128;
        int b = rand.nextInt(128) + 128;
        Color color = Color.getHSBColor(r,g,b);
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

    @Override
    public void update(Graphics g) { }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

}

