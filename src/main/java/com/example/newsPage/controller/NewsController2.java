package com.example.newsPage.controller;

import com.example.newsPage.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController2 {

    private final NewsService newsService;

    @Autowired
    public NewsController2(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/latest")
    public ResponseEntity<?> getLatestNews() {
        String news = newsService.getTopNews();
        System.out.println("re");
        System.out.println(news);
        return ResponseEntity.ok(news);
    }
}
