package com.example.polishCommunity.controller;

import com.example.polishCommunity.service.SafetyService;
import com.example.polishCommunity.model.Safety;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class SafetyController {
    private final SafetyService safetyService;
    public SafetyController(SafetyService safetyService){
        this.safetyService = safetyService;
    }
    @GetMapping("/safety")
    public String getSafetyPage(Model model){
        List<Safety> safetyList = safetyService.getAllSafetyItems();
        model.addAttribute("safetyList", safetyList);
        return "/Pages/safety";
    }
}
