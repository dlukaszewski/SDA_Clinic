package pl.sda.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sda.clinic.model.Visit;

import java.util.List;
import java.util.Optional;


public interface VisitRepository extends JpaRepository <Visit,Long > {

/*    @Query("select u from Visit u where u.doctor.id = :id and u.patient.pesel = null ")
    List<Visit> searchNotBookedVisit(@Param("id")Long id);*/

    @Query(value = "SELECT * FROM Visit WHERE doctor_id = :id AND patient_pesel = null", nativeQuery = true)
    List<Visit> searchNotBookedVisit(@Param("id")Long id);
}
