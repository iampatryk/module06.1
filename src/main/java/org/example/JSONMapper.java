package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static PostTask3 mapTo(String jsonString) {
        try {
            JsonNode node = mapper.readTree(jsonString);
            long userId = node.get("userId").asLong();
            long id = node.get("id").asLong();
            String title = node.get("title").asText();
            String body = node.get("body").asText();
            return new PostTask3(userId,id,title,body);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
