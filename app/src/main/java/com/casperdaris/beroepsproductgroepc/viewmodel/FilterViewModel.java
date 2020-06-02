package com.casperdaris.beroepsproductgroepc.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.casperdaris.beroepsproductgroepc.DatabaseHelper;
import com.casperdaris.beroepsproductgroepc.Objecten.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FilterViewModel extends AndroidViewModel {

    private DatabaseHelper databaseHelper;
    private MutableLiveData<List<Taal>> talen;
    private MutableLiveData<List<Religie>> religies;
    private List<Taal> selectedTalen;
    private List<Religie> selectedReligies;

    public FilterViewModel(@NonNull Application application) {
        super(application);
        databaseHelper = new DatabaseHelper(application);
        talen = new MutableLiveData<>();
        talen.postValue(databaseHelper.getTalen());
        religies = new MutableLiveData<>();
        religies.postValue(databaseHelper.getReligies());
        selectedTalen = new ArrayList<>();
        selectedReligies = new ArrayList<>();
    }

    public MutableLiveData<List<Taal>> getTalen() {
        return talen;
    }

    public MutableLiveData<List<Religie>> getReligies() {
        return religies;
    }

    public void setSelectedTalen(Set<String> selectedTalen) {
        List<Taal> taalList = new ArrayList<>();
        selectedTalen.forEach(taalNaam -> {
            Taal taal = new Taal(taalNaam);
            taalList.add(taal);
        });
        this.selectedTalen = taalList;
    }

    public void setSelectedReligies(Set<String> selectedReligies) {
        List<Religie> religieList = new ArrayList<>();
        selectedReligies.forEach(religieNaam -> {
            Religie religie = new Religie(religieNaam);
            religieList.add(religie);
        });
        this.selectedReligies = religieList;
    }

    public List<Taal> getSelectedTalen() {
        return selectedTalen;
    }

    public List<Religie> getSelectedReligies() {
        return selectedReligies;
    }
}