import wijnen.*;

/**
 * Mark Goovaerts
 * Datum: 4-11-13
 */
public class DemoWijnen {
    public static void main(String[] args) {

        //Controle na deel 1:
        //enkele testwijnen aanmaken:
        Wijn w1 = new Wijn("Gelso Nero", "Puglia", 2010, 9.95);
        Wijn w2 = new Wijn("Barbera di Alba", "Piemonte", 2012, 10.50);
        Wijn w3 = new Wijn("Gelso di Oro", "Puglia", 2010, 22);
        Wijn w4 = new Wijn("Toscana Rosso", "Toscana", 2010, 6.95);
        Wijn w5 = new Wijn("Montefreddo", "Emilia Romagna", 2011, 8.95);

        //toString oproepen en afdrukken:
        System.out.println(w1.toString());


        //Controle na deel 2:
        Wijn w6 = new Likeur("Amaretto", "Italia", 2004, 42.50, 0.29);
        Wijn w7 = new Likeur("Elixir d'Anvers", "Belgium", 2010, 32, 0.52);
        //toString oproepen en afdrukken:
        System.out.println(w7.toString());


        //Controle na deel 3 en 4:
        Wijn w8 = new Champagne("Lancelot Reserve", "Cramant", 2012, 18.20, Smaak.EXTRA_BRUT);
        Wijn w9 = new Champagne("Lancelot Chevalier", "Cramant", 2013, 17.60, Smaak.DEMI_SEC);
        Wijn w10 = new Champagne("Bandock Des Lys", "Reims", 2011, 17, Smaak.DOUX);
        Wijn w11 = new Wijn("Zuidflank", "Limburg", 2013, 21);
        //toString oproepen en afdrukken:
        System.out.println(w8.toString());


        //Controle na deel 5:
        //wijnhuis aanmaken:
        WijnHuis wh = new WijnHuis("Legras & Haas");

        //wijnhuis bevoorraden:
        wh.voegWijnToe(w1);
        wh.voegWijnToe(w2);
        wh.voegWijnToe(w3);
        wh.voegWijnToe(w4);
        wh.voegWijnToe(w5);
        wh.voegWijnToe(w6);
        wh.voegWijnToe(w7);
        wh.voegWijnToe(w8);
        wh.voegWijnToe(w9);
        wh.voegWijnToe(w10);
        wh.voegWijnToe(w11);

        //wijnen opzoeken:
        System.out.println("\nOp zoek naar wijnen:");
        System.out.println("Lancelot Chevalier: " + wh.zoekWijn(w9));
        System.out.println("Zuidflank: " + wh.zoekWijn(w11));

        //wijnhuis afdrukken:
        System.out.println();
        System.out.println(wh);

    }
}

/* Verwachte afdruk:
Gelso Nero           Puglia          2010     9,95 €
Elixir d'Anvers      Belgium         2010    40,00 € --> 52% alc
Lancelot Reserve     Cramant         2012    20,02 € --> Extra-brut

Op zoek naar wijnen:
Lancelot Chevalier: true
Zuidflank: false

Wijnhuis LEGRAS & HAAS:
Wijnen:
	Gelso Nero           Puglia          2010     9,95 €
	Barbera di Alba      Piemonte        2012    10,50 €
	Gelso di Oro         Puglia          2010    22,00 €
	Toscana Rosso        Toscana         2010     6,95 €
	Montefreddo          Emilia Romagna  2011     8,95 €
Champagnes:
	Lancelot Reserve     Cramant         2012    20,02 € --> Extra-brut
	Lancelot Chevalier   Cramant         2013    17,60 € --> Demi-sec
	Bandock Des Lys      Reims           2011    17,00 € --> Doux
Likeuren:
	Amaretto             Italia          2004    42,50 € --> 29% alc
	Elixir d'Anvers      Belgium         2010    40,00 € --> 52% alc
*/
