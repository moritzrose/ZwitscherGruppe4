package com.brights.zwitscher.blogposts;


public class BlogPostResponseDTO {



    private String title;
    private String content;
    private String image;
    private String username;

    public BlogPostResponseDTO() {
    }


    public BlogPostResponseDTO(String title, String content, String image, String username) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titel) {
        this.title = titel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
