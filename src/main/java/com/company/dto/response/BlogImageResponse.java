package com.company.dto.response;

import com.company.entities.BlogImage;

import java.time.LocalDateTime;

public record BlogImageResponse(String filePath,
                                String altText,
                                LocalDateTime createdAt) {
    public static BlogImageResponse converteBlogImageToBlogImageResponse(BlogImage blogImage) {
        return new BlogImageResponse(blogImage.getFilePath(), blogImage.getAltText(), blogImage.getCreatedAt());
    }
}
