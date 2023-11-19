package com.brights.zwitscher.comment;

import com.brights.zwitscher.blogposts.BlogPost;
import com.brights.zwitscher.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    private LocalDateTime commentTime;

    @ManyToOne
    @JsonIgnore
    private BlogPost blogPost;

    @ManyToOne
    private User user;

    public Comment(User user, String comment) {
        this.user = user;
        this.comment = comment;
        this.commentTime=LocalDateTime.now();
    }

    public Comment() {}


    public String getCommentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return commentTime.format(formatter);
    }

    public void setCommentTime(LocalDateTime commentTime) {
        this.commentTime = commentTime;
    }

    public String getComment() {
        return comment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BlogPost getBlogPost() {
        return blogPost;
    }

    public void setBlogPost(BlogPost blogPost) {
        this.blogPost = blogPost;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
}

