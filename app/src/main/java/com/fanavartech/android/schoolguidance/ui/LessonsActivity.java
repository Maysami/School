package com.fanavartech.android.schoolguidance.ui;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.fanavartech.android.schoolguidance.R;

import java.util.ArrayList;
import java.util.List;

public class LessonsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewLessons;
    private GradesTabAdapter tabAdapter;
    private List<Lessons> lessonses = new ArrayList<>();
    private Toolbar mToolbar;
    private TextView tvToolbarLessons;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grades_tab_fragment);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        tvToolbarLessons = (TextView) findViewById(R.id.tv_toolbar_lessons);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/sans_light.ttf");
        tvToolbarLessons.setTypeface(type);
        recyclerViewLessons = (RecyclerView) findViewById(R.id.recycler_view_lessons);
        tabAdapter = new GradesTabAdapter(lessonses);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewLessons.setLayoutManager(layoutManager);
        recyclerViewLessons.setItemAnimator(new DefaultItemAnimator());
        recyclerViewLessons.setAdapter(tabAdapter);
        recyclerViewLessons.addOnScrollListener(new HidingScrollListener() {
            @Override
            public void onHide() {
                hideViews();
            }

            @Override
            public void onShow() {
                showViews();
            }
        });

        prepareLessons();


    }

    private void hideViews() {

        mToolbar.animate().translationY(-mToolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
    }

    private void showViews() {
        mToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));

    }

    private void prepareLessons() {
        Lessons lessons = new Lessons("ریاضی", null);
        lessonses.add(lessons);

        lessons = new Lessons("فیزیک", null);
        lessonses.add(lessons);

        lessons = new Lessons("فارسی", null);
        lessonses.add(lessons);

        lessons = new Lessons("هندسه", null);
        lessonses.add(lessons);

        lessons = new Lessons("دینی", null);
        lessonses.add(lessons);

        lessons = new Lessons("عربی", null);
        lessonses.add(lessons);
        lessons = new Lessons("اجتماعی", null);
        lessonses.add(lessons);
        lessons = new Lessons("جبر و احتمال", null);
        lessonses.add(lessons);
        lessons = new Lessons("", null);
        lessonses.add(lessons);
        lessons = new Lessons("دینی", null);
        lessonses.add(lessons);
        lessons = new Lessons("دینی", null);
        lessonses.add(lessons);
        lessons = new Lessons("دینی", null);
        lessonses.add(lessons);
        lessons = new Lessons("دینی", null);
        lessonses.add(lessons);
        lessons = new Lessons("دینی", null);
        lessonses.add(lessons);

        tabAdapter.notifyDataSetChanged();

    }
}
