package pl.sda.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sda.clinic.model.Patient;

import java.util.Optional;


public interface PatientRepository extends JpaRepository<Patient, Long> {/*
    @Query("select u from Patient u where u.user.username = :username")
    Optional<Patient> searchByUserUserName(@Param("username") String username);*/

    @Query(value = "SELECT * FROM Patient WHERE user_username = :username" , nativeQuery = true)
    Optional<Patient> searchByUserUserName(@Param("username") String username);
}
