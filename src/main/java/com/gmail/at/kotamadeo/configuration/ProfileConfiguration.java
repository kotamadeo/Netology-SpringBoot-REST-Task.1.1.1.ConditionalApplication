package com.gmail.at.kotamadeo.configuration;

import com.gmail.at.kotamadeo.profile.DeveloperProfile;
import com.gmail.at.kotamadeo.profile.ProductionProfile;
import com.gmail.at.kotamadeo.profile.SystemProfile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfiguration {

    @Bean
    @Profile("dev")
    public SystemProfile getDeveloperProfile() {
        return new DeveloperProfile();
    }

    @Bean
    @Profile("prod")
    public SystemProfile getProductionProfile() {
        return new ProductionProfile();
    }
}
