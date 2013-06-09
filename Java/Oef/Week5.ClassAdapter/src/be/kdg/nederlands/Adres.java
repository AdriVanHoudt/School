package be.kdg.nederlands;

import be.kdg.english.Address;

public class Adres extends Address {

	public Adres( String city, int zip, String state) {
		super("", city, ""+zip, state);
	}

}