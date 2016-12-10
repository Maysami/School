package com.fanavartech.android.schoolguidance;


import android.app.Application;
import android.content.Context;

/**
 * Main Application of the project
 *
 * Contains methods to build the "static" strings. These strings were before constants in different
 * classes
 */
public class MainApp extends Application {
    private static Context mContext;


    public static Context getmContext() {
        return mContext;
    }

    public static void setmContext(Context mContext) {
        MainApp.mContext = mContext;
    }
}
