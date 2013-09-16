package be.kdg.herhaling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Team implements Showable,Comparable<Team>{
    private String naam;
    private List<Speler> spelers;

    // De volgende regels mag je niet wijzigen
    public abstract void showTeam();
    public Team() {}

    // 3.1 Schrijf de nodige constructor (de spelers worden achteraf toegevoegd) + een getter voor elk attribuut
    public Team(String naam) {
    	this.naam = naam;
    	this.spelers = new ArrayList<Speler>();
    }
    public String getNaam() {
		return naam;
	}
	public List<Speler> getSpelers() {
		return spelers;
	}
    // 3.2 Schrijf een interface met de naam Showable met daarin één methode, de methode void showTeam()
    // Implementeer de interface in deze klasse (Let op! De methode zelf wordt hier niet uitgewerkt!)

    // 3.3 Voeg een speler aan de arraylist toe, maar alleen als het rugNummer nog niet voorkomt
    public void voegToe(Speler toeTeVoegenSpeler) {
    	for(Speler speler : this.spelers){
    		if(speler.getRugNummer() == toeTeVoegenSpeler.getRugNummer()){
    			return;
    		}
    	}
    	this.spelers.add(toeTeVoegenSpeler);
    }

    
	// 3.4 Sorteer de spelers volgens naam
    public void sort() {
    	Collections.sort(this.spelers);
    }

    // 3.5 Geef de speler met het gegeven rugNummer terug, geef null terug als de speler niet gevonden is
    public Speler zoekSpeler(int rugNummer) {
        return this.spelers.get(rugNummer);
    }
}
