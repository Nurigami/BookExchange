package sprint.spring.exchange.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sprint.spring.exchange.model.Message;
import sprint.spring.exchange.repository.UserRepository;


@RestController
public class SecurityController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin")
    @ResponseBody
    public Message getAdmin(){
        return new Message("Hello admin");
    }

    @GetMapping("/user")
    @ResponseBody
    public Message getUser(){
        return new Message("Hello user");
    }
}