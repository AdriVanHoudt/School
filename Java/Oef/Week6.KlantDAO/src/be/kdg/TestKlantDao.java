package be.kdg;

import be.kdg.patterns.Klant;
import be.kdg.patterns.KlantDao;

import java.util.Set;

/**
 * Deze klasse dient om te testen of je de klasse KlantDao goed hebt uitgewerkt.
 * Zie de verwachte uitvoer onderaan.
 */
public class TestKlantDao {
    public static void main(String[] args) {
        KlantDao klantDao = new KlantDao("jdbc:hsqldb:db/mijnDatabase");

        // maak een nieuw klant-object
        Klant klant = new Klant("ikke", "ikke@hotmail.com");
        System.out.println("klant = " + klant);

        // creëer het klant-object in de database zodat er ook een id is.
        boolean resultaat = klantDao.create(klant);
        System.out.println("klant toegevoegd:");
        System.out.println("resultaat = " + resultaat);
        System.out.println("klant = " + klant);

        // voeg nog drie klanten toe
        klant = new Klant("ikke", "ikke@blabla.com");
        klantDao.create(klant);
        klant = new Klant("gij", "gij@gmail.com");
        klantDao.create(klant);
        klant = new Klant("ikke", "wij@gmail.com");
        klantDao.create(klant);

        // haal de klant mt id=3 op
        klant = klantDao.retrieve(3);
        System.out.println("\nopgevraagde klant = " + klant);

        // haal alle klanten met naam 'ikke' op
        Set<Klant> ikkeKlanten = klantDao.retrieveByName("ikke");
        System.out.println();
        for (Klant ikkeKlant : ikkeKlanten) {
            System.out.println("ikkeKlant = " + ikkeKlant);
        }

        // verander de naam van klant met id=3 naar 'haha'
        klant.setNaam("haha");
        resultaat = klantDao.update(klant);
        System.out.println("\nresultaat = " + resultaat);

        // haal alle klanten met naam 'ikke' op
        ikkeKlanten = klantDao.retrieveByName("ikke");
        System.out.println();
        for (Klant ikkeKlant : ikkeKlanten) {
            System.out.println("ikkeKlant = " + ikkeKlant);
        }

        // verwijder de klant met id=0
        klantDao.delete(0);
        ikkeKlanten = klantDao.retrieveByName("ikke");
        System.out.println();
        for (Klant ikkeKlant : ikkeKlanten) {
            System.out.println("ikkeKlant = " + ikkeKlant);
        }

        // haal alle klanten met naam 'haha' op
        Set<Klant> hahaKlanten = klantDao.retrieveByName("haha");
        System.out.println();
        for (Klant hahaKlant : hahaKlanten) {
            System.out.println("hahaKlant = " + hahaKlant);
        }

        // haal alle klanten op en druk ze gesorteerd op id af:
        System.out.println("\nVOOR clear:");
        for(Klant kl : klantDao.retrieveAll()) {
            System.out.println(kl);
        }

        //testClear:
        klantDao.clear();
        System.out.println("\nNA clear:");
        for(Klant kl : klantDao.retrieveAll()) {
            System.out.println(kl);
        }
        System.out.println("\nEinde test");

        // sluit de database
        klantDao.close();
    }
}
// Verwachte uitvoer
/*
klant = Klant[-1, ikke, ikke@hotmail.com]
klant toegevoegd:
resultaat = true
klant = Klant[0, ikke, ikke@hotmail.com]

opgevraagde klant = Klant[3, ikke, wij@gmail.com]

ikkeKlant = Klant[0, ikke, ikke@hotmail.com]
ikkeKlant = Klant[1, ikke, ikke@blabla.com]
ikkeKlant = Klant[3, ikke, wij@gmail.com]

resultaat = true

ikkeKlant = Klant[0, ikke, ikke@hotmail.com]
ikkeKlant = Klant[1, ikke, ikke@blabla.com]

ikkeKlant = Klant[1, ikke, ikke@blabla.com]

hahaKlant = Klant[3, haha, wij@gmail.com]

VOOR clear:
Klant[1, ikke, ikke@blabla.com]
Klant[2, gij, gij@gmail.com]
Klant[3, haha, wij@gmail.com]

NA clear:

Einde test
*/