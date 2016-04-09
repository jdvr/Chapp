package es.juandavidvega.repository;

import es.juandavidvega.output.ChatMessage;
import es.juandavidvega.output.ChatMessages;

public interface ChatMessageRepository {
    void save(ChatMessage message);
    ChatMessages loadChannelMessages();

}
