package com.fanavartech.android.schoolguidance.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanavartech.android.schoolguidance.R;

import java.util.ArrayList;
import java.util.List;

public class HomeWorksTabFragment extends Fragment {
    private List<HomeWorks> worksList = new ArrayList<>();
    private HomeWorkAdapter homeWorkAdapter ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.homeworks_tab_fragment,container,false);
        RecyclerView recyclerViewGrades = (RecyclerView) rootView.findViewById(R.id.recycler_view_home_works);
        homeWorkAdapter = new HomeWorkAdapter(worksList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewGrades.setLayoutManager(mLayoutManager);
        recyclerViewGrades.setItemAnimator(new DefaultItemAnimator());
        recyclerViewGrades.setAdapter(homeWorkAdapter);

        prepareGrades();
        return  rootView;
    }

    private void prepareGrades() {

        HomeWorks homeWorks = new HomeWorks("تکلیف درس اتحادها داده شده است","16 آذر 1395",null);
        worksList.add(homeWorks);

        homeWorks = new HomeWorks("تکلیف درس اتحادها داده شده است","16 آذر 1395",null);
        worksList.add(homeWorks);

        homeWorks = new HomeWorks("تکلیف درس اتحادها داده شده است","16 آذر 1395",null);
        worksList.add(homeWorks);


        homeWorks = new HomeWorks("تکلیف درس اتحادها داده شده است","16 آذر 1395",null);
        worksList.add(homeWorks);

        homeWorks = new HomeWorks("تکلیف درس اتحادها داده شده است","16 آذر 1395",null);
        worksList.add(homeWorks);

        homeWorks = new HomeWorks("تکلیف درس اتحادها داده شده است","16 آذر 1395",null);
        worksList.add(homeWorks);

        homeWorkAdapter.notifyDataSetChanged();
    }
}
