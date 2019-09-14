package pl.sda.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.clinic.model.Role;


import java.util.Optional;

public interface RoleRepository extends JpaRepository< Role, Long> {

    Optional<Role> findByAuthority(String authority);
}
