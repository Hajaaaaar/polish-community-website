package com.example.polishCommunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/metrics")
    public String showMetrics(Model model) {
        try {
            // Query total users
            int totalUsers = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users", Integer.class);

            // Query active users
            int activeUsers = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users WHERE is_active = true", Integer.class);

            // Query total news
            int totalNews = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM news", Integer.class);

            // Query total organisations
            int totalOrganisations = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM organisations", Integer.class);


            // Query total comments
            int totalComments = jdbcTemplate.queryForObject(
                    "SELECT (SELECT COUNT(*) FROM housing_questionnaire) + (SELECT COUNT(*) FROM housing_replies) AS totalComments",
                    Integer.class);

            // Add metrics to the model
            model.addAttribute("totalUsers", totalUsers);
            model.addAttribute("activeUsers", activeUsers);
            model.addAttribute("totalNews", totalNews);
            model.addAttribute("totalOrganisations", totalOrganisations);
            model.addAttribute("totalComments", totalComments);

            return "admin/metrics";
        } catch (Exception e) {
            // Log the error and provide an error message to the model
            model.addAttribute("errorMessage", "Failed to load dashboard metrics. Please try again later.");
            e.printStackTrace(); // Log the stack trace for debugging
            return "admin/metrics"; // Redirect to the metrics page with an error message
        }
    }
}
