package com.jkristian.speakable;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class SpeakableApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}