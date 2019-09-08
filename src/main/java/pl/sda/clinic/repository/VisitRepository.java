package pl.sda.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.clinic.model.Visit;



public interface VisitRepository extends JpaRepository <Visit,Long > {
}
