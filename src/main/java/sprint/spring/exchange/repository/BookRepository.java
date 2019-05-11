package sprint.spring.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sprint.spring.exchange.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE lower(b.author) LIKE CONCAT('%',:author,'%')")
    List<Book> findBooksByAuthor(@Param("author") String auth);

    @Query("SELECT b FROM Book b WHERE lower(b.name) LIKE CONCAT('%',:name,'%')")
    List<Book> findBooksByName(@Param("name") String auth);
}
