package es.juandavidvega.action;

import es.juandavidvega.output.ChatMessages;
import es.juandavidvega.service.ChannelLoader;
import es.juandavidvega.service.ChatMessageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import es.juandavidvega.input.HelloMessage;
import es.juandavidvega.input.UserMessage;
import es.juandavidvega.output.ChatMessage;
import es.juandavidvega.output.GreetingMessage;


@Controller
public class ChatRoomController {

    private final ChatMessageProcessor chatMessageProcessor;
    private final ChannelLoader channelLoader;

    @Autowired
    public ChatRoomController(ChatMessageProcessor chatMessageProcessor, ChannelLoader channelLoader) {
        this.chatMessageProcessor = chatMessageProcessor;
        this.channelLoader = channelLoader;
    }

    @MessageMapping("/hello")
    @SendTo("/chat/joined")
    public ChatMessages join(HelloMessage message) throws Exception {
        simulatedDelay();
        GreetingMessage greetingMessage = new GreetingMessage(message.getSender());
        ChatMessages messages = channelLoader.loadMessages();
        messages.add(greetingMessage);
        return messages;
    }

    @MessageMapping("/send/message")
    @SendTo("/chat/new/message")
    public ChatMessages message(UserMessage message) throws Exception {
        simulatedDelay();
        ChatMessages messages = new ChatMessages();
        ChatMessage processedMessage = chatMessageProcessor.process(message);
        messages.add(processedMessage);
        return messages;
    }

    private void simulatedDelay() throws InterruptedException {
        Thread.sleep(3000);
    }
}
