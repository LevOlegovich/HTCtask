package com.nlv2022.htc.presentation;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.nlv2022.htc.data.repository.RepozitoryEmployeesImpl;
import com.nlv2022.htc.domain.GetCompanyUseCase;
import com.nlv2022.htc.domain.GetListEmployeesUseCase;
import com.nlv2022.htc.domain.GetStatusLoadUseCase;
import com.nlv2022.htc.domain.GetTimeUpdateUseCase;
import com.nlv2022.htc.domain.LoadDataUseCase;
import com.nlv2022.htc.domain.entity.CompanyInfo;
import com.nlv2022.htc.domain.entity.EmployeeInfo;

import java.util.List;


public class EmployeesViewModel extends AndroidViewModel {

    private final RepozitoryEmployeesImpl repozitory;
    private final GetListEmployeesUseCase getListEmployeesUseCase;
    private final LoadDataUseCase loadDataUseCase;
    private final GetTimeUpdateUseCase getTimeUpdateUseCase;
    private final GetStatusLoadUseCase getStatusLoadUseCase;
    private final GetCompanyUseCase getCompanyUseCase;


    public EmployeesViewModel(@NonNull Application application) {
        super(application);

        this.repozitory = new RepozitoryEmployeesImpl(application);
        this.getTimeUpdateUseCase = new GetTimeUpdateUseCase(repozitory);
        this.getStatusLoadUseCase = new GetStatusLoadUseCase(repozitory);
        this.getListEmployeesUseCase = new GetListEmployeesUseCase(this.repozitory);
        this.loadDataUseCase = new LoadDataUseCase(this.repozitory);
        this.getCompanyUseCase = new GetCompanyUseCase(repozitory);
        loadData();

    }


    public LiveData<List<EmployeeInfo>> getEmployees() {
        return getListEmployeesUseCase.getAllEmployees();
    }


    public void loadData() {
        loadDataUseCase.loadData();
    }

    public CompanyInfo getCompanyInfo() {
        return getCompanyUseCase.getCompanyInfo();
    }

    public boolean getStatusFromLoadInfo() {
        return getStatusLoadUseCase.getStatusLoad();
    }

    public String getTimeUpdateFromLoadInfo() {
        return getTimeUpdateUseCase.getTimeUpdate();
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        repozitory.getCompositeDisposable().dispose();
    }


}
