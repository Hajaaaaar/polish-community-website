package com.example.polishCommunity.controller;

import com.example.polishCommunity.model.HousingQuestionnaire;
import com.example.polishCommunity.model.HousingReply;
import com.example.polishCommunity.repository.HousingQuestionnaireRepository;
import com.example.polishCommunity.repository.HousingReplyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/housing")
public class HousingController {

    private final HousingQuestionnaireRepository questionnaireRepository;
    private final HousingReplyRepository replyRepository;

    public HousingController(HousingQuestionnaireRepository questionnaireRepository, HousingReplyRepository replyRepository) {
        this.questionnaireRepository = questionnaireRepository;
        this.replyRepository = replyRepository;
    }

    @GetMapping
    public String showHousingPage(Model model) {
        List<HousingQuestionnaire> questions = questionnaireRepository.findAllWithReplies();
        model.addAttribute("questions", questions);
        return "Pages/housingPage";
    }


    @PostMapping("/housing-questionnaire")
    public String handleFormSubmission(@RequestParam(name = "name", required = false) String name,
                                       @RequestParam(name = "email", required = false) String email,
                                       @RequestParam(name = "message") String message,
                                       RedirectAttributes redirectAttributes) {
        try {
            HousingQuestionnaire questionnaire = new HousingQuestionnaire(name, email, message);
            questionnaireRepository.save(questionnaire);
            redirectAttributes.addFlashAttribute("successMessage", "Thank you! Your response has been submitted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while submitting your response.");
            e.printStackTrace();
        }
        return "redirect:/housing";
    }

    @PostMapping("/submit-reply")
    public String handleReplySubmission(@RequestParam(name = "questionId") Long questionId,
                                        @RequestParam(name = "name", required = false) String name,
                                        @RequestParam(name = "replyMessage") String replyMessage,
                                        RedirectAttributes redirectAttributes) {
        try {
            HousingReply reply = new HousingReply(name, replyMessage, new HousingQuestionnaire());
            reply.getQuestion().setId(questionId); // Manually set the question ID
            replyRepository.save(reply);
            redirectAttributes.addFlashAttribute("commentSuccessMessage", "Your reply has been posted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("commentErrorMessage", "Failed to post your reply.");
            e.printStackTrace();
        }
        return "redirect:/housing";
    }

}



