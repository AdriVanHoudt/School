package observer.view;


import observer.model.Croque;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

class PrijsPanel extends JPanel implements Observer {
    private JLabel teBetalen;
    private JLabel betaalWijze;
    private JTextField prijsField;

    public PrijsPanel(Croque croque) {
        maakComponenten();
        maakLayout();
        vulPrijsIn(croque);
    }

    private void maakComponenten() {
        teBetalen = new JLabel("Te Betalen");
        betaalWijze = new JLabel("Contant");
        betaalWijze.setBackground(Color.CYAN);
        betaalWijze.setOpaque(true);
        prijsField = new JTextField(3);
        prijsField.setHorizontalAlignment(JTextField.RIGHT);
    }

    private void maakLayout() {
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setBackground(Color.ORANGE);
        add(betaalWijze);
        add(teBetalen);
        add(prijsField);
    }

    public void update(Observable object, Object arg) {
        Croque croque = (Croque) object;
        String wijze = croque.getBetaalWijze();
        betaalWijze.setText(wijze);
        vulPrijsIn(croque);
    }

    private void vulPrijsIn(Croque croque) {
        String teBetalen = croque.teBetalen();
        prijsField.setText(teBetalen);
    }
}
