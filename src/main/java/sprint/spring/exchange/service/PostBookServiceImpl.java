package sprint.spring.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint.spring.exchange.entity.Book;
import sprint.spring.exchange.entity.Category;
import sprint.spring.exchange.entity.PostBook;
import sprint.spring.exchange.model.Message;
import sprint.spring.exchange.model.PostBookModel;
import sprint.spring.exchange.repository.BookRepository;
import sprint.spring.exchange.repository.PostBookRepository;

import java.util.List;

@Service
public class PostBookServiceImpl implements PostBookService {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private PostBookRepository postBookRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Message addPost(PostBookModel postBookModel, String login) {
        Category category = categoryService.getCategory(1L);
        if(postBookModel.getBook().getId()==null){
            Book book = bookRepository.save(postBookModel.getBook());
            PostBook pb = new PostBook(category,book,login,postBookModel.getTerms());
            postBookRepository.save(pb);
            return new Message("New Post is created");
        }

        PostBook pb = new PostBook(category,postBookModel.getBook(),login,postBookModel.getTerms());
        postBookRepository.save(pb);
        return new Message("New Post is created");
    }

    @Override
    public PostBook getPostById(Long id) {
        return postBookRepository.getOne(id);
    }

    @Override
    public List<PostBook> getAllPosts() {
        return postBookRepository.findAll();
    }

    @Override
    public Message deletePost(Long id) {
        PostBook postBook = postBookRepository.getOne(id);
        postBookRepository.delete(postBook);
        return new Message("Post is removed");
    }

    @Override
    public Message updatePost(PostBook postBook){
        if(postBookRepository.findById(postBook.getId()).orElse(null)!=null){
            PostBook p = postBookRepository.getOne(postBook.getId());
            p.setBook(postBook.getBook());
            p.setCategory(postBook.getCategory());
            p.setLogin(postBook.getLogin());
            p.setTerms(postBook.getTerms());
            return new Message("Post is updated");
        }
        return new Message("Post with id " + postBook.getId()+ " does not exist");
    }

    @Override
    public List<PostBook> getPostsOfUser(String login) {
        return postBookRepository.getPostsOfUser(login);
    }

    @Override
    public List<PostBook> getPostsByBookNameAuthor(String author, String bookName) {
        return postBookRepository.getPostsByBookNameAuthor(author,bookName);
    }
}
