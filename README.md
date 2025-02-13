# groq-java-api
Groq API Java Client Library
- [Examples git repo](https://github.com/FrankleyRocha/groq-java-api-examples)

# maven
```xml
<dependency>
    <groupId>io.github.frankleyrocha</groupId>
    <artifactId>groqapi</artifactId>
    <version>1.0.1</version>
</dependency>
```

# SingleMessageExample
````Java
package io.github.frankleyrocha.groqapi.examples;

import io.github.frankleyrocha.groqapi.GroqApi;

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
````

# SingleMessageWithSystemExample
````Java
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
````

# ChatBotExample
````Java
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
````