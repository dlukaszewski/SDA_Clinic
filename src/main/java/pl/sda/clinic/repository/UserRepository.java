package pl.sda.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.clinic.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
