package be.kdg.patterns.model;

/**
 * De originele Klant klasse. Hier hoef je niets te wijzigen.
 */
public class KlantImpl implements Klant {
    private final String naam;
    private final String rekeningNummer;
    private double saldo;

    public KlantImpl(String naam, String rekeningNummer) {
        this.naam = naam;
        this.rekeningNummer = rekeningNummer;
    }

    public String getNaam() {
        return naam;
    }

    public String getRekeningNummer() {
        return rekeningNummer;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isSaldoToereikend(double bedrag) {
        return saldo - bedrag >= 0;
    }

    public void doeStorting(double bedrag) {
        saldo += bedrag;
    }

    public void haalAf(double bedrag) {
        if (isSaldoToereikend(bedrag)) {
            saldo -= bedrag;
        }
    }

    public void schrijfOver(double bedrag, String rekeningNummer) {
        // Doe niets, gebeurt in proxy
    }

    public void wijzigWachtwoord() {
        // Doe niets, gebeurt in proxy.
    }
}
