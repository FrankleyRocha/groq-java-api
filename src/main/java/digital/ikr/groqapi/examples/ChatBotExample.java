package digital.ikr.groqapi.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import digital.ikr.groqapi.GroqApi;

public class ChatBotExample {

    public static void main(String[] args) throws Exception {

        String apiKey = System.getenv("GROQ_API_KEY");

        GroqApi api = new GroqApi(apiKey);

        List<GroqApi.Message> memory = new ArrayList<>();
        memory.add(new GroqApi.Message(
            "system",
            "Você é um assistentente que fala português, fale o máximo possível como um ser humano de forma humanizada!"
        ));

        Scanner sc = new Scanner(System.in);

        String model = "llama-3.3-70b-versatile";

        System.out.println("Bem vindo, você está conversando com o modelo: "+model);
        System.out.println("Escreva \"sair\" para encerrar!");

        while(true){

            System.out.print("$ ");
            String userMessage = sc.nextLine();

            if("sair".equals(userMessage.toLowerCase())){
                sc.close();
                break;
            }

            memory.add(new GroqApi.Message(
                "user",
                userMessage
            ));

            String assistantMessage = api.completions(
                model,
                memory
            );

            System.out.println();
            System.out.println(assistantMessage);
            System.out.println();

            memory.add(new GroqApi.Message(
                "assistant",
                assistantMessage
            ));

        }

    }
}