package com.example.newsPage.service;

import com.example.newsPage.model.News;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class NewsService {
    public List<News> getAllNews() {
        return Arrays.asList(
                new News("Breaking News 1", "This is the content of the first news.", "www.google.com", LocalDate.now()),
                new News("Breaking News 2", "This is the content of the second news.", "www.google.com", LocalDate.now().minusDays(1)),
                new News("Breaking News 3", "This is the content of the third news.", "www.google.com", LocalDate.now().minusDays(2))
        );
    }
}
