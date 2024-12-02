package com.example.polishCommunity.controller;

import com.example.polishCommunity.model.HealthInformation;
import com.example.polishCommunity.repository.HealthInformationRepository;
import com.example.polishCommunity.service.HealthInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping("/health")
public class HealthInformationController {

    @Autowired
    private HealthInformationService healthInformationService;

    @GetMapping
    public String showHealthSurvey(Model model) {
        model.addAttribute("healthInformation", new HealthInformation()); // Add the object here
        return "Pages/healthPage";
    }

    @PostMapping("/submit")
    public String submitHealthInformation(@ModelAttribute("healthInformation") HealthInformation healthInformation) {
        healthInformationService.saveHealthInformation(healthInformation);
        return "redirect:/health";
    }
}

//    @PostMapping("/submit")
//    public String submitHealthInformation(@RequestParam String name,
//                                          @RequestParam String email,
//                                          @RequestParam String location,
//                                          @RequestParam Boolean q1registered,
//                                          @RequestParam String q2queries,
//                                          HealthInformation healthInformation) {
//        try {
//            HealthInformationRepository.dataSource (name, email, location, q1registered,q2queries);
//            return "redirect:/health"; // Redirect to signin-register with successMessage
//        } catch (RuntimeException e) {
//            return "redirect:/home";  // Redirect to the same page with errorMessage
//        }
//
//    }
//
//}