package com.nlv2022.htc.domain.usecase;

import com.nlv2022.htc.domain.repozitory.IRepozitory;

public class GetTimeUpdateUseCase {

    private IRepozitory IRepozitory;

    public GetTimeUpdateUseCase(IRepozitory IRepozitory) {
        this.IRepozitory = IRepozitory;
    }

    public String getTimeUpdate() {
        return IRepozitory.getTimeUpdate();

    }
}
