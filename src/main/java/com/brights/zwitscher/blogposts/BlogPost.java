package com.brights.zwitscher.blogposts;


import com.brights.zwitscher.comment.Comment;
import com.brights.zwitscher.user.User;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BlogPost {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String image;
    private LocalDateTime blogPostTime;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL)
    @OrderBy("commentTime")
    private List<Comment> comments  = new ArrayList<>();

    public BlogPost() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public BlogPost(String title, String content, String image, User user) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.user = user;
        this.blogPostTime = LocalDateTime.now();
    }


    public Long getId() {
        return id;
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

    public String getBlogPostTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return blogPostTime.format(formatter);
    }

    public void setBlogPostTime(int year, int month, int day, int hour, int minute, int second) {
        this.blogPostTime = LocalDateTime.of(year, month, day, hour, minute, second);
    }
}
