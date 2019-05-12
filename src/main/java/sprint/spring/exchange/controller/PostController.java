package sprint.spring.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sprint.spring.exchange.entity.Post;
import sprint.spring.exchange.model.JsonMsg;
import sprint.spring.exchange.model.Message;
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

    @GetMapping("/searchPosts")
    public ResponseEntity<List<Post>>getPostsBySearch(@RequestHeader String userLogin,
                                                      @RequestHeader String category){
        return new ResponseEntity<>(postService.getPostsBySearch(userLogin,category),HttpStatus.OK);
    }
    @GetMapping("/searchPosts/books")
    public ResponseEntity<List<Post>>getPostsByBooks(@RequestHeader String author,
                                                     @RequestHeader String name){
        return new ResponseEntity<>(postService.getPostsByBooks(author,name),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<JsonMsg>updatePost(@RequestBody Post post){
        return new ResponseEntity<>(postService.updatePost(post),HttpStatus.OK);
    }
}
