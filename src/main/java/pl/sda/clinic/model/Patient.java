package pl.sda.clinic.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Patient {

    @Id
    private String firstName;
    private String lastName;
    private Long patientId;
    private LocalDateTime appointmentDate;
    private String password;

    public Patient(String firstName, String lastName, String password,Long patientId, LocalDateTime appointmentDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patientId = patientId;
        this.appointmentDate = appointmentDate;
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

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
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
        return Objects.equals(getPatientId(), patient.getPatientId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPatientId());
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patientId=" + patientId +
                ", appointmentDate=" + appointmentDate +
                ", password='" + password + '\'' +
                '}';
    }
}
