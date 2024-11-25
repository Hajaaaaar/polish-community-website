package com.example.newsPage.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class News {
    private String title;
    private String content;
    private String link;
    private LocalDate date;

    public News(String title, String content, String link, LocalDate date) {
        this.title = title;
        this.content = content;
        this.link = link;
        this.date = date;
    }
}
