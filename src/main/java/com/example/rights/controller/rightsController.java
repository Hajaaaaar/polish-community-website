package com.example.rights.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class rightsController {

    @GetMapping("/resources/rights")
    public String getRightsPage(Model model){
    return "Pages/Rights";
    }
}





