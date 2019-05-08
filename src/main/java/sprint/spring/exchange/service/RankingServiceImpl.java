package sprint.spring.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint.spring.exchange.model.Ranking;
import sprint.spring.exchange.repository.RankingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RankingServiceImpl implements RankingService {
    @Autowired
    private RankingRepository rankingRepository;

    @Override
    public List<Ranking> getActiveUsers(String category) {
        List<Object[]> objects = rankingRepository.getActiveUsers(category);
        List<Ranking> rankings = new ArrayList<>();
        for(int c =0; c<3; c++){
            rankings.add(new Ranking((String)objects.get(c)[0],(Long)objects.get(c)[1]));
        }
        return rankings;
    }

}
