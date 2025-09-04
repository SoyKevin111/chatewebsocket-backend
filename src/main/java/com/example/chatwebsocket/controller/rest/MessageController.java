package com.example.chatwebsocket.controller.rest;

import com.example.chatwebsocket.model.Message;
import com.example.chatwebsocket.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

   private final MessageService messageService;

   public MessageController(MessageService messageService) {
      this.messageService = messageService;
   }

   @PostMapping("/send")
   public ResponseEntity<?> saveMessage(@RequestBody Message message) {
      return ResponseEntity.ok(this.messageService.saveMessage(message));
   }

   @GetMapping
   public ResponseEntity<List<Message>> getAllMessages() {
      return ResponseEntity.ok(this.messageService.findAll());
   }

}
