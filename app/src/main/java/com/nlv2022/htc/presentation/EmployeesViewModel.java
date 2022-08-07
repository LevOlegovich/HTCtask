package com.nlv2022.htc.presentation;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.nlv2022.htc.data.repository.RepozitoryEmployeesImpl;
import com.nlv2022.htc.domain.usecase.GetCompanyUseCase;
import com.nlv2022.htc.domain.usecase.GetGeneralInfoUseCase;
import com.nlv2022.htc.domain.usecase.GetListEmployeesUseCase;
import com.nlv2022.htc.domain.usecase.GetStatusLoadUseCase;
import com.nlv2022.htc.domain.usecase.GetTimeUpdateUseCase;
import com.nlv2022.htc.domain.usecase.LoadDataUseCase;
import com.nlv2022.htc.domain.entity.CompanyInfo;
import com.nlv2022.htc.domain.entity.EmployeeInfo;
import com.nlv2022.htc.domain.entity.GeneralInfo;
import com.nlv2022.htc.domain.usecase.SaveGeneralInfoUseCase;

import java.util.List;


public class EmployeesViewModel extends AndroidViewModel {

    private final RepozitoryEmployeesImpl repozitory;
    private final GetListEmployeesUseCase getListEmployeesUseCase;
    private final LoadDataUseCase loadDataUseCase;
    private final GetTimeUpdateUseCase getTimeUpdateUseCase;
    private final GetStatusLoadUseCase getStatusLoadUseCase;
    private final GetCompanyUseCase getCompanyUseCase;
    private GetGeneralInfoUseCase getGeneralInfoUseCase;
    private SaveGeneralInfoUseCase saveGeneralInfoUseCase;


    public EmployeesViewModel(@NonNull Application application) {
        super(application);

        this.repozitory = new RepozitoryEmployeesImpl(application);
        this.getTimeUpdateUseCase = new GetTimeUpdateUseCase(repozitory);
        this.getStatusLoadUseCase = new GetStatusLoadUseCase(repozitory);
        this.getListEmployeesUseCase = new GetListEmployeesUseCase(this.repozitory);
        this.loadDataUseCase = new LoadDataUseCase(this.repozitory);
        this.getCompanyUseCase = new GetCompanyUseCase(repozitory);
        this.getGeneralInfoUseCase = new GetGeneralInfoUseCase(repozitory);
        this.saveGeneralInfoUseCase = new SaveGeneralInfoUseCase(repozitory);
        loadData();

    }


    public LiveData<List<EmployeeInfo>> getEmployees() {
        return getListEmployeesUseCase.getAllEmployees();
    }


    public void loadData() {
        loadDataUseCase.loadData();
    }

    private CompanyInfo getCompanyInfo() {
        return getCompanyUseCase.getCompanyInfo();
    }

    private boolean getStatusFromLoadInfo() {
        return getStatusLoadUseCase.getStatusLoad();
    } // оказался не нужен, возможно удалю

    private String getTimeUpdateFromLoadInfo() {
        return getTimeUpdateUseCase.getTimeUpdate();
    }

    public GeneralInfo getGeneralInfo() {
        return getGeneralInfoUseCase.getGeneralInfo();
    }

    public void saveGeneralInfo() {
        GeneralInfo generalInfo = new GeneralInfo(
                getCompanyInfo().getName(),
                getCompanyInfo().getAge(),
                getCompanyInfo().getCompetences().toString(),
                getTimeUpdateFromLoadInfo());
        saveGeneralInfoUseCase.saveGeneralInfo(generalInfo);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        repozitory.getCompositeDisposable().dispose();
    }


}
