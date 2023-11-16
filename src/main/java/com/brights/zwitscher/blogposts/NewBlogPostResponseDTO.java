package com.brights.zwitscher.blogposts;

public class NewBlogPostResponseDTO {

    private String title;
    private String postContentText;
    private String imageUrl;
    private String username;

    public NewBlogPostResponseDTO(String title, String postContentText, String imageUrl, String username) {
        this.title = title;
        this.postContentText = postContentText;
        this.imageUrl = imageUrl;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return postContentText;
    }

    public void setMessage(String message) {
        this.postContentText = message;
    }
}
