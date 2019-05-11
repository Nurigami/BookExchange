package sprint.spring.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sprint.spring.exchange.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE lower(b.name) LIKE coalesce(cast(CONCAT('%',:name,'%') as text),b.name) " +
            "and lower(b.author) LIKE coalesce(cast(CONCAT('%',:author,'%') as text),b.author)")
    List<Book> findBooksByNameAndAuthor(@Param("name") String name,@Param("author") String author);
}
