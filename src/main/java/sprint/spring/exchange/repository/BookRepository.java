package sprint.spring.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sprint.spring.exchange.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
