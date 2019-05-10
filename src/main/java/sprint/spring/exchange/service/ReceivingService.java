package sprint.spring.exchange.service;

import sprint.spring.exchange.entity.Post;
import sprint.spring.exchange.model.JsonMsg;

public interface ReceivingService {
    JsonMsg receiveItem(Post post, String recLogin);
}
