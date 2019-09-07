package pl.sda.clinic.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Doctor {

    @Id
    private String firstName;
    private String lastName;
    private String doctorId;
    private String specialization;
    private String password;

    public Doctor(String doctorId, String specialization, String password, String firstName, String lastName) {
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Doctor() {
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(getDoctorId(), doctor.getDoctorId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDoctorId());
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", specialization='" + specialization + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
