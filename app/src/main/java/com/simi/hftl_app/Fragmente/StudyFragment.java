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

import com.simi.hftl_app.Listen.StudyListAdapter;
import com.simi.hftl_app.Listen.StudyListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.StudyCourse;
import com.simi.hftl_app.R;

import java.util.ArrayList;

/**
 * Created by student on 09.02.2016.
 */
public class StudyFragment extends MyRefreshFragment
{
    public StudyFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.study_fragment,container,false);

        ListView list = (ListView) view.findViewById(R.id.listViewStudy);
        final ArrayList<StudyListItem> items = new ArrayList<>();
        items.add(new StudyListItem("Informations- und Kommunikationstechnik (Bachelor)", StudyCourse.IKT_BACHELOR));
        items.add(new StudyListItem("Kommunikations- und Medieninformatik (Bachelor)", StudyCourse.KMI_BACHELOR));
        items.add(new StudyListItem("Wirtschaftsinformatik (Bachelor)", StudyCourse.WI_BACHELOR));
        items.add(new StudyListItem("Informations- und Kommunikationstechnik (Master)", StudyCourse.IKT_MASTER));
        items.add(new StudyListItem("Master Information and Communication Technology (Master - english)", StudyCourse.ICT_MASTER));
        StudyListAdapter adapter = new StudyListAdapter((MainActivity) getActivity(), R.layout.study_list_item, items);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ((MainActivity)getActivity()).setClickedElement(items.get(position));
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new StudyInfoFragment(), "StudyInfoFragment");
                ft.addToBackStack(StudyInfoFragment.class.getSimpleName());
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
            color = getActivity().getResources().getColor(R.color.study_color);
            list.setDivider(new ColorDrawable(color));
            list.setDividerHeight(5);
        }

        return view;
    }
}
