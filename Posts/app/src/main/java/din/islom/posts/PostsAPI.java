package din.islom.posts;

import java.util.List;
import java.util.Map;

import din.islom.posts.models.Comment;
import din.islom.posts.models.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface PostsAPI {
    @GET("posts")
    Call<List<Post>> getData();

    @GET("posts")
    Call<List<Post>> getData(@Query("userId") int userId, @Query("_sort") String sort, @Query("order") String order);

    @GET
    Call<List<Post>> getData(@QueryMap Map<String, String> parameters);

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);
}
