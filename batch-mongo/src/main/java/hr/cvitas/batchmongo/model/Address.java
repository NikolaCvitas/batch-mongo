package hr.cvitas.batchmongo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    private String street;
    private String city;
    private String postal_code;
    private String country;

    public Address() {
    }

    public Address(String street, String city, String postal_code, String country) {
        this.street = street;
        this.city = city;
        this.postal_code = postal_code;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
