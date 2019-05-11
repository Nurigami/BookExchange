package sprint.spring.exchange.service;

import sprint.spring.exchange.entity.User;
import sprint.spring.exchange.model.Message;

import java.util.List;

public interface UserService {
    Message addUser(User user);
    Message addAdmin(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    Message updateUser(User user);
    Message blockUser(Long id);
    Message unblockUser(Long id);
    User findUserByLogin(String login);
}
