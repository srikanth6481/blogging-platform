package com.example.blog.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    // Getters and setters
    // ...
}
