package com.nlv2022.htc.domain.usecase;

import com.nlv2022.htc.domain.RepozitoryEmployees;

public class GetTimeUpdateUseCase {

    private RepozitoryEmployees repozitoryEmployees;

    public GetTimeUpdateUseCase(RepozitoryEmployees repozitoryEmployees) {
        this.repozitoryEmployees = repozitoryEmployees;
    }

    public String getTimeUpdate() {
        return repozitoryEmployees.getTimeUpdate();

    }
}
