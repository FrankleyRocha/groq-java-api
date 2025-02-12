package digital.ikr.groqapi.examples;

import digital.ikr.groqapi.GroqApi;

public class SingleMessageWithSystemExample {

    public static void main(String[] args) {

        String apiKey = System.getenv("GROQ_API_KEY");
        String model = "llama-3.3-70b-versatile";

        GroqApi api = new GroqApi(apiKey);

        String assistantMessage = api.completions(
            model,
            "O que é Java?",
            "Você é um assistente que fala português do Brasil e dá respostas curtas, porem concisas e objetivas"
        );

        System.out.println(assistantMessage);

    }

}
