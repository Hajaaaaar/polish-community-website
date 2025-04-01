package com.example.polishCommunity.integration;

import com.example.polishCommunity.controller.HousingController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HousingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShowHousingPage() throws Exception {
        mockMvc.perform(get("/housing"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Housing Information")));
    }
}
