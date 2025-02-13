# groq-java-api

**Groq API Java Client Library**
A Java library for interacting with the Groq API.

## 📂 Examples

Check out practical usage examples in the repository:
🔗 [groq-java-api-examples](https://github.com/FrankleyRocha/groq-java-api-examples/tree/main/src/main/java/io/github/frankleyrocha/groqapi/examples)

---

## 📦 Installation via Maven

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.github.frankleyrocha</groupId>
    <artifactId>groqapi</artifactId>
    <version>1.0.1</version>
</dependency>
```

---

## 🚀 Usage Examples

### 📝 SingleMessageExample

A simple request to generate a response from the AI:

```java
package io.github.frankleyrocha.groqapi.examples;

import io.github.frankleyrocha.groqapi.GroqApi;

public class SingleMessageExample {

    public static void main(String[] args) {

        String apiKey = System.getenv("GROQ_API_KEY");
        String model = "llama-3.3-70b-versatile";

        GroqApi api = new GroqApi(apiKey);

        String assistantMessage = api.completions(
            model,
            "What is Java?" //User message
        );

        System.out.println(assistantMessage);

    }
}
```

---

### 🛠️ SingleMessageWithSystemExample

An example using system instructions for short and concise responses:

```java
package io.github.frankleyrocha.groqapi.examples;

import io.github.frankleyrocha.groqapi.GroqApi;

public class SingleMessageWithSystemExample {

    public static void main(String[] args) {

        String apiKey = System.getenv("GROQ_API_KEY");
        String model = "llama-3.3-70b-versatile";

        GroqApi api = new GroqApi(apiKey);

        String assistantMessage = api.completions(
            model,
            "What is Java?", //User message
            "You are an assistant who provides short, "+ //System message
            "concise, and objective answers of no more than 5 lines."
        );

        System.out.println(assistantMessage);

    }
}
```

---

### 🤖 ChatBotExample

A simple example of a chatbot with memory:

```java
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
            "You are an helpfull assistant. Speak in the most human-like manner possible!" //System message
        );

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome! You are chatting with the model: " + model);
        System.out.println("Type \"exit\" to end the conversation.");

        while (true) {
            System.out.print("$ ");
            String userMessage = sc.nextLine();

            if ("exit".equalsIgnoreCase(userMessage)) {
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
```

---

## 🌍 Contributing

This library is **community-maintained**. Contributions are welcome!

### Ways to contribute:
1. **Report Issues**: Open an issue describing the problem.
2. **Suggest Improvements**: Share ideas for new features.
3. **Submit Pull Requests**:
   - Fork the repository.
   - Create a new branch (`git checkout -b feature-name`).
   - Make your changes and commit (`git commit -m "Description of changes"`).
   - Open a pull request! 🎉

We appreciate all contributions! 💙

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).