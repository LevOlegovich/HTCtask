package com.nlv2022.htc.domain.usecase;

import com.nlv2022.htc.domain.repozitory.IRepozitory;
import com.nlv2022.htc.domain.entity.GeneralInfo;

public class SaveGeneralInfoUseCase {

    private IRepozitory IRepozitory;

    public SaveGeneralInfoUseCase(IRepozitory IRepozitory) {
        this.IRepozitory = IRepozitory;
    }

   public void saveGeneralInfo(GeneralInfo generalInfo){
        IRepozitory.saveGeneralInfo(generalInfo);
    }
}
