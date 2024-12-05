package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.SurveyResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<SurveyResponse, Long> {
}
