package com.fanavartech.android.schoolguidance.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanavartech.android.schoolguidance.R;

public class HomeWorksTabFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.homeworks_tab_fragment,container,false);
    }
}