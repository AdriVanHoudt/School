package be.kdg.klassen;

/**
 * @author Kristiaan Behiels
 * @version 1.0 10/10/13
 */
public class Dobbelstenen {

    private Dobbelsteen steenEen;
    private Dobbelsteen steenTwee;
    private Dobbelsteen steenDrie;
    private static int AANTAL_WORPEN;
    private int[] worpen;


    public Dobbelstenen(int aantal) {
        AANTAL_WORPEN = aantal;
        worpen = new int[AANTAL_WORPEN];
        steenEen = new Dobbelsteen();
        steenTwee = new Dobbelsteen();
        steenDrie = new Dobbelsteen();
    }

    public void werpDobbelsteen() {
        for(int i = 0; i <AANTAL_WORPEN; i++){
            worpen[i] = steenEen.werpDobbelsteen();
        }
    }

    public void werpTweeDobbelstenen() {
        for(int i = 0; i <AANTAL_WORPEN; i++){
            worpen[i] = steenEen.werpDobbelsteen() + steenTwee.werpDobbelsteen();
        }
    }

    public void werpDrieDobbelstenen() {
        for(int i = 0; i <AANTAL_WORPEN; i++){
            worpen[i] = steenEen.werpDobbelsteen() + steenTwee.werpDobbelsteen() + steenDrie.werpDobbelsteen();
        }
    }

    private double som = 0.0;
    private double berekenGemiddelde(){
        return ((som * 1.0) / AANTAL_WORPEN);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < AANTAL_WORPEN; i++) {
            som += worpen[i];
            result += String.format("%2d ", worpen[i]);
            if ((i + 1)  % 10 == 0) {
                result += String.format("\n");
            }
        }

        result += String.format("Het gemiddelde is %.2f", berekenGemiddelde());
        result += String.format("\n");

        return  result;
    }
}
