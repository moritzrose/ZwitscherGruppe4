package com.brights.zwitscher.comment;

import com.brights.zwitscher.blogposts.BlogPost;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query(value = "SELECT * FROM COMMENT ORDER BY COMMENT.commenTime ASC ", nativeQuery = true)
    List<Comment> findAllOrderedByIdASC();
}
