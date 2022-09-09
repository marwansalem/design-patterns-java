package patterns.creational.prototype.copy.constructor;

public class Address {
    public String streetAddress;
    public String city;
    public String country;

    public Address(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
            "streetAddress='" + streetAddress + '\'' +
            ", city='" + city + '\'' +
            ", country='" + country + '\'' +
            '}';
    }

    public Address(Address other) {
        this(other.streetAddress, other.city, other.country);
    }
}
