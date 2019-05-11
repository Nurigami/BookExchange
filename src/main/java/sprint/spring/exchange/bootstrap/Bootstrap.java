package sprint.spring.exchange.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import sprint.spring.exchange.entity.Book;
import sprint.spring.exchange.entity.User;
import sprint.spring.exchange.entity.UserRoles;
import sprint.spring.exchange.repository.BookRepository;
import sprint.spring.exchange.repository.JournalRepository;
import sprint.spring.exchange.repository.UserRepository;
import sprint.spring.exchange.repository.UserRolesRepository;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRolesRepository userRolesRepository;

    @Autowired
    private BookRepository bookRepository;
    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    /*    User user1 = new User("user1","user1","user1",
                passwordEncoder.encode("user1"),"user1",true);
        userRepository.save(user1);

        User user2 = new User("user2","user2", "user2",
                passwordEncoder.encode("user2"),"user2",true);
        userRepository.save(user2);

        User user3 = new User("user3","user3","user3",
                passwordEncoder.encode("user3"),"user3",false);
        userRepository.save(user3);

        UserRoles userRoles1 = new UserRoles(user1, "ROLE_ADMIN");
        userRolesRepository.save(userRoles1);

        UserRoles userRoles2 = new UserRoles(user2, "ROLE_USER");
        userRolesRepository.save(userRoles2);

        UserRoles userRoles3 = new UserRoles(user3, "ROLE_USER");
        userRolesRepository.save(userRoles3);*/

    Book book=new Book("book1","Drama","Pushkin","333","user1",false);
    Book book2=new Book("book1","Drama","Pushkin","333","user1",false);
    Book book3=new Book("book2","Drama","Duma","333","user1",false);
    bookRepository.save(book);
    bookRepository.save(book3);
    bookRepository.save(book2);
    }
}
