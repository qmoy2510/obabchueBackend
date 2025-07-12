package com.example.demo.controller;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    @PostMapping("/api/recommend")
    public String recommend(){
        // The client gets the API key from the environment variable `GEMINI_API_KEY`.
        Client client = Client.builder().apiKey("").build();

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.5-flash",
                        "맑은날씨에 맵지 않고 맛있는"+ " 음식을 json 형태로 4개 추천 해줘 각 데이터 뭉치 하나당 메뉴, 음식이 각각 하나씩 나오게 작성해줘 json만 출력해줘",
                        null);
        return response.text();
    }
}
