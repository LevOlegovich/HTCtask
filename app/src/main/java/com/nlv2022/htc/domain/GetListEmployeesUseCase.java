package com.nlv2022.htc.domain;

import androidx.lifecycle.LiveData;

import com.nlv2022.htc.domain.entity.EmployeeInfo;

import java.util.List;

public class GetListEmployeesUseCase {

    private  RepozitoryEmployees repozitoryEmployees;

    public GetListEmployeesUseCase(RepozitoryEmployees repozitoryEmployees) {
        this.repozitoryEmployees = repozitoryEmployees;
    }

    public LiveData<List<EmployeeInfo>> getAllEmployees() {

        return repozitoryEmployees.getAllEmployees();

    }
}
