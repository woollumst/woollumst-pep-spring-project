package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Message;
import com.example.repository.MessageRepository;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    
    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }
/*
    //Message service methods below
    //create new message
    public Message createMessage(Message message){
        return messageRepository.save(message);
    }

    //get all msgs
    public Message[] getAllMessages(){
        return messageRepository.getAllMessages();
    }

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
