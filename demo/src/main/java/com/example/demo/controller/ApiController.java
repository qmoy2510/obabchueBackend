package com.example.demo.controller;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/")
    public String dddd(){
        // The client gets the API key from the environment variable `GEMINI_API_KEY`.
        Client client = Client.builder().apiKey("API키").build();

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.5-flash",
                        "오늘 먹을 음식 추천좀 해줘봐",
                        null);
        return response.text();
    }
}
