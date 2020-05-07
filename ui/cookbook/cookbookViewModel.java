package com.example.agdshfkgh.ui.cookbook;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class cookbookViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public cookbookViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is your cookbook");
    }

    public LiveData<String> getText() {
        return mText;
    }
}