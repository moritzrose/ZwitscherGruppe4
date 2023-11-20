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

        User codingCarl = new User("CodingCarl", "12345");
        codingCarl.setProfilPicture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbTV5zDc6-zVWOeTGi6E4nyb6K5_ygUeTh0xOfNLA__5vmF5dSjFJJKSe1THwutIIsIAU&usqp=CAU");
        userRepository.save(codingCarl);

        User faresCode = new User("FaresCod", "12345");
        faresCode.setProfilPicture("https://www.sciencebuddies.org/0Rlfgxiy3CWH7xqRyWf5xMg7d3Q=/700x368/-/https/www.sciencebuddies.org/cdn/Files/16563/5/stem-coding-projects.png");
        userRepository.save(faresCode);


        User randomProgrammer = new User("Moritz Rose", "12345");
        randomProgrammer.setProfilPicture("https://pm1.aminoapps.com/6636/ddaf1c402f3767d7c934aac8520aa12c023fd31c_00.jpg");
        userRepository.save(randomProgrammer);

        User iDontHack = new User("iDontHack", "12345");
        iDontHack.setProfilPicture("https://i.pinimg.com/736x/dc/28/a7/dc28a77f18bfc9aaa51c3f61080edda5.jpg");
        userRepository.save(iDontHack);
        User larsgerhard = new User("Lars Gerhard", "12345");
        larsgerhard.setProfilPicture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTGBIIsBuPsv2CTO9Ai6jvoIwgd8q6G8SXwp0rF-gJkRns0twiDVYnq3BOfNQCUQGu8ZJo&usqp=CAU");
        userRepository.save(larsgerhard);

        User compilerHero = new User("CompilerHero", "12345");
        compilerHero.setProfilPicture("https://img.freepik.com/premium-photo/sticker-boy-coding-computer-anime-s-creative-design-bold-line-cute-kawaii-st_655090-454640.jpg");
        userRepository.save(compilerHero);

        User devGenius23 = new User("DevGenius23", "12345");
        compilerHero.setProfilPicture("https://as2.ftcdn.net/v2/jpg/02/50/14/75/1000_F_250147542_M6Bp8KweCx2zuoQf89dJbjoRMcyC35uG.jpg");
        userRepository.save(devGenius23);

        User algorithmAce = new User("AlgorithmAce", "12345");
        compilerHero.setProfilPicture("https://www.all-electronics.de/files/upload/post/all/2022/12/461346/adobestock-261576629-algorithmus.jpeg");
        userRepository.save(algorithmAce);



        // Create admin
        User admin = new User("admin", "12345");
        admin.setAdmin(true);
        admin.setProfilPicture("https://d2gg9evh47fn9z.cloudfront.net/1600px_COLOURBOX9896883.jpg");
        userRepository.save(admin);

        BlogPost post1 = new BlogPost("", "Meine ersten Erfahrungen auf Stack Overflow waren wie eine Reise in ein fremdes Land. Ich stellte eine Frage und wurde mit einer Flut von Antworten und weiteren Fragen konfrontiert. ", "", randomProgrammer);
        post1.setBlogPostTime(2023, 11, 11, 22, 12);
        post1.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/Stack_Overflow_logo.svg/1920px-Stack_Overflow_logo.svg.png");


        BlogPost post2 = new BlogPost("", "Einmal blickte ich auf meinen eigenen Code und fragte mich ernsthaft, wer ihn geschrieben hatte. Er schien so kompliziert und unverständlich, dass ich fast dachte, er sei von Außerirdischen verfasst worden.", "", iDontHack);
        post2.setBlogPostTime(2022, 7, 7, 7, 7);

        BlogPost post3 = new BlogPost("", "Fehlermeldungen in der Programmierung sind wie Hieroglyphen. Ich erinnere mich an eine besonders kryptische Meldung, die mir sagte, dass \"null nicht null sein kann\"", "https://i.ibb.co/51b9YbS/supermeme-13h17-3.png", codingCarl);
        post3.setBlogPostTime(2021, 8, 8, 8, 8);

        BlogPost post4 = new BlogPost("", "Wenn ich Kommentare im Code schreibe, scheinen sie manchmal ein Eigenleben zu führen. Einmal schrieb ich \"Dieser Abschnitt ist selbsterklärend\", und kurz danach fragte mich ein Kollege, was ich damit gemeint hätte.", "", larsgerhard);
        post4.setBlogPostTime(2020, 6, 6, 6, 6);

        BlogPost post5 = new BlogPost("", "Manchmal können die Fehlermeldungen lustig erscheinen, besonders wenn der Grund für den Fehler etwas Kleines wie ein vergessenes Komma oder eine Klammer ist.", "https://media.tenor.com/LqrmT6OCeGcAAAAd/code.gif", faresCode);
        post5.setBlogPostTime(2023, 1, 9, 3, 6);

        BlogPost post6 = new BlogPost("","Wenn ich anfange zu programmieren und die Musik im Hintergrund mich begleitet.","https://i.ibb.co/mbm6L7f/supermeme-11h50-12.png",compilerHero);
        post6.setBlogPostTime(2021, 1, 9, 3, 6);

        BlogPost post7 = new BlogPost("","Wenn jemand sagt, Programmieren sei einfach und jeder könne es.","https://media.tenor.com/SinZyg9xCEEAAAAC/zoolander-surprise.gif",devGenius23);
        post7.setBlogPostTime(2022, 4, 6, 7, 6);

        Comment comment1_1 = new Comment(codingCarl, "Ich fühle mit dir!");
        Comment comment1_2 = new Comment(larsgerhard, "Willkommen im Dschungel von Stack Overflow! \uD83D\uDE04 Es ist normal, am Anfang überwältigt zu sein, aber mit der Zeit wirst du dich immer besser zurechtfinden.");
        Comment comment1_3 = new Comment(iDontHack, "Denk daran, dass auch erfahrene Entwickler einmal Anfänger waren. Du bist nicht allein auf dieser Reise, und wir sind hier, um zu helfen!");
        Comment comment1_4 = new Comment(faresCode, "Da hast du recht😅😅😅😅");

        comment1_1.setCommentTime(2023, 6, 11, 22, 12);

        Comment comment2 = new Comment(codingCarl, "true Story...");
        comment2.setCommentTime(2021, 7, 8, 7, 7);

        Comment comment7_1 = new Comment(compilerHero,"🤣🤣🤣🤣🤣🤣🤣");

        // Kommentäre auf die Posts

        post1.getComments().add(comment1_1);
        comment1_1.setBlogPost(post1);
        post1.getComments().add(comment1_2);
        comment1_2.setBlogPost(post1);
        post1.getComments().add(comment1_3);
        comment1_3.setBlogPost(post1);
        post1.getComments().add(comment1_4);
        comment1_4.setBlogPost(post1);
        post2.getComments().add(comment2);
        comment2.setBlogPost(post2);
        post7.getComments().add(comment7_1);
        comment7_1.setBlogPost(post7);

        blogPostRepository.save(post1);
        blogPostRepository.save(post2);
        blogPostRepository.save(post3);
        blogPostRepository.save(post4);
        blogPostRepository.save(post5);
        blogPostRepository.save(post6);
        blogPostRepository.save(post7);
    }
}
