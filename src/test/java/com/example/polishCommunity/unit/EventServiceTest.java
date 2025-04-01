package com.example.polishCommunity.unit;

import com.example.polishCommunity.model.Event;
import com.example.polishCommunity.repository.AddEventRepository;
import com.example.polishCommunity.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class EventServiceTest {

    @Mock
    private AddEventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddEvent() {
        //Create a test event
        Event event = new Event();
        event.setTitle("Polish Festival");
        event.setDate("2024-06-10");
        event.setLocation("Cardiff");
        event.setCategory("Cultural");
        event.setDescription("Cultural event showcasing Polish heritage.");
        event.setImageUrl("festival.jpg");


        //Simulate repository behavior
        doNothing().when(eventRepository).addEvent(event);

        //Ensure calling addEvent() does not throw exceptions
        assertDoesNotThrow(() -> eventRepository.addEvent(event));

        //Verify the repository method was called exactly once
        verify(eventRepository, times(1)).addEvent(event);
    }
}
