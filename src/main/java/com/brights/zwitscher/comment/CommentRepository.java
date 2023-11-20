package com.brights.zwitscher.comment;

import com.brights.zwitscher.blogposts.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
