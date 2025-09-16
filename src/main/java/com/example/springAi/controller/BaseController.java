package com.example.springAi.controller;


import com.example.springAi.service.ChatServiceImp;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class BaseController {

    private ChatClient chatClient;
    @Autowired
    private ChatServiceImp chatServiceImp;

    public BaseController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/query/{q}")
    public ResponseEntity<String> getTheResponseFromOpenAi(@PathVariable(value = "q") String query) {
        String result = chatClient.prompt(query).call().content();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/query/service/{q}")
    public ResponseEntity<String> getTheResponseFromJavaExert(@PathVariable(value = "q") String query) {
        String result = chatServiceImp.chatWithAi(query);
        return ResponseEntity.ok(result);
    }
}

