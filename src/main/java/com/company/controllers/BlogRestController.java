package com.company.controllers;

import com.company.dto.request.BlogRequest;
import com.company.dto.request.CommentRequest;
import com.company.dto.response.BlogResponse;
import com.company.dto.response.CommentResponse;
import com.company.services.inter.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/blog")
@RequiredArgsConstructor
public class BlogRestController {

    private final BlogService blogService;

    @PostMapping("/insert")
    public BlogResponse insertBlog(@RequestBody BlogRequest blogRequest) {
        return blogService.insertBlog(blogRequest);
    }

    @PostMapping("/insertComment")
    public CommentResponse insertComment(@RequestBody CommentRequest commentRequest) {
        return blogService.insertComment(commentRequest);
    }

    @GetMapping("/filter")
    public List<BlogResponse> filterBlogs(@RequestParam(required = false) String name,
                                          @RequestParam(required = false) String title,
                                          @RequestParam(required = false) Boolean published,
                                          @RequestParam(required = false) LocalDateTime publishedDate) {
        return blogService.filter(name, title, published, publishedDate);
    }

    @GetMapping("/info/{blogId}")
    public BlogResponse getBlogInfo(@PathVariable Long blogId) {
        return blogService.getBlogInfo(blogId);
    }
}


