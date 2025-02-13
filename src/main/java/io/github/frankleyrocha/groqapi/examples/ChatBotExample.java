package io.github.frankleyrocha.groqapi.examples;

import java.util.Scanner;

import io.github.frankleyrocha.groqapi.GroqApi;
import io.github.frankleyrocha.groqapi.GroqChatBot;

public class ChatBotExample {

    public static void main(String[] args) throws Exception {

        String apiKey = System.getenv("GROQ_API_KEY");
        String model = "llama-3.3-70b-versatile";
        GroqApi api = new GroqApi(apiKey);
        GroqChatBot bot = new GroqChatBot(
            api,
            model,
            "Você é um assistentente que fala português, fale como um ser humano da forma mais humanizada possível!"
        );

        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo, você está conversando com o modelo: "+model);
        System.out.println("Escreva \"sair\" para encerrar!");

        while(true){

            System.out.print("$ ");
            String userMessage = sc.nextLine();

            if("sair".equals(userMessage.toLowerCase())){
                sc.close();
                break;
            }

            String assistantMessage = bot.chat(userMessage);

            System.out.println();
            System.out.println(assistantMessage);
            System.out.println();

        }

    }
}