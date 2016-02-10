package com.simi.hftl_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by student on 09.02.2016.
 */
public class DualStudyFragment extends Fragment
{
    public DualStudyFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.dual_study_fragment,container,false);

        ListView list = (ListView) view.findViewById(R.id.listViewStudyDual);
        final ArrayList<StudyListItem> items = new ArrayList<>();
        items.add(new StudyListItem("Kommunikations- und Medieninformatik (Bachelor)"));
        items.add(new StudyListItem("Wirtschaftsinformatik (Bachelor)"));
        items.add(new StudyListItem("Angewandte Informatik (Bachelor)"));
        items.add(new StudyListItem("Wirtschaftsinformatik (Master)"));
        StudyListAdapter adapter = new StudyListAdapter((MainActivity) getActivity(), R.layout.study_list_item, items);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(getActivity().getApplicationContext(), items.get(position).getName(), Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
