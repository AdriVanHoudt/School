package jdbcdemo.model;

public class Gebruiker {
    private int sleutel;
    private String voornaam;
    private String familienaam;
    private String gebruikersnaam;
    private String wachtwoord;

    public Gebruiker(int sleutel, String voornaam, String familienaam,
                     String gebruikersnaam, String wachtwoord) {
        this.sleutel = sleutel;
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public int getSleutel() {
        return sleutel;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Gebruiker gebruiker = (Gebruiker) object;
        return sleutel != gebruiker.sleutel;

    }

    public int hashCode() {
        return sleutel;
    }

    public String toString() {
        return "Gebruiker{" +
                "sleutel=" + sleutel +
                ", voornaam='" + voornaam + '\'' +
                ", familienaam='" + familienaam + '\'' +
                ", gebruikersnaam='" + gebruikersnaam + '\'' +
                ", wachtwoord='" + wachtwoord + '\'' +
                '}';
    }
}
