package com.example.polishCommunity.controller;

import com.example.polishCommunity.model.HousingQuestionnaire;
import com.example.polishCommunity.model.HousingReply;
import com.example.polishCommunity.repository.HousingQuestionnaireRepository;
import com.example.polishCommunity.repository.HousingReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/housing")
public class HousingController {

    @Autowired
    private HousingQuestionnaireRepository questionnaireRepository;

    @Autowired
    private HousingReplyRepository replyRepository;

    // Get request to show the housing page with all comments
    @GetMapping
    public String showHousingPage(Model model) {
        // Fetch all housing questions from the database
        List<HousingQuestionnaire> questions = questionnaireRepository.findAll();
        model.addAttribute("questions", questions);
        return "Pages/housingPage";
    }

    // Post request to handle the form submission for housing questionnaire
    @PostMapping("/housing-questionnaire")
    public String handleFormSubmission(@RequestParam(name = "name", required = false) String name,
                                       @RequestParam(name = "email", required = false) String email,
                                       @RequestParam(name = "message") String message,
                                       RedirectAttributes redirectAttributes) {
        try {
            // Save the submitted question to the database
            HousingQuestionnaire questionnaire = new HousingQuestionnaire(name, email, message);
            questionnaireRepository.save(questionnaire);

            // Add a success message to the redirect attributes
            redirectAttributes.addFlashAttribute("successMessage", "Thank you! Your response has been submitted.");
        } catch (Exception e) {
            // Add an error message to the redirect attributes
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while submitting your response. Please try again.");
            e.printStackTrace(); // Log the error for debugging
        }
        return "redirect:/housing";
    }

    // POST request to handle reply submission
    @PostMapping("/submit-reply")
    public String handleReplySubmission(
            @RequestParam(name = "questionId") Long questionId,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "replyMessage") String replyMessage,
            RedirectAttributes redirectAttributes) {
        Optional<HousingQuestionnaire> optionalQuestion = questionnaireRepository.findById(questionId);
        if (optionalQuestion.isPresent()) {
            HousingQuestionnaire question = optionalQuestion.get();
            HousingReply reply = new HousingReply(name, replyMessage, question);
            replyRepository.save(reply);
            redirectAttributes.addFlashAttribute("commentSuccessMessage", "Your reply has been posted.");
        } else {
            redirectAttributes.addFlashAttribute("commentErrorMessage", "The question you are replying to does not exist.");
        }
        return "redirect:/housing";
    }

}


