package be.kdg;

import be.kdg.herhaling.Adres;
import be.kdg.herhaling.Speler;

public class TestSpeler {
   
    public static void main(String[] args) {
        Speler eenSpeler = new Speler(10, "Cornelis Clem", "Nationalestraat 5", 2000, "Antwerpen");
        Speler nogEenSpeler = new Speler(7, "Gils Jos", new Adres("Kouterdreef 181", 2970, "Schilde"));

        System.out.println(eenSpeler);
        System.out.println(nogEenSpeler);
    }
    
}

/*
10 Cornelis Clem        Nationalestraat 5    2000 Antwerpen
 7 Gils Jos             Kouterdreef 181      2970 Schilde
*/