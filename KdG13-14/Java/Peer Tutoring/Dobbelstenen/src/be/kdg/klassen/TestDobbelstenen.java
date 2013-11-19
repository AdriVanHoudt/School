package be.kdg.klassen;

/**
 * @author Kristiaan Behiels
 * @version 1.0 10/10/13
 */
public class TestDobbelstenen {

    private static final int AANTAL_WORPEN = 100;
    private static final int AANTAL_PER_REGEL = 10;

    public static void main(String[] args) {

        Dobbelstenen stenen = new Dobbelstenen(AANTAL_WORPEN);

        System.out.println(AANTAL_WORPEN + " worpen met 1 dobbelsteen:\n");
        stenen.werpDobbelsteen();
        System.out.println(stenen);

        System.out.println(AANTAL_WORPEN + " worpen met 2 dobbelsteen:\n");
        stenen.werpTweeDobbelstenen();
        System.out.println(stenen);

        System.out.println(AANTAL_WORPEN + " worpen met 3 dobbelsteen:\n");
        stenen.werpDrieDobbelstenen();
        System.out.println(stenen);

    }
}