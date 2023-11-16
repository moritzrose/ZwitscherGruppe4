package com.brights.zwitscher.user;

import com.brights.zwitscher.blogposts.BlogPost;
import com.brights.zwitscher.blogposts.BlogPostRepository;
import com.brights.zwitscher.blogposts.BlogPostService;
import com.brights.zwitscher.session.RegisterRequestDTO;
import com.brights.zwitscher.session.RegisterResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    private UserRepository userRepository;

    private BlogPostService blogPostserv;

    @Autowired
    public UserController(UserRepository userRepository,BlogPostService blogPostRepository) {
        this.userRepository = userRepository;
        this.blogPostserv = blogPostRepository;
    }

    @GetMapping("/user")
    public UserDTO user(@ModelAttribute("sessionUser") Optional<User> sessionUserOptional) {
        User sessionUser = sessionUserOptional
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No valid login"));
        return new UserDTO(sessionUser.getUsername(), sessionUser.isAdmin());
    }

    @GetMapping("/getAdmin")

    @PostMapping("/register")
    public RegisterResponseDTO createUser(@RequestBody RegisterRequestDTO registerRequestDTO){
        Optional<User> duplicateOptional = userRepository.findByUsername(registerRequestDTO.getUsername());

        if(duplicateOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username is already taken!");
        }
        else {
            if (registerRequestDTO.getPassword1().equals(registerRequestDTO.getPassword2())){
                User createUser = new User(registerRequestDTO.getUsername(),registerRequestDTO.getPassword1());
                userRepository.save(createUser);
                return new RegisterResponseDTO(registerRequestDTO.getUsername());
            }
            else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Passwords are not the same!");
        }
    }




}