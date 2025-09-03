package com.example.chatwebsocket.repository;

import com.example.chatwebsocket.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository extends MongoRepository<User, String> {
   boolean existsByUsername(String username);
}
