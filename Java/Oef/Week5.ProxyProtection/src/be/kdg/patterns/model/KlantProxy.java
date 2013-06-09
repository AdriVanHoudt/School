										package be.kdg.patterns.model;

import be.kdg.patterns.data.User;

/**
 * Vul aan waar nodig (security proxy pattern)
 */
public class KlantProxy implements Klant {
    private final KlantImpl klant;

    /**
     * Deze constructor maakt een KlantImpl object aan, maar alleen
     * als het rekeningnummer bestaat en het bijhorende wachtwoord correct
     * wordt ingegeven (anders wordt een foutmelding gegeven en wordt de uitvoering
     * van het programma via System.exit(1) afgebroken.
     *  Maakt gebruik van de methode autenticate (zie verder).
     *
     * @param naam De naam van de klant
     * @param rekeningNummer Het rekeningnummer van de klant
     */
    public KlantProxy(String naam, String rekeningNummer) {
        if (!autenticate(rekeningNummer)) {
            System.out.println("Login fout, geen toegang!");
            System.exit(1);
        }
        klant = new KlantImpl(naam, rekeningNummer);
    }

    public double getSaldo() {
        return 0; // vul aan
    }

    public void doeStorting(double bedrag) {
        // vul aan
    }

    public void haalAf(double bedrag) {
        // vul aan
    }

    public void schrijfOver(double bedrag, String rekeningNummer) {
        // vul aan
    }

    /**
     * Deze methode haalt uit Users eerst het user object op met het overeenstemmende
     * rekeningnummer. Indien dit gevonden wordt dan wordt het wachtwoord gevraagd
     * (via de overeenstemmende methode in de klasse User).
     *
     * @param rekeningNummer Het rekeningnummer van de klant.
     * @return true als de user bestaat en het juiste wachtwoord ingegeven heeft.
     */
    private boolean autenticate(String rekeningNummer) {
        return false; // vul aan        
    }

    private User getUser(String rekeningNummer) {
        // vul aan, roep deze methode op bij de methode autenticate
        return null;
    }

    public void wijzigWachtwoord() {
        // vul aan
    }

}
