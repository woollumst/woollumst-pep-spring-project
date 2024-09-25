package com.example.repository;

import org.springframework.stereotype.Repository;

import com.example.entity.Message;

@Repository
public class MessageRepository { //used to be interface?
    public Message createMessage(Message message){
        //logic 
        return message;
    }
    public Message[] getAllMessages(){
        Message[] messages = null;
        //logic
        return messages;
    }

    public Message getMessageByID(int msgID){
        //logic
        return null;
    }

    public void deleteMsgByID(int msgID){
        //logic
        return;
    }

    public Message updateMsgByID(int msgID, String msgText){
        //logic
        return null;
    }

    public Message[] getAllAccMsgs(int accID){
        //logic
        return null;
    }
}
