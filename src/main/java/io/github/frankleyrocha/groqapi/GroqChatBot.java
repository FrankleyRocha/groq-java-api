package io.github.frankleyrocha.groqapi;

import java.util.ArrayList;
import java.util.List;

public class GroqChatBot {

    private String model;
    private GroqApi api;
    private List<GroqApi.Message> memory;

    public GroqChatBot(GroqApi api, String model) {
        this.model = model;
        this.api = api;
    }

    public GroqChatBot(GroqApi api, String model, String systemMessage) {
        this.model = model;
        this.api = api;
        this.memory = new ArrayList<>();
        this.memory.add(new GroqApi.Message("system",systemMessage));
    }

    public String chat(String message){

        memory.add(new GroqApi.Message(
            "user",
            message
        ));

        String assistantMessage = api.completions(
            model,
            memory
        );

        memory.add(new GroqApi.Message(
            "assistant",
            assistantMessage
        ));

        return assistantMessage;
    }

}
