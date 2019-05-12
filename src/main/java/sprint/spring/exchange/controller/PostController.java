package sprint.spring.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sprint.spring.exchange.entity.Post;
import sprint.spring.exchange.model.Message;
import sprint.spring.exchange.model.PostModel;
import sprint.spring.exchange.service.PostService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/exchange/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/user")
    public ResponseEntity<Message> addPost(@RequestBody PostModel postModel, Principal principal){
        if(principal!=null){
            return new ResponseEntity<>(postService.addPost(postModel,principal.getName()),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("Please sign in"),HttpStatus.OK);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        return new ResponseEntity<>(postService.getPostById(id),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(),HttpStatus.OK);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Message> deletePost(@PathVariable Long id){
        return new ResponseEntity<>(postService.deletePost(id),HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<Message> updatePost(@RequestBody Post post){
        return new ResponseEntity<>(postService.updatePost(post),HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getPostsOfUserByCategory(Principal principal, @RequestHeader String category){
        if(principal!=null){
            return new ResponseEntity<>(postService.getPostsOfUserByCategory(principal.getName(),category),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("Please sign in"),HttpStatus.OK);
    }

    @GetMapping("/all/search")
    public ResponseEntity<List<Post>> getPostsByBookNameAuthor(@RequestHeader(required = false) String author,
                                                               @RequestHeader (required = false) String bookName){
        return new ResponseEntity<>(postService.getPostsByBookNameAuthor(author,bookName),HttpStatus.OK);
    }

}
