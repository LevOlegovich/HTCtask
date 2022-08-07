package com.nlv2022.htc.domain;

import androidx.lifecycle.LiveData;

import com.nlv2022.htc.domain.entity.CompanyInfo;
import com.nlv2022.htc.domain.entity.EmployeeInfo;
import com.nlv2022.htc.domain.entity.GeneralInfo;

import java.util.List;

public interface RepozitoryEmployees {

    LiveData<List<EmployeeInfo>> getAllEmployees();

    void loadData();

    String getTimeUpdate();

    boolean getStatusLoad();

    CompanyInfo getCompanyInfo();

    GeneralInfo getGeneralInfo();

    void saveGeneralInfo(GeneralInfo generalInfo);


}
