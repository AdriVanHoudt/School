package calc.view;


import javax.swing.*;

import calc.model.CalculatorModel;

import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private static final String INITIAL_VALUE = "1";

    private JTextField inputField = new JTextField(5);
    private JTextField totalField = new JTextField(20);
    private JButton multiplyButton = new JButton("Multiply");
    private JButton clearButton = new JButton("Clear");
    private JLabel inputLabel = new JLabel("Input");
    private JLabel totalLabel = new JLabel("Total");

    // werk hier de constructor uit
   
    public CalculatorView(CalculatorModel model) {
    	FlowLayout pom = new FlowLayout();
    	JPanel panel = new JPanel(pom);
    	panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panel.add(inputLabel); 
        panel.add(inputField);
        panel.add(multiplyButton);
        panel.add(totalLabel);
        this.totalField.setEditable(false);
        this.totalField.setText(INITIAL_VALUE);
        panel.add(totalField);
        panel.add(clearButton);
        add(panel);
        pack();
        Dimension dimension = this.getToolkit().getScreenSize();
        setLocation((dimension.width - this.getSize().width) / 2, (dimension.height - this.getSize().height) / 2);

        setTitle("Simple Calculator - MVC");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // werk de volgende methoden uit
    public void reset() {
    	this.totalField.setText(INITIAL_VALUE);
    }

    public String getUserInput() {
         return this.inputField.getText();
    }

    public void setTotalField(String newTotal) {
    	this.totalField.setText(newTotal);
    }

    public void showError(String errMessage) {
    	JOptionPane.showMessageDialog(this,errMessage);
    }

    public void addMultiplyListener(ActionListener mal) {
    	this.multiplyButton.addActionListener(mal);
    }
    	
    public void addClearListener(ActionListener cal) {
    	this.clearButton.addActionListener(cal);
    }
}

