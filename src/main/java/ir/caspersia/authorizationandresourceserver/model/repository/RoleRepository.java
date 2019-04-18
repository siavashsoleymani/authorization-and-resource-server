package ir.caspersia.authorizationandresourceserver.model.repository;

import ir.caspersia.authorizationandresourceserver.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String role);
}
