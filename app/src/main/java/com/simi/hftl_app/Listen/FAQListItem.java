package com.simi.hftl_app.Listen;

import com.simi.hftl_app.Model.QuestionType;

/**
 * Created by student on 14.02.2016.
 */
public class FAQListItem
{
    private String name;
    private QuestionType questionType;

    public FAQListItem (String name, QuestionType questionType)
    {
        this.name = name;
        this.questionType = questionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
