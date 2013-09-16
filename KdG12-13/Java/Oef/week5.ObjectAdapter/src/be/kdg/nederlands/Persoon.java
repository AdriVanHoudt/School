package be.kdg.nederlands;

import be.kdg.english.Person;
import be.kdg.english.Address;

public class Persoon implements PersoonInterface{
    private Person person;

    public Persoon(String name, Adres addres){
    	Address address = new Address(addres.getStraat(), addres.getGemeente(), Integer.toString(addres.getPostCode()), "");
    	person = new Person(name, address);
    }
    
	@Override
	public String getNaam() {
		return person.getName();
	}

	@Override
	public Adres getAdres() {
		Adres adres = new Adres(person.getAddress().getCity(), Integer.parseInt(person.getAddress().getZip()), person.getAddress().getState());
		return adres;
	}
}
