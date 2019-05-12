package sprint.spring.exchange.service;

import sprint.spring.exchange.entity.Post;
import sprint.spring.exchange.model.Message;

public interface JournalService {
    Message receiveItem(Long postId, String recLogin);
}
