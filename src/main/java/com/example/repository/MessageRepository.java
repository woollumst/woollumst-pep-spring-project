package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entity.*;
import java.util.*;
@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> { //used to be interface?
    
    void deleteByMessageId(int messageId);
    Message findBymessageId(int messageId);
    boolean existsByMessageId(int messageId);
    //Message saveByMessageIdAndMessageText(int messageId, String messageText); //errored out
    List<Message> findAllByPostedBy(int postedBy);
}
