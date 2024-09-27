package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Message;
import com.example.exception.ClientException;
import com.example.repository.MessageRepository;
import java.util.*;
import javax.transaction.Transactional;

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
 
    public Message getMessageByID(int msgID){
        Message message = messageRepository.findBymessageId(msgID);
        return message;
    }

    //delete msg by msg ID
    @Transactional
    public void deleteMsgById(int msgID){
        if(messageRepository.existsByMessageId(msgID)){
            messageRepository.deleteByMessageId(msgID);
        }
    }
    public boolean existsById(int msgId){
        return messageRepository.existsById(msgId);
    }
 
    //update by message ID
    public Message updateMsgByID(int messageId, String messageText){
        if(!(messageText.length() > 1 && messageText.length() <= 255) || !messageRepository.existsByMessageId(messageId)){
            throw new ClientException("Message Update failed!");
        }
        else{
            Message message = messageRepository.findBymessageId(messageId);
            message.setMessageText(messageText);
            return messageRepository.save(message);
        }
    }
    //get all msgs by acc ID
    public List<Message> getAllAccMsgs(int postedBy){
        return messageRepository.findAllBypostedBy(postedBy);
    }
}