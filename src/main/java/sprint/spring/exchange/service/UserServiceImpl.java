package sprint.spring.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint.spring.exchange.entity.User;
import sprint.spring.exchange.entity.UserRoles;
import sprint.spring.exchange.model.Message;
import sprint.spring.exchange.repository.UserRepository;
import sprint.spring.exchange.repository.UserRolesRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRolesRepository userRolesRepository;

    @Override
    public Message addUser(User user) {
        User u = userRepository.save(user);
        UserRoles ur = new UserRoles(u,"ROLE_USER");
        userRolesRepository.save(ur);
        return new Message("User is saved.");
    }

    @Override
    public Message addAdmin(User user) {
        User u = userRepository.save(user);
        UserRoles ur = new UserRoles(u,"ROLE_ADMIN");
        userRolesRepository.save(ur);
        return new Message("Admin is saved.");
    }

    @Override
    public User getUserById(Long id) {
        for(User u: userRepository.findAll()){
            if(u.getId().equals(id)){
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Message updateUser(User user) {
        for(User u: userRepository.findAll()){
            if(u.getId().equals(user.getId())){
                u.setFio(user.getFio());
                u.setLogin(user.getLogin());
                u.setPassword(user.getPassword());
                u.setEmail(user.getEmail());
                u.setPhone(user.getPhone());
                u.setAddress(user.getAddress());
                userRepository.save(u);
                return new Message("User profile is updated");
            }
        }
        return new Message("User with id "+ user.getId() + " does not exist");
    }

    @Override
    public Message blockUser(Long id) {
        for(User u: userRepository.findAll()){
            if(u.getId().equals(id)){
                u.setActive(false);
                return new Message("User account is deleted");
            }
        }
        return new Message("User with id "+ id + " does not exist");
    }

    @Override
    public Message unblockUser(Long id) {
        for(User u: userRepository.findAll()){
            if(u.getId().equals(id)){
                u.setActive(true);
                return new Message("User account is restored");
            }
        }
        return new Message("User with id "+ id + " does not exist");
    }
}
