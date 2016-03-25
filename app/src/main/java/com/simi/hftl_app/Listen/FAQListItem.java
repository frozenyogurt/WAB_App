package com.simi.hftl_app.Listen;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.QuestionType;
import com.simi.hftl_app.R;

/**
 * Created by student on 14.02.2016.
 */
public class FAQListItem
{
    private String name;
    private String info;
    private MainActivity activity;
    private QuestionType questionType;

    public FAQListItem (String name, QuestionType questionType, MainActivity activity)
    {
        this.activity = activity;
        this.name = name;
        this.questionType = questionType;
        init();
    }

    private void init() 
    {
        if(questionType.equals(QuestionType.ACCEPTED))
        {
            info = activity.getResources().getString(R.string.ACCEPTED);
        }
        if(questionType.equals(QuestionType.APARTMENTS))
        {
            info = activity.getResources().getString(R.string.APARTMENTS);
        }
        if(questionType.equals(QuestionType.INTERNSHIP))
        {
            info = activity.getResources().getString(R.string.INTERNSHIP);
        }
        if(questionType.equals(QuestionType.MEANING_ACCREDITATION))
        {
            info = activity.getResources().getString(R.string.MEANING_ACCREDITATION);
        }
        if(questionType.equals(QuestionType.STUDY_CATEGORY_DIFFERENCE))
        {
            info = activity.getResources().getString(R.string.STUDY_CATEGORY_DIFFERENCE);
        }
        if(questionType.equals(QuestionType.STUDY_COSTS))
        {
            info = activity.getResources().getString(R.string.STUDY_COSTS);
        }
        if(questionType.equals(QuestionType.STUDY_COSTS_SEMESTER))
        {
            info = activity.getResources().getString(R.string.STUDY_COSTS_SEMESTER);
        }
        if(questionType.equals(QuestionType.STUDY_FAR_AWAY))
        {
            info = activity.getResources().getString(R.string.STUDY_FAR_AWAY);
        }
        if(questionType.equals(QuestionType.WHICH_STUDY_COURSE))
        {
            info = activity.getResources().getString(R.string.WHICH_STUDY_COURSE);
        }
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
