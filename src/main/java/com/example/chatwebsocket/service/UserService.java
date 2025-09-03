package com.example.chatwebsocket.service;

import com.example.chatwebsocket.model.User;
import com.example.chatwebsocket.repository.IUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
public class UserService {

   private final IUserRepository userRepository;

   public UserService(IUserRepository userRepository) {
      this.userRepository = userRepository;
   }

   public User saveUser(User user) {
      try {
         return userRepository.save(user);
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
      }
   }

   public Optional<User> findByUsername(String username) {
      try {
         return userRepository.findByUsername(username);
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
      }
   }


}
