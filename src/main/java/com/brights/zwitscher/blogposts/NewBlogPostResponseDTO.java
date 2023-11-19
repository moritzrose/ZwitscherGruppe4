package com.brights.zwitscher.blogposts;

public class NewBlogPostResponseDTO {

    private String blogTitle;
    private String blogContentText;
    private String imageUrl;
    private String username;

    public NewBlogPostResponseDTO(String blogTitle, String blogContentText, String imageUrl, String username) {
        this.blogTitle = blogTitle;
        this.blogContentText = blogContentText;
        this.imageUrl = imageUrl;
        this.username = username;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public String getBlogContentText() {
        return blogContentText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getUsername() {
        return username;
    }
}
