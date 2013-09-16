package be.kdg.nederlands;

import be.kdg.english.Address;

public class Adres implements AdresInterface {
    private Address address;

    public Adres( String city, int zip, String state) {
		address = new Address(city, Integer.toString(zip), state, "");
	}
    
	@Override
	public String getStraat() {
		return this.address.getStreet();
	}

	@Override
	public int getPostCode() {
		return Integer.parseInt(this.address.getZip());
	}

	@Override
	public String getGemeente() {
		return this.address.getCity();
	}
}
