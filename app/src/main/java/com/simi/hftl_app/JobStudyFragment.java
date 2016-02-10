package com.simi.hftl_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by student on 09.02.2016.
 */
public class JobStudyFragment extends Fragment
{
    public JobStudyFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.job_study_fragment,container,false);

        ListView list = (ListView) view.findViewById(R.id.listViewStudyJob);
        final ArrayList<StudyListItem> items = new ArrayList<>();
        items.add(new StudyListItem("Informations- und Kommunikationstechnik (Bachelor)", StudyCourse.JOB_IKT_BACHELOR));
        items.add(new StudyListItem("Kommunikations- und Medieninformatik (Bachelor)", StudyCourse.JOB_KMI_BACHELOR));
        items.add(new StudyListItem("Wirtschaftsinformatik (Bachelor)", StudyCourse.JOB_WI_BACHELOR));
        items.add(new StudyListItem("Informations - und Kommunikationstechnik (Master)", StudyCourse.JOB_IKT_MASTER));
        items.add(new StudyListItem("Wirtschaftsinformatik (Master)", StudyCourse.JOB_WI_MASTER));
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
                ft.add(R.id.activityLayout, new StudyInfoFragment());
                ft.addToBackStack(StudyInfoFragment.class.getSimpleName());
                ft.commit();
            }
        });

        return view;
    }
}
