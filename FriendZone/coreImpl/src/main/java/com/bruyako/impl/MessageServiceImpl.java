package com.bruyako.impl;

import com.bruyako.MessageDaoInterface;
import com.bruyako.MessageService;
import com.bruyako.model.ContactDto;
import com.bruyako.model.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by brunyatko on 10.11.15.
 */
@Transactional
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDaoInterface messageDaoInterface;

    @Override
    public List<MessageDto> getConversation(ContactDto from, ContactDto to) {

        long contactFromId = from.getContactId();
        long contactToId = to.getContactId();

        return messageDaoInterface.getConversation(contactFromId, contactToId);
    }

    @Override
    public void sendMessage(String content, Long from, Long to) {

        MessageDto message = new MessageDto();
        messageDaoInterface.storeMessage(message);
    }
}
