package com.nlv2022.htc.data.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.nlv2022.htc.data.mapper.Converter;

import java.util.List;

@Entity(tableName = "employees")
public class EmployeeDbModel {

    @PrimaryKey(autoGenerate = true)
    private final int id;
    private final String name;
    private final String phoneNumber;
    @TypeConverters(value = Converter.class)
    private final List<String> skills;

    public EmployeeDbModel(int id, String name, String phoneNumber, List<String> skills) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.skills = skills;

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

    public int getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeDbModel that = (EmployeeDbModel) o;

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
        return "EmployeeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", skills=" + skills +
                '}';
    }
}
