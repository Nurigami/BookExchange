package sprint.spring.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sprint.spring.exchange.entity.Receiving;

import java.util.List;

public interface RankingRepository extends JpaRepository<Receiving, Long> {

    @Query("select distinct j.login, count(j.login), j.category.name from Receiving j " +
            "where j.category.name = :category " +
            "group by j.login, j.category.name " +
            "order by count(j.login) desc")
    List<Object[]> getActiveUsers(@Param("category") String category);
}
