package sprint.spring.exchange.service;

import sprint.spring.exchange.entity.PostBook;
import sprint.spring.exchange.model.Message;
import sprint.spring.exchange.model.PostBookModel;

import java.util.List;

public interface PostBookService {
    Message addPost(PostBookModel postBookModel, String login);
    PostBook getPostById(Long id);
    List<PostBook> getAllPosts();
    Message deletePost(Long id);
    Message updatePost(PostBook postBook);
    List<PostBook> getPostsOfUser(String userLogin);
    List<PostBook> getPostsByBookNameAuthor(String author, String bookName);
}
