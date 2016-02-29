package com.simi.hftl_app.Model;

import java.util.ArrayList;

/**
 * Created by student on 17.02.2016.
 */
public class Question
{
    private String questionName;
    private ArrayList<Answer> answers = new ArrayList<>();

    public Question (String name)
    {
        this.questionName = name;
    }

    public Question(String name, ArrayList<Answer> answers)
    {
        this.questionName = name;
        this.answers = answers;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
}
