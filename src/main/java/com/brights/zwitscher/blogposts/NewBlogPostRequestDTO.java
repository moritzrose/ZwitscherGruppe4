package com.brights.zwitscher.blogposts;

public class NewBlogPostRequestDTO {

    private String blogTitle;
    private String blogContentText;
    private String imageUrl;


    public String getBlogContentText() {
        return blogContentText;
    }

    public String getImageUrl() {
        return imageUrl;
    }


    public String getBlogTitle() {
        return blogTitle;
    }
}
