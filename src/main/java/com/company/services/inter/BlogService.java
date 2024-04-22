package com.company.services.inter;

import com.company.dto.request.BlogRequest;
import com.company.dto.request.CommentRequest;
import com.company.dto.response.BlogResponse;
import com.company.dto.response.CommentResponse;

import java.time.LocalDateTime;
import java.util.List;


public abstract class BlogService {

    public abstract BlogResponse insertBlog(BlogRequest blogRequest);

    public abstract CommentResponse insertComment(CommentRequest commentRequest);

    public abstract List<BlogResponse> filter(String name, String title, Boolean published, LocalDateTime publishedDate) ;

    public abstract BlogResponse getBlogInfo(Long blogId);


}
