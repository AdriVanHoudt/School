package wijnen;

/**
 * PEER opdracht
 * P2W2
 */
public class WijnHuis {
    private static final int MAX_AANTAL = 10;
    private Wijn[] wijnen = new Wijn[MAX_AANTAL];  //voorlopig gevuld met 10 null-objecten
    private String naam; //de naam van het wijnhuis
    private int aantal = 0;  //het werkelijke aantal elementen in de array

    public WijnHuis(String naam) {
        this.naam = naam;
    }

    public boolean zoekWijn(Wijn wijn) {
        //Opgave 5.1  done

        for (Wijn w : wijnen) {
            if (w != null && w.getNaam().equals(wijn.getNaam())) {
                return true;
            }
        }
        return false;
    }

    public void voegWijnToe(Wijn nieuw) {
        //Opgave 5.2 done

        if (!zoekWijn(nieuw) && aantal <= 9) {
            wijnen[aantal++] = nieuw;
        }
    }

    @Override
    public String toString() {
        String str = "Wijnhuis " + naam.toUpperCase() + ":\n";
        //Opgave 5.3
        for(Wijn w : wijnen){
            str += w.toString() + "\n";
        }
        return str;
    }
}
