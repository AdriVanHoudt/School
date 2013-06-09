package be.kdg.nederlands;

import be.kdg.english.Address;
import be.kdg.english.Person;

/**
 * Vul de klassen Adres en Persoon op de juiste manier aan zodat je
 * een uitvoer zoals hieronder bekomt. Maak gebruik van het Class-adapter pattern.
 */
public class RunNederlandsDemo {
    public static void main(String[] args) {
       Adres adres = new Adres("Hoogstraat 17", 2000, "Antwerpen");
       Persoon persoon = new Persoon("Jan Peeters", adres);

       System.out.println(persoon);
    }
}

/*
Jan Peeters
Hoogstraat 17
2000 Antwerpen
*/