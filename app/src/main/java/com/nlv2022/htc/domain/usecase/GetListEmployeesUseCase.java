package com.nlv2022.htc.domain.usecase;

import androidx.lifecycle.LiveData;

import com.nlv2022.htc.domain.repozitory.IRepozitory;
import com.nlv2022.htc.domain.entity.EmployeeInfo;

import java.util.List;

public class GetListEmployeesUseCase {

    private IRepozitory IRepozitory;

    public GetListEmployeesUseCase(IRepozitory IRepozitory) {
        this.IRepozitory = IRepozitory;
    }

    public LiveData<List<EmployeeInfo>> getAllEmployees() {

        return IRepozitory.getAllEmployees();

    }
}
