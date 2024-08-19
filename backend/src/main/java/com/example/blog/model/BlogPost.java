package com.example.blog.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    @Column(length = 10000)
    private String content;

    // Getters and setters
    // ...
}
