package ir.caspersia.authorizationandresourceserver.model.repository;

import ir.caspersia.authorizationandresourceserver.model.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    Privilege findByName(String name);
}
