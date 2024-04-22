package com.company.dto.request;

import com.company.entities.Blog;

import java.util.List;

public record BlogRequest(
        String name,
        String title,
        String content,
        String cover,
        List<BlogImageRequest> blogImages) {

    public static Blog converteBlogRequestToBlog(BlogRequest blogRequest) {
        Blog blog = new Blog();
        blog.setName(blogRequest.name());
        blog.setTitle(blogRequest.title());
        blog.setContent(blogRequest.content());
        blog.setCover(blogRequest.cover());
        blog.setBlogImages(blogRequest.blogImages.stream().map(BlogImageRequest::convereteBlogImageRequestToBlogImage).toList());
        return blog;
    }

}
