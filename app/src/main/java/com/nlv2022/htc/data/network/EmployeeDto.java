package com.nlv2022.htc.data.network;

import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nlv2022.htc.constants.Constants;
import com.nlv2022.htc.data.mapper.SkillsConverter;

import java.util.Arrays;
import java.util.List;


/** Полям класса присвоены значения по умолчанию во избежание NPE ,
 *  так как в json некоторые поля могут быть пустые. */

public class EmployeeDto {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @SerializedName("name")
    @Expose
    private String name = Constants.DEFAULT_VALUE;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber = Constants.DEFAULT_VALUE;
    @SerializedName("skills")
    @Expose
    @TypeConverters(value = SkillsConverter.class)
    private List<String> skills = Arrays.asList(Constants.DEFAULT_VALUE);



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

        EmployeeDto that = (EmployeeDto) o;

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
