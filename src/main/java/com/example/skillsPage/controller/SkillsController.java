package com.example.skillsPage.controller;

import com.example.skillsPage.model.Skills;
import com.example.skillsPage.service.SkillsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SkillsController {

    private final SkillsService skillsService;

    public SkillsController(SkillsService skillsService) {
        this.skillsService = skillsService;
    }

    @GetMapping("/skills")
    public String getSkillsPage(Model model) {
        List<Skills> skillsList = skillsService.getAllSkills();
        model.addAttribute("skillsList", skillsList);
        return "Pages/skillsPage";
    }
}
