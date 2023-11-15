package com.brights.zwitscher.blogposts;

public class NewBlogPostResponseDTO {

    String username;
    String postContentText;
    String imageUrl;

    public NewBlogPostResponseDTO(String username, String message) {
        this.username = username;
        this.postContentText = message;
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
