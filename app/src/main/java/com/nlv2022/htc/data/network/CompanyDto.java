package com.nlv2022.htc.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nlv2022.htc.constants.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompanyDto {

    @SerializedName("name")
    @Expose
    private String name = Constants.DEFAULT_VALUE;
    @SerializedName("age")
    @Expose
    private String age = Constants.DEFAULT_VALUE;
    @SerializedName("competences")
    @Expose
    private List<String> competences = Arrays.asList(new String[]{Constants.DEFAULT_VALUE});

    @SerializedName("employees")
    @Expose
    private List<EmployeeDto> employees = new ArrayList<>();




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<String> getCompetences() {
        return competences;
    }

    public void setCompetences(List<String> competences) {
        this.competences = competences;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }


}
