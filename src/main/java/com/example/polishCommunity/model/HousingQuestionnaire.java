package com.example.polishCommunity.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "housing_questionnaire")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HousingQuestionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public HousingQuestionnaire(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }
}
