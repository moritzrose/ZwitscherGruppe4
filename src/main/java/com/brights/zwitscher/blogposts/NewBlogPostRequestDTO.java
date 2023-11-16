package com.brights.zwitscher.blogposts;

import com.brights.zwitscher.user.User;

public class NewBlogPostRequestDTO {

    private String title;
    private String blogContentText;
    private String imageUrl;


    public String getBlogContentText() {
        return blogContentText;
    }

    public String getImageUrl() {
        return imageUrl;
    }


    public String getTitle() {
        return title;
    }
}
