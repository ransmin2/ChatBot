package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;

@Service
public class ChatGPTService {
    @Value("${openai.api-key}")
    private String apiKey;

    private final String apiURL = "https://api.openai.com/v1/chat/completions";

    public String getGptResponse(String input) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        // Ensure model parameter is included and other parameters comply with API expectations
        String body = String.format("{ \"model\": \"gpt-3.5-turbo\", \"messages\": [{ \"role\": \"system\", \"content\": \"You are a helpful assistant.\" },{ \"role\": \"user\", \"content\": \"%s\" }]}", input);

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(apiURL, entity, String.class);
            // Extract and return the desired output from the API’s response
            return response.getBody();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
