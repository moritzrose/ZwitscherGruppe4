package com.brights.zwitscher.comment;

import com.brights.zwitscher.blogposts.BlogPost;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    private LocalDateTime commentTime;

    public LocalDateTime getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDateTime commentTime) {
        this.commentTime = commentTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

@ManyToOne
    private BlogPost blogPost;

}

