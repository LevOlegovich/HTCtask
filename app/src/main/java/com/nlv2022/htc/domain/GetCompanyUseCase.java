package com.nlv2022.htc.domain;

import com.nlv2022.htc.domain.entity.CompanyInfo;

public class GetCompanyUseCase {
    private RepozitoryEmployees repozitoryEmployees;

    public GetCompanyUseCase(RepozitoryEmployees repozitoryEmployees) {
        this.repozitoryEmployees = repozitoryEmployees;
    }

    public CompanyInfo getCompanyInfo(){
        return repozitoryEmployees.getCompanyInfo();
    }
}
