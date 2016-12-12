package com.fanavartech.android.schoolguidance.ui;


import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.fanavartech.android.schoolguidance.R;
import com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends FillGap3BaseActivity<ObservableRecyclerView> implements ObservableScrollViewCallbacks {
    private List<News> newsList = new ArrayList<>();
    private NewsAdapter newsAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_home;
    }

    @Override
    protected ObservableRecyclerView createScrollable() {

        ObservableRecyclerView recyclerView = (ObservableRecyclerView) findViewById(R.id.scroll);
        newsAdapter = new NewsAdapter(newsList);
        recyclerView.setScrollViewCallbacks(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        setDummyDataFew(recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(newsAdapter);


        prepareNews();

        return recyclerView;
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

        news = new News("دانش آموزانی که لیاقت حضور در اربعین حسینی(ع) را داشته اید،زیارت شما قبول درگاه احدیت. شرکت فرهیختگان علم و صنعت");
        newsList.add(news);

        newsAdapter.notifyDataSetChanged();
    }



}
