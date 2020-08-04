package din.islom.posts;

import java.util.List;

import din.islom.posts.models.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostsAPI {
    @GET("posts")
    Call<List<Post>> getData();
}
