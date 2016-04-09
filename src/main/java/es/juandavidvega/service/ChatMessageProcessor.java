package es.juandavidvega.service;

import es.juandavidvega.input.UserMessage;
import es.juandavidvega.output.ChatMessage;
import es.juandavidvega.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageProcessor {

    private final ChatMessageRepository chatMessageRepository;


    @Autowired
    public ChatMessageProcessor(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public void process(UserMessage rawMessage){
        ChatMessage message = new ChatMessage(rawMessage.getContent(), rawMessage.getSender(), rawMessage.getSendDate());
        chatMessageRepository.save(message);
    }
}
