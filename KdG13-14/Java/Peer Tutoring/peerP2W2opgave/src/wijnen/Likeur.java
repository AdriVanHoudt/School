package wijnen;

/**
 * PEER opdracht
 * P2W2
 */
public class Likeur extends Wijn {
    private double alcoholGehalte; //in procent

    //Opdracht 2.1 done

    public Likeur(String naam, String streek, int jaar, double basisPrijs, double alcoholGehalte) {
        super(naam, streek, jaar, basisPrijs);
        this.alcoholGehalte = alcoholGehalte;
    }


    //Opdracht 2.2 done

    @Override
    public double berekenPrijs() {
        if(alcoholGehalte > 0.5){
            return super.berekenPrijs() * 1.25;
        }
        return super.berekenPrijs();
    }


    //Opdracht 2.3 done

    @Override
    public String toString() {
        return String.format("%s --> %.0f%% alc", super.toString(), alcoholGehalte * 100);
    }
}
