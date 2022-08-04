package com.nlv2022.htc.domain.entity;

import com.nlv2022.htc.constants.Constants;

import java.util.Arrays;
import java.util.List;

public class CompanyInfo {
    private String name = Constants.DEFAULT_VALUE;
    private String age = Constants.DEFAULT_VALUE;
    private List<String> competences = Arrays.asList(new String[]{Constants.DEFAULT_VALUE});

    public CompanyInfo(String name, String age, List<String> competences) {
        this.name = name;
        this.age = age;
        this.competences = competences;
    }

    public CompanyInfo() {
    }



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

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", competences=" + competences +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyInfo that = (CompanyInfo) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        return competences != null ? competences.equals(that.competences) : that.competences == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (competences != null ? competences.hashCode() : 0);
        return result;
    }
}
