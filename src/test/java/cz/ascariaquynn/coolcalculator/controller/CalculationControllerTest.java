package cz.ascariaquynn.coolcalculator.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CalculationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenNumberTest() throws Exception {
        mockMvc.perform(get("/api/v1/calculation/calculate/43256791"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"result\":11331545}"));
    }
}
