package ir.caspersia.authorizationandresourceserver.model.repository;

import ir.caspersia.authorizationandresourceserver.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);
}
