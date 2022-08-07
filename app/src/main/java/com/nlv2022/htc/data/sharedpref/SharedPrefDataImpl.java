package com.nlv2022.htc.data.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.nlv2022.htc.constants.Constants;

public class SharedPrefDataImpl implements ISharedPrefData {
    private final Context context;
    private SharedPreferences sharedPreferences;

    public SharedPrefDataImpl(Context context) {
        this.context = context;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }


    @Override
    public void saveGeneralInfoShared(GeneralInfoShared infoShared) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.TIME_UPDATE, infoShared.getTimeUpdate());
        editor.putString(Constants.NAME_COMPANY, infoShared.getNameCompany());
        editor.putString(Constants.AGE_COMPANY, infoShared.getAgeCompany());
        editor.putString(Constants.COMPETENCES_COMPANY, infoShared.getCompetensec());
        editor.commit();

    }

    @Override
    public GeneralInfoShared getGeneralInfoShared() {
        String nameCompany = sharedPreferences.getString(Constants.NAME_COMPANY, Constants.DEFAULT_VALUE);
        String ageCompany = sharedPreferences.getString(Constants.AGE_COMPANY, Constants.DEFAULT_VALUE);
        String competencesCompany = sharedPreferences.getString(Constants.COMPETENCES_COMPANY, Constants.DEFAULT_VALUE);
        String timeUpdate = sharedPreferences.getString(Constants.TIME_UPDATE, Constants.DEFAULT_VALUE);
        return new GeneralInfoShared(
                nameCompany,
                ageCompany,
                competencesCompany,
                timeUpdate);
    }
}
