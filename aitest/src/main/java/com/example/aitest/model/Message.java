package com.example.aitest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @AllArgsConstructor @Builder
public class Message {
    
    private String role;
    private String content;

}