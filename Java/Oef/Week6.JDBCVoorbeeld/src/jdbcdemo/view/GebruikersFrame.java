package jdbcdemo.view;

import jdbcdemo.model.Gebruikers;

import javax.swing.*;
import java.awt.*;

public class GebruikersFrame extends JFrame {
    private final Gebruikers gebruikers;
    private JScrollPane scrollPane;

    public GebruikersFrame(Gebruikers gebruikers) {
        this.gebruikers = gebruikers;
        setTitle("Gebruikers volgens familienaam");

        maakComponenten();
        maakLayout();
        toonFrame();
    }

    private void maakComponenten() {
        GebruikersTableModel model = new GebruikersTableModel(gebruikers);
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(400, 150));
        scrollPane = new JScrollPane(table);
    }

    private void maakLayout() {
        add(scrollPane, BorderLayout.CENTER);
    }

    private void toonFrame() {
        setBounds(400, 400, 0, 0);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        Dimension d = getToolkit().getScreenSize();
        setLocation((d.width - getSize().width) / 2,
                (d.height - getSize().height) / 2);
        setVisible(true);
    }
}
