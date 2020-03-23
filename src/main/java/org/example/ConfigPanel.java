package org.example;

import javax.swing.*;

public class ConfigPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;
    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * se adauga campurile pt setari cu obiecte din libraria SWING care au in cazu de fata diferite roluri : JLabel label(etichetea cu text care indica utilizatorului ca are de ales nr de fete),
     * JSpinner sidesField(pentru nr de fete ), JComboBox colorCombo(da posibilitatea
     * de a alege din optiunile date ca parametru la construntor)
     * librarii: javax.swing.JFrame
     *           javax.swing.JLabel
     *           javax.swing.JComboBox
     *           javax.swing.JComboBox
     */
    private void init() {
        JLabel sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6);
        colorCombo =new JComboBox(new String[]{"Random", "Black"});

         frame.add(sidesLabel);
         frame.add(sidesField);
         frame.add(colorCombo);
         frame.setVisible(true);
    }
}
