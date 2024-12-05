package com.example.polishCommunity.controller;

import com.example.polishCommunity.model.HousingQuestionnaire;
import com.example.polishCommunity.repository.HousingQuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/housing")
public class HousingController {

    @Autowired
    private HousingQuestionnaireRepository questionnaireRepository;

    // Get request to show the housing page with all comments
    @GetMapping
    public String showHousingPage(Model model) {
        // Fetch all housing questions from the database
        List<HousingQuestionnaire> questions = questionnaireRepository.findAll();
        model.addAttribute("questions", questions);
        return "Pages/housingPage"; // Return the housing page view
    }

    // Post request to handle the form submission for housing questionnaire
    @PostMapping("/housing-questionnaire")
    public String handleFormSubmission(@RequestParam(name = "name", required = false) String name,
                                       @RequestParam(name = "email", required = false) String email,
                                       @RequestParam(name = "message") String message,
                                       Model model) {
        try {
            // Save the submitted question to the database
            HousingQuestionnaire questionnaire = new HousingQuestionnaire(name, email, message);
            questionnaireRepository.save(questionnaire);

            // Fetch all housing questions again after adding the new comment
            List<HousingQuestionnaire> questions = questionnaireRepository.findAll();
            model.addAttribute("questions", questions);

            // Add a success message to be displayed on the page
            model.addAttribute("successMessage", "Thank you! Your response has been submitted.");
        } catch (Exception e) {
            // Handle errors during form submission
            model.addAttribute("errorMessage", "An error occurred while submitting your response. Please try again.");
            e.printStackTrace(); // Log the error for debugging
        }
        return "redirect:/housing"; // Forward to the same page after submitting the form
    }

}
