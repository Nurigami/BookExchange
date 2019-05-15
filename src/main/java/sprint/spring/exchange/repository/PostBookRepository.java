package sprint.spring.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sprint.spring.exchange.entity.PostBook;

import java.util.List;

public interface PostBookRepository extends JpaRepository<PostBook, Long> {

    @Query("select p from PostBook p " +
            "where p.login = coalesce(cast(:login as text), p.login)")
    List<PostBook> getPostsOfUser(@Param("login")String userLogin);

    @Query("select p from PostBook p join fetch p.book b " +
            "where lower(b.author) like coalesce (cast(concat('%',:author,'%')as text),lower(b.author)) and" +
            " lower(b.name) like coalesce (cast(concat('%',:name,'%')as text),lower(b.name))")
            List <PostBook> getPostsByBookNameAuthor(@Param("author")String author, @Param("name")String bookName);

}
