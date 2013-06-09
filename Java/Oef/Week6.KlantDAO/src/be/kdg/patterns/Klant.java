package be.kdg.patterns;

/**
 * Deze klasse bevat de gegevens van 1 klant.
 * Ze wordt gebruikt, samen met de KlantDao.
 * Hier moet je in principe niets veranderen.
 */
public class Klant {
    private int id;
    private String naam;
    private String email;

    /**
     * Creëert een klant a.d.h. van de naam en het emailadres.
     *
     * @param naam de naam van de nieuwe klant
     * @param email het email adres van de nieuwe klant
     */
    public Klant(String naam, String email) {
        this(-1, naam, email);
    }

    /**
     * Creëert een klant a.d.h. van een id, een naam en een email adres.
     * Deze constructor wordt normaal enkel gebruikt door de KlantDao.
     * Vandaar dat deze functie package private gedeclareerd is.
     *
     * @param id een uniek nummer dat deze klant identificeert
     * @param naam de naam van de nieuwe klant
     * @param email het email adres van de nieuwe klant
     */
    Klant(int id, String naam, String email) {
        this.id = id;
        this.naam = naam;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getEmail() {
        return email;
    }

    void setId(int id) {
        this.id = id;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Klant[" + id + ", " + naam + ", " + email + "]";
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Klant)) return false;

        final Klant klant = (Klant) object;
        return id == klant.id;
    }

    public int hashCode() {
        return id;
    }
}
