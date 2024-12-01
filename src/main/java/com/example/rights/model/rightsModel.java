package com.example.rights.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class rightsModel {
    private String name;
    private String description;
    private String link;
    private String duration;
    private LocalDate expiryDate;
}
