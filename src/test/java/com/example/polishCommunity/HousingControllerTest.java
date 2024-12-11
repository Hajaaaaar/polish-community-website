package com.example.polishCommunity;

import com.example.polishCommunity.controller.HousingController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class HousingControllerTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private HousingController housingController;

    @Mock
    private Model model;

    @Mock
    private RedirectAttributes redirectAttributes;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShowHousingPage() {
        // Mock database results
        List<Map<String, Object>> mockResult = new ArrayList<>();
        Map<String, Object> questionRow = new HashMap<>();
        questionRow.put("question_id", 1L);
        questionRow.put("question_name", "Sara Doe");
        questionRow.put("question_email", "sara.doe@example.com");
        questionRow.put("question_message", "Is this housing available?");
        questionRow.put("reply_id", null);
        mockResult.add(questionRow);

        when(jdbcTemplate.queryForList(anyString())).thenReturn(mockResult);

        // Call the method
        String viewName = housingController.showHousingPage(model);

        // Verify and Assert
        verify(model).addAttribute(eq("questions"), anyList());
        assertEquals("Pages/housingPage", viewName);
    }

    @Test
    void testHandleFormSubmission() {
        // Mock RedirectAttributes
        when(redirectAttributes.addFlashAttribute(anyString(), anyString())).thenReturn(redirectAttributes);

        // Call the method
        String result = housingController.handleFormSubmission(
                "Hajar Doe", "hajar.doe@example.com", "How do I apply?", redirectAttributes);

        // Verify and Assert
        verify(jdbcTemplate).update(anyString(), eq("Hajar Doe"), eq("hajar.doe@example.com"), eq("How do I apply?"));
        assertEquals("redirect:/housing", result);
    }

    @Test
    void testHandleReplySubmission() {
        // Mock RedirectAttributes
        when(redirectAttributes.addFlashAttribute(anyString(), anyString())).thenReturn(redirectAttributes);

        // Call the method
        String result = housingController.handleReplySubmission(
                1L, "Admin", "Thank you for your question!", redirectAttributes);

        // Verify and Assert
        verify(jdbcTemplate).update(anyString(), eq("Admin"), eq("Thank you for your question!"), eq(1L));
        assertEquals("redirect:/housing", result);
    }
}
