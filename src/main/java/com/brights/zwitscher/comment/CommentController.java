package com.brights.zwitscher.comment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CommentController {


    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @GetMapping("/allcomment")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @PostMapping("/addcomment")
    public void addComment(Comment comment) {
        commentService.addNewComment(comment);
    }
}

