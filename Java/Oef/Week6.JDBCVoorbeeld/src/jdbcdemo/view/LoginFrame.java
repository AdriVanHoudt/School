package jdbcdemo.view;

import jdbcdemo.data.GebruikersDAO;
import jdbcdemo.model.Gebruikers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel errorLabel;

    public LoginFrame() {
        super("Database Login");
        maakComponenten();
        maakLayout();
        voegListenersToe();
        toonFrame();
    }

    private void maakComponenten() {
        userLabel = new JLabel("Gebruikersnaam: ", JLabel.RIGHT);
        passwordLabel = new JLabel("Wachtwoord: ", JLabel.RIGHT);
        userField = new JTextField(16);
        passwordField = new JPasswordField(16);
        loginButton = new JButton("Login");
        errorLabel = new JLabel(" ", JLabel.CENTER);
    }

    private void maakLayout() {
        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        inputPanel.add(userLabel);
        inputPanel.add(userField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);

        JPanel errorPanel = new JPanel();
        errorPanel.add(errorLabel);

        add(errorPanel, BorderLayout.PAGE_START);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.PAGE_END);
    }

    private void voegListenersToe() {
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String gebruikersnaam = userField.getText();
                char[] wachtwoord = passwordField.getPassword();

                GebruikersDAO dao = GebruikersDAO.getInstance();
                if (dao.isGeldigeGebruiker(gebruikersnaam, wachtwoord)) {
                    errorLabel.setText(" ");
                    userField.setText("");
                    passwordField.setText("");
                    Gebruikers gebruikers = new Gebruikers(dao.getGebruikers());
                    new GebruikersFrame(gebruikers);
                } else {
                    errorLabel.setText("Foutieve login, probeer opnieuw!");
                }
                // GebruikersDAO.flushDAO();
            }
        });
    }

    private void toonFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(this);
        setVisible(true);
    }
}
