package com.example.polishCommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RightsController {

    @GetMapping("/rights")
    public ModelAndView getRightsPage(Model model){
        ModelAndView mav=new ModelAndView("Pages/Rights");
        mav.addObject("object",new Object());
        return mav;
    }
}





