package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entity.*;
@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> { //used to be interface?
/* 
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
*/
}
