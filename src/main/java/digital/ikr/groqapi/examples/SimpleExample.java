package digital.ikr.groqapi.examples;

import java.util.ArrayList;
import java.util.List;

import digital.ikr.groqapi.GroqApi;

public class SimpleExample {

    public static void main(String[] args) {

        String apiKey = System.getenv("GROQ_API_KEY");
        String model = "llama-3.3-70b-versatile";

        GroqApi api = new GroqApi(apiKey);

        List<GroqApi.Message> messages = new ArrayList<>();

        messages.add(new GroqApi.Message(
            "system",
            "Você é um assistentente que fala português"
        ));

        messages.add(new GroqApi.Message(
            "user",
            "O que é Java?"
        ));

        String assistantMessage = api.completions(
            model,
            messages
        );

        System.out.println(assistantMessage);

    }

}
