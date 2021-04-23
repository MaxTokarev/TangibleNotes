package com.tangible.notes;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

import dagger.hilt.android.HiltAndroidApp;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
    }
}
