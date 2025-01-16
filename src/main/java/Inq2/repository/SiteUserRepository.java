package Inq2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Inq2.domain.SiteUser;

public interface SiteUserRepository extends JpaRepository<SiteUser,Long> {
}
