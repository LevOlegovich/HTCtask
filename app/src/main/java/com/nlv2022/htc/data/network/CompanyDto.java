package com.nlv2022.htc.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nlv2022.htc.constants.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Полям класса присвоены значения по умолчанию во избежание NPE ,
 *  так как в json некоторые поля могут быть пустые. */

public class CompanyDto {

    @SerializedName("name")
    @Expose
    private String name = Constants.DEFAULT_VALUE;
    @SerializedName("age")
    @Expose
    private String age = Constants.DEFAULT_VALUE;
    @SerializedName("competences")
    @Expose
    private List<String> competences = Arrays.asList(Constants.DEFAULT_VALUE);

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyDto that = (CompanyDto) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (competences != null ? !competences.equals(that.competences) : that.competences != null)
            return false;
        return employees != null ? employees.equals(that.employees) : that.employees == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (competences != null ? competences.hashCode() : 0);
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CompanyDto{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", competences=" + competences +
                ", employees=" + employees +
                '}';
    }
}
