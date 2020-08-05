package din.islom.posts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import din.islom.posts.models.Comment;
import din.islom.posts.models.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private PostsAPI postsAPI;

    private static final String TAG = "MainActivity==========>";

    private List<Post> listOfPosts;
    private List<Comment> listOfComments;

    private final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Создаем объект, при помощи которого будем выполнять запросы
        postsAPI = retrofit.create(PostsAPI.class);

        //initListOfPosts();
        initListOfComments();
    }

    private void initListOfPosts() {
         postsAPI.getData().enqueue(new Callback<List<Post>>() {
             @Override
             public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                 if(!response.isSuccessful()) {
                     Log.d(TAG, "onResponse: " + response.message());
                     return;
                 }
                 listOfPosts = response.body();
             }

             @Override
             public void onFailure(Call<List<Post>> call, Throwable t) {
                 Log.d(TAG, "onFailure: " + t.getMessage());
             }
         });
    }

    private void initListOfComments() {
        postsAPI.getComments().enqueue(new Callback<List<Comment>>() {
        // Call<List<Comment>> call = postsAPI.getComments();
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if(!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.message());
                    return;
                }
                listOfComments = response.body();
                Comment comment = listOfComments.get(0);
                Log.d(TAG, "onResponse: " + comment.getName());
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}