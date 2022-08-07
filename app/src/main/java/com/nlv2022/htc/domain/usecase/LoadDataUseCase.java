package com.nlv2022.htc.domain.usecase;

import com.nlv2022.htc.domain.RepozitoryEmployees;

public class LoadDataUseCase {

    private RepozitoryEmployees repozitoryEmployees;

    public LoadDataUseCase(RepozitoryEmployees repozitoryEmployees) {
        this.repozitoryEmployees = repozitoryEmployees;
    }

    public void loadData() {
        repozitoryEmployees.loadData();

    }

}
