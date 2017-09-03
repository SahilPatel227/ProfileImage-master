package com.example.admin.profileimage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 8/21/2017.
 */

public class adapterrecycle extends RecyclerView.Adapter<adapterrecycle.MyViewHolder>  {


        private List<Friends> friendsList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView Name;
            public ImageView img;

            public MyViewHolder(View view) {
                super(view);
                img = (ImageView) view.findViewById(R.id.image1);
                Name = (TextView) view.findViewById(R.id.tv_name);
            }
        }


        public adapterrecycle(List<Friends> friendsList) {
            this.friendsList = friendsList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.friends_list_row, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Friends movie = friendsList.get(position);
            holder.Name.setText(movie.getName());
            holder.img.setImageResource(R.drawable.ic_image);
        }

        @Override
        public int getItemCount() {
            return friendsList.size();
        }
    }