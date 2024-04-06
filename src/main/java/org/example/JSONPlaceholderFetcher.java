package org.example;

import java.net.http.HttpResponse;
import java.util.List;

public class JSONPlaceholderFetcher {

    private final PostApiHandler postApiHandler;

    public JSONPlaceholderFetcher(PostApiHandler postApiHandler) {

        this.postApiHandler = postApiHandler;
    }

    public Post getPostById(int id) {

        HttpResponse<String> response = postApiHandler.postUserData(String.valueOf(id));
        if (response.statusCode() == 200) {
            return PostMapper.convertJSONToPost(response.body());
        } else {
            throw new RuntimeException();
        }
    }

    public List<Post> getAllPosts() {
        HttpResponse<String> response = postApiHandler.getAllPostsData();
        if (response.statusCode() == 200) {
            return PostMapper.convertJSONToPostList(response.body());
        } else {
            throw new RuntimeException();
        }
    }
}




/*

    private final UserApiHandler apiHandler;
    public UserService(UserApiHandler apiHandler) {
        this.apiHandler = apiHandler;
    }

    public User getUserById(int id) {

        HttpResponse<String> response = apiHandler.getUserDate(id);
        if(response.statusCode() == 200) {
            return UserMapper.convertJSONToUser(response.body());
        } else {
            throw new RuntimeException();
        }
    }
 */