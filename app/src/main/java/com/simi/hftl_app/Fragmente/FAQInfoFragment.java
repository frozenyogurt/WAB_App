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
            text.setText(getActivity().getResources().getString(R.string.ACCEPTED));
        }
        if(clickedItem.getQuestionType().equals(QuestionType.APARTMENTS))
        {
            text.setText(getActivity().getResources().getString(R.string.APARTMENTS));
        }
        if(clickedItem.getQuestionType().equals(QuestionType.INTERNSHIP))
        {
            text.setText(getActivity().getResources().getString(R.string.INTERNSHIP));
        }
        if(clickedItem.getQuestionType().equals(QuestionType.MEANING_ACCREDITATION))
        {
            text.setText(getActivity().getResources().getString(R.string.MEANING_ACCREDITATION));
        }
        if(clickedItem.getQuestionType().equals(QuestionType.STUDY_CATEGORY_DIFFERENCE))
        {
            text.setText(getActivity().getResources().getString(R.string.STUDY_CATEGORY_DIFFERENCE));
        }
        if(clickedItem.getQuestionType().equals(QuestionType.STUDY_COSTS))
        {
            text.setText(getActivity().getResources().getString(R.string.STUDY_COSTS));
        }
        if(clickedItem.getQuestionType().equals(QuestionType.STUDY_COSTS_SEMESTER))
        {
            text.setText(getActivity().getResources().getString(R.string.STUDY_COSTS_SEMESTER));
        }
        if(clickedItem.getQuestionType().equals(QuestionType.STUDY_FAR_AWAY))
        {
            text.setText(getActivity().getResources().getString(R.string.STUDY_FAR_AWAY));
        }
        if(clickedItem.getQuestionType().equals(QuestionType.WHICH_STUDY_COURSE))
        {
            text.setText(getActivity().getResources().getString(R.string.WHICH_STUDY_COURSE));
        }

        return view;
    }
}
