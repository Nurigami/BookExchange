package sprint.spring.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sprint.spring.exchange.entity.Post;
import sprint.spring.exchange.model.RecMessage;
import sprint.spring.exchange.service.ReceivingService;

@RestController
@RequestMapping("exchange/receiving")
public class ReceivingController {
    @Autowired
    private ReceivingService receivingService;

    @PostMapping
    public ResponseEntity<RecMessage> receiveItem(@RequestBody Post post, @RequestHeader(required = false) String recLogin){
        return new ResponseEntity<>(receivingService.receiveItem(post,recLogin), HttpStatus.OK);
    }
}
