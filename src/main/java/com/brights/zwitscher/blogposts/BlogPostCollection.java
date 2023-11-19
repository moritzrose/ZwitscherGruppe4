package com.brights.zwitscher.blogposts;

import java.util.List;

public class BlogPostCollection {

    List<BlogPost> blogPostList;

    public BlogPostCollection(List<BlogPost> blogPostList) {
        this.blogPostList = blogPostList;
    }

    public List<BlogPost> getBlogPostList() {
        return blogPostList;
    }

    public void setBlogPostList(List<BlogPost> blogPostList) {
        this.blogPostList = blogPostList;
    }
}
