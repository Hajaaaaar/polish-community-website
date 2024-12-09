package com.example.polishCommunity.service;

import com.example.polishCommunity.model.Event;
import com.example.polishCommunity.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    // Constructor-based dependency injection for the repository
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    /**
     * Fetch all events from the database.
     *
     * @return List of Event objects
     */
    public List<Event> getAllEvents() {
        return eventRepository.getAllEvents();
    }
}

//    /**
//     * Add a new event to the database.
//     *
//     * @param event The Event object to be added
//     */
//    public void addEvent(Event event) {
//        eventRepository.addEvent(event);
//    }
//}
