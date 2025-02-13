package io.github.frankleyrocha.groqapi.examples;

import io.github.frankleyrocha.groqapi.GroqApi;

public class SingleMessageWithSystemExample {

    public static void main(String[] args) {

        String apiKey = System.getenv("GROQ_API_KEY");
        String model = "llama-3.3-70b-versatile";

        GroqApi api = new GroqApi(apiKey);

        String assistantMessage = api.completions(
            model,
            "O que é Java?",
            "Você é um assistente que fala português do Brasil e dá respostas curtas, concisas e objetivas de no máximo 5 (cinco) linhas."
        );

        System.out.println(assistantMessage);

    }

}
