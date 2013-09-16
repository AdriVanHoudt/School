package calc.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import calc.model.CalculatorModel;
import calc.view.CalculatorView;

public class CalculatorController implements Observer {
    private CalculatorModel model;
    private CalculatorView view;

    // werk hier de constructor uit
    public CalculatorController(CalculatorModel model, CalculatorView view) {
    	this.model = model;
    	this.view = view;
    	
    	view.addMultiplyListener(new MultiplyListener());
    	view.addClearListener(new ClearListener());
    }

    // werk hier de inner class MultiplyListener uit
    private class MultiplyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{
				model.multiplyBy(view.getUserInput());
				view.setTotalField(model.getValue());
			}catch(NumberFormatException e){
				view.showError("Bad user input: "+ view.getUserInput());
			}
			
		}


    }

    // werk hier de inner class ClearListener uit
    private class ClearListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			model.reset();
			view.reset();
			
		}

        }

	@Override
	public void update(Observable o, Object arg) {
		CalculatorModel m = (CalculatorModel) o;
		
	}
    }

