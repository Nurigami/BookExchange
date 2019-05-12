package sprint.spring.exchange.service;

import sprint.spring.exchange.entity.Book;
import sprint.spring.exchange.entity.Post;
import sprint.spring.exchange.model.Message;
import sprint.spring.exchange.model.PostModel;

import java.util.List;

public interface PostService {
    Message addPost(PostModel postModel, String login);
    Post getPostById(Long id);
    List<Post> getAllPosts();
    Message deletePost(Long id);
    Message updatePost(Post post);
    List<Post> getPostsOfUserByCategory(String login,String category);
    List<Post> getPostsByBookNameAuthor(String author,String bookName);
}
