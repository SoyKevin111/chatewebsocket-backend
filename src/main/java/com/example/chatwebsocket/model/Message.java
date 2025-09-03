package com.example.chatwebsocket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "message")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {

   @Id
   private String id;

   private String sender;
   private String content;
   private MessageType type;
}
