package com.example.chatwebsocket.controller.rest;

import com.example.chatwebsocket.model.User;
import com.example.chatwebsocket.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

   private final UserService userService;

   public UserController(UserService userService) {
      this.userService = userService;
   }

   @PostMapping("/login")
   public ResponseEntity<?> login(@RequestParam String username) {
      return userService.findByUsername(username).isPresent() ? ResponseEntity.ok("Successfully logged in") : ResponseEntity.notFound().build();
   }

   @PostMapping("/register")
   public ResponseEntity<?> register(@RequestParam String username) {
      Optional<User> user = userService.findByUsername(username);
      return user.isPresent()
         ? ResponseEntity.badRequest().body("User already exists")
         : ResponseEntity.ok(this.userService.saveUser(new User(username)));
   }

}
