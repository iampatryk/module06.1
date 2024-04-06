package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        PostApiHandler postApiHandler = new PostApiHandler();
        JSONPlaceholderFetcher jsonPlaceholderFetcher = new JSONPlaceholderFetcher(postApiHandler);


//        --- GETTING POST BY ID ---
//        System.out.println(jsonPlaceholderFetcher.getPostById(1));


//        --- GETTING ALL POSTS ---
        List<Post> posts = jsonPlaceholderFetcher.getAllPosts();
        for (Post post : posts) {
            System.out.println(post);
        }



    }
}