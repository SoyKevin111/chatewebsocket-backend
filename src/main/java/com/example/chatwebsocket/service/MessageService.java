package com.example.chatwebsocket.service;

import com.example.chatwebsocket.model.Message;
import com.example.chatwebsocket.repository.IMessageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

   private final IMessageRepository messageRepository;

   public MessageService(IMessageRepository messageRepository) {
      this.messageRepository = messageRepository;
   }

   public Message saveMessage(Message message) {
      try {
         message.setTimestamp(LocalDateTime.now());
         return messageRepository.save(message);
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
      }
   }

   public List<Message> findAll() {
      try {
         return this.messageRepository.findAll();
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
      }
   }

}
