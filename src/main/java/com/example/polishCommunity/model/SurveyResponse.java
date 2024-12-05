package com.example.polishCommunity.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "survey_responses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SurveyResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Column(nullable = false)
    private String question1;

    @Column(nullable = false)
    private String question2;

    @Column(nullable = false)
    private String question3;

    @Column(nullable = false)
    private String question4;

    @Column(nullable = false)
    private String question5;

    @Column(nullable = false)
    private String question6;

    @Column(nullable = false)
    private String question7;

    @Column(nullable = false)
    private String question8;

    @Column(nullable = false)
    private String question9;

    @Column(nullable = false)
    private String question10;

    // Constructor to handle required fields
    public SurveyResponse(String name, String email, String question1, String question2, String question3,
                              String question4, String question5, String question6, String question7, String question8,
                              String question9, String question10) {
        this.name = name;
        this.email = email;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.question4 = question4;
        this.question5 = question5;
        this.question6 = question6;
        this.question7 = question7;
        this.question8 = question8;
        this.question9 = question9;
        this.question10 = question10;
    }
}
