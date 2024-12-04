package com.example.polishCommunity.controller;


import com.example.polishCommunity.model.SurveyResponse;
import com.example.polishCommunity.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Work-SurveyPage")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @RequestMapping
    public String showSurveyPage() {
        return "Pages/Work-SurveyPage";  // Ensure the name matches your HTML template file
    }

    @PostMapping("/submit")
    public String submitSurvey(@RequestParam String name,
                               @RequestParam String gender,
                               @RequestParam String reasonForSeekingWork,
                               @RequestParam String educationLevel,
                               @RequestParam String comfortWithLanguage,
                               @RequestParam String workEnvironment,
                               @RequestParam String teamPreference,
                               @RequestParam String skillsExperience,
                               @RequestParam String workSchedule,
                               @RequestParam String desiredIndustry,
                               @RequestParam String jobStability,
                               @RequestParam String jobImpactOnLife) {

        SurveyResponse response = new SurveyResponse();
        response.setName(name);
        response.setGender(gender);
        response.setReasonForSeekingWork(reasonForSeekingWork);
        response.setEducationLevel(educationLevel);
        response.setComfortWithLanguage(comfortWithLanguage);
        response.setWorkEnvironment(workEnvironment);
        response.setTeamPreference(teamPreference);
        response.setSkillsExperience(skillsExperience);
        response.setWorkSchedule(workSchedule);
        response.setDesiredIndustry(desiredIndustry);
        response.setJobStability(jobStability);
        response.setJobImpactOnLife(jobImpactOnLife);

        surveyService.saveSurveyResponse(response);

        return "thankyou"; // A page that thanks users for submitting their survey
    }
}

