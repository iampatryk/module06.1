package org.example;

import java.net.http.HttpResponse;
import java.util.List;

public class JSONPlaceholderFetcher {

    private final PostApiHandler postApiHandler;

    public JSONPlaceholderFetcher(PostApiHandler postApiHandler) {

        this.postApiHandler = postApiHandler;
    }

    public Post getPostById(int id) {

        HttpResponse<String> response = postApiHandler.getPostUserData(String.valueOf(id));
        if (response.statusCode() == 200) {
            return JSONMapper.convertJSONToPost(response.body());
        } else {
            throw new RuntimeException();
        }
    }

    public List<Post> getAllPosts() {
        HttpResponse<String> response = postApiHandler.getAllPostsData();
        if (response.statusCode() == 200) {
            return JSONMapper.convertJSONToPostList(response.body());
        } else {
            throw new RuntimeException();
        }
    }


//    public boolean addPost(String post) {
//        HttpResponse<String> response = postApiHandler.addPostData(post);
//        if (response.statusCode() == 201) {
//            return true;
//        } else {
//            throw new RuntimeException();
//        }
//    }


}


