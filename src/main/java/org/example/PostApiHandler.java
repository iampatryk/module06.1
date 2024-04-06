package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostApiHandler {

    private final String userURL = "https://jsonplaceholder.typicode.com/posts";
    private final HttpClient client = HttpClient.newHttpClient();

    public HttpResponse<String> getPostUserData(String userJSON) {
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(userURL + "/" + userJSON))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<String> getAllPostsData() {
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(userURL))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addPostData(String post) {
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(userURL))
                    .POST(HttpRequest.BodyPublishers.ofString(post))
                    .header("Content-Type","application/json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.statusCode() ==201;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}
