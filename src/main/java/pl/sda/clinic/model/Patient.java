package pl.sda.clinic.model;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Objects;

@Entity
public class Patient {

    private String firstName;
    private String lastName;
    @Id
    private Long pesel;

    @Embedded
    public User user;

    public Patient(String firstName, String lastName,Long pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.user = new User();
    }

    public Patient() {
        this.user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    public String getUsername(){
        if (user == null){
            return "";
        }
        return user.getUsername();
    }
    public String getPassword(){
        if (user == null){
            return "";
        }
        return user.getPassword();
    }
    public void SetUsername(String username){
        if (user == null){
            user = new User();
        }
        user.setUsername(username);
    }
    public void SetPassword(String password){
        if (user == null){
            user = new User();
        }
        user.setPassword(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(getPesel(), patient.getPesel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPesel());
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel=" + pesel +
                '}';
    }
}
