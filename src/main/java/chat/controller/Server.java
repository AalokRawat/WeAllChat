package chat.controller;

import chat.data.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.HashMap;

@Controller
public class Server {

    HashMap<String, String> users = new HashMap<>();

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/receiver")
    @SendTo("/topic/send")
    public Message message(@Payload Message message){
        return message;
    }

    @MessageMapping("/addUser")
    @SendTo("/topic/send")
    public Message addUser(@Payload Message message,
                           SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }

}
