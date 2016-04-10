package es.juandavidvega.output;


import java.util.Date;

public class GreetingMessage extends ChatMessage{

    public GreetingMessage(String userName) {
        super("Hello " + userName + ", welcome to chat!", userName, new Date());
    }

    @Override
    public MessageType getType() {
        return MessageType.Greeting;
    }
}
