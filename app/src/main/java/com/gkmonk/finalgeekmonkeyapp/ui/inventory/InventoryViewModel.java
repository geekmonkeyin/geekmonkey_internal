package com.gkmonk.finalgeekmonkeyapp.ui.inventory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InventoryViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public InventoryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Invetory fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}