package com.fanavartech.android.schoolguidance.ui;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.fanavartech.android.schoolguidance.R;

import java.util.List;

public class LessonsAdapter extends RecyclerView.Adapter<LessonsAdapter.MyViewHolder> {
    private List<Lessons> lessonsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextViewPlus titleHeaderNews;
        private RelativeLayout layoutTitleLesson;

        public MyViewHolder(View itemView) {
            super(itemView);
            titleHeaderNews = (TextViewPlus) itemView.findViewById(R.id.title_lesson);
            layoutTitleLesson = (RelativeLayout) itemView.findViewById(R.id.layout_title_lesson);

        }


    }

    public LessonsAdapter(List<Lessons> lessonsList) {
        this.lessonsList = lessonsList;
    }

    @Override
    public LessonsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_grades, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LessonsAdapter.MyViewHolder holder, final int position) {

        final Lessons lessons = lessonsList.get(position);
        holder.titleHeaderNews.setText(lessons.getLesson());
        holder.layoutTitleLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.layout_title_lesson :
                        Intent intent = new Intent(view.getContext(), InterfaceActivity.class);
                        view.getContext().startActivity(intent);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return lessonsList.size();
    }


}
