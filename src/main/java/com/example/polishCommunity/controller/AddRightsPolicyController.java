package com.example.polishCommunity.controller;

import com.example.polishCommunity.model.CreatePolicy;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddRightsPolicyController {

    @GetMapping("/addNewPolicy")
    public ModelAndView getRightsAddPolicyPage(){
        ModelAndView modelAndView=new ModelAndView("Pages/createRightsPolicy");
        return modelAndView;
    }

    @PostMapping("addNewPolicy")
    public ModelAndView submitForm(CreatePolicy createPolicy){
        ModelAndView mav=new ModelAndView("redirect:Pages/createRightsPolicy");
        return mav;
    }
}

