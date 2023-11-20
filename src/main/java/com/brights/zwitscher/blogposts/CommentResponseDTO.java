package com.brights.zwitscher.blogposts;

import com.brights.zwitscher.comment.Comment;
import com.brights.zwitscher.user.User;

public class CommentResponseDTO {
    Comment comment;
    User user;
    String image;

    public CommentResponseDTO(Comment comment, User user, String image) {
        this.comment = comment;
        this.user = user;
        this.image = image;
    }

    public CommentResponseDTO() {
    }

    public Comment getComment() {
        return comment;
    }

    public User getUser() {
        return user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
