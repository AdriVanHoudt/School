package observer.view;

import observer.model.Croque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class ToppingPanel extends JPanel {
    private final Croque croque;
    private JCheckBox kaas;
    private JCheckBox ham;
    private JCheckBox ananas;

    public ToppingPanel(Croque croque) {
        this.croque = croque;

        maakComponenten();
        maakLayout();
        voegListenersToe();
    }

    private void maakComponenten() {
        kaas = new JCheckBox("Kaas");
        ham = new JCheckBox("Ham");
        ananas = new JCheckBox("Ananas");
        kaas.setBackground(Color.LIGHT_GRAY);
        ham.setBackground(Color.LIGHT_GRAY);
        ananas.setBackground(Color.LIGHT_GRAY);
    }

    private void maakLayout() {
        setLayout(new GridLayout(0, 1));
        add(kaas);
        add(ham);
        add(ananas);
    }

    private void voegListenersToe() {
        kaas.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    croque.setMetKaas(true);
                } else {
                    croque.setMetKaas(false);
                }
            }
        });
        ham.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    croque.setMetHam(true);
                } else {
                    croque.setMetHam(false);
                }
            }
        });
        ananas.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    croque.setMetAnanas(true);
                } else {
                    croque.setMetAnanas(false);
                }
            }
        });
    }
}
