package com.brights.zwitscher.blogposts;

import com.brights.zwitscher.comment.Comment;
import com.brights.zwitscher.user.User;

public class CommentResponseDTO {
    Comment comment;
    User user;


    public CommentResponseDTO(Comment comment, User user) {
        this.comment = comment;
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public User getUser() {
        return user;
    }
}
