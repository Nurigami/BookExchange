package sprint.spring.exchange.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sprint.spring.exchange.entity.User;
import sprint.spring.exchange.repository.JournalRepository;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private JournalRepository journalRepository;

    @Override
    public void run(String... args) throws Exception {
    }
}
