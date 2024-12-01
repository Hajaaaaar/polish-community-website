//package com.example.polishCommunity.controller;
//
//import com.example.polishCommunity.model.HealthInformation;
//import com.example.polishCommunity.service.HealthInformationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/healthPage")
//public class HealthInformationController {
//    @Autowired
//    private HealthInformationService healthInformationService;
//    @GetMapping
//    public String showHealthSurvey(Model model){
//        model.addAttribute("healthInformation", new HealthInformation());
//        return "healthPage";
//    }
//    @PostMapping
//    public String submitHealthInformation(HealthInformation healthInformation){
//        healthInformationService.saveHealthInformation(healthInformation);
//        return "redirect:/health/thank-you";
//    }
//    @GetMapping("/thank-you")
//    public String thankYou(){
//        return "thank-you";
//    }
//
//}
