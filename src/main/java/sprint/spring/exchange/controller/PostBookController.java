package sprint.spring.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sprint.spring.exchange.entity.PostBook;
import sprint.spring.exchange.model.Message;
import sprint.spring.exchange.model.PostBookModel;
import sprint.spring.exchange.service.PostBookService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/exchange/post/book")
public class PostBookController {
    @Autowired
    private PostBookService postBookService;

    @PostMapping("/user")
    public ResponseEntity<Message> addPost(@RequestBody PostBookModel postBookModel, Principal principal){
        if(principal!=null){
            return new ResponseEntity<>(postBookService.addPost(postBookModel,principal.getName()),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("Please sign in"),HttpStatus.OK);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<PostBook> getPostById(@PathVariable Long id){
        return new ResponseEntity<>(postBookService.getPostById(id),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostBook>> getAllPosts(){
        return new ResponseEntity<>(postBookService.getAllPosts(),HttpStatus.OK);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Message> deletePost(@PathVariable Long id){
        return new ResponseEntity<>(postBookService.deletePost(id),HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<Message> updatePost(@RequestBody PostBook postBook){
        return new ResponseEntity<>(postBookService.updatePost(postBook),HttpStatus.OK);
    }

    @GetMapping("/user/myposts")
    public ResponseEntity<?> getPostsOfUser(Principal principal){
        if(principal==null) return new ResponseEntity<>(new Message("Please sign in."),HttpStatus.OK);
        return new ResponseEntity<>(postBookService.getPostsOfUser(principal.getName()),HttpStatus.OK);
    }

    @GetMapping("/all/search")
    public ResponseEntity<List<PostBook>> getPostsByBookNameAuthor(@RequestHeader(required = false) String author,
                                                                   @RequestHeader (required = false) String bookName){
        return new ResponseEntity<>(postBookService.getPostsByBookNameAuthor(author,bookName),HttpStatus.OK);
    }

}
