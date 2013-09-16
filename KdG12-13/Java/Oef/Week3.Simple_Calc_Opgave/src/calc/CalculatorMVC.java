package calc;

import calc.controller.CalculatorController;
import calc.model.CalculatorModel;
import calc.view.CalculatorView;

public class CalculatorMVC {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView(model);
        new CalculatorController(model, view);

        view.setVisible(true);
    }
}

