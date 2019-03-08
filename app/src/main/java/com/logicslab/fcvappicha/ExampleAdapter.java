package com.logicslab.fcvappicha;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private ArrayList<ExampleItem> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public ImageView mFirstImage, mSecondImage;
        public TextView mFirstTeam, mSecondTeam, mFistGoal, mSeconGoal, mMatchDay;


        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            mFirstImage = itemView.findViewById(R.id.ivFirstTeam);
            mSecondImage = itemView.findViewById(R.id.ivSecondTeam);

            mFirstTeam = itemView.findViewById(R.id.tvFirstTeam);
            mSecondTeam = itemView.findViewById(R.id.tvSecondTeam);


            mFistGoal = itemView.findViewById(R.id.tvGoalFirst);
            mSeconGoal = itemView.findViewById(R.id.tvGoalSecond);


            mMatchDay = itemView.findViewById(R.id.tvMatchDate);

        }
    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleList){
        mExampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.match_template, viewGroup, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {
        ExampleItem currentItem = mExampleList.get(i);

        int fGoal = Integer.parseInt(currentItem.getFirstGoal());
        int sGoal = Integer.parseInt(currentItem.getSecondGoal());

        if (fGoal == sGoal){
            exampleViewHolder.mFistGoal.setTextColor(Color.GRAY);
            exampleViewHolder.mSeconGoal.setTextColor(Color.GRAY);
        }

        exampleViewHolder.mFirstImage.setImageResource(currentItem.getFirstImage());
        exampleViewHolder.mSecondImage.setImageResource(currentItem.getSecondImage());

        exampleViewHolder.mFirstTeam.setText(currentItem.getFirstTeam());
        exampleViewHolder.mSecondTeam.setText(currentItem.getSecondTeam());

        exampleViewHolder.mFistGoal.setText(currentItem.getFirstGoal());
        exampleViewHolder.mSeconGoal.setText(currentItem.getSecondGoal());

        exampleViewHolder.mMatchDay.setText(currentItem.getMatchDate());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
