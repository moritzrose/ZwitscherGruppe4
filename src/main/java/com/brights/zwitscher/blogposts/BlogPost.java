package com.brights.zwitscher.blogposts;


import com.brights.zwitscher.user.User;
import jakarta.persistence.*;

@Entity
public class BlogPost {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String image;

    @ManyToOne
    private User user;

    public BlogPost() {
    }

    public BlogPost(String title, String content, String image, User user) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.user = user;
    }



    public User getUsername() {
        return user;
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
