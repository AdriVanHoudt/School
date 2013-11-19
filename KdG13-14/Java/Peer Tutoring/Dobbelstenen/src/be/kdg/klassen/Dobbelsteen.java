package be.kdg.klassen;

import java.util.Random;

/**
 * @author Kristiaan Behiels
 * @version 1.0 10/10/13
 */
public class Dobbelsteen {
    private static final Random RANDOM = new Random();

    public int werpDobbelsteen() {
        return RANDOM.nextInt(6) + 1;
    }


}
