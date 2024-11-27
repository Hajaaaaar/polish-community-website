package com.example.workPage.model;

public class WorkInformation {
    private Long id;
    private String title;
    private String description;
    private String resourceLink;

    public WorkInformation(Long id, String title, String description, String resourceLink) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.resourceLink = resourceLink;
    }
}
