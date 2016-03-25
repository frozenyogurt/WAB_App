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
        ArrayList<String> points1 = new ArrayList<>();
        points1.add("Punkt 1");
        points1.add("Punkt 2");
        points1.add("Punkt 3");
        points1.add("Punkt 4");
        points1.add("Punkt 5");
        points1.add("Punkt 6");
        points1.add("Punkt 7");
        items.add(new StudyListItem((MainActivity) getActivity(), StudyCourse.IKT_BACHELOR, points1));
        ArrayList<String> points2 = new ArrayList<>();
        points2.add("Punkt 1");
        points2.add("Punkt 2");
        points2.add("Punkt 3");
        points2.add("Punkt 4");
        points2.add("Punkt 5");
        points2.add("Punkt 6");
        points2.add("Punkt 7");
        items.add(new StudyListItem((MainActivity) getActivity(), StudyCourse.KMI_BACHELOR, points2));
        ArrayList<String> points3 = new ArrayList<>();
        points3.add("Punkt 1");
        points3.add("Punkt 2");
        points3.add("Punkt 3");
        points3.add("Punkt 4");
        points3.add("Punkt 5");
        points3.add("Punkt 6");
        points3.add("Punkt 7");
        items.add(new StudyListItem((MainActivity) getActivity(), StudyCourse.WI_BACHELOR, points3));
        ArrayList<String> points4 = new ArrayList<>();
        points4.add("Punkt 1");
        points4.add("Punkt 2");
        points4.add("Punkt 3");
        points4.add("Punkt 4");
        points4.add("Punkt 5");
        points4.add("Punkt 6");
        points4.add("Punkt 7");
        items.add(new StudyListItem((MainActivity) getActivity(), StudyCourse.IKT_MASTER, points4));
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
