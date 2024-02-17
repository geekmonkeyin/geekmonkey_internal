package com.gkmonk.finalgeekmonkeyapp.ui.amazon;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AmazonViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public AmazonViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is amazon fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}