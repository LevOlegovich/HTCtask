package com.nlv2022.htc.presentation.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nlv2022.htc.R;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    TextView phoneNumber;
    TextView skills;
    TextView itemNumber;

    public EmployeeViewHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.tvName);
        this.phoneNumber = itemView.findViewById(R.id.tvPhoneNumber);
        this.skills = itemView.findViewById(R.id.tvSkills);
        this.itemNumber=itemView.findViewById(R.id.itemNumber);
    }


}
