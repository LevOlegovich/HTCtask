package com.nlv2022.htc.presentation;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nlv2022.htc.databinding.ActivityMainBinding;
import com.nlv2022.htc.domain.entity.EmployeeInfo;
import com.nlv2022.htc.domain.entity.GeneralInfo;
import com.nlv2022.htc.presentation.adapter.EmployeesAdapter;

import java.util.Collections;
import java.util.List;


/**
 * Список сотрудников хранится в базе данных,
 * общая информация о компании и время последнего успешного
 * обновления -- в SharedPreferences.
 */


public class MainActivityEmployees extends AppCompatActivity {

    private RecyclerView recyclerViewEmployees;
    private EmployeesAdapter adapter;
    private EmployeesViewModel viewModel;
    private ActivityMainBinding binding;
    Button refrechButton;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        refrechButton = binding.refrechBtn;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivityEmployees.this);
        initRecyclerView();

        viewModel = new ViewModelProvider(this).get(EmployeesViewModel.class);
        viewModel.getEmployees().observe(this, new Observer<List<EmployeeInfo>>() {
            @Override
            public void onChanged(List<EmployeeInfo> employees) {
                Collections.sort(employees, EmployeeInfo.byName);
                adapter.submitList(employees);

                updateTextViewAfterLoadData(viewModel.getGeneralInfo(), employees);
                viewModel.saveGeneralInfo();
                Log.d("MyTag", "list employees: " + employees);
               // Log.d("MyTag", "status in observe: " + viewModel.getStatusFromLoadInfo());
                Log.d("MyTag", "shared in observe: " + viewModel.getGeneralInfo().getTimeUpdate());


            }

        });


        refrechButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.loadData();
            }
        });


    }


    private void initRecyclerView() {
        recyclerViewEmployees = binding.rcView;
        adapter = new EmployeesAdapter();
        recyclerViewEmployees.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewEmployees.setAdapter(adapter);
    }

    // updateTextViewAfterLoadData -- здесь  логика отображения данных.
    private void updateTextViewAfterLoadData(GeneralInfo generalInfo, List<EmployeeInfo> employees) {

        initCountEmployees(employees);          // установка текста в TextView , a именно--количество сотрудников)
        initText(generalInfo.getTimeUpdate(),
                generalInfo.getNameCompany(),
                generalInfo.getAgeCompany(),
                generalInfo.getCompetensec());  // установка текста в TextView (общая информация из SharedPreferences)

    }


    private void initCountEmployees(List<EmployeeInfo> employees) {
        String count = String.valueOf(employees.size());
        binding.itemCount.setText(count);
    }


    private void initText(String timeUpdate, String nameCompany, String ageCompany, String competencesCompany) {
        binding.tvTime.setText(timeUpdate);
        binding.textViewNameCompany.setText(nameCompany);
        binding.textViewAgeCompany.setText(ageCompany);
        binding.textViewCompetencesCompany.setText(competencesCompany);
    }


}