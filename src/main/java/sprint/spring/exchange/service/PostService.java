package sprint.spring.exchange.service;

import sprint.spring.exchange.entity.Book;
import sprint.spring.exchange.entity.Post;
import sprint.spring.exchange.model.JsonMsg;
import sprint.spring.exchange.model.Message;

import java.util.List;

public interface PostService {
    JsonMsg addPost(String category, String login, Book book);
    Post getPost(Long id);
    List<Post> getAllposts();
    JsonMsg updatePost(Post post);
    JsonMsg deletePost(Long id);
    List <Post> getPostsBySearch(String userLogin,String category);
    List <Post> getPostsByBooks(String author,String bookName);
}
