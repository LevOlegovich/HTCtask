package com.nlv2022.htc.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RootEntityDto {

    @SerializedName("company")
    @Expose
    private CompanyDto company;


    public CompanyDto getCompany() {
        return company;
    }

    public void setCompany(CompanyDto company) {
        this.company = company;
    }
}
