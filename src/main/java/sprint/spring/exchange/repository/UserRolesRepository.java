package sprint.spring.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sprint.spring.exchange.entity.UserRoles;

public interface UserRolesRepository extends JpaRepository <UserRoles,Long> {
}
