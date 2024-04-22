package com.company.repositories;

import com.company.entities.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByNameContainingOrTitleContainingOrPublishedOrPublishedDate(String name, String title, Boolean published, LocalDateTime publishedDate, Pageable pageable);
}
