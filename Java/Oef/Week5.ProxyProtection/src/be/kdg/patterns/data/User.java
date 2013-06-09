package be.kdg.patterns.data;

import java.util.Scanner;

/**
 * Vul in deze klasse de methoden autenticate en wijzigWachtwoord aan.
 * Maak bij voorkeur gebruik van een Scanner voor het inlezen.
 */
public class User {
    private final String rekeningNummer;
    private String wachtwoord;

    public User(String rekeningNummer, String wachtwoord) {
        this.rekeningNummer = rekeningNummer;
        this.wachtwoord = wachtwoord;
    }

    public String getRekeningNummer() {
        return rekeningNummer;
    }

    /**
     * In deze methode wordt aan de gebruiker gevraagd om zijn/haar
     * wachtwoord in te geven.
     *
     * @return boolean true als het wachtwoord overeenstemt.
     */
    public boolean autenticate() {
        return false;
    }

    /**
     * Met behulp van deze methode wordt de gebruiker de mogelijkheid gegeven
     * zijn/haar wachtwoord te wijzigen. Voorzie een controle op het nieuwe
     * wachtwoord door het tweemaal te vragen. Het wachtwoord wordt slechts aangepast
     * als beide ingaven voor het nieuwe wachtwoord overeenstemmen.
     */
    public void wijzigWachtwoord() {

    }
}
