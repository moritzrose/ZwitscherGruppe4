package com.brights.zwitscher.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository repository;
@Autowired
    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }
public List<Comment> getAllComments() {
    return repository.findAllOrderedByIdASC();
}

    public void addNewComment(Comment comment) {

    repository.save(comment);

    }
}
