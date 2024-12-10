package com.example.polishCommunity.controller;

import com.example.polishCommunity.model.Event;
import com.example.polishCommunity.repository.AddEventRepository;
import com.example.polishCommunity.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AddEventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AddEventRepository addEventRepository;

    // Show the add event form and display the list of events
    @GetMapping("/dashboard/AddEvents")
    public String showAddEventsPage(Model model) {
        List<Event> events = eventRepository.getAllEvents();
        model.addAttribute("events", events);
        return "admin/AddEventsPage"; // Refers to AddEventsPage.html
    }

    // Handle add event form submission
    @PostMapping("/dashboard/AddEvent")
    public String addEvent(
            @RequestParam String title,
            @RequestParam String date,
            @RequestParam String location,
            @RequestParam String category,
            @RequestParam String description,
            @RequestParam(required = false) String imageUrl) {

        // Create a new event object and populate it with data from the form
        Event event = new Event();
        event.setTitle(title);
        event.setDate(date);
        event.setLocation(location);
        event.setCategory(category);
        event.setDescription(description);
        event.setImageUrl(imageUrl);

        // Save the event to the database using the AddEventRepository
        addEventRepository.addEvent(event);

        // Redirect to the events page to show the updated list of events
        return "redirect:/dashboard/EventsTable"; // Redirect to the EventsTable page
    }
}
