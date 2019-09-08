package pl.sda.clinic.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Visit {

    @Id
    @GeneratedValue(generator = "visitSeq")
    @SequenceGenerator(name = "visitSeq", sequenceName = "visit_seq", allocationSize = 1)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime appointmentDate;

    @ManyToOne(targetEntity = Doctor.class)
    private Doctor doctor;

    @ManyToOne(targetEntity = Patient.class)
    private Patient patient;


    public Visit(Long id, LocalDateTime appointmentDate)
    {
        this.id =id;
        this.appointmentDate = appointmentDate;
    }

    public Visit() {
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visit)) return false;
        Visit visit = (Visit) o;
        return Objects.equals(getId(), visit.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", appointmentDate=" + appointmentDate +
                ", doctor=" + doctor +
                ", patient=" + patient +
                '}';
    }
}
