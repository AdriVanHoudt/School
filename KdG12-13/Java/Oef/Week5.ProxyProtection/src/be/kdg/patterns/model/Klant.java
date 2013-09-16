package be.kdg.patterns.model;

/**
 * Hier hoef je niets te wijzigen.
 */
public interface Klant {
    double getSaldo();

    void doeStorting(double bedrag);

    void haalAf(double bedrag);

    void schrijfOver(double bedrag, String rekeningNummer);

    void wijzigWachtwoord();
}
