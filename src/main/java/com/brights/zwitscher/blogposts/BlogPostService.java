package com.brights.zwitscher.blogposts;


import com.brights.zwitscher.comment.Comment;
import com.brights.zwitscher.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
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

        // Extract the image URL from the content text
        String imageUrl = extractImageUrl(blogContentText);

        // Remove the image URL from the content text
        blogContentText = blogContentText.replace(imageUrl, "");

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

    private String extractImageUrl(String text) {
        String urlPattern = "(https?://\\S+\\.(jpg|jpeg|png|gif))";
        Pattern pattern = Pattern.compile(urlPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "";
        }
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
                System.out.println(blogPost.getComments().size());
                blogPost.getComments().remove(commentToDelete);
                System.out.println(blogPost.getComments().size());
                blogPostRepository.save(blogPost);
                System.out.println(blogPost.getComments().size());
                break;
            }
        }
        if (commentToDelete == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment does not exist");
        }
        return commentToDelete;
    }
}
