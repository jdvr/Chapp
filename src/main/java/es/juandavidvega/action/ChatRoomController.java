package es.juandavidvega.action;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import es.juandavidvega.input.HelloMessage;
import es.juandavidvega.input.UserMessage;
import es.juandavidvega.output.ChatMessage;
import es.juandavidvega.output.GreetingMessage;


@Controller
public class ChatRoomController {

    @MessageMapping("/hello")
    @SendTo("/chat/joined")
    public GreetingMessage join(HelloMessage message) throws Exception {
        simulatedDelay();
        return new GreetingMessage("Hello " + message.getSender() + ", welcome to chat!");
    }

    @MessageMapping("/send/message")
    @SendTo("/chat/new/message")
    public ChatMessage message(UserMessage message) throws Exception {
        simulatedDelay();
        return new ChatMessage(message);
    }




    private void simulatedDelay() throws InterruptedException {
        Thread.sleep(3000);
    }
}
