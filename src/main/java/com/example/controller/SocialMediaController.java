package com.example.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.*;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */

 @RestController
public class SocialMediaController {
    //AccountService accountService;
    //MessageService messageService;

    //register
    @PostMapping("register")
    public ResponseEntity<Account> register(){
        Account account = new Account();
        return ResponseEntity.body(account));
    }

    //login
    @PostMapping("login")
    public ResponseEntity<Account> login(){

    }

    //create new message
    @PostMapping("messages")
    public ResponseEntity<Message> createMessage(){

    }

    //get all messages
    @GetMapping("messages")
    public ResponseEntity<Message[]> getAllMessages(){

    }

    //get message by ID 
    @GetMapping("messages/{messageId}")
    public ResponseEntity<Message> getMessageByID(){

    }

    //delete message by ID 
    @DeleteMapping("messages/{messageId}")
    public ResponseEntity<Integer> deleteMessageByID(){

    }

    //Update message text by message ID
    @PatchMapping("messages/{messageId}")
    public ResponseEntity<Message> updateMessage(){

    }

    //get all messages of particular user (by account ID)
    @GetMapping("accounts/{accountId}/messages")
    public ResponseEntity<Message[]> getAccountMessages(){
        
    }

}
