package wijnen;

/**
 * PEER opdracht
 * P2W2
 */
public class Champagne extends Wijn{
    private Smaak smaak;


    //Opdracht 4.1 done
    public Champagne(String naam, String streek, int jaar, double basisPrijs, Smaak smaak) {
        super(naam, streek, jaar, basisPrijs);
        this.smaak = smaak;

    }

    //Opdracht 4.2    done

    @Override
    public double berekenPrijs() {
        if(smaak.toString().toLowerCase().contains("brut")){
            return super.berekenPrijs() * 1.1;
        }
        return super.berekenPrijs();
    }

    //Opdracht 4.3 done

    @Override
    public String toString() {
        return String.format("%s --> %s", super.toString(), smaak.toString());
    }
}
