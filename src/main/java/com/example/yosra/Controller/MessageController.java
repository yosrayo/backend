/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.yosra.Controller;

import com.example.yosra.Exception.ResourceNotFoundException;
import com.example.yosra.Model.Message;
import com.example.yosra.Repository.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TPC
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageRepository messageRepository;
    
    
    @GetMapping()
    public List<Message> list() {
        return (List<Message>) messageRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Message get(@PathVariable Long id) {
        return (Message) messageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Message", "id", id));
    }
    
    @PostMapping
    public Message post(@RequestBody Message message) {
        return messageRepository.save(message);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        messageRepository.delete(get(id));
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public String handleError() {
        return "erreur de connexion";
    }
    
}
