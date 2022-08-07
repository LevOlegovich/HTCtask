package com.nlv2022.htc.domain.usecase;

import com.nlv2022.htc.domain.repozitory.IRepozitory;
import com.nlv2022.htc.domain.entity.CompanyInfo;

public class GetCompanyUseCase {
    private IRepozitory IRepozitory;

    public GetCompanyUseCase(IRepozitory IRepozitory) {
        this.IRepozitory = IRepozitory;
    }

    public CompanyInfo getCompanyInfo(){
        return IRepozitory.getCompanyInfo();
    }
}
