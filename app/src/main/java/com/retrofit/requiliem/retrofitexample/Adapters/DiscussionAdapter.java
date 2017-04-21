package com.retrofit.requiliem.retrofitexample.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.retrofit.requiliem.retrofitexample.R;
import com.retrofit.requiliem.retrofitexample.models.Discussion;

import java.util.ArrayList;

/**
 * Created by OmarV on 21/04/2017.
 */

public class DiscussionAdapter extends RecyclerView.Adapter<DiscussionAdapter.ViewHolder> {

    private ArrayList<Discussion> discussion;

    public DiscussionAdapter(ArrayList<Discussion> discussion) {
        this.discussion = discussion;
    }

    @Override
    public DiscussionAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DiscussionAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tx_title.setText(discussion.get(i).getTitle());
        viewHolder.tx_body.setText(discussion.get(i).getBody());
    }

    @Override
    public int getItemCount() {
        return discussion.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tx_title,tx_body;
        public ViewHolder(View view) {
            super(view);

            tx_title = (TextView)view.findViewById(R.id.title);
            tx_body = (TextView)view.findViewById(R.id.content);

        }
    }
}
