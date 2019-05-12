package sprint.spring.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint.spring.exchange.entity.Book;
import sprint.spring.exchange.entity.Category;
import sprint.spring.exchange.entity.Post;
import sprint.spring.exchange.entity.User;
import sprint.spring.exchange.model.Message;
import sprint.spring.exchange.model.PostModel;
import sprint.spring.exchange.repository.PostRepository;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private PostRepository postRepository;

    @Override
    public Message addPost(PostModel postModel,String login) {
        Category category = categoryService.getCategory(postModel.getCategoryId());
        Book book = bookService.getBookById(postModel.getBookId());
        String terms = postModel.getTerms();
        Post post = new Post(category,book,login,terms);
        postRepository.save(post);
        return new Message("New Post is created");
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.getOne(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Message deletePost(Long id) {
        Post post = postRepository.getOne(id);
        postRepository.delete(post);
        return new Message("Post is removed");
    }

    @Override
    public Message updatePost(Post post){
        if(postRepository.findById(post.getId()).orElse(null)!=null){
            Post p = postRepository.getOne(post.getId());
            p.setBook(post.getBook());
            p.setCategory(post.getCategory());
            p.setLogin(post.getLogin());
            p.setTerms(post.getTerms());
            return new Message("Post is updated");
        }
        return new Message("Post with id " + post.getId()+ " does not exist");
    }

    @Override
    public List<Post> getPostsOfUserByCategory(String login, String category) {
        return postRepository.getPostsOfUserByCategory(login,category);
    }

    @Override
    public List<Post> getPostsByBookNameAuthor(String author, String bookName) {
        if(author==null && bookName==null) return postRepository.getPostsByBookNameAuthor(author,bookName);
        if(author==null && bookName!=null) return postRepository.getPostsByBookNameAuthor(author,bookName.toLowerCase());
        if(author!=null && bookName==null) return postRepository.getPostsByBookNameAuthor(author.toLowerCase(),bookName);
        return postRepository.getPostsByBookNameAuthor(author.toLowerCase(),bookName.toLowerCase());
    }
}
