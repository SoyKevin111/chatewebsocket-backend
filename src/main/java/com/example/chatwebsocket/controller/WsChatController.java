package com.example.chatwebsocket.controller;

import com.example.chatwebsocket.model.Message;
import com.example.chatwebsocket.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class WsChatController {

   private final MessageService messageService;

   public WsChatController(MessageService messageService) {
      this.messageService = messageService;
   }

   @MessageMapping("/chat.sendMessage")
   @SendTo("/topic/public")
   public Message sendMessage(@Payload Message msg){
      this.messageService.saveMessage(msg);
      System.out.println("Message received from : "+msg.getSender()+" : "+msg.getContent());
      return msg;
   }

   @MessageMapping("/chat.addUser")
   @SendTo("/topic/public")
   public Message addUser(@Payload Message msg, SimpMessageHeaderAccessor headerAccessor){
      //Almacenar nombre de usuario en los atributos de sesión de WS
      headerAccessor.getSessionAttributes().put("username", msg.getSender());
      System.out.println("user joined: "+msg.getSender() + " - " +msg.getType());
      return msg;
   }

}
