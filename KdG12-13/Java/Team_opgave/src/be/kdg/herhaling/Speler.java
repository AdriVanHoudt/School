package be.kdg.herhaling;

public class Speler implements Comparable<Speler> {
    private int rugNummer;
    private String naam;
    private Adres adres;

    // 2.1 Maak beide constructors + een getter voor het rugNummer
    public Speler(int rugnummer, String naam, Adres adres){
    	this.rugNummer = rugnummer;
    	this.naam = naam;
    	this.adres = adres;
    }
    
    public Speler(int rugnummer, String naam, String straat, int postnummer, String gemeente){
    	this(rugnummer, naam, new Adres(straat, postnummer, gemeente));
    }
    // 2.2 Override de toString methode (zie gewenste uitvoer - werk met kolommen)
    public String toString(){
		return String.format("%-3d%-20s%-20s", this.rugNummer, this.naam, this.adres.toString());
    }
    
	public int getRugNummer() {
		return rugNummer;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rugNummer;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		return true;
	}

	public int compareTo(Speler o) {
		Speler other = (Speler) o;
		if (rugNummer != other.rugNummer)
			return 0;
		return 1;
	}

}
