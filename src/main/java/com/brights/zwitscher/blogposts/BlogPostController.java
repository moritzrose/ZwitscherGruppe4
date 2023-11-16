package com.brights.zwitscher.blogposts;

import com.brights.zwitscher.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;

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
    public NewBlogPostResponseDTO addNewPost(@RequestBody NewBlogPostRequestDTO newBlogPostRequestDTO, @ModelAttribute("sessionUser") Optional<User> sessionUserOptional){
        User sessionUser = sessionUserOptional
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No valid login"));
        if(sessionUser.isAdmin()) return blogPostService.addNewPost(newBlogPostRequestDTO, sessionUser);
        else throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You are not admin!");
    }
}
