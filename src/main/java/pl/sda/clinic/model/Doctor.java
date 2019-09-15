package pl.sda.clinic.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(generator = "docSeq")
    @SequenceGenerator(name = "docSeq", sequenceName = "doc_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;

    @ManyToOne(targetEntity = User.class)
    private User user;

    public Doctor(Long id, String specialization, String firstName, String lastName) {
        this.id = id;
        this.specialization = specialization;
        this.firstName = firstName;
        this.lastName = lastName;
        this.user = new User();

    }

    public Doctor() {
        this.user = new User();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(getId(), doctor.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
