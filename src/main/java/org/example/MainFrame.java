package org.example;


import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    /**
     * se initializeaza toate componentele paginii : panza , paoul de configurare si panoul de "contol"
     * se seteaza sinoptionea de inchidere a paginii
     * librarii: javax.swing.JFrame implicit doarece foloseste functia add din clasa pe care o mostentest :JFrame
     */
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new DrawingPanel(this);
        configPanel= new ConfigPanel(this);
        controlPanel =new ControlPanel(this);

        add(canvas,BorderLayout.CENTER);
        add(controlPanel,BorderLayout.SOUTH);
        add(controlPanel,BorderLayout.NORTH);

        pack();
    }


}
