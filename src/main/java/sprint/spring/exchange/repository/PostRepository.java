package sprint.spring.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sprint.spring.exchange.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
