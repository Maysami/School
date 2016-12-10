package com.fanavartech.android.schoolguidance.ui;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fanavartech.android.schoolguidance.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_TOP = 0;
    private static final int TYPE_HEADER = 1;
    private static final int TYPE_ITEM = 2;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private List<News> newsList;

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_TOP) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_sections_main, parent, false);
            TopViewHolder topViewHolder = new TopViewHolder(itemView, this);
            return topViewHolder;
        } else if (viewType == TYPE_HEADER) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.header_list_news, parent, false);
            HeaderViewHolder headerViewHolder = new HeaderViewHolder(itemView);
            return headerViewHolder;
        } else if (viewType == TYPE_ITEM) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_news, parent, false);
            ItemViewHolder itemViewHolder = new ItemViewHolder(itemView);
            return itemViewHolder;
        }
        return null;

    }

    public static class TopViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private RelativeLayout layoutOne, layoutTwo;
        private NewsAdapter mAdapter;
        private CircleImageView imageView;

        public TopViewHolder(View itemView, NewsAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            imageView = (CircleImageView) itemView.findViewById(R.id.img_grades);
            layoutOne = (RelativeLayout) itemView.findViewById(R.id.title_part);
            layoutTwo = (RelativeLayout) itemView.findViewById(R.id.title_part_two);
            imageView.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.img_grades :


                    Intent intent = new Intent(itemView.getContext(),LessonsActivity.class);
                    itemView.getContext().startActivity(intent);


            }
        }
    }

    public void onItemHolderClick(RecyclerView.ViewHolder viewHolder) {
        // TODO Auto-generated method stub
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(null, viewHolder.itemView,
                    viewHolder.getAdapterPosition(), viewHolder.getItemId());
        }

    }

    public void setOnItemClickListener(
            AdapterView.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        private final TextView txtHeader;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            txtHeader = (TextView) itemView.findViewById(R.id.title_header_news);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ItemViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_list_news);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (position == 1) {
            ((HeaderViewHolder) holder).txtHeader.setText(R.string.str_header_news);
        } else if (position >= 2) {
            News news = newsList.get(position - 2);
            ((ItemViewHolder) holder).title.setText(news.getTitle());
        }
    }


    @Override
    public int getItemCount() {
        return newsList.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return TYPE_TOP;
        else if (position == 1)
            return TYPE_HEADER;
        else if (position == 2)
            return TYPE_ITEM;
        return TYPE_ITEM;
    }

}
