package com.example.chatwebsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WsConfiguration implements WebSocketMessageBrokerConfigurer {

   @Override
   public void registerStompEndpoints(StompEndpointRegistry registry) {
      registry.addEndpoint("/ws")
         .setAllowedOrigins("http://localhost:4200")
         .withSockJS();
   }

   @Override
   public void configureMessageBroker(MessageBrokerRegistry registry) {
      registry.setApplicationDestinationPrefixes("/app"); // //mensajes enviados al servidor empezar con /app y el servidor redirige al metood apropiado con la anotacion @MessageMapping
      registry.enableSimpleBroker("/topic"); //se activa un agente de mensajeria en memoria que envia los mensajes a los clientes suscritos a /topic
   }


}
