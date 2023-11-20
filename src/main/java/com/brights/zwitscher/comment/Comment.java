package com.brights.zwitscher.comment;

import com.brights.zwitscher.blogposts.BlogPost;
import com.brights.zwitscher.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private String image;

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

    public Comment(String comment, String image, LocalDateTime commentTime, User user) {
        this.user = user;
        this.comment = comment;
        this.commentTime = commentTime;
        this.image = image;
    }

    public Comment() {}


    public String getCommentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm - dd. MMMM yyyy", Locale.GERMAN);

        return commentTime.format(formatter);
    }

    public void setCommentTime(int year, int month, int day, int hour, int minute) {
        this.commentTime = LocalDateTime.of(year, month, day, hour, minute);
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

    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return image;
    }
}

