package sprint.spring.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint.spring.exchange.entity.Book;
import sprint.spring.exchange.entity.Category;
import sprint.spring.exchange.entity.Post;
import sprint.spring.exchange.entity.User;
import sprint.spring.exchange.model.JsonMsg;
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
    public JsonMsg updatePost(Post post) {
        return null;
    }

    @Override
    public JsonMsg deletePost(Long id) {
        return null;
    }
}
