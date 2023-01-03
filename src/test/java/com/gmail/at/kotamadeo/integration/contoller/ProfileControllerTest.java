package com.gmail.at.kotamadeo.integration.contoller;

import com.gmail.at.kotamadeo.integration.BaseIT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.env.Environment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@AutoConfigureMockMvc
class ProfileControllerTest extends BaseIT {
    private static final String PROD_VALUE = "Текущий профиль: prod";
    private static final String DEV_VALUE = "Текущий профиль: dev";
    private static final String HOST = "http://localhost:";
    private static final String PROFILE_URI = "/profile";
    private final Environment environment;
    private final TestRestTemplate testRestTemplate;
    private final MockMvc mockMvc;


    @Test
    void checkGetProdProfile() {
        var prodPath = format("%s%s%s", HOST, PROD_CONTAINER.getMappedPort(PROD_PORT), PROFILE_URI);
        var prodBody = testRestTemplate.getForEntity(prodPath, String.class).getBody();
        assertEquals(PROD_VALUE, prodBody, "Тест не пройден! Ожидаемый результат не совпадает с актуальным");
    }

    @Test
    void checkGetDevProfile() {
        var devPath = format("%s%s%s", HOST, DEV_CONTAINER.getMappedPort(DEV_PORT), PROFILE_URI);
        var devBody = testRestTemplate.getForEntity(devPath, String.class).getBody();
        assertEquals(DEV_VALUE, devBody, "Тест не пройден! Ожидаемый результат не совпадает с актуальным");
    }

    @Test
    void checkGetcurrentAppProfile() throws Exception {
        var profiles = environment.getActiveProfiles();
        for (String profile : profiles) {
            if (profile.equals("dev")) {
                mockMvc.perform(MockMvcRequestBuilders.get(PROFILE_URI))
                        .andExpectAll(
                                status().is2xxSuccessful(),
                                content().string(DEV_VALUE));
            } else if (profile.equals("prod")) {
                mockMvc.perform(MockMvcRequestBuilders.get(PROFILE_URI))
                        .andExpectAll(
                                status().is2xxSuccessful(),
                                content().string(PROD_VALUE));
            }
        }
    }
}