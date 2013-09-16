package be.kdg.english;

/**
 * Deze klasse is in productie; JE MAG ZE NIET WIJZIGEN!
 */
public class Person {
    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name + '\n' + address;
    }
}