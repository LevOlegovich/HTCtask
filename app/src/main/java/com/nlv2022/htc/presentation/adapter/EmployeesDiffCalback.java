package com.nlv2022.htc.presentation.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.nlv2022.htc.domain.entity.EmployeeInfo;

public class EmployeesDiffCalback extends DiffUtil.ItemCallback<EmployeeInfo> {
    @Override
    public boolean areItemsTheSame(@NonNull EmployeeInfo oldItem, @NonNull EmployeeInfo newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull EmployeeInfo oldItem, @NonNull EmployeeInfo newItem) {
        return oldItem.equals(newItem);
    }
}
