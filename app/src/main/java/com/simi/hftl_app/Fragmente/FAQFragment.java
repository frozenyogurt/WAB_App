package com.simi.hftl_app.Fragmente;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.Listen.ExpandableFAQListAdapter;
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
    private ArrayList<Boolean> rotations = new ArrayList<>();

    public FAQFragment () {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.faq_hftl_fragment,container,false);

        TextView title = (TextView) view.findViewById(R.id.faq_fragment_title);
        title.setText(getActivity().getResources().getString(R.string.FAQ_TITLE));

        ExpandableListView list = (ExpandableListView) view.findViewById(R.id.faq_list);
        final ArrayList<FAQListItem> persons = new ArrayList<>();
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_STUDY_COSTS), QuestionType.STUDY_COSTS, (MainActivity) getActivity()));
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_STUDY_COSTS_SEMESTER), QuestionType.STUDY_COSTS_SEMESTER, (MainActivity) getActivity()));
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_STUDY_CATEGORY_DIFFERENCE), QuestionType.STUDY_CATEGORY_DIFFERENCE, (MainActivity) getActivity()));
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_WHICH_STUDY_COURSE), QuestionType.WHICH_STUDY_COURSE, (MainActivity) getActivity()));
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_MEANING_ACCREDITATION), QuestionType.MEANING_ACCREDITATION, (MainActivity) getActivity()));
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_ACCEPTED), QuestionType.ACCEPTED, (MainActivity) getActivity()));
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_APARTMENTS), QuestionType.APARTMENTS, (MainActivity) getActivity()));
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_INTERNSHIP), QuestionType.INTERNSHIP, (MainActivity) getActivity()));
        persons.add(new FAQListItem(getActivity().getResources().getString(R.string.QUESTION_STUDY_FAR_AWAY), QuestionType.STUDY_FAR_AWAY, (MainActivity) getActivity()));
        final ExpandableFAQListAdapter adapter = new ExpandableFAQListAdapter((MainActivity) getActivity(),persons);
        list.setAdapter(adapter);

        for (int i = 0; i < persons.size(); i++)
        {
            rotations.add(false);
        }

        list.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
        {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id)
            {
                ImageView arrow = (ImageView) v.findViewById(R.id.item_arrow);
                if (rotations.get(groupPosition)) {
                    rotations.set(groupPosition, false);
                    arrow.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_back));
                } else {
                    rotations.set(groupPosition, true);
                    arrow.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_up));
                }
                return false;
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
