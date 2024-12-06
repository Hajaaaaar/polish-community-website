package com.example.polishCommunity.controller;

import com.example.polishCommunity.model.CreatePolicy;
import com.example.polishCommunity.model.Rights;
import com.example.polishCommunity.model.SubRights;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AddRightsPolicyController {

    @GetMapping("/addNewPolicy")
    public ModelAndView getRightsAddPolicyPage(){
        ModelAndView modelAndView=new ModelAndView("Pages/createRightsPolicy");
        modelAndView.addObject("subRights",new SubRights());
        return modelAndView;
    }

    @PostMapping("/addNewPolicy")
    public ModelAndView submitForm(@ModelAttribute("subRights") SubRights subRights){
        ModelAndView mav;

        mav=new ModelAndView("redirect:/rights/1");
        return mav;
    }
}

