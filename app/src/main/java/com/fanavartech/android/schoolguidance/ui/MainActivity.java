package com.fanavartech.android.schoolguidance.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import com.crashlytics.android.Crashlytics;
import com.fanavartech.android.schoolguidance.R;

import io.fabric.sdk.android.Fabric;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private List<News> newsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        CircleImageView imgStudent = (de.hdodenhof.circleimageview.CircleImageView)findViewById(R.id.img_student);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        newsAdapter = new NewsAdapter(newsList);
        RecyclerView.LayoutManager mlayoutManager  = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(newsAdapter);
        newsAdapter.setOnItemClickListener(this);
        prepareNews();
    }

    private void prepareNews() {
        News news = new News("سه شنبه جلسه اولیاء و مربیان می باشد.");
        newsList.add(news);

       news = new News("نمرات درس ریاضی وارد شد.");
        newsList.add(news);

       news = new News("امروز 2 ساعت تاخیر داشتند.");
        newsList.add(news);

       news = new News("برنامه اردوی قم روز  پنج شنبه می باشد. ");
        newsList.add(news);

        news = new News("تکالیف درس فارسی داده شده است.");
        newsList.add(news);

        news = new News("حضور والدین گرامی در جلسه اولیاء و مربیان الزامی است.");
        newsList.add(news);

        news = new News("دانش آموزان مقطع ششم ابتدایی، جهت ثبت نام در اردوی قم به آقای معینی مراجعه کنند.");
        newsList.add(news);

        news = new News("کلاس فوق برنامه ریاضی از ساعت 14 الی 16 در کلاس 601 برگزار می گردد.");
        newsList.add(news);

        news = new News("به اطلاع تمام دانش آموزان دبیرستان فرزانگان تهران می رساند،  جهت آمادگی جهت آزمون های نهایی پایان ترم، اردوی درسی به مدت 2 هفته در کتابخانه مدرسه برگزار می گردد.");
        newsList.add(news);

        news = new News("دانش آموزانی که لیاقت حضور در اربعین حسینی(ع) را داشته اید،زیارت شما قبول درگاه احدیت. مدیر مدرسه");
        newsList.add(news);

        newsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        CircleImageView imgGrades;
        imgGrades= (CircleImageView) view.findViewById(R.id.img_grades);
    }
}
