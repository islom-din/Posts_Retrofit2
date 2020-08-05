package din.islom.posts;

import java.util.List;

import din.islom.posts.models.Comment;
import din.islom.posts.models.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostsAPI {
    @GET("posts")
    Call<List<Post>> getData();

    @GET("posts/1/comments")
    Call<List<Comment>> getComments();
}
