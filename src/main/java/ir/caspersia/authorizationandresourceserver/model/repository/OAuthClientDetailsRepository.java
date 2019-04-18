package ir.caspersia.authorizationandresourceserver.model.repository;

import ir.caspersia.authorizationandresourceserver.model.entity.OAuthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OAuthClientDetailsRepository extends JpaRepository<OAuthClientDetails, Long> {
}
