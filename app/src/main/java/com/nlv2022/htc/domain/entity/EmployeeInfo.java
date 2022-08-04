package com.nlv2022.htc.domain.entity;

import java.util.Comparator;
import java.util.List;


public final class EmployeeInfo {

    private int id;
    private String name;
    private String phoneNumber;
    private List<String> skills;


    public EmployeeInfo(int id, String name, String phoneNumber, List<String> skills) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.skills = skills;

    }

    public EmployeeInfo() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<String> getSkills() {
        return skills;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeInfo that = (EmployeeInfo) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null)
            return false;
        return skills != null ? skills.equals(that.skills) : that.skills == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", skills=" + skills +
                '}';
    }

    public static Comparator<EmployeeInfo> byName = new Comparator<EmployeeInfo>() {
        @Override
        public int compare(EmployeeInfo e1, EmployeeInfo e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };


}
