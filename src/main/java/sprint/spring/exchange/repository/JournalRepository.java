package sprint.spring.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sprint.spring.exchange.entity.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}
