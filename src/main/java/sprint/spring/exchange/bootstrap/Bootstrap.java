package sprint.spring.exchange.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sprint.spring.exchange.entity.*;
import sprint.spring.exchange.repository.*;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ReceivingRepository journalRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
/*        Category c1 = new Category("book");
        Category c2 = new Category("other");
        categoryRepository.save(c1);
        categoryRepository.save(c2);
        Book b1 = new Book("name","desc","author","terms","userOwner",false);
        Book b2 = new Book("name2","desc2","author","terms","userOwner2",false);
        bookRepository.save(b1);
        bookRepository.save(b2);
        Receiving j1 = new Receiving(c1,b1.getLogin(),null,b1,"userReceiver");
        Receiving j2 = new Receiving(c1,b2.getLogin(),null,b2,"userReceiver");
        journalRepository.save(j1);
        journalRepository.save(j2);
        User u1 = new User("fio","log","pass","email","phone","address");
        userRepository.save(u1);
        Post p1 = new Post(c1,b1,u1);
        postRepository.save(p1);*/
    }
}
