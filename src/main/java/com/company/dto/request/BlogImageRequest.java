package com.company.dto.request;

import com.company.entities.BlogImage;

import java.time.LocalDateTime;

public record BlogImageRequest(String filePath,
                               String altText) {
    public static BlogImage convereteBlogImageRequestToBlogImage(BlogImageRequest blogImageRequest) {
        BlogImage blogImage = new BlogImage();
        blogImage.setFilePath(blogImageRequest.filePath);
        blogImage.setAltText(blogImageRequest.altText);
        blogImage.setCreatedAt(LocalDateTime.now());
        return blogImage;
    }
}
