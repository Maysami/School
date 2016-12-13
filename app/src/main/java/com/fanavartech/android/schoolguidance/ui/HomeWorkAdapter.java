package com.fanavartech.android.schoolguidance.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanavartech.android.schoolguidance.R;

import java.util.List;

public class HomeWorkAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int TYPE_CONTENT = 0;
    private List<HomeWorks> worksList ;

    public HomeWorkAdapter(List<HomeWorks> worksList) {
        this.worksList = worksList;
    }

    // the content function
    public static class ContentViewHolder extends RecyclerView.ViewHolder {

        private TextViewPlus tvTypeHomeWork, tvDeadlineDate,tvUrlDowloadTask;

        public ContentViewHolder(View itemView) {
            super(itemView);
            tvTypeHomeWork = (TextViewPlus) itemView.findViewById(R.id.tv_type_home_works);
            tvDeadlineDate = (TextViewPlus) itemView.findViewById(R.id.tv_value_deadline_date);

        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_CONTENT) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_home_works, parent, false);
            ContentViewHolder contentViewHolder = new ContentViewHolder(itemView);
            return contentViewHolder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        HomeWorks works = worksList.get(position);
        ((ContentViewHolder) holder).tvTypeHomeWork.setText(works.getTypeHomeWork());
        ((ContentViewHolder) holder).tvDeadlineDate.setText(works.getDeadlineDate());
    }

    @Override
    public int getItemCount() {
        return worksList.size();
    }
}
