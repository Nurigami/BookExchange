package sprint.spring.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint.spring.exchange.entity.Book;
import sprint.spring.exchange.entity.Category;
import sprint.spring.exchange.entity.Post;
import sprint.spring.exchange.entity.User;
import sprint.spring.exchange.model.JsonMsg;
import sprint.spring.exchange.model.Message;
import sprint.spring.exchange.repository.PostRepository;

import java.util.List;

@Service

public class PostServiceImpl implements PostService {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PostRepository postRepository;

    @Override
    public JsonMsg addPost(String category, String login, Book book) {
/*        if(book.getId()==null){
            Book newBook = bookService.addBook(book);
            for(Category c : categoryService.getAllCategories()){
                if(c.getName().equals(category)){
                    //Post p = new Post(c,login,newBook);
                }
            }
        }*/
        return null;
    }

    @Override
    public Post getPost(Long id) {
        return null;
    }

    @Override
    public List<Post> getAllposts() {
        return postRepository.findAll();
    }

    @Override
    public JsonMsg updatePost(Post post)  {
        for(Post p : postRepository.findAll()){
            if(p.getId().equals(post.getId())){
                p.setBook(post.getBook());
                p.setCategory(post.getCategory());
                p.setUserLogin(post.getUserLogin());
                postRepository.save(post);
                return new JsonMsg("Post is updated",post.getUserLogin());
            }
        }
        return new JsonMsg("Post with id " + post.getId()+ " does not exist", post.getUserLogin() );
    }

    @Override
    public JsonMsg deletePost(Long id) {
        return null;
    }

    @Override
    public List<Post> getPostsBySearch(String userLogin, String category) {
        return postRepository.getPostsBySearch(userLogin,category);
    }

    @Override
    public List<Post> getPostsByBooks(String author,String name) {
        return postRepository.getPostsByBooks(author,name);
    //return  null;
        }
}
