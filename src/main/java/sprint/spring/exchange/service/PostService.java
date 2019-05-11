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
    //Message updatePost(PostModel postModel);
    Message deletePost(Long id);
}
