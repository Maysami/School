package com.fanavartech.android.schoolguidance.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class PagerAdapter extends FragmentStatePagerAdapter{
   int mNumOfTabs ;

    public PagerAdapter(FragmentManager fm, int mNumOfTabs) {
        super(fm);
        this.mNumOfTabs = mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 4:
                GradesTabFragment gradesTabFragment = new GradesTabFragment();
                return gradesTabFragment;
            case 3:
                HomeWorksTabFragment homeWorksTabFragment = new HomeWorksTabFragment();
                return homeWorksTabFragment;
            case 2:
                ChartTabFragment chartTabFragment = new ChartTabFragment();
                return chartTabFragment;
            case 1:
                ExamTabFragment examTabFragment=new ExamTabFragment();
                return examTabFragment;
            case 0:
                ReportTabFragment reportTabFragment = new ReportTabFragment();
                return reportTabFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
