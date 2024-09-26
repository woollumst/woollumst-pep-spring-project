package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Message;
import com.example.exception.ClientException;
import com.example.repository.MessageRepository;
import java.util.*;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final AccountService accountService;
    @Autowired
    public MessageService(MessageRepository messageRepository, AccountService accountService){
        this.messageRepository = messageRepository;
        this.accountService = accountService;
    }
    //Message service methods below
    //create new message
    public Message createMessage(Message message){
        if(message.getMessageText().length() > 255 || message.getMessageText().length() < 1)
            throw new ClientException("Invalid message");
        if(!accountService.checkUserInDB(message.getPostedBy()))
            throw new ClientException("Account Invalid!");
        return messageRepository.save(message);
    }
    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }
    /*
    public Message getMessageByID(int msgID){
        Optional<Message> message;
        message = messageRepository.findById(msgID);
        if(message.isPresent())
            return message.get();
        else {
            return null;
        }
    }
    //delete msg by msg ID
    public Integer deleteMsgById(int msgID){
        if(messageRepository.existsByMessageId(msgID)){
            messageRepository.deleteByMessageId(msgID);
            return 1;
        }
        return 0;
    }
    public boolean existsById(int msgId){
        return messageRepository.existsById(msgId);
    }
 
    //update by message ID
    public Message updateMsgByID(int msgID, String msgText){
        return messageRepository.saveByMessageIdAndMessageText(msgID, msgText);
    }
    //get all msgs by acc ID
    public List<Message> getAllAccMsgs(int accID){
        return messageRepository.findAllByPostedBy(accID);
    }*/
}