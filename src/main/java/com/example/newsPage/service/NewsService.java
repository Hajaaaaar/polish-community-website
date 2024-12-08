package com.example.newsPage.service;

import com.example.newsPage.model.News;
import com.example.newsPage.repository.NewsRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NewsService {
    @Value("${newsapi.key}")
    private String apiKey;
    private final RestTemplate restTemplate;
    private final NewsRepository newsRepository;

    public NewsService(RestTemplate restTemplate, NewsRepository newsRepository) {
        this.restTemplate = restTemplate;
        this.newsRepository = newsRepository;
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public String getTopNews() {
            String url = "https://api.thenewsapi.com/v1/news/top?api_token=" + apiKey + "&locale=us";
            return restTemplate.getForObject(url, String.class);
    }
}

