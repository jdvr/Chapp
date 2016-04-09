package es.juandavidvega.output;

import java.util.ArrayList;
import java.util.List;

public class ChatMessages {
    private final List<ChatMessage> messages = new ArrayList<>();

    public void add(ChatMessage element) {
        messages.add(element);
    }
}
