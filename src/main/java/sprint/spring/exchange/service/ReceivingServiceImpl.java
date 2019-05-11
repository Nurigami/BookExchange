package sprint.spring.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint.spring.exchange.entity.Receiving;
import sprint.spring.exchange.entity.Post;
import sprint.spring.exchange.model.RecMessage;
import sprint.spring.exchange.repository.ReceivingRepository;
import sprint.spring.exchange.repository.PostRepository;

@Service
public class ReceivingServiceImpl implements ReceivingService {
    @Autowired
    private ReceivingRepository journalRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public RecMessage receiveItem(Post post, String recLogin) {
        if(recLogin!=null){
            Receiving journal = new Receiving(post,recLogin);
            journalRepository.save(journal);
            postRepository.delete(post);
            return new RecMessage("Please contact the owner to receive the book. Link to the book owner's contacts is below ",
                    post.getUser().getLogin());
        }
        return new RecMessage("Please sign in.",null);
    }
}
