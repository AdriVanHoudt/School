/**
 * Voorbeeld van Test Driven Development.
 *
 * Opdracht: Schrijf de klasse Punt zodanig dat alle testen succesvol zijn.
 * Werkt test na test af, zet de nog niet uitgewerkte andere testen voorlopig in commentaar.
 */


import org.junit.Test;
import org.junit.Before;

import demo.Punt;


import static org.junit.Assert.*;

/**
 * Testklasse voor de ontwikkeling van de klasse Punt.
 * De klasse Punt bevat de x en y coordinaten van een punt.
 */
public class TestPunt {
    private Punt pOne;
    private Punt pTwo;
    private Punt pThree;
    private Punt pFour;

    @Before
    public void setUp() {
        pOne = new Punt(1, 2);
        pTwo = new Punt(2, 1);
        pThree = new Punt(1, 1);
        pFour = new Punt(3, 2);
    }

    /**
     * Test de equals methode.
     * Vergelijking tussen twee Punt objecten (coordinaten moeten overeenstemmen).
     */
    @Test
    public void testEqual() {
        assertTrue("Must be equal", pOne.equals(new Punt(1, 2)));
        assertFalse("Must be unequal", pOne.equals(pTwo));
        assertFalse("Must be unequal", pOne.equals("1, 2"));
    }

    /**
     * Test de hashcode methode.
     * De hashcode is op basis van beide coordinaten.
     */
    @Test
    public void testHashcode() {
        int codeOne = pOne.hashCode();
        int codeTwo = pTwo.hashCode();
        assertFalse("Hashcode must be different", codeOne == codeTwo);
        assertTrue("Hashcode must be equal", codeOne == pOne.hashCode());
    }

   /**
     * Test de methode distance.
     * Dit is de afstand tussen twee punten.
     */
    @Test
    public void testDistance() {
        double dist = Math.sqrt(5);
        assertEquals("Distance must be sqrt(5)", dist, pThree.distance(pFour), 1e-7);

        dist = Math.sqrt(2);
        assertEquals("Distance must be sqrt(2)", dist, pOne.distance(pTwo), 1e-7);
    }



    /**
     * Test de methode distanceToCenter.
     * Dit is de afstand van het punt tot het nulpunt (coordinaten 0,0).
     */
    @Test
    public void testDistanceToCenter() {
        double distOne = pOne.distanceToCenter();
        double distTwo = pTwo.distanceToCenter();
        assertEquals("Distance must be sqrt(5)", distOne, Math.sqrt(5), 1e-7);
        assertTrue("Distances must be equal", distOne == distTwo);
    }

    /**
     * Test de compare methode.
     * Deze methode vergelijkt de afstanden tot het nulpunt.
     */
    @Test
    public void testCompare() {
       assertTrue("Result must be 0", pOne.compareTo(pTwo) == 0);
       assertTrue("Result must be < 0", pOne.compareTo(pFour) < 0);
       assertTrue("Result must be > 0", pOne.compareTo(pThree) > 0);
    }
}