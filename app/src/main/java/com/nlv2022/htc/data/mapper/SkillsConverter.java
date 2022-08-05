package com.nlv2022.htc.data.mapper;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class SkillsConverter {

    @TypeConverter
    public String get_string(List<String> skills) {
        return new Gson().toJson(skills);

    }

    @TypeConverter
    public List<String> get_list(String skills) {
        if (skills == null)
            return null;
        return Arrays.asList
                (skills.replace("[", " ")
                        .replace("]", " ").split(","));
    }

}
