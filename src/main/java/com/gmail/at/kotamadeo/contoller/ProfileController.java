package com.gmail.at.kotamadeo.contoller;

import com.gmail.at.kotamadeo.profile.SystemProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ProfileController {
    private final SystemProfile profile;

    @GetMapping("profile")
    public String getProfile() {
        return profile.getProfile();
    }
}