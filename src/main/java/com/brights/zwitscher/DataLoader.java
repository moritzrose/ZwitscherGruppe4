package com.brights.zwitscher;

import com.brights.zwitscher.blogposts.BlogPost;
import com.brights.zwitscher.blogposts.BlogPostRepository;
import com.brights.zwitscher.user.User;
import com.brights.zwitscher.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;
    private BlogPostRepository blogPostRepository;

    @Autowired
    public DataLoader(UserRepository userRepository, BlogPostRepository blogPostRepository) {
        this.userRepository = userRepository;
        this.blogPostRepository = blogPostRepository;
    }

    public void run(ApplicationArguments args) {
        // Create user
        User user1= new User("user1","12345");
        userRepository.save(user1);

        // Create admin
        User user2= new User("admin","12345");
        user2.setAdmin(true);
        userRepository.save(user2);

        BlogPost post1 = new BlogPost("Eintrag 1", "","",user1);
        BlogPost post2 = new BlogPost("Eintrag 2", "Content bla b la b la","",user1);
        BlogPost post3 = new BlogPost("Eintrag 3", "Content bla b la b la","",user1);
//
//        Date timestamp = new Date ( )
//        post1.setTimestamp (  );

        blogPostRepository.save(post1);
        blogPostRepository.save(post2);
        blogPostRepository.save(post3);

    }
}
