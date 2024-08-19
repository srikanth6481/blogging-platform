package com.example.blog.controller;

import com.example.blog.model.BlogPost;
import com.example.blog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public String listBlogs(Model model) {
        model.addAttribute("posts", blogPostService.findAll());
        return "blog/blog-list";
    }

    @GetMapping("/{id}")
    public String viewBlog(@PathVariable Long id, Model model) {
        model.addAttribute("post", blogPostService.findById(id));
        return "blog/blog-view";
    }

    @GetMapping("/new")
    public String newBlog(Model model) {
        model.addAttribute("post", new BlogPost());
        return "blog/blog-edit";
    }

    @PostMapping
    public String saveBlog(@ModelAttribute BlogPost post) {
        blogPostService.save(post);
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/edit")
    public String editBlog(@PathVariable Long id, Model model) {
        model.addAttribute("post", blogPostService.findById(id));
        return "blog/blog-edit";
    }

    @PostMapping("/{id}")
    public String updateBlog(@PathVariable Long id, @ModelAttribute BlogPost post) {
        post.setId(id);
        blogPostService.save(post);
        return "redirect:/blogs";
    }

    @PostMapping("/{id}/delete")
    public String deleteBlog(@PathVariable Long id) {
        blogPostService.deleteById(id);
        return "redirect:/blogs";
    }
}
