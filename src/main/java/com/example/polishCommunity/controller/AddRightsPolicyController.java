package com.example.polishCommunity.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddRightsPolicyController {

    @GetMapping("/addNewPolicy")
    public ModelAndView getRightsAddPolicyPage(){
        ModelAndView modelAndView=new ModelAndView("Pages/createRightsPolicy");
        return modelAndView;
    }
    }

