package com.brights.zwitscher.blogposts;


import com.brights.zwitscher.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public NewBlogPostResponseDTO addNewPost(NewBlogPostRequestDTO newBlogPostRequestDTO, User sessionUser){

        String blogTitle = newBlogPostRequestDTO.getBlogTitle();
        String blogContentText = newBlogPostRequestDTO.getBlogContentText();
        String imageUrl = newBlogPostRequestDTO.getImageUrl().matches("(?i)https?://.*\\\\.(?:png|jpg|jpeg|gif|svg|bmp|tiff)") ? newBlogPostRequestDTO.getImageUrl() : "";


        blogPostRepository.save(new BlogPost(blogTitle, blogContentText, imageUrl, sessionUser));

        return new NewBlogPostResponseDTO(blogTitle, blogContentText, imageUrl, sessionUser.getUsername());
    }
}
