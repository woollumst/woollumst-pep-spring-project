package com.example.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.service.*;
import com.example.entity.*;
import java.util.List;
import com.example.exception.*;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */

 @RestController
public class SocialMediaController {
    private final AccountService accountService;
    private final MessageService messageService;

    @Autowired
    public SocialMediaController(AccountService accountService, MessageService messageService){
        this.accountService = accountService;
        this.messageService = messageService;
    }

    //register
    @PostMapping("register")
    public ResponseEntity<Account> register(@RequestBody Account newAcc){
        newAcc = accountService.registerAccount(newAcc);
        return ResponseEntity.status(200).body(newAcc);
    }
/*
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
*/
    //Error Handling ?
   // 409 CONFLICT - duplicate username detected
   @ExceptionHandler(ConflictException.class)
    public ResponseEntity<String> ConflictException(ConflictException ex){
        return ResponseEntity.status(409).body(ex.getMessage());
    }
   //401 Unauthorized - Login unsuccessful
   @ExceptionHandler(UnauthorizedException.class)
   public ResponseEntity<String> UnauthorizedException(ClientException ex){
       return ResponseEntity.status(400).body(ex.getMessage());
   }
   //400 Client Error - registration unsuccessful any other reason
   // message creation unsuccessful, update unsuccessful
    @ExceptionHandler(ClientException.class)
    public ResponseEntity<String> ClientException(ClientException ex){
        return ResponseEntity.status(400).body(ex.getMessage());
    }
}
