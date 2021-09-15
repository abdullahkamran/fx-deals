package com.assignment.fxdeals.core;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.assignment.fxdeals.Application;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class FxDealControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllFxDealsSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fx-deals"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.responseBody",
                        Matchers.hasSize(Matchers.greaterThanOrEqualTo(0))));
    }

    @Test
    public void testGetFxDealSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fx-deals/initialTestId1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is("initialTestId1")));
    }

    @Test
    public void testGetFxDealFailure() throws Exception {

        // doesn't exist
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fx-deals/999999")
        )
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());

        // doesn't exist
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fx-deals/-1111")
        )
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());

    }

    @Test
    public void testCreateFxDealSuccess() throws Exception {

        String requestBody =
                "{" +
                        "\"id\":1," +
                        "\"fromCurrency\":\"PKR\"," +
                        "\"toCurrency\":\"USD\"," +
                        "\"timestamp\":\"2021-09-15T17:35:19.114Z\"," +
                        "\"amount\":100.00" +
                        "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fx-deals")
                .contentType("application/json")
                .content(requestBody)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is("1")));

    }

    @Test
    public void testCreateFxDealFailure() throws Exception {

        String requestBody =
            "{" +
                "\"fromCurrency\":\"PKR\"," +
                "\"toCurrency\":\"USD\"," +
                "\"timestamp\":\"2021-09-15T17:35:19.114Z\"," +
                "\"amount\":100.00" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fx-deals")
                .contentType("application/json")
                .content(requestBody)
        )
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());

    }

}