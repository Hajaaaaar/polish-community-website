package com.example.polishCommunity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Rights {
    private int titleId;

    public Rights(int titleId, String title, String description) {
        this.titleId = titleId;
        this.title = title;
        this.description = description;
    }

    private String title;
    private List<SubRights> subTitle;
    private String description;
}
