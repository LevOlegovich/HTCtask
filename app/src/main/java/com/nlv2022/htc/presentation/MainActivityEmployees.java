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

import com.nlv2022.htc.constants.Constants;
import com.nlv2022.htc.databinding.ActivityMainBinding;
import com.nlv2022.htc.domain.entity.CompanyInfo;
import com.nlv2022.htc.domain.entity.EmployeeInfo;
import com.nlv2022.htc.presentation.adapter.EmployeesAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**     Список сотрудников хранится в базе данных,
        общая информация о компании и время последнего успешного
обновления -- в SharedPreferences.*/


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
        ArrayList<EmployeeInfo> deafaultEmployees = new ArrayList<>();
        initRecyclerView();

        viewModel = new ViewModelProvider(this).get(EmployeesViewModel.class);
        viewModel.getEmployees().observe(this, new Observer<List<EmployeeInfo>>() {
            @Override
            public void onChanged(List<EmployeeInfo> employees) {
                Collections.sort(employees, EmployeeInfo.byName);
                Log.d("MyTag", "list employees: " + employees);

                if (employees.isEmpty()) {
                    adapter.submitList(deafaultEmployees);
                    updateTextViewOnStart(viewModel.getCompanyInfo());
                } else {
                    adapter.submitList(employees);
                    updateTextViewOnStart(viewModel.getCompanyInfo());
                }
                Log.d("MyTag", "status in observe: " + viewModel.getStatusLoad());

            }

        });


        refrechButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.loadDataViewModel();
            }
        });


    }

    private void initRecyclerView() {
        recyclerViewEmployees = binding.rcView;
        adapter = new EmployeesAdapter();
        recyclerViewEmployees.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewEmployees.setAdapter(adapter);
    }


    private void updateTextViewOnStart(CompanyInfo companyInfo) {
        if (viewModel.getStatusLoad() == true) {
            String timeUpdate = viewModel.getTimeUpdate();
            initText
                    (timeUpdate,
                            companyInfo.getName(),
                            companyInfo.getAge(),
                            companyInfo.getCompetences().toString());
            writeSharedPref();
        } else {
            initViewFromSharedPref();
        }

    }


    private void writeSharedPref() {

        editor = sharedPreferences.edit();
        binding.tvTime.setText(viewModel.getTimeUpdate());
        String timeUpdate = binding.tvTime.getText().toString();
        String nameCompany = binding.textViewNameCompany.getText().toString();
        String ageCompany = binding.textViewAgeCompany.getText().toString();
        String competencesCompany = binding.textViewCompetencesCompany.getText().toString();
        editor.putString(Constants.TIME_UPDATE, timeUpdate);
        editor.putString(Constants.NAME_COMPANY, nameCompany);
        editor.putString(Constants.AGE_COMPANY, ageCompany);
        editor.putString(Constants.COMPETENCES_COMPANY, competencesCompany);
        editor.commit();
        Log.d("MyTag", "sharedPreferences Write " + timeUpdate);
    }


    private void initViewFromSharedPref() {
        String timeUpdate = sharedPreferences.getString(Constants.TIME_UPDATE, Constants.DEFAULT_VALUE);
        String nameCompany = sharedPreferences.getString(Constants.NAME_COMPANY, Constants.DEFAULT_VALUE);
        String ageCompany = sharedPreferences.getString(Constants.AGE_COMPANY, Constants.DEFAULT_VALUE);
        String competencesCompany = sharedPreferences.getString(Constants.COMPETENCES_COMPANY, Constants.DEFAULT_VALUE);
        initText(timeUpdate,
                nameCompany,
                ageCompany,
                competencesCompany);
        Log.d("MyTag", "sharedPreferences init " + binding.textViewNameCompany.getText().toString());
    }

    private void initText(String timeUpdate, String nameCompany, String ageCompany, String competencesCompany) {
        binding.tvTime.setText(timeUpdate);
        binding.textViewNameCompany.setText(nameCompany);
        binding.textViewAgeCompany.setText(ageCompany);
        binding.textViewCompetencesCompany.setText(competencesCompany);
    }


}