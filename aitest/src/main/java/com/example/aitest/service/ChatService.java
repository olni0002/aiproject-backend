package com.example.aitest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.aitest.model.Body;
import com.example.aitest.model.Message;

import reactor.core.publisher.Mono;

@Service
public class ChatService {
    private final WebClient webClient;
    private Body body;

    public ChatService(WebClient.Builder webClientBuilder, Body.BodyBuilder bodyBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api-inference.huggingface.co").build();

        this.body = bodyBuilder.model("Qwen/Qwen2.5-Coder-32B-Instruct")
                            .max_tokens(10000)
                            .stream(false)
                            .build();
    }

    public Mono<String> chatPrompt(String prompt) {
    
        Message[] messages = {new Message("user", prompt)};
        body.setMessages(messages);

        return webClient.post()
                .uri("/models/Qwen/Qwen2.5-Coder-32B-Instruct/v1/chat/completions")
                .bodyValue(body)
                .header("Authorization", "Bearer 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")
                .header("Content-Type", "application/json")
                .retrieve()
                .bodyToMono(String.class);
        
    }
}
