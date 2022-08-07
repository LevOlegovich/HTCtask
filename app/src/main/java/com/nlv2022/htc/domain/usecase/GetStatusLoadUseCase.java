package com.nlv2022.htc.domain.usecase;

import com.nlv2022.htc.domain.repozitory.IRepozitory;

public class GetStatusLoadUseCase {
    IRepozitory IRepozitory;

    public GetStatusLoadUseCase(IRepozitory IRepozitory) {
        this.IRepozitory = IRepozitory;
    }

    public boolean getStatusLoad() {
        return IRepozitory.getStatusLoad();
    }


}
