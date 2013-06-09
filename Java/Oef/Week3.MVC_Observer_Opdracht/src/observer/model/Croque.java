package observer.model;

import java.util.Observable;

// Deze klasse wordt geobserveerd!
public class Croque extends Observable {
    private static final int BASIS_PRIJS = 200;
    private static final int KAAS_PRIJS = 50;
    private static final int HAM_PRIJS = 60;
    private static final int ANANAS_PRIJS = 30;

    private boolean metKaas = false;
    private boolean metHam = false;
    private boolean metAnanas = false;

    private String betaalWijze = "Contant";

    public String getBetaalWijze() {
        return betaalWijze;
    }

    public void setBetaalWijze(String wijze) {
        betaalWijze = wijze;
        setChanged();
        notifyObservers();
    }

    public void setMetKaas(boolean kaas) {
        metKaas = kaas;
        setChanged();
        notifyObservers();
    }

    public void setMetHam(boolean ham) {
        metHam = ham;
        setChanged();
        notifyObservers();
    }

    public void setMetAnanas(boolean ananas) {
        metAnanas = ananas;
        setChanged();
        notifyObservers();
    }

    public String teBetalen() {
        int teBetalen = BASIS_PRIJS;

        if (metKaas) {
            teBetalen += KAAS_PRIJS;
        }
        if (metHam) {
            teBetalen += HAM_PRIJS;
        }
        if (metAnanas) {
            teBetalen += ANANAS_PRIJS;
        }
        return Double.toString((double) teBetalen / 100);
    }

}
