package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PostMapper {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Post convertJSONToPost(String userJson) {
        Post post = new Post();

        try {
            JsonNode node = MAPPER.readTree(userJson);
            post.setTitle(node.get("title").textValue());
            post.setBody(node.get("body").textValue());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return post;
    }


}
