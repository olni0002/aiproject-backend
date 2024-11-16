package com.example.aitest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aitest.service.ChatService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ChatController {

    private ChatService chatService;
    
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @CrossOrigin
    @GetMapping("/chat/{prompt}")
    public Mono<String> chatPrompt(@PathVariable String prompt) {
        return chatService.chatPrompt(prompt);
        
    }
}
