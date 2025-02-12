package digital.ikr.groqapi.examples;

import digital.ikr.groqapi.GroqApi;

public class SingleMessageExample {

    public static void main(String[] args) {

        String apiKey = System.getenv("GROQ_API_KEY");
        String model = "llama-3.3-70b-versatile";

        GroqApi api = new GroqApi(apiKey);

        String assistantMessage = api.completions(
            model,
            "O que é Java?"
        );

        System.out.println(assistantMessage);

    }

}
