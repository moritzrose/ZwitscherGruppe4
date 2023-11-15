package com.brights.zwitscher.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository repository;
@Autowired
    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

}
