package sprint.spring.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sprint.spring.exchange.entity.User;
import sprint.spring.exchange.model.Message;
import sprint.spring.exchange.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/exchange/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Message> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }

    @PostMapping("/admin")
    public ResponseEntity<Message> addAdmin(@RequestBody User user){
        return new ResponseEntity<>(userService.addAdmin(user),HttpStatus.OK);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Message> updateUser(@RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(user),HttpStatus.OK);
    }

    @PutMapping("/admin/block/{id}")
    public ResponseEntity<Message> blockUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.blockUser(id),HttpStatus.OK);
    }

    @PutMapping("/admin/unblock/{id}")
    public ResponseEntity<Message> unblockUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.unblockUser(id),HttpStatus.OK);
    }

}
