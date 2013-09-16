package observer.view;

import observer.model.Croque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class BetaalPanel extends JPanel {
    private final Croque croque;
    private JRadioButton contant;
    private JRadioButton proton;
    private JRadioButton bancontact;

    public BetaalPanel(Croque croque) {
        this.croque = croque;

        maakComponenten();
        maakLayout();
        voegListenersToe();
    }

    private void maakComponenten() {
        contant = new JRadioButton("Contant", true);
        proton = new JRadioButton("Proton");
        bancontact = new JRadioButton("Bancontact");
        ButtonGroup betaling = new ButtonGroup();
        betaling.add(contant);
        betaling.add(proton);
        betaling.add(bancontact);
    }

    private void maakLayout() {
        setLayout(new GridLayout(0, 1));
        add(contant);
        add(proton);
        add(bancontact);
    }

    private void voegListenersToe() {
        contant.addItemListener(new BetaalListener());
        proton.addItemListener(new BetaalListener());
        bancontact.addItemListener(new BetaalListener());
    }

    private class BetaalListener implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                JRadioButton button = (JRadioButton) event.getSource();
                croque.setBetaalWijze(button.getActionCommand());
            }
        }
    }
}
