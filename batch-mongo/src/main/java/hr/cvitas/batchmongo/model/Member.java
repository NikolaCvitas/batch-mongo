package hr.cvitas.batchmongo.model;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Member {

    @Id
    private Integer id;
    private String first_name;
    private String last_name;
    private String birth_date;
    private String sex;
    private String tax_number;
    private String street;
    private String city;
    private String postal_code;
    private String country;

    public Member() {
    }


    public Member(Integer id, String first_name, String last_name, String birth_date, String sex, String tax_number, String street, String city, String postal_code, String country) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.sex = sex;
        this.tax_number = tax_number;
        this.street = street;
        this.city = city;
        this.postal_code = postal_code;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTax_number() {
        return tax_number;
    }

    public void setTax_number(String tax_number) {
        this.tax_number = tax_number;
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
        return "Member{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", sex='" + sex + '\'' +
                ", tax_number='" + tax_number + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
