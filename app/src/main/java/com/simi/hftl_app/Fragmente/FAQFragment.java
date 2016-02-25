package com.simi.hftl_app.Fragmente;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.simi.hftl_app.Listen.FAQListAdapter;
import com.simi.hftl_app.Listen.FAQListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.QuestionType;
import com.simi.hftl_app.R;

import java.util.ArrayList;

/**
 * Created by student on 12.02.2016.
 */
public class FAQFragment extends MyRefreshFragment
{
    public FAQFragment () {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.faq_hftl_fragment,container,false);

        TextView title = (TextView) view.findViewById(R.id.faq_fragment_title);
        title.setText(getActivity().getResources().getString(R.string.FAQ_TITLE));

        ListView list = (ListView) view.findViewById(R.id.faq_list);
        final ArrayList<FAQListItem> persons = new ArrayList<>();
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_STUDY_COSTS), QuestionType.STUDY_COSTS));
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_STUDY_COSTS_SEMESTER), QuestionType.STUDY_COSTS_SEMESTER));
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_STUDY_CATEGORY_DIFFERENCE), QuestionType.STUDY_CATEGORY_DIFFERENCE));
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_WHICH_STUDY_COURSE), QuestionType.WHICH_STUDY_COURSE));
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_MEANING_ACCREDITATION), QuestionType.MEANING_ACCREDITATION));
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_ACCEPTED), QuestionType.ACCEPTED));
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_APARTMENTS), QuestionType.APARTMENTS));
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_INTERNSHIP), QuestionType.INTERNSHIP));
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_STUDY_FAR_AWAY), QuestionType.STUDY_FAR_AWAY));
        FAQListAdapter adapter = new FAQListAdapter((MainActivity)getActivity(),R.layout.faq_list_item,persons);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((MainActivity) getActivity()).setClickedFAQ(persons.get(position));
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new FAQInfoFragment(), "FAQInfoFragment");
                ft.addToBackStack(FAQInfoFragment.class.getSimpleName());
                ft.commit();
            }
        });

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.underline);
        int color = ((MainActivity) getActivity()).convertColorString();
        if (color != 0)
        {
            layout.setBackgroundColor(color);
            list.setDivider(new ColorDrawable(color));
            list.setDividerHeight(5);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.hftl_info_color);
            layout.setBackgroundColor(color);
            list.setDivider(new ColorDrawable(color));
            list.setDividerHeight(5);
        }

        return view;
    }
}
