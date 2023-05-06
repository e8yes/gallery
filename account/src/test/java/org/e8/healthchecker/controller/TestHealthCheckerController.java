package org.e8.healthchecker.controller;

import java.util.Calendar;
import java.util.Date;
import org.e8.MainApplication;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = MainApplication.class)
@AutoConfigureMockMvc
@Transactional
public class TestHealthCheckerController {

    @Autowired
    private MockMvc mvc;

    @Test
    public void whenChechHealth_thenReturnFilledJson() throws Exception {
        String currentYear = ((Integer) Calendar.getInstance().get(Calendar.YEAR)).toString();

        mvc.perform(get("/health/check").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.healthCheckerId", is("e574abc3-2a08-4cd5-8324-34c1a5500c23"))).
                andExpect(jsonPath("$.checkedAt", startsWith(currentYear)));
    }
}
