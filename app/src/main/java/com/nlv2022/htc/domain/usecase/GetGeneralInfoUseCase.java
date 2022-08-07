package com.nlv2022.htc.domain.usecase;

import com.nlv2022.htc.domain.RepozitoryEmployees;
import com.nlv2022.htc.domain.entity.GeneralInfo;

public class GetGeneralInfoUseCase {
    private RepozitoryEmployees repozitoryEmployees;

    public GetGeneralInfoUseCase(RepozitoryEmployees repozitoryEmployees) {
        this.repozitoryEmployees = repozitoryEmployees;
    }

    public GeneralInfo getGeneralInfo() {
        return repozitoryEmployees.getGeneralInfo();
    }

}
