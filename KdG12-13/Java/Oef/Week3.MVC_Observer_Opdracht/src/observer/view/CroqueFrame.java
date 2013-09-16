package observer.view;

import observer.model.Croque;

import javax.swing.*;
import java.awt.*;

public class CroqueFrame extends JFrame {
    private final Croque croque;
    private JLabel titel;
    private PrijsPanel prijsPanel;
    private ToppingPanel toppingPanel;
    private BetaalPanel betaalPanel;

    public CroqueFrame(Croque croque) {
        super("Croque Observer");
        this.croque = croque;

        maakComponenten();
        maakLayout();
        voegListenersToe();
        toonFrame();
    }

    private void maakComponenten() {
        titel = new JLabel("Kies je croque");
        titel.setFont(new Font("Dialog", Font.BOLD, 24));
        titel.setBackground(Color.ORANGE);
        titel.setOpaque(true);
        prijsPanel = new PrijsPanel(croque);
        toppingPanel = new ToppingPanel(croque);
        betaalPanel = new BetaalPanel(croque);
    }

    private void maakLayout() {
        JPanel keuzePanel = new JPanel(new GridLayout(0, 2));
        keuzePanel.add(toppingPanel);
        keuzePanel.add(betaalPanel);
        add(titel, BorderLayout.PAGE_START);
        add(keuzePanel, BorderLayout.CENTER);
        add(prijsPanel, BorderLayout.PAGE_END);
    }

    private void voegListenersToe() {
        croque.addObserver(prijsPanel);
    }

    private void toonFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 200, 400, 280);
        pack();
        setVisible(true);
    }
}
