package com.example.chatwebsocket.config;

import com.example.chatwebsocket.model.ChatMessage;
import com.example.chatwebsocket.model.ChatMessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@Slf4j
public class WsEventListener {

   private final SimpMessageSendingOperations messageSendingOperations;

   public WsEventListener(SimpMessageSendingOperations messageSendingOperations) {
      this.messageSendingOperations = messageSendingOperations;
   }

   public void handleWsDisconnectListener(SessionDisconnectEvent event){
      StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

      //Recuperar username
      String username = (String) headerAccessor.getSessionAttributes().get("username");
      if(username != null){
         //Asignar menesaje de tipo "LEAVE"
         var message = new ChatMessage();
         message.setType(ChatMessageType.LEAVE);
         message.setSender(username);

         messageSendingOperations.convertAndSend("/topic/public", message);
      }

   }

}
