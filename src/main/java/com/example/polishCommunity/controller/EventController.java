package com.example.polishCommunity.controller;

import com.example.polishCommunity.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    private final EventService eventService;
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    // Display all events
    @GetMapping("/eventsPage")
    public String showEventsPage(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "Pages/EventsPage";  // Return the view page that will display the events
    }
}

