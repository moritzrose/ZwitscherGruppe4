package com.brights.zwitscher.blogposts;


import com.brights.zwitscher.comment.Comment;
import com.brights.zwitscher.comment.CommentRepository;
import com.brights.zwitscher.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;
    private final CommentRepository commentRepository;


    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository, CommentRepository commentRepository) {
        this.blogPostRepository = blogPostRepository;
        this.commentRepository = commentRepository;
    }

    public List<BlogPost> getAllPosts() {

        return blogPostRepository.findAllOrderedByTimestampDesc();
    }

    public BlogPost getBlogPostById(Long postId) {
        return blogPostRepository.findById(postId).orElse(null);
    }

    public NewBlogPostResponseDTO addNewPost(NewBlogPostRequestDTO newBlogPostRequestDTO, User sessionUser) {

        String blogTitle = newBlogPostRequestDTO.getBlogTitle();
        String blogContentText = newBlogPostRequestDTO.getBlogContentText();
        String imageUrl = "";  //newBlogPostRequestDTO.getImageUrl().matches("(?i)https?://.*\\\\.(?:png|jpg|jpeg|gif|svg|bmp|tiff)") ? newBlogPostRequestDTO.getImageUrl() : "";


        blogPostRepository.save(new BlogPost(blogTitle, blogContentText, imageUrl, sessionUser));

        return new NewBlogPostResponseDTO(blogTitle, blogContentText, imageUrl, sessionUser.getUsername());
    }

    public Optional<BlogPost> deletePost(Long postId) {
        Optional<BlogPost> postToDelete = blogPostRepository.findById(postId);

        if (postToDelete.isPresent()) {
            blogPostRepository.deleteById(postId);
            return postToDelete;
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post doesn't exist!");
    }

    public Comment updateBlogPostWithComment(Long blogId, User user, CommentRequestDTO comment) {
        // Check if post with provided id exists
        BlogPost blogPostById = getBlogPostById(blogId);
        Comment newComment = new Comment(user, comment.getComment());

        if (blogPostById == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post with id " + blogId + " not found");
        }
        // Comment wants to know about the entry it belongs to
        newComment.setBlogPost(blogPostById);
        // Blog post wants to know about the comment
        blogPostById.getComments().add(newComment);
        this.blogPostRepository.save(blogPostById);

        return newComment;
    }

    public Comment deleteComment(Long commentId) {
        List<BlogPost> listOfBlogPosts = blogPostRepository.findAll();
        Comment commentToDelete = null;

        for (BlogPost blogPost : listOfBlogPosts){
            for (Comment comment : blogPost.getComments()){
                if(comment.getId().equals(commentId)){
                    commentToDelete = comment;
                    break;
                }
            }
            if (commentToDelete != null){
                blogPost.getComments().remove(commentToDelete);
                blogPostRepository.save(blogPost);
                break;
            }
        }
        if (commentToDelete == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment does not exist");
        }
        return commentToDelete;
    }
}
