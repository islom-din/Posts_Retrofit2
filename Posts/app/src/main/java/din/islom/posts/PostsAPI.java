package din.islom.posts;

import java.util.List;

import din.islom.posts.models.Comment;
import din.islom.posts.models.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostsAPI {
    @GET("posts")
    Call<List<Post>> getData();

    @GET("posts/{id}/{comments}")
    Call<List<Comment>> getComments(@Path("id") int postId, @Path("comments") String commentsString);
}
