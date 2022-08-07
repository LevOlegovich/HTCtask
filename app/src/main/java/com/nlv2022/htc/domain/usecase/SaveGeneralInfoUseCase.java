package com.nlv2022.htc.domain.usecase;

import com.nlv2022.htc.domain.RepozitoryEmployees;
import com.nlv2022.htc.domain.entity.GeneralInfo;

public class SaveGeneralInfoUseCase {

    private RepozitoryEmployees repozitoryEmployees;

    public SaveGeneralInfoUseCase(RepozitoryEmployees repozitoryEmployees) {
        this.repozitoryEmployees = repozitoryEmployees;
    }

   public void saveGeneralInfo(GeneralInfo generalInfo){
        repozitoryEmployees.saveGeneralInfo(generalInfo);
    }
}
