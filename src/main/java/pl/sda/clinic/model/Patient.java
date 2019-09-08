package pl.sda.clinic.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Patient {


    private String firstName;
    private String lastName;
    @Id
    private Long pesel;
    private String password;

    public Patient(String firstName, String lastName, String password,Long pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.password = password;
    }

    public Patient() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                ", password='" + password + '\'' +
                '}';
    }
}
