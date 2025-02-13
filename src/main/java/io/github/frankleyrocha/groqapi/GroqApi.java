package io.github.frankleyrocha.groqapi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class GroqApi {

    private final String baseUrl;
    private final String apiKey;

    public GroqApi(String apiKey){
        this.baseUrl = "https://api.groq.com";
        this.apiKey = apiKey;
    }

    public GroqApi(String baseUrl, String apiKey) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }

    private String apiCall(String endpointUrl, String requestBody){

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpointUrl))
                .header("Authorization", "Bearer " + this.apiKey)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200)
                return response.body();
            else
                throw new RuntimeException("Error! response.status: "+response.statusCode()+", response.body: "+response.body());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public String completions(String model, List<Message> messages){

        String endpointUrl = this.baseUrl+"/openai/v1/chat/completions";
        String requestBody = "{\"model\":\""+model+"\", \"messages\":"+messages+"}";
        String responseBody = apiCall(endpointUrl, requestBody);
        String content = JsonPath.read(responseBody, "$.choices[0].message.content");

        return content;

    }

    public String completions(String model, String message){

        List<Message> messages = new ArrayList<>();

        messages.add(new GroqApi.Message(
            "user",
            message
        ));

        return completions(model, messages);

    }

    public String completions(String model, String userMessage, String systemMessage){

        List<Message> messages = new ArrayList<>();

        messages.add(new GroqApi.Message(
            "system",
            systemMessage
        ));

        messages.add(new GroqApi.Message(
            "user",
            userMessage
        ));

        return completions(model, messages);

    }

    public record Message(String role, String content){

        public final String toString() {

            String jsonSafe = content
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");

            return "{\"role\":\""+role+"\",\"content\":\""+jsonSafe+"\"}";
        }

    }

}
