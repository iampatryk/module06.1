import org.example.JSONMapper;
import org.example.JSONPlaceholderFetcher;
import org.example.Post;
import org.example.PostApiHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostTests {

    @Test
    public void getSinglePostTest() {
        JSONPlaceholderFetcher jsonPlaceholderFetcher = new JSONPlaceholderFetcher(new PostApiHandler());

        Post expectedPost = new Post(1, 1, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
        Post actualPost = jsonPlaceholderFetcher.getPostById(1);

        Assertions.assertEquals(expectedPost, actualPost);

    }

    @Test
    public void getMultiplePostsTest() {
        JSONPlaceholderFetcher jsonPlaceholderFetcher = new JSONPlaceholderFetcher(new PostApiHandler());

        int expectedSize = 100;
        int actualSize = jsonPlaceholderFetcher.getAllPosts().size();

        Assertions.assertEquals(expectedSize, actualSize);

    }

    @Test
    public void mapToJSONTest() {
//        JSONMapper jsonMapper = new JSONMapper();

        Post post = new Post(1,1,"Test Title","Test Body");
        String expectedJson = "{\"userId\":1,\"id\":1,\"title\":\"Test Title\",\"body\":\"Test Body\"}";
        String actualJson = JSONMapper.mapTo(post);

        Assertions.assertEquals(expectedJson, actualJson);

    }

    @Test
    public void addPostTest() {
        PostApiHandler postApiHandler = new PostApiHandler();
        JSONPlaceholderFetcher jsonPlaceholderFetcher = new JSONPlaceholderFetcher(postApiHandler);

        String newPost = "{\"title\": \"New Post Title\", \"body\": \"New Post Body\"}";
        boolean result = jsonPlaceholderFetcher.addPost(newPost);

        Assertions.assertTrue(result);

    }
}
