package com.nlv2022.htc.data.mapper;

import com.nlv2022.htc.data.database.EmployeeDbModel;
import com.nlv2022.htc.data.network.CompanyDto;
import com.nlv2022.htc.data.network.EmployeeDto;
import com.nlv2022.htc.data.network.RootEntityDto;
import com.nlv2022.htc.data.sharedpref.GeneralInfoShared;
import com.nlv2022.htc.domain.entity.CompanyInfo;
import com.nlv2022.htc.domain.entity.EmployeeInfo;
import com.nlv2022.htc.domain.entity.GeneralInfo;

import java.util.ArrayList;
import java.util.List;

public class MapperEntities {

    public EmployeeDbModel mapDtoToDbModel(EmployeeDto dto) {
        return new EmployeeDbModel(
                dto.getId(),
                dto.getName(),
                dto.getPhoneNumber(),
                dto.getSkills());

    }


    public EmployeeInfo mapDbModelToEntity(EmployeeDbModel dbModel) {
        return new EmployeeInfo(
                dbModel.getId(),
                dbModel.getName(),
                dbModel.getPhoneNumber(),
                dbModel.getSkills());

    }


    public List<EmployeeInfo> mapListDbModelToEntity(List<EmployeeDbModel> employeeDbModelList) {
        List<EmployeeInfo> list = new ArrayList<>();

        for (EmployeeDbModel employee : employeeDbModelList) {
            list.add(mapDbModelToEntity(employee));
        }
        return list;
    }


    public List<EmployeeDbModel> getEmployeesDbModelsFromDto(RootEntityDto rootEntityDto) {
        List<EmployeeDbModel> employeeDbModelList = new ArrayList<>();
        List<EmployeeDto> employeeDtoList = rootEntityDto.getCompany().getEmployees();
        for (EmployeeDto employeeDto : employeeDtoList) {
            employeeDbModelList.add(mapDtoToDbModel(employeeDto));
        }
        return employeeDbModelList;
    }


    public CompanyInfo mapCompanyDtoToEntity(CompanyDto companyDto) {
        return new CompanyInfo(
                companyDto.getName(),
                companyDto.getAge(),
                companyDto.getCompetences());

    }

    public GeneralInfo getGeneralInfo(GeneralInfoShared generalInfoShared) {
        return new GeneralInfo(
                generalInfoShared.getNameCompany(),
                generalInfoShared.getAgeCompany(),
                generalInfoShared.getCompetensec(),
                generalInfoShared.getTimeUpdate());

    }


    public GeneralInfoShared getGeneralInfoShared(GeneralInfo generalInfo) {
        return new GeneralInfoShared(
                generalInfo.getNameCompany(),
                generalInfo.getAgeCompany(),
                generalInfo.getCompetensec(),
                generalInfo.getTimeUpdate());
    }
}
