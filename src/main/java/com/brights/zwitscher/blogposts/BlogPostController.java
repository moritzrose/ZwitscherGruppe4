package com.brights.zwitscher.blogposts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogPostController {


    private final BlogPostService blogPostService;

    @Autowired
    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }


    @GetMapping("/allposts")
    public List<BlogPost> getAllPosts(){

        return blogPostService.getAllPosts();

    }



    // nur Admin kann post hinzufügen
    @PostMapping("/addnewpost")
    public NewBlogPostResponseDTO addNewPost(@RequestBody NewBlogPostRequestDTO newBlogPostRequestDTO){
        return blogPostService.addNewPost(newBlogPostRequestDTO);
    }
}
