package com.example.newsPage.controller;

import com.example.newsPage.model.News;
import com.example.newsPage.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/newsPage")
    public String getNewsPage(Model model) {
        List<News> newsList = newsService.getAllNews();
        model.addAttribute("newsList", newsList);
        return "Pages/news-page";
    }
}
