package com.logicslab.fcvappicha;

public class ExampleItem {
    private int mFirstImage, mSecondImage;
    private String mFirstTeam, mSecondTeam, mFirstGoal, mSecondGoal, mMatchDate;

    public ExampleItem(int firstImage, int secondImage, String firstTeam, String secondTeam, String firstGoal, String secondGoal, String matchDate){

        mFirstImage = firstImage;
        mSecondImage = secondImage;

        mFirstTeam = firstTeam;
        mSecondTeam = secondTeam;

        mFirstGoal = firstGoal;
        mSecondGoal = secondGoal;

        mMatchDate = matchDate;

    }

    public int getFirstImage(){
        return mFirstImage;
    }

    public int getSecondImage(){
        return mSecondImage;
    }

    public String getFirstTeam(){
        return mFirstTeam;
    }

    public String getSecondTeam(){
        return mSecondTeam;
    }

    public String getFirstGoal(){
        return mFirstGoal;
    }

    public String getSecondGoal(){
        return mSecondGoal;
    }

    public String getMatchDate(){
        return mMatchDate;
    }

}
