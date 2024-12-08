package com.example.polishCommunity.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.polishCommunity.model.Event;

@Controller
public class EventAddController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/events/add")
    public String addEvent(@ModelAttribute("event") Event event) {
        // SQL to insert data into the eventss table
        String sql = "INSERT INTO eventss (title, date, location, category, description, image_url) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                event.getTitle(),
                event.getDate(),
                event.getLocation(),
                event.getCategory(),
                event.getDescription(),
                event.getImageUrl()
        );


        // Redirect to the events page to show the updated list
        return "redirect:/eventsPage";
    }
}





