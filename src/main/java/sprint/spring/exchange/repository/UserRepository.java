package sprint.spring.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sprint.spring.exchange.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
