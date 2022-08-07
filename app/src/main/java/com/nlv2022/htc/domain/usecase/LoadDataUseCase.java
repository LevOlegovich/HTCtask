package com.nlv2022.htc.domain.usecase;

import com.nlv2022.htc.domain.repozitory.IRepozitory;

public class LoadDataUseCase {

    private IRepozitory IRepozitory;

    public LoadDataUseCase(IRepozitory IRepozitory) {
        this.IRepozitory = IRepozitory;
    }

    public void loadData() {
        IRepozitory.loadData();

    }

}
