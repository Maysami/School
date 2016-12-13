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


public class GradesTabFragment extends Fragment {

    private List<Grades> gradesList = new ArrayList<>();
    private GradesAdapter gradesAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.grade_tab_fragment, container, false);
        RecyclerView recyclerViewGrades = (RecyclerView) rootView.findViewById(R.id.recycler_view_grades);
        gradesAdapter = new GradesAdapter(gradesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewGrades.setLayoutManager(mLayoutManager);
        recyclerViewGrades.setItemAnimator(new DefaultItemAnimator());
        recyclerViewGrades.setAdapter(gradesAdapter);

        prepareGrades();

        return rootView;
    }

    private void prepareGrades() {
        Grades grades = new Grades("14 مهرماه 1394", "20", "کتبی از 20", "عالی");
        gradesList.add(grades);

        grades = new Grades("5 مهرماه 1394", "19.75", "کتبی از 20", "عالی");
        gradesList.add(grades);

        grades = new Grades("5 مهرماه 1394", "20", "کتبی از 20", "عالی");
        gradesList.add(grades);

        grades = new Grades("5 مهرماه 1394", "18.5", "کتبی از 20", "خوب");
        gradesList.add(grades);

        grades = new Grades("5 مهرماه 1394", "20", "امتحان کتبی", "عالی");
        gradesList.add(grades);

        grades = new Grades("5 مهرماه 1394", "17", "امتحان کتبی", "متوسط");
        gradesList.add(grades);

        gradesAdapter.notifyDataSetChanged();
    }
}
