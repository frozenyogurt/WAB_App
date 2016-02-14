package com.simi.hftl_app.Listen;

import com.simi.hftl_app.Model.Question;

/**
 * Created by student on 14.02.2016.
 */
public class FAQListItem
{
    private String name;
    private Question question;

    public FAQListItem (String name, Question question)
    {
        this.name = name;
        this.question = question;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
