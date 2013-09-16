package observer.view;

import observer.model.Croque;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Deze klasse moet je aanvullen.
 * Zorg ervoor dat de informatie die in het prijspanel van het Croqueframe
 * getoond wordt in dit tweede frame ook zichtbaar is.
 */
public class CroqueFrameTwo extends JFrame implements Observer  {
    private final Croque croque;
    private JLabel titel;
    private JLabel teBetalen;
    private JLabel betaalWijze;
    private JTextField prijsField;

    public CroqueFrameTwo(Croque croque) {
        super("Croque Observer");
        this.croque = croque;
        
        maakComponenten();
        maakLayout();
        voegListenersToe();
        toonFrame();
    }

    private void maakComponenten() {
        titel = new JLabel("Gekozen Croque");
        titel.setFont(new Font("Dialog", Font.BOLD, 24));
        titel.setBackground(Color.ORANGE);
        titel.setOpaque(true);

        teBetalen = new JLabel("Te Betalen");
        betaalWijze = new JLabel("Contant");
        betaalWijze.setBackground(Color.CYAN);
        betaalWijze.setOpaque(true);
        prijsField = new JTextField(3);
        prijsField.setHorizontalAlignment(JTextField.RIGHT);
    }

    private void maakLayout() {
        JPanel prijsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        setBackground(Color.ORANGE);
        prijsPanel.add(betaalWijze);
        prijsPanel.add(teBetalen);
        prijsPanel.add(prijsField);

        add(titel, BorderLayout.PAGE_START);
        add(prijsPanel, BorderLayout.PAGE_END);
    }

    private void voegListenersToe() {
    	this.croque.addObserver(this);
    }

    private void toonFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500, 200, 400, 280);
        pack();
        setVisible(true);
    }

	@Override
	public void update(Observable model, Object arg1) {
		Croque croque = (Croque) model;
		this.prijsField.setText(croque.teBetalen());
		this.betaalWijze.setText(croque.getBetaalWijze());
	}

}
