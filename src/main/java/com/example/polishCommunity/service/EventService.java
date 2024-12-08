package com.example.polishCommunity.service;

import com.example.polishCommunity.model.Event;
import com.example.polishCommunity.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    // Fetch all events
    public List<Event> getAllEvents() {
        return eventRepository.getAllEvents();
    }
    // Add a new event
    public void addEvent(Event event) {
        eventRepository.addEvent(event);
    }
}
