package com.example.polishCommunity.repository;


import com.example.polishCommunity.model.SurveyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SurveyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(SurveyResponse response) {
        String sql = "INSERT INTO survey_responses (name, gender, reason_for_seeking_work, education_level, " +
                "comfort_with_language, work_environment, team_preference, skills_experience, work_schedule, " +
                "desired_industry, job_stability, job_impact_on_life) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, response.getName(), response.getGender(), response.getReasonForSeekingWork(),
                response.getEducationLevel(), response.getComfortWithLanguage(), response.getWorkEnvironment(),
                response.getTeamPreference(), response.getSkillsExperience(), response.getWorkSchedule(),
                response.getDesiredIndustry(), response.getJobStability(), response.getJobImpactOnLife());
    }
}

