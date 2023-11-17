package com.brights.zwitscher.blogposts;

import com.brights.zwitscher.comment.Comment;
import com.brights.zwitscher.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class BlogPostController {


    private final BlogPostService blogPostService;
    private final BlogPostRepository blogPostRepository;



    @Autowired
    public BlogPostController(BlogPostService blogPostService, BlogPostRepository blogPostRepository) {
        this.blogPostService = blogPostService;
        this.blogPostRepository = blogPostRepository;
    }


    @GetMapping("/posts")
    public BlogPostCollection getAllPosts(){
        List<BlogPost> posts = StreamSupport //
                .stream(blogPostRepository.findAllOrderedByTimestampDesc ().spliterator(), false) //
                .collect( Collectors.toList());
        return new BlogPostCollection ( posts );
    }

    // nur Admin kann post hinzufügen
    @PostMapping("/post")
    public NewBlogPostResponseDTO addNewPost(@RequestBody NewBlogPostRequestDTO newBlogPostRequestDTO, @ModelAttribute("sessionUser") Optional<User> sessionUserOptional){
        User sessionUser = sessionUserOptional
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No valid login"));

        if(sessionUser.isAdmin()) return blogPostService.addNewPost(newBlogPostRequestDTO, sessionUser);
        else throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You are not admin!");
    }

    @PostMapping("/posts/{id}/comments")
    public Comment addComment(@RequestBody Comment comment,@PathVariable Long id) {
        return this.blogPostService.updateBlogPostWithComment(id,comment);
    }
}
