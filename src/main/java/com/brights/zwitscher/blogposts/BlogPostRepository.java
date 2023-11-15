package com.brights.zwitscher.blogposts;

import com.brights.zwitscher.session.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost,Long> {




}
