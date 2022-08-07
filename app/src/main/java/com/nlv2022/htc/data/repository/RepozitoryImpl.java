

package com.nlv2022.htc.data.repository;


import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.nlv2022.htc.R;
import com.nlv2022.htc.constants.Constants;
import com.nlv2022.htc.data.http.ApiFactory;
import com.nlv2022.htc.data.http.ApiService;
import com.nlv2022.htc.data.database.AppDataBase;
import com.nlv2022.htc.data.database.EmployeeDao;
import com.nlv2022.htc.data.database.EmployeeDbModel;
import com.nlv2022.htc.data.mapper.MapperEntities;
import com.nlv2022.htc.data.network.CompanyDto;
import com.nlv2022.htc.data.network.RootEntityDto;
import com.nlv2022.htc.data.sharedpref.GeneralInfoShared;
import com.nlv2022.htc.data.sharedpref.ISharedPrefData;
import com.nlv2022.htc.data.sharedpref.SharedPrefDataImpl;
import com.nlv2022.htc.domain.repozitory.IRepozitory;
import com.nlv2022.htc.domain.entity.CompanyInfo;
import com.nlv2022.htc.domain.entity.EmployeeInfo;
import com.nlv2022.htc.domain.entity.GeneralInfo;
import com.nlv2022.htc.domain.entity.LoadInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RepozitoryImpl implements IRepozitory {

    private final Application application;
    private final ISharedPrefData sharedPrefData;
    private final EmployeeDao employeeDao;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final MapperEntities mapper = new MapperEntities();

    private LoadInfo loadInfo = new LoadInfo(false, Constants.DEFAULT_VALUE);
    private CompanyDto companyDto = new CompanyDto();


    public RepozitoryImpl(Application application) {
        this.application = application;
        this.employeeDao = AppDataBase.getInstance(application).employeeDao();
        this.sharedPrefData = new SharedPrefDataImpl(application.getApplicationContext());
    }


    @Override
    public LiveData<List<EmployeeInfo>> getAllEmployees() { // трансформация данных у LiveData из базы данных.

        return Transformations.map(employeeDao.getAllEmployee(),
                new Function<List<EmployeeDbModel>, List<EmployeeInfo>>() {
                    @Override
                    public List<EmployeeInfo> apply(List<EmployeeDbModel> dbModelList) {
                        return mapper.mapListDbModelToEntity(dbModelList);
                    }
                }
        );

    }


    @Override
    public void loadData() { // загрузка данных по сети
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiservice();

        Disposable disposable = apiService.getRootEntity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RootEntityDto>() {
                    @Override
                    public void accept(RootEntityDto rootEntityDto) throws Exception {
                        deleteAllEmployees(); // удаление данных из базы в другом потоке.

                        List<EmployeeDbModel> employeeDbModelList =
                                mapper.getEmployeesDbModelsFromDto(rootEntityDto);

                        insertEmployees(employeeDbModelList); // добавление данных из базы в другом потоке.

                        loadInfo = new LoadInfo(true, getCurrentTime()); // запись данных о загрузке
                        companyDto = (rootEntityDto.getCompany());

                        Toast.makeText(application, R.string.success, Toast.LENGTH_SHORT).show();
                        Log.d("MyTag", "status in RepozitoryEmployeesImpl : " + loadInfo.getStatus());


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        loadInfo = new LoadInfo(false, getTimeUpdate()); // запись данных о загрузке

                        Toast.makeText(application, R.string.notupdated, Toast.LENGTH_SHORT).show();
                        Log.d("MyTag", "status in RepozitoryEmployeesImpl: " + loadInfo.getStatus());
                    }

                });

        compositeDisposable.add(disposable);
    }


    @Override
    public String getTimeUpdate() {
        return loadInfo.getTime();
    } // получение времени обновления

    @Override
    public boolean getStatusLoad() {
        return loadInfo.getStatus();
    } // информация о статусе загрузки, по умолчанию false.

    @Override
    public CompanyInfo getCompanyInfo() {
        return mapper.mapCompanyDtoToEntity(companyDto);
    } // информация о компании

    @Override
    public GeneralInfo getGeneralInfo() {

        GeneralInfoShared generalInfoShared = sharedPrefData.getGeneralInfoShared();
        return mapper.mapToGeneralInfo(generalInfoShared);
    } // получение данных из sharedPref.

    @Override
    public void saveGeneralInfo(GeneralInfo generalInfo) {
        sharedPrefData.saveGeneralInfoShared(mapper.mapToGeneralInfoShared(generalInfo));

    } // сохранение в sharedPref.


    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    private String getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "HH:mm:ss - dd/MM/yyyy", Locale.getDefault());
        return simpleDateFormat.format(date);
    }  // получение текущего времени


    private void insertEmployees(List<EmployeeDbModel> employees) {
        new InsertEmployeesTask().execute(employees);

    }

    private void deleteAllEmployees() {
        new DeleteAllEmployeeTask().execute();

    }


    private class InsertEmployeesTask
            extends AsyncTask<List<EmployeeDbModel>, Void, Void> {

        @SafeVarargs
        @Override
        protected final Void doInBackground(List<EmployeeDbModel>... lists) {
            if (lists != null && lists.length > 0) {

                employeeDao.insertEmployee(lists[0]);
            }
            return null;
        }

    }


    private class DeleteAllEmployeeTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            employeeDao.deleteAllEmployees();
            return null;
        }
    }


}



