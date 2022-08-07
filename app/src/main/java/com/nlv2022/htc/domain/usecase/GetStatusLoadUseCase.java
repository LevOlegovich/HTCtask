package com.nlv2022.htc.domain.usecase;

import com.nlv2022.htc.domain.RepozitoryEmployees;

public class GetStatusLoadUseCase {
    RepozitoryEmployees repozitoryEmployees;

    public GetStatusLoadUseCase(RepozitoryEmployees repozitoryEmployees) {
        this.repozitoryEmployees = repozitoryEmployees;
    }

    public boolean getStatusLoad() {
        return repozitoryEmployees.getStatusLoad();
    }
}
