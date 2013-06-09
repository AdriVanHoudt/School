package be.kdg.english;

/**
 * Deze klasse is in productie; JE MAG ZE NIET WIJZIGEN!
 */
public class Address {
    private String street;
    private String city;
    private String zip;
    private String state;

    public Address(String street, String city, String zip, String state) {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return street + '\n' + city + '\n' + zip + '\n' + state;
    }
}
