package com.example.polishCommunity.repository;

import com.example.polishCommunity.model.HealthSurveyResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HealthSurveyRepository extends JpaRepository<HealthSurveyResponse, Long>{
}
