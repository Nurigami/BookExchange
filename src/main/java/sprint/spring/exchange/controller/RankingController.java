package sprint.spring.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sprint.spring.exchange.model.Ranking;
import sprint.spring.exchange.service.RankingService;

import java.util.List;

@RestController
@RequestMapping("/exchange/ranking")
public class RankingController {
    @Autowired
    private RankingService rankingService;

    @GetMapping
    public List<Ranking> getActiveUsers(@RequestHeader String category){
        return rankingService.getActiveUsers(category);
    }
}
