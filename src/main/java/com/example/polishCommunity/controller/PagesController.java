package com.example.polishCommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
//    @GetMapping("/home")
//    public String home(Model model) {
//        model.addAttribute("lang", "en"); // Default language (or retrieve it dynamically)
//        return "Pages/home";
//    }
<<<<<<< HEAD
    @GetMapping("/home/contact")
    public String contact(Model model) {
    return "Pages/contactsPage";
}
=======
>>>>>>> 0c72edfcd7d2e445a2461a7291cc563bce2751f1
}
