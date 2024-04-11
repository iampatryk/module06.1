import org.example.JSONPlaceholderFetcher;
import org.example.Post;
import org.example.PostApiHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.net.http.HttpResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostTest {
    @Mock
    private JSONPlaceholderFetcher jsonPlaceholderFetcher;

    @Mock
    private PostApiHandler postApiHandler;

    @Mock
    private HttpResponse<String> response;

    @Test
    public void getPostByIdTest() {

        String jsonResponse = "{\"userId\":1,\"id\":1,\"title\":\"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\"body\":\"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"}";

        when(response.statusCode()).thenReturn(200);
        when(response.body()).thenReturn(jsonResponse);
        when(postApiHandler.getPostUserData(anyString())).thenReturn(response);

        Post expectedPost = new Post(1, 1, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
        Post actualPost = jsonPlaceholderFetcher.getPostById(1);

        Assertions.assertEquals(expectedPost,actualPost);

    }

    @Test
    public void addPostTest() {
        PostApiHandler postApiHandler = new PostApiHandler();
        when(postApiHandler.addPostData(anyString())).thenReturn(response);
        JSONPlaceholderFetcher jsonPlaceholderFetcher = new JSONPlaceholderFetcher(postApiHandler);
        String newPost = "{\"title\": \"New Post Title\", \"body\": \"New Post Body\"}";
        boolean result = jsonPlaceholderFetcher.addPost(newPost);

        Assertions.assertEquals(response, result);
    }
 }
