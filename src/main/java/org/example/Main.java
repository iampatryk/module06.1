package org.example;

public class Main {
    public static void main(String[] args) {

        PostApiHandler postApiHandler = new PostApiHandler();
        JSONPlaceholderFetcher jsonPlaceholderFetcher = new JSONPlaceholderFetcher(postApiHandler);
        System.out.println(jsonPlaceholderFetcher.getPostById(1));
    }
}