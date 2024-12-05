package com.example.polishCommunity.controller;

import com.example.polishCommunity.model.HousingQuestionnaire;
import com.example.polishCommunity.repository.HousingQuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HousingController {

    @Autowired
    private HousingQuestionnaireRepository questionnaireRepository;

    @PostMapping("/housing-questionnaire")
    public String handleFormSubmission(@RequestParam(name = "name", required = false) String name,
                                       @RequestParam(name = "email", required = false) String email,
                                       @RequestParam(name = "message") String message,
                                       Model model) {
        try {
            // Save data to the database
            HousingQuestionnaire questionnaire = new HousingQuestionnaire(name, email, message);
            questionnaireRepository.save(questionnaire);
            // Add a success message
            model.addAttribute("successMessage", "Thank you! Your response has been submitted.");
        }   catch (Exception e) {
            model.addAttribute("errorMessage", "An error occurred while submitting your response. Please try again.");
        }
        return "Pages/housingPage"; // Redirect back to the same page

    }
}

