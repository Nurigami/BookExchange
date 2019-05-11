package sprint.spring.exchange.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRolesRepository userRolesRepository;

    @Override
    public void run(String... args) throws Exception {
        Category c1 = new Category("book");
        Category c2 = new Category("other");
        categoryRepository.save(c1);
        categoryRepository.save(c2);

        Book b1 = new Book("name","desc","author");
        Book b2 = new Book("name2","desc2","author");
        bookRepository.save(b1);
        bookRepository.save(b2);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User u1 = new User("fio","use",passwordEncoder.encode("123"),"email","phone","address",true);
        User u2 = new User("fio","use",passwordEncoder.encode("456"),"email","phone","address",false);
        User u3 = new User("fio","adm",passwordEncoder.encode("789"),"email","phone","address",true);
        userRepository.save(u1);
        userRepository.save(u2);
        UserRoles ur1 = new UserRoles(u1,"ROLE_USER");
        UserRoles ur2 = new UserRoles(u2,"ROLE_ADMIN");
        userRolesRepository.save(ur1);
        userRolesRepository.save(ur2);

        Post p1 = new Post(c1,b1,u1,"My terms for exchange");
        Post p2 = new Post(c1,b2,u2,"My terms for exchange");
        postRepository.save(p1);
        postRepository.save(p2);
    }
}
