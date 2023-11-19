package com.brights.zwitscher;

import com.brights.zwitscher.blogposts.BlogPost;
import com.brights.zwitscher.blogposts.BlogPostRepository;
import com.brights.zwitscher.comment.Comment;
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

        User codingCarl= new User("CodingCarl","12345");
        userRepository.save(codingCarl);

        User randomProgrammer = new User("RandomProgrammer","12345");
        userRepository.save(randomProgrammer);
        User iDontHack = new User("iDontHack","12345");
        userRepository.save(iDontHack);
        User larsgerhard = new User("Lars Gerhard","12345");
        userRepository.save(larsgerhard);

        // Create admin
        User user2= new User("admin","12345");
        user2.setAdmin(true);
        userRepository.save(user2);

        BlogPost post1 = new BlogPost("", "Meine ersten Erfahrungen auf Stack Overflow waren wie eine Reise in ein fremdes Land. Ich stellte eine Frage und wurde mit einer Flut von Antworten und weiteren Fragen konfrontiert. ","",randomProgrammer);
        post1.setBlogPostTime ( 2023,11,11,22,12,12 );

        BlogPost post2 = new BlogPost("", "Einmal blickte ich auf meinen eigenen Code und fragte mich ernsthaft, wer ihn geschrieben hatte. Er schien so kompliziert und unverständlich, dass ich fast dachte, er sei von Außerirdischen verfasst worden.","",iDontHack);
        post2.setBlogPostTime ( 2022,7,7,7,7,7);

        BlogPost post3 = new BlogPost("", "Fehlermeldungen in der Programmierung sind wie Hieroglyphen. Ich erinnere mich an eine besonders kryptische Meldung, die mir sagte, dass \"null nicht null sein kann\".","",codingCarl);
        post3.setBlogPostTime ( 2021,8,8,8,8,8);

        BlogPost post4 = new BlogPost("", "Wenn ich Kommentare im Code schreibe, scheinen sie manchmal ein Eigenleben zu führen. Einmal schrieb ich \"Dieser Abschnitt ist selbsterklärend\", und kurz danach fragte mich ein Kollege, was ich damit gemeint hätte.","",larsgerhard);
        post4.setBlogPostTime ( 2020,6,6,6,6,6);

        Comment comment1 = new Comment(codingCarl,"Ich fühle mit dir!");
        comment1.setCommentTime  ( 2023,11,11,22,12,50 );

        Comment comment2 = new Comment(codingCarl,"true Story...");
        comment2.setCommentTime  ( 2021,7,8,7,7,7);

        post1.getComments().add(comment1);
        comment1.setBlogPost(post1);

        post2.getComments().add(comment2);
        comment2.setBlogPost(post2);

        blogPostRepository.save(post1);
        blogPostRepository.save(post2);
        blogPostRepository.save(post3);
        blogPostRepository.save(post4);
    }
}
