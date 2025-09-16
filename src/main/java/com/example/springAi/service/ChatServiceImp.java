package com.example.springAi.service;

import com.example.springAi.entity.SampleEntity;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImp implements ChatService {

    private ChatClient chatClient;

    public ChatServiceImp(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @Override
    public String chatWithAi(String str) {

        String staticPrompt = "how are you.";

        String result = "";
//        result = chatClient    // simple prompt
//                .prompt()
//                .call()
//                .content();

//        result = chatClient.prompt()  // user define prompt.
//                .user(staticPrompt)
//                .system("you are expert in java.")    // tell llm how o behave
//                .call()
//                .content();

        Prompt newPrompts = new Prompt();// using this way alos we cab create the prompt
//         chat response will give u the generation list and meta data also
//         below is the correct procedure to ask the ai and get the answer.
        result = chatClient
                .prompt(staticPrompt)
                .call()
                .chatResponse()
                .getResult()
                .getOutput() // this message is given by llm
                .getText();

//         or else u can get the metadata  from chat response.
        chatClient
                .prompt(staticPrompt)
                .call()
                .chatResponse()
                .getMetadata().getRateLimit();

        chatClient.prompt()
                .call()
                .entity(SampleEntity.class);   //using thos u will get response in pojo

        chatClient.prompt()
                .call()
                .entity(new ParameterizedTypeReference<List<SampleEntity>>() {
                });  // this will give u result in string.

        return result;
    }
}
