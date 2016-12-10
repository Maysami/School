package com.fanavartech.android.schoolguidance.ui;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanavartech.android.schoolguidance.R;

import java.util.List;

public class GradesTabAdapter extends RecyclerView.Adapter<GradesTabAdapter.MyViewHolder> {
    private List<Lessons> lessonsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextViewPlus titleHeaderNews;

        public MyViewHolder(View itemView) {
            super(itemView);
            titleHeaderNews = (TextViewPlus) itemView.findViewById(R.id.title_header_news);

        }
    }

    public GradesTabAdapter(List<Lessons> lessonsList) {
        this.lessonsList = lessonsList;
    }

    @Override
    public GradesTabAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_grades, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GradesTabAdapter.MyViewHolder holder, int position) {

        Lessons lessons = lessonsList.get(position);
        holder.titleHeaderNews.setText(lessons.getLesson());

    }

    @Override
    public int getItemCount() {
        return lessonsList.size();
    }


}
