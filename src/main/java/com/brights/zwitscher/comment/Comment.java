package com.brights.zwitscher.comment;

import jakarta.persistence.*;

@Entity
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }





}

