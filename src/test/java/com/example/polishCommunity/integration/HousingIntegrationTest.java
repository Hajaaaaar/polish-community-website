package com.example.polishCommunity.integration;


import com.example.polishCommunity.model.HousingQuestionnaire;
import com.example.polishCommunity.model.HousingReply;
import com.example.polishCommunity.repository.HousingQuestionnaireRepository;
import com.example.polishCommunity.repository.HousingReplyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HousingIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private HousingQuestionnaireRepository questionnaireRepository;

    @Autowired
    private HousingReplyRepository replyRepository;

    @BeforeEach
    public void setUp() {
        jdbcTemplate.execute("DELETE FROM housing_replies");
        jdbcTemplate.execute("DELETE FROM housing_questionnaire");

        jdbcTemplate.execute("INSERT INTO housing_questionnaire (id, name, email, message, status) VALUES (1, 'John Doe', 'john@example.com', 'How can I rent this?', 'approved')");
        jdbcTemplate.execute("INSERT INTO housing_replies (id, name, message, question_id, status) VALUES (1, 'Admin', 'You need to fill a form.', 1, 'approved')");
    }

    @Test
    public void testShowHousingPageIntegration() throws Exception {
        mockMvc.perform(get("/housing"))
                .andExpect(status().isOk())
                .andExpect(view().name("Pages/housingPage"))
                .andExpect(model().attributeExists("questions"))
                .andExpect(content().string(containsString("John Doe")))
                .andExpect(content().string(containsString("You need to fill a form.")));
    }

    @Test
    public void testHandleFormSubmissionIntegration() throws Exception {
        mockMvc.perform(post("/housing/housing-questionnaire")
                        .param("name", "Hajar")
                        .param("email", "hajar@example.com")
                        .param("message", "What are the housing conditions?")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/housing"));

        List<HousingQuestionnaire> questionnaires = questionnaireRepository.findAllWithReplies();
        assertEquals(2, questionnaires.size());
    }

    @Test
    public void testHandleReplySubmissionIntegration() throws Exception {
        mockMvc.perform(post("/housing/submit-reply")
                        .param("questionId", "1")
                        .param("name", "New Admin")
                        .param("replyMessage", "Here is how you apply.")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/housing"));

        List<HousingReply> replies = replyRepository.findByQuestionId(1L);
        assertEquals(2, replies.size());
    }
}
