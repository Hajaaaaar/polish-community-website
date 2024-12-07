package com.example.profilePage.controller;

import com.example.polishCommunity.model.User;
import com.example.polishCommunity.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProfileController {
    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profileLogin")
    public String getNewsPage(Model model) {
        return "Pages/profileLogin";
    }

    @PostMapping("/profile")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            Model model,
                            RedirectAttributes redirectAttributes) {
        return "redirect:/home";
        /* if (userService.authenticateUser(email, password)) {
            User currentUser = userService.getCurrentUser(email);
            if (currentUser != null) {
                System.out.println("Current user: " + currentUser.getName());
                model.addAttribute("currentUser", currentUser);
                return "Pages/profilePage";
            } else {
                return "redirect:/home";
            }
        } else {
            redirectAttributes.addFlashAttribute("loginErrorMessage", "Invalid email or password. Please try again.");
            return "redirect:/profileLogin"; // Redirect back to login page
        }*/
    }
}
