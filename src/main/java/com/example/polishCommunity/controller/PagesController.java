package com.example.polishCommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {
    @GetMapping("/home")
    public String home(Model model) {
        return "Pages/home";
    }

    @GetMapping("/EventsPage")
    public String EventsPage(Model model) {
        return "Pages/EventsPage";
    }

    @GetMapping("/FAQpage")
    public String FAQpage(Model model) {return "Pages/FAQpage";}

    @GetMapping("/contact")
    public String contact(Model model) {
    return "Pages/contactsPage";
}

    @GetMapping("/signin-register")
    public String Signregister(Model model) {
        return "Pages/signin-register";
    }

    @GetMapping("/workPage")
    public String work(Model model) {
        return "Pages/workPage";
    }

}
