package com.example.blog.service;

import com.example.blog.model.BlogPost;
import com.example.blog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public List<BlogPost> findAll() {
        return blogPostRepository.findAll();
    }

    public BlogPost findById(Long id) {
        return blogPostRepository.findById(id).orElse(null);
    }

    public void save(BlogPost post) {
        blogPostRepository.save(post);
    }

    public void deleteById(Long id) {
        blogPostRepository.deleteById(id);
    }
}
