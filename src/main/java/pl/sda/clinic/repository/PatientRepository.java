package pl.sda.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.clinic.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
