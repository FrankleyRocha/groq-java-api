package digital.ikr.groqapi.examples;

import java.util.Scanner;

import digital.ikr.groqapi.GroqApi;
import digital.ikr.groqapi.GroqChatBot;

public class ChatBotExample {

    public static void main(String[] args) throws Exception {

        String apiKey = System.getenv("GROQ_API_KEY");
        String model = "llama-3.3-70b-versatile";
        GroqApi api = new GroqApi(apiKey);
        GroqChatBot bot = new GroqChatBot(
            api,
            model,
            "Você é um assistentente que fala português, fale o máximo possível como um ser humano de forma humanizada!"
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

            String assistantMessage = bot.completions(userMessage);

            System.out.println();
            System.out.println(assistantMessage);
            System.out.println();

        }

    }
}