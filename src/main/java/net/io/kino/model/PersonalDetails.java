package net.io.kino.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonalDetails {

    private String name;
    private String surname;
    @Column
    private String email;
    private String phone;

    public PersonalDetails() {
    }

    public PersonalDetails(String email) {
        this.email = email;
    }

    public PersonalDetails(String name, String surname, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
