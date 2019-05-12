package sprint.spring.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sprint.spring.exchange.entity.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("select p from Post p join fetch p.category c " +
            "where lower(c.name) like coalesce (cast(concat('%',:name,'%') as text), lower(c.name))"
            + "and p.login = coalesce(cast(:login as text), p.login)")
    List<Post> getPostsOfUserByCategory(@Param("login")String login,
                                              @Param("name")String categoryName);

    @Query("select p from Post p join fetch p.book b " +
            "where lower(b.author) like coalesce (cast(concat('%',:author,'%')as text),lower(b.author)) and" +
            " lower(b.name) like coalesce (cast(concat('%',:name,'%')as text),lower(b.name))")
            List <Post> getPostsByBookNameAuthor(@Param("author")String author, @Param("name")String bookName);

}
