package com.example.exportresponseasjsonfile.services;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
public class ExportIntermediaryService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public ExportIntermediaryService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public void exporResposeToFile() {
        String url = "https://api.sulamericaseguros.com.br/open-insurance/channels/v1/intermediary/SP";
        String response =  restTemplate.getForObject(url, String.class);

        try {
            // Salvar o response em um arquivo JSON
            String filePath = "C:\\ws-developer\\spring-java\\export-response-as-json-file\\exported\\file.json";
            // Converter a String JSON para um objeto Java (opcional)
            Object parsedResponse = objectMapper.readValue(response, Object.class);

            // Salvar o response como JSON no arquivo
            objectMapper.writeValue(new File(filePath), parsedResponse);
            System.out.println("Response salvo em " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
