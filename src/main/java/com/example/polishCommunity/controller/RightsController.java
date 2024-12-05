package com.example.polishCommunity.controller;

import com.example.polishCommunity.model.Rights;
import com.example.polishCommunity.service.RightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RightsController {

 private RightsService rightsService;

 public RightsController(RightsService rightsService){
  this.rightsService=rightsService;
 }
    @GetMapping("/rights/{id}")
    public ModelAndView getRightsPage(@PathVariable int id){
        ModelAndView mav=new ModelAndView("Pages/Rights");
        Rights rights =rightsService.getRightsByTitleId(id);
        mav.addObject("rights",rights);
        return mav;
    }
}





