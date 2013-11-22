package wijnen;

/**
 * PEER opdracht
 * P2W2
 */
public enum Smaak {
    //Opdracht 3.1  done
    BRUT, EXTRA_BRUT, BRUT_SANS_MILLESIME, SEC, DEMI_SEC, DOUX;

    //Opdracht 3.2 done
    @Override
    public String toString() {
       return this.name();
    }

}