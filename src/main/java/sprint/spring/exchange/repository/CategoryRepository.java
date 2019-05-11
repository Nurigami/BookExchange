package sprint.spring.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sprint.spring.exchange.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
