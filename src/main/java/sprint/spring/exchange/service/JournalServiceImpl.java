package sprint.spring.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint.spring.exchange.entity.Journal;
import sprint.spring.exchange.entity.Post;
import sprint.spring.exchange.model.Message;
import sprint.spring.exchange.repository.JournalRepository;
import sprint.spring.exchange.repository.PostRepository;

@Service
public class JournalServiceImpl implements JournalService {
    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public Message receiveItem(Long postId, String recLogin) {
        if(recLogin!=null){
            if(postRepository.findById(postId).orElse(null)!=null){
                Post post = postRepository.getOne(postId);
                Journal journal = new Journal(post,recLogin);
                journalRepository.save(journal);
                postRepository.delete(post);
                return new Message("Please contact the owner to receive the book. Link to the book owner's contacts: " +
                        post.getLogin());
            }
            return new Message("Post with id " + postId + " does not exist.");
        }
        return new Message("Please sign in.");
    }
}
