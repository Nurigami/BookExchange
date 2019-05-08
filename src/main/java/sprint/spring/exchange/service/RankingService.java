package sprint.spring.exchange.service;

import sprint.spring.exchange.model.Ranking;

import java.util.List;

public interface RankingService {
    List<Ranking> getActiveUsers(String category);
}
