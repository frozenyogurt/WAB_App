package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simi.hftl_app.Listen.FAQListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.QuestionType;
import com.simi.hftl_app.R;

/**
 * Created by student on 14.02.2016.
 */
public class FAQInfoFragment extends MyRefreshFragment
{
    public FAQInfoFragment () {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.faq_info_fragment, container, false);

        TextView title = (TextView) view.findViewById(R.id.faq_title);
        TextView text = (TextView) view.findViewById(R.id.faq_text);
        FAQListItem clickedItem = ((MainActivity) getActivity()).getClickedFAQ();

        title.setText(clickedItem.getName());
        if(clickedItem.getQuestionType().equals(QuestionType.ACCEPTED))
        {
            text.setText("Anwort zur Frage");
        }
        if(clickedItem.getQuestionType().equals(QuestionType.APARTMENTS))
        {
            text.setText("Anwort zur Frage");
        }
        if(clickedItem.getQuestionType().equals(QuestionType.INTERNSHIP))
        {
            text.setText("Anwort zur Frage");
        }
        if(clickedItem.getQuestionType().equals(QuestionType.MEANING_ACCREDITATION))
        {
            text.setText("Anwort zur Frage");
        }
        if(clickedItem.getQuestionType().equals(QuestionType.STUDY_CATEGORY_DIFFERENCE))
        {
            text.setText("Anwort zur Frage");
        }
        if(clickedItem.getQuestionType().equals(QuestionType.STUDY_COSTS))
        {
            text.setText("Anwort zur Frage");
        }
        if(clickedItem.getQuestionType().equals(QuestionType.STUDY_COSTS_SEMESTER))
        {
            text.setText("Anwort zur Frage");
        }
        if(clickedItem.getQuestionType().equals(QuestionType.STUDY_FAR_AWAY))
        {
            text.setText("Anwort zur Frage");
        }
        if(clickedItem.getQuestionType().equals(QuestionType.WHICH_STUDY_COURSE))
        {
            text.setText("Anwort zur Frage");
        }

        return view;
    }
}
