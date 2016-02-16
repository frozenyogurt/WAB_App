package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simi.hftl_app.Listen.FAQListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Question;
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
        if(clickedItem.getQuestion().equals(Question.ACCEPTED))
        {
            text.setText("Anwort zur Frage");
        }
        if(clickedItem.getQuestion().equals(Question.APARTMENTS))
        {
            text.setText("Anwort zur Frage");
        }
        if(clickedItem.getQuestion().equals(Question.INTERNSHIP))
        {
            text.setText("Anwort zur Frage");
        }
        if(clickedItem.getQuestion().equals(Question.MEANING_ACCREDITATION))
        {
            text.setText("Anwort zur Frage");
        }
        if(clickedItem.getQuestion().equals(Question.STUDY_CATEGORY_DIFFERENCE))
        {
            text.setText("Anwort zur Frage");
        }
        if(clickedItem.getQuestion().equals(Question.STUDY_COSTS))
        {
            text.setText("Anwort zur Frage");
        }
        if(clickedItem.getQuestion().equals(Question.STUDY_COSTS_SEMESTER))
        {
            text.setText("Anwort zur Frage");
        }
        if(clickedItem.getQuestion().equals(Question.STUDY_FAR_AWAY))
        {
            text.setText("Anwort zur Frage");
        }
        if(clickedItem.getQuestion().equals(Question.WHICH_STUDY_COURSE))
        {
            text.setText("Anwort zur Frage");
        }

        return view;
    }
}
