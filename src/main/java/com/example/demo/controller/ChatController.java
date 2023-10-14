package com.example.demo.controller;

import com.example.demo.model.Chat;
import com.example.demo.service.ChatGPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatGPTService chatGPTService;

    @PostMapping("/ask")
    public Chat askGpt(@RequestBody Chat chat) {
        String response = chatGPTService.getGptResponse(chat.getInput());
        chat.setOutput(response);
        return chat;
    }
}
