package sprint.spring.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sprint.spring.exchange.entity.Post;
import sprint.spring.exchange.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/exchange/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllposts(){
        return new ResponseEntity<>(postService.getAllposts(), HttpStatus.OK);
    }

}
