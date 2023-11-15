package com.brights.zwitscher.blogposts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Stack;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }


    public List<BlogPost> getAllPosts() {

        return blogPostRepository.findAllOrderedByIdDesc();
    }

    public BlogPost getBlogPostById(Long postId) {
        return blogPostRepository.findById(postId).orElse(null);
    }

    public void addNewPost(BlogPost blogPost){

        blogPostRepository.save(blogPost);
    }
}
