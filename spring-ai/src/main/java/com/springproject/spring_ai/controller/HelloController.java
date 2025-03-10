package com.springproject.spring_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final ChatClient chatClient;

    public HelloController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping
    public String prompt(@RequestParam String message) {
        return chatClient
                .prompt(message)
                .call()
                .content();
    }
}
