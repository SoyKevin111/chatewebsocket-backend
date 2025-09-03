package com.example.chatwebsocket.repository;

import com.example.chatwebsocket.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends MongoRepository<User, String> {

   //boolean existsByUsername(String username);
   Optional<User> findByUsername(String username);
   //List<User> findByIdIn(List<String> ids);
}
