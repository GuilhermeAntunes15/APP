package com.example.apptemp.ui.notifications;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.apptemp.MainActivity;

public class NotificationsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;


    public NotificationsViewModel() {



        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}