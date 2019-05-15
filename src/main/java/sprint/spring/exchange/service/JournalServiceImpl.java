package sprint.spring.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint.spring.exchange.entity.Journal;
import sprint.spring.exchange.entity.PostBook;
import sprint.spring.exchange.model.Message;
import sprint.spring.exchange.repository.JournalRepository;
import sprint.spring.exchange.repository.PostBookRepository;

@Service
public class JournalServiceImpl implements JournalService {
    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private PostBookRepository postBookRepository;

    @Override
    public Message receiveItem(Long postId, String recLogin) {
        if(recLogin!=null){
            if(postBookRepository.findById(postId).orElse(null)!=null){
                PostBook postBook = postBookRepository.getOne(postId);
                Journal journal = new Journal(postBook,recLogin);
                journalRepository.save(journal);
                postBookRepository.delete(postBook);
                return new Message("Please contact the owner to receive the book. Link to the book owner's contacts: " +
                        postBook.getLogin());
            }
            return new Message("PostBook with id " + postId + " does not exist.");
        }
        return new Message("Please sign in.");
    }
}
