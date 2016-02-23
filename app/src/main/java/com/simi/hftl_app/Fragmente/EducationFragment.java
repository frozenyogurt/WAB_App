package com.simi.hftl_app.Fragmente;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.simi.hftl_app.Listen.EducationListAdapter;
import com.simi.hftl_app.Listen.EducationListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Education;
import com.simi.hftl_app.R;

import java.util.ArrayList;

/**
 * Created by student on 11.02.2016.
 */
public class EducationFragment extends MyRefreshFragment
{
    public EducationFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.education_fragment,container,false);

        ListView list = (ListView) view.findViewById(R.id.listViewEducation);
        final ArrayList<EducationListItem> items = new ArrayList<>();
        items.add(new EducationListItem("TOEIC", Education.TOEIC));
        items.add(new EducationListItem("Business English Cambridge (BEC)", Education.BEC));
        items.add(new EducationListItem("Cambridge Advanced English (CAE)", Education.CAE));
        items.add(new EducationListItem("Intercultural Training", Education.IT));
        items.add(new EducationListItem("Intensivkurs Deutsch", Education.ID));
        EducationListAdapter adapter = new EducationListAdapter((MainActivity) getActivity(), R.layout.study_list_item, items);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ((MainActivity)getActivity()).setClickedEductaion(items.get(position));
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new EducationInfoFragment(), "EducationInfoFragment");
                ft.addToBackStack(EducationInfoFragment.class.getSimpleName());
                ft.commit();
            }
        });

        int color = ((MainActivity) getActivity()).convertColorString();
        if (color != 0)
        {
            list.setDivider(new ColorDrawable(color));
            list.setDividerHeight(5);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.education_color);
            list.setDivider(new ColorDrawable(color));
            list.setDividerHeight(5);
        }

        return view;
    }}
