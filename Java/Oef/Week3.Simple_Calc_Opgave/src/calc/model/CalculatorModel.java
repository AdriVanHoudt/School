package calc.model;

/**
 * @author Kristiaan Behiels
 * @version 1.0 22-nov-2009
 */

import java.math.BigInteger;
import java.util.Observable;

public class CalculatorModel extends Observable{
    private static final String INITIAL_VALUE = "1";

    private BigInteger total;  

    public CalculatorModel() {
        reset();
    }

    public void reset() {
        total = new BigInteger(INITIAL_VALUE);
    }

    public void multiplyBy(String operand) {
        total = total.multiply(new BigInteger(operand));
        this.setChanged();
        this.notifyObservers();
    }

    public void setValue(String value) {
        total = new BigInteger(value);
        this.setChanged();
        this.notifyObservers();
    }

    public String getValue() {
        return total.toString();
    }
}

