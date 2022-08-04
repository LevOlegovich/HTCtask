package com.nlv2022.htc.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import com.nlv2022.htc.R;
import com.nlv2022.htc.constants.Constants;
import com.nlv2022.htc.domain.entity.EmployeeInfo;

public class EmployeesAdapter extends ListAdapter<EmployeeInfo, EmployeeViewHolder> {

    public EmployeesAdapter() {
        super(new EmployeesDiffCalback());
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        int layout;
        if (viewType == EmployeesViewType.EMPLOYEE_COMPLETE_INFORMATION) {
            layout = R.layout.item_employee_enabled;
        } else if (viewType == EmployeesViewType.EMPLOYEE_INCOMPLETE_INFORMATION) {
            layout = R.layout.item_employee_disabled;
        } else {
            throw new RuntimeException("Uknown view type: " + viewType);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new EmployeeViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        EmployeeInfo employee = getItem(position);
        holder.name.setText(employee.getName());
        holder.phoneNumber.setText(employee.getPhoneNumber());
        holder.skills.setText(employee.getSkills().toString());

        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);

    }

    @Override
    public int getItemViewType(int position) {
        EmployeeInfo employee = getItem(position);

        if (completeInformation(employee)) {
            return EmployeesViewType.EMPLOYEE_COMPLETE_INFORMATION;
        } else {
            return EmployeesViewType.EMPLOYEE_INCOMPLETE_INFORMATION;
        }

    }


    private boolean completeInformation(EmployeeInfo employee) {
        if (employee.getName().equals(Constants.DEFAULT_VALUE)
                || employee.getPhoneNumber().equals(Constants.DEFAULT_VALUE) ||
                employee.getSkills().toString().contains(Constants.DEFAULT_VALUE)) {
            return false;
        } else
            return true;
    }

}
