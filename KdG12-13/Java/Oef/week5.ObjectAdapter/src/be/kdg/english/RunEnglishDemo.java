package be.kdg.english;

/**
 * Dit programma maakt gebruik van de klassen Address en Person.
 * Zie ook de klassen zelf en de uitvoer hieronder.
 *
 * Pas het Object-adapter pattern toe zodanig dat je bij uitvoering van
 * RunNederlandsDemo via de te schrijven klassen Adres en Persoon gebruik
 * maakt van de reeds bestaande klassen Address en Person en van de interfaces
 * AdresInterface en PersoonInterface. 
 */
public class RunEnglishDemo {
    public static void main(String[] args) {
        Address address = new Address("1156 High Street", "Santa Cruz", "CA 95064", "California");
        Person person = new Person("John Smith", address);

        System.out.println(person);
    }

}

/*
John Smith
1156 High Street
Santa Cruz
CA 95064
California
*/
