package com.fanavartech.android.schoolguidance.ui;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanavartech.android.schoolguidance.R;

import java.util.List;

public class GradesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_CONTENT = 0;
    private List<Grades> gradesList;

    public GradesAdapter(List<Grades> gradesList) {
        this.gradesList = gradesList;
    }


    // the content function
    public static class ContentViewHolder extends RecyclerView.ViewHolder {

        private TextViewPlus tvValueDate, tvValueGrade, tvValueQuestion, tvTitleGrade;

        public ContentViewHolder(View itemView) {
            super(itemView);
            tvValueDate = (TextViewPlus) itemView.findViewById(R.id.tv_value_date);
            tvValueGrade = (TextViewPlus) itemView.findViewById(R.id.tv_value_grade);
            tvTitleGrade = (TextViewPlus) itemView.findViewById(R.id.tv_title_grade);
            tvValueQuestion = (TextViewPlus) itemView.findViewById(R.id.tv_value_question);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_CONTENT) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_grades, parent, false);
            ContentViewHolder contentViewHolder = new ContentViewHolder(itemView);
            return contentViewHolder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Grades grades = gradesList.get(position);
        ((ContentViewHolder) holder).tvValueDate.setText(grades.getValueDate());
        ((ContentViewHolder) holder).tvValueGrade.setText(grades.getScoreExam());
        ((ContentViewHolder) holder).tvTitleGrade.setText(grades.getTypeExam());
        ((ContentViewHolder) holder).tvValueQuestion.setText(grades.getStatus());

    }

    @Override
    public int getItemCount() {
        return gradesList.size();
    }
}
