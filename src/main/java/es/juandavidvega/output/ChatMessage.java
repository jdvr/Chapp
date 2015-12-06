package es.juandavidvega.output;

import java.util.Date;

import es.juandavidvega.input.UserMessage;

public class ChatMessage {

    private String content;
    private String sender;
    private Date sendDate;

    public ChatMessage(UserMessage userMessage) {
        this.content = userMessage.getContent();
        this.sender = userMessage.getSender();
        this.sendDate = userMessage.getSendDate();
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public Date getSendDate() {
        return sendDate;
    }
}
