package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.HousingQuestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingQuestionnaireRepository extends JpaRepository<HousingQuestionnaire, Long> {
}
