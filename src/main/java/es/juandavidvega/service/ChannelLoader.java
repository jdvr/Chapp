package es.juandavidvega.service;

import es.juandavidvega.output.ChatMessages;
import es.juandavidvega.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelLoader {

    private final ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChannelLoader(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public ChatMessages loadMessages(){
        return chatMessageRepository.loadChannelMessages();
    }
}
