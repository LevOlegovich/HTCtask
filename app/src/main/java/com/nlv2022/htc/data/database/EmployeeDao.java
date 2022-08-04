package com.nlv2022.htc.data.database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM employees")
    LiveData<List<EmployeeDbModel>> getAllEmployee();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEmployee(List<EmployeeDbModel> employees);

    @Query("DELETE  FROM employees")
    void deleteAllEmployees();


}
