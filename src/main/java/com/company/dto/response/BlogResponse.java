package com.company.dto.response;

import com.company.entities.Blog;

import java.time.LocalDateTime;
import java.util.List;

public record BlogResponse(Long id,
                           String name,
                           String title,
                           String content,
                           String cover,
                           LocalDateTime publishedDate,
                           LocalDateTime createdAt,
                           Long createdBy,
                           List<BlogImageResponse> blogImages) {
    public static BlogResponse converteBlogToBlogResponse(Blog blog) {
        return new BlogResponse(blog.getId(), blog.getName(), blog.getTitle(), blog.getContent(), blog.getCover(), blog.getPublishedDate(), blog.getCreatedAt(),
                blog.getCreatedBy(), blog.getBlogImages().stream().map(BlogImageResponse::converteBlogImageToBlogImageResponse).toList());
    }
}
