package com.example.polishCommunity.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "housing_replies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HousingReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private String message;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private HousingQuestionnaire question;

    public HousingReply(String name, String message, HousingQuestionnaire question) {
        this.name = name;
        this.message = message;
        this.question = question;
    }
}
