package com.example.aitest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder @AllArgsConstructor
public class Body {
    
    private String model;
    private Message[] messages;
    private int max_tokens;
    private boolean stream;

}