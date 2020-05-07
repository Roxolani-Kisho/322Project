package com.example.agdshfkgh.ui.search;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.agdshfkgh.R;

public class searchViewModel<textView> extends ViewModel {

    private MutableLiveData<String> mText;


    @SuppressLint("WrongViewCast")
    public searchViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Your saved ingredients");


    }

    public LiveData<String> getText() {
        return mText;
    }

}