package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.simi.hftl_app.Listen.PersonListAdapter;
import com.simi.hftl_app.Listen.PersonListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Person;
import com.simi.hftl_app.R;

import java.util.ArrayList;

/**
 * Created by student on 11.02.2016.
 */
public class AboutUsFragment extends MyRefreshFragment
{
    public AboutUsFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.about_us_fragment, container, false);

        ListView list = (ListView) view.findViewById(R.id.about_us_list);
        ArrayList<PersonListItem> persons = new ArrayList<>();
        persons.add(new PersonListItem(getActivity().getResources().getString(R.string.stephan_name),
                Person.STEPHAN,
                getActivity().getResources().getString(R.string.stephan_description),
                getActivity().getResources().getString(R.string.stephan_mail)));
        persons.add(new PersonListItem(getActivity().getResources().getString(R.string.simion_name),
                Person.SIMION,
                getActivity().getResources().getString(R.string.simion_description),
                getActivity().getResources().getString(R.string.simion_mail)));
        persons.add(new PersonListItem(getActivity().getResources().getString(R.string.florian_name),
                Person.FLORIAN,
                getActivity().getResources().getString(R.string.florian_description),
                getActivity().getResources().getString(R.string.florian_mail)));
        PersonListAdapter adapter = new PersonListAdapter((MainActivity)getActivity(),R.layout.person_list_item,persons);
        list.setAdapter(adapter);

        return view;
    }
}