package com.usa.service;

import com.usa.model.BoxModel;
import com.usa.model.MessageModel;
import com.usa.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<MessageModel> getAllMessages(){
        return (List<MessageModel>) messageRepository.getAllMessages();
    }

    public Optional<MessageModel> getMessage(Integer id){
        return messageRepository.getMessage(id);
    }

    public MessageModel saveMessage(MessageModel messageModel){
        if (messageModel.getIdMessage() == null){
            return  messageRepository.saveMessage(messageModel);
        }else {
            Optional<MessageModel> optional= messageRepository.getMessage(messageModel.getIdMessage());
            if (optional.isEmpty()){
                return messageRepository.saveMessage(messageModel);
            }else {
                return messageModel;
            }
        }
    }

    public boolean deleteMessage(Integer id){
        Boolean aBoolean = getMessage(id).map(m -> {
            messageRepository.deleteMessage(m.getIdMessage());
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public MessageModel updateMessage(MessageModel messageModel){
        if (messageModel.getIdMessage() != null) {
            Optional<MessageModel> optional = messageRepository.getMessage(messageModel.getIdMessage());
            if (!optional.isEmpty()){
                if (messageModel.getMessageText() != null) {
                    optional.get().setMessageText(messageModel.getMessageText());
                    optional.get().setClient(messageModel.getClient());
                    optional.get().setBox(messageModel.getBox());
                }
                messageRepository.saveMessage(optional.get());
                return optional.get();
            }else {
                return messageModel;
            }
        }else {
            return messageModel;
        }
    }
}
