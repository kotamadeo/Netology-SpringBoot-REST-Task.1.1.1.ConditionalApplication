package com.gmail.at.kotamadeo.profile;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Текущий профиль: prod";
    }
}
