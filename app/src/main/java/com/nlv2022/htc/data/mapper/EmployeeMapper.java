package com.nlv2022.htc.data.mapper;

import com.nlv2022.htc.data.database.EmployeeDbModel;
import com.nlv2022.htc.data.network.CompanyDto;
import com.nlv2022.htc.data.network.EmployeeDto;
import com.nlv2022.htc.domain.entity.CompanyInfo;
import com.nlv2022.htc.domain.entity.EmployeeInfo;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {

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


    public CompanyInfo mapCompanyDtoToEntity(CompanyDto companyDto) {
        return new CompanyInfo(
                companyDto.getName(),
                companyDto.getAge(),
                companyDto.getCompetences());

    }

}
