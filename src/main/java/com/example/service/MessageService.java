package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Message;
import com.example.exception.ClientException;
import com.example.repository.MessageRepository;
import java.util.List;

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

    //get all msgs
    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }
/*
    //get message by message ID 
    public Message getMessageByID(int msgID){
        return messageRepository.getMessageByID(msgID);
    }
    //delete msg by msg ID
    public void deleteMsgByID(int msgID){
        messageRepository.deleteMsgByID(msgID);
    }
    //update by message ID
    public Message updateMsgByID(int msgID, String msgText){
        return messageRepository.updateMsgByID(msgID, msgText);
    }
    //get all msgs by acc ID
    public Message[] getAllAccMsgs(int accID){
        return messageRepository.getAllAccMsgs(accID);
    } */
}
