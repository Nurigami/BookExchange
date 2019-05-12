package sprint.spring.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sprint.spring.exchange.model.Message;
import sprint.spring.exchange.service.JournalService;

@RestController
@RequestMapping("exchange/receive")
public class JournalController {
    @Autowired
    private JournalService journalService;

    @PostMapping("/{postId}")
    public ResponseEntity<Message> receiveItem(@PathVariable Long postId, @RequestHeader(required = false) String recLogin){
        return new ResponseEntity<>(journalService.receiveItem(postId,recLogin), HttpStatus.OK);
    }
}
