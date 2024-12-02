package com.example.polishCommunity.controller;

import com.example.polishCommunity.model.HealthInformation;
import com.example.polishCommunity.service.HealthInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/health")
public class HealthInformationController {

    @Autowired
    private HealthInformationService healthInformationService;

    @GetMapping
    public String showHealthSurvey(Model model) {
        model.addAttribute("healthInformation", new HealthInformation()); // Add the object here
        return "healthPage";
    }

    @PostMapping("/submit")
    public String submitHealthInformation(@ModelAttribute("healthInformation") HealthInformation healthInformation) {
        healthInformationService.saveHealthInformation(healthInformation);
        return "redirect:/health";
    }
}