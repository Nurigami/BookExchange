package sprint.spring.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sprint.spring.exchange.entity.Receiving;

public interface ReceivingRepository extends JpaRepository<Receiving, Long> {
}
