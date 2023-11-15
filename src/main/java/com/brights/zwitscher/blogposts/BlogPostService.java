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

        return blogPostRepository.findAll();
    }

    public NewBlogPostResponseDTO addNewPost(NewBlogPostRequestDTO newBlogPostRequestDTO){
        String blogContentText = newBlogPostRequestDTO.getBlogContentText();
        String imageUrl = newBlogPostRequestDTO.getImageUrl().matches("(?i)https?://.*\\\\.(?:png|jpg|jpeg|gif|svg|bmp|tiff)") ? newBlogPostRequestDTO.getImageUrl() : "Image-Url was not valid!";


        return new NewBlogPostResponseDTO();
    }
}
