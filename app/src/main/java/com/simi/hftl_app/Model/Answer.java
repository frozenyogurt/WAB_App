package com.simi.hftl_app.Model;

import java.util.HashMap;

/**
 * Created by student on 17.02.2016.
 */
public class Answer
{
    private String answerName;
    private boolean isSet = false;
    private HashMap <RatingCategory, Integer> ratingMap = new HashMap<>();

    public Answer(String name)
    {
        this.answerName = name;
    }

    public Answer(String answerName, HashMap<RatingCategory, Integer> ratingMap)
    {
        this.answerName = answerName;
        this.ratingMap = ratingMap;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public boolean isSet() {
        return isSet;
    }

    public void setIsSet(boolean isSet) {
        this.isSet = isSet;
    }

    public HashMap<RatingCategory, Integer> getRatingMap() {
        return ratingMap;
    }

    public void setRatingMap(HashMap<RatingCategory, Integer> ratingMap) {
        this.ratingMap = ratingMap;
    }
}
