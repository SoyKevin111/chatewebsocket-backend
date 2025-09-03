package com.example.chatwebsocket.repository;

import com.example.chatwebsocket.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMessageRepository extends MongoRepository<Message, String> {
}
