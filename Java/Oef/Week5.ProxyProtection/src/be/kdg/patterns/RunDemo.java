package be.kdg.patterns;

import be.kdg.patterns.model.Klant;
import be.kdg.patterns.model.KlantProxy;

/**
 * Vul in de overige klassen aan waar nodig zodanig dat je bij het
 * uitvoeren van dit programma de onderstaande uitvoer kunt reproduceren.
 *
 * Start met het aanpassen van de klasse Users (singleton pattern).
 */
public class RunDemo {
    public static void main(String[] args) {
        Klant proxy = new KlantProxy("Jos Bellens", "BE01-0012-3456-7890");

        proxy.doeStorting(20000);
        System.out.println("saldo = " + proxy.getSaldo());

        proxy.haalAf(5000);
        System.out.println("saldo = " + proxy.getSaldo());

        proxy.schrijfOver(10000, "BE01-0012-3456-7890");
        System.out.println("saldo = " + proxy.getSaldo());

        proxy.schrijfOver(10000, "BE01-0012-3456-7890");
        System.out.println("saldo = " + proxy.getSaldo());

        proxy.schrijfOver(1000, "BE11-0012-3456-7890");
        System.out.println("saldo = " + proxy.getSaldo());
        
        proxy.wijzigWachtwoord();
    }
}

// Demo Run 1:
/*
Geef wachtwoord: matrxi
Login fout, geen toegang!
*/

// Demo Run 2:
/*
Geef wachtwoord: matrix
saldo = 20000.0
saldo = 15000.0
Overschrijving uitgevoerd.
saldo = 5000.0
Overschrijving: ontoereikend saldo.
saldo = 5000.0
Overschrijving: ongeldig rekeningnummer.
saldo = 5000.0
Oud wachtwoord: matrix
Nieuw wachtwoord: goose
Herhaal nieuw wachtwoord: goose
Wachtwoord aangepast
*/