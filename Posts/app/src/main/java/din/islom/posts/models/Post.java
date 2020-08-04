package din.islom.posts.models;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("userId")
    private int userID;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;


}
