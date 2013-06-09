package be.kdg.herhaling;

public class Adres {
    private String straat;
    private int postNummer;
    private String gemeente;

    // 1.1 Maak de constructor + getters
    public Adres(String straat, int postnummer, String gemeente){
    	this.straat = straat;
    	this.postNummer = postnummer;
    	this.gemeente = gemeente;
    }

    public String getStraat() {
		return straat;
	}

	public int getPostNummer() {
		return postNummer;
	}

	public String getGemeente() {
		return gemeente;
	}

	// 1.2 Override de toString methode
    public String toString() {
        return String.format("%-20s%-7d%-10s",this.straat, this.postNummer, this.gemeente);
    }
}
