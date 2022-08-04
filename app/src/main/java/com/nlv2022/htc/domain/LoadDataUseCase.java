package com.nlv2022.htc.domain;

public class LoadDataUseCase {

    private RepozitoryEmployees repozitoryEmployees;

    public LoadDataUseCase(RepozitoryEmployees repozitoryEmployees) {
        this.repozitoryEmployees = repozitoryEmployees;
    }

    public void loadData() {
        repozitoryEmployees.loadData();

    }

}
