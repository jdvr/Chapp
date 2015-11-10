package es.juandavidvega.action;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import es.juandavidvega.hello.Greeting;
import es.juandavidvega.hello.HelloMessage;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        simulatedDelay();
        return new Greeting("Hello, " + message.getName() + "!");
    }

    private void simulatedDelay() throws InterruptedException {
        Thread.sleep(3000);
    }
}
