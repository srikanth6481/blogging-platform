package com.example.blog.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class WebUtils {

    public static String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
