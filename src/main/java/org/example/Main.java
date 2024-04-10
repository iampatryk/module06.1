package org.example;

import java.net.http.HttpResponse;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PostApiHandler postApiHandler = new PostApiHandler();
        JSONPlaceholderFetcher jsonPlaceholderFetcher = new JSONPlaceholderFetcher(postApiHandler);


//        --- GETTING POST BY ID ---
        System.out.println(jsonPlaceholderFetcher.getPostById(1));


//        --- GETTING ALL POSTS ---
        List<Post> posts = jsonPlaceholderFetcher.getAllPosts();
        for (Post post : posts) {
            System.out.println(post);
        }


//        --- ADD POST --- 1
        String newPost = "{\"title\": \"New Post Title\", \"body\": \"New Post Body\"}";
        boolean addPostSuccess = jsonPlaceholderFetcher.addPost(newPost);

        if(addPostSuccess) {
            System.out.println("Successfully added new post");
        } else {
            System.out.println("Failed to add new post");
//            return;
        }


        //        --- ADD POST --- 2
//        String newPost = "{\"title\": \"New Post Title\", \"body\": \"New Post Body\"}";
//        boolean addPostSuccess = postApiHandler.addPostData(newPost);
//
//        if(addPostSuccess) {
//            System.out.println("Successfully added new post");
//        } else {
//            System.out.println("Failed to add new post");
////            return;
//        }






    }
}