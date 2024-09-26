package com.example.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.service.*;
import com.example.entity.*;
import java.util.*;
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

    //login
    @PostMapping("login")
    public ResponseEntity<Account> login(@RequestBody Account qAccount){
        qAccount = accountService.loginAccount(qAccount);
        return ResponseEntity.status(200).body(qAccount);
    }

    //create new message
    @PostMapping("messages")
    public ResponseEntity<Message> createMessage(@RequestBody Message message){
        message = messageService.createMessage(message);
        return ResponseEntity.status(200).body(message);
    }

    //get all messages
    @GetMapping("messages")
    public ResponseEntity<List<Message>> getAllMessages(){
        List<Message> messages = messageService.getAllMessages();
        return ResponseEntity.status(200).body(messages);
    }
/*
    //get message by ID 
    @GetMapping("messages/{messageId}")
    public ResponseEntity<Message> getMessageByID(@PathVariable int msgId){
        Message message = messageService.getMessageByID(msgId);
        return ResponseEntity.status(200).body(message);
    }

    //delete message by ID 
    @DeleteMapping("messages/{messageId}")
    public ResponseEntity<Integer> deleteMessageByID(@PathVariable int messageId){
        if(messageService.existsById(messageId)){
            messageService.deleteMsgById(messageId);
            return ResponseEntity.status(200).body(1);
        }
        else
            return ResponseEntity.status(200).build();
    }

    //Update message text by message ID
    @PatchMapping("messages/{messageId}")
    public ResponseEntity<Message> updateMessage(@PathVariable int messageId, @RequestBody String messageText){
        Message message = messageService.updateMsgByID(messageId, messageText);
        return ResponseEntity.status(200).body(message);
    }

    //get all messages of particular user (by account ID)
    @GetMapping("accounts/{accountId}/messages")
    public ResponseEntity<List<Message>> getAccountMessages(@PathVariable int accId){
        List<Message> messages = messageService.getAllAccMsgs(accId);
        return ResponseEntity.status(200).body(messages);
    }
*/
    //Error Handling
   // 409 CONFLICT - duplicate username detected
   @ExceptionHandler(ConflictException.class)
    public ResponseEntity<String> ConflictException(ConflictException ex){
        return ResponseEntity.status(409).body(ex.getMessage());
    }
   //401 Unauthorized - Login unsuccessful
   @ExceptionHandler(UnauthorizedException.class)
   public ResponseEntity<String> UnauthorizedException(UnauthorizedException ex){
       return ResponseEntity.status(401).body(ex.getMessage());
   }
   //400 Client Error - registration unsuccessful any other reason
   // message creation unsuccessful, update unsuccessful
    @ExceptionHandler(ClientException.class)
    public ResponseEntity<String> ClientException(ClientException ex){
        return ResponseEntity.status(400).body(ex.getMessage());
    }
}
