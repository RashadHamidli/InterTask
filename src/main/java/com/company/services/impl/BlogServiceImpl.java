package com.company.services.impl;

import com.company.config.CustomSecurityContext;
import com.company.dto.request.BlogRequest;
import com.company.dto.request.CommentRequest;
import com.company.dto.response.BlogResponse;
import com.company.dto.response.CommentResponse;
import com.company.entities.Blog;
import com.company.entities.User;
import com.company.repositories.BlogRepository;
import com.company.repositories.UserRepository;
import com.company.services.inter.BlogService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BlogServiceImpl extends BlogService {
    private final BlogRepository blogRepository;
    private final CustomSecurityContext securityContext;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public BlogResponse insertBlog(BlogRequest blogRequest) {
        Blog blog = BlogRequest.converteBlogRequestToBlog(blogRequest);
        blog.setCreatedAt(LocalDateTime.now());
        blog.setPublishedDate(LocalDateTime.now());
        blog.setPublished(true);
        blog.setViewedCount(0L);
        String context = securityContext.getSecurityContext();
        User user = userRepository.findByUsername(context).orElseThrow();
        blog.setCreatedBy(user.getId());
        Blog savedBlog = blogRepository.save(blog);
        return BlogResponse.converteBlogToBlogResponse(savedBlog);
    }

    @Override
    @Transactional
    public CommentResponse insertComment(CommentRequest commentRequest) {
        return null;
    }

    @Override
    public List<BlogResponse> filter(String name, String title, Boolean published, LocalDateTime publishedDate) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("createdAt").descending());
        List<Blog> blogs = blogRepository.findAllByNameContainingOrTitleContainingOrPublishedOrPublishedDate(name, title, published, publishedDate, pageable);
        return blogs.stream().map(BlogResponse::converteBlogToBlogResponse).toList();
    }

    @Override
    public BlogResponse getBlogInfo(Long blogId) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new IllegalArgumentException(STR."\{blogId} not found"));
        return BlogResponse.converteBlogToBlogResponse(blog);
    }

}
