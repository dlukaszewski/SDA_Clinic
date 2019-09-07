package pl.sda.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.clinic.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, String> {
}
