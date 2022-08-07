package com.nlv2022.htc.domain.usecase;

import com.nlv2022.htc.domain.repozitory.IRepozitory;
import com.nlv2022.htc.domain.entity.GeneralInfo;

public class GetGeneralInfoUseCase {
    private IRepozitory IRepozitory;

    public GetGeneralInfoUseCase(IRepozitory IRepozitory) {
        this.IRepozitory = IRepozitory;
    }

    public GeneralInfo getGeneralInfo() {
        return IRepozitory.getGeneralInfo();
    }

}
