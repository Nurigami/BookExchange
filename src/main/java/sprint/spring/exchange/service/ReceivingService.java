package sprint.spring.exchange.service;

import sprint.spring.exchange.entity.Post;
import sprint.spring.exchange.model.RecMessage;

public interface ReceivingService {
    RecMessage receiveItem(Post post, String recLogin);
}
