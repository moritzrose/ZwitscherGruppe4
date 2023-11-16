package com.brights.zwitscher.blogposts;


import com.brights.zwitscher.user.User;
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

    public NewBlogPostResponseDTO addNewPost(NewBlogPostRequestDTO newBlogPostRequestDTO, User sessionUser){
        String title = newBlogPostRequestDTO.getTitle();
        String blogContentText = newBlogPostRequestDTO.getBlogContentText();
        String imageUrl = newBlogPostRequestDTO.getImageUrl().matches("(?i)https?://.*\\\\.(?:png|jpg|jpeg|gif|svg|bmp|tiff)") ? newBlogPostRequestDTO.getImageUrl() : "Image-Url was not valid!";


        blogPostRepository.save(new BlogPost(title, blogContentText, imageUrl, sessionUser));

        return new NewBlogPostResponseDTO(title, blogContentText, imageUrl, sessionUser.getUsername());
    }
}
