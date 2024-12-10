package com.example.polishCommunity.model;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Safety {
    private String name;
    private String description;
    private String link;
    private String phone;
    public Safety(String name, String description, String link, String phone) {
        this.name = name;
        this.description = description;
        this.link = link;
        this.phone = phone;
    }
}