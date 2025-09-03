package com.example.chatwebsocket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

   @Id
   private String id;

   private String username;

   public User(String username) {
      this.username = username;
   }
}
