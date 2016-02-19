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
 * Created by student on 12.02.2016.
 */
public class EmployeeHFTLFragment extends MyRefreshFragment
{
    public EmployeeHFTLFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.employee_hftl_fragment,container,false);

        ListView list = (ListView) view.findViewById(R.id.employee_list);
        ArrayList<PersonListItem> persons = new ArrayList<>();

        persons.add(new PersonListItem("Rektor: Prof. Dr.-Ing. habil. Volker Saupe", Person.SAUPE,
                (getActivity().getResources().getString(R.string.SAUPE)),
                "saupe@hft-leipzig.de"));
        persons.add(new PersonListItem("Prorektor: Prof. Dr. Jean-Alexander Müller", Person.MUELLER,
                (getActivity().getResources().getString(R.string.MUELLER)),
                "mueller01@hft-leipzig.de"));
        persons.add(new PersonListItem("Prorektor: Prof. Dr. Claus Baderschneider", Person.BADERSCHNEIDER,
                (getActivity().getResources().getString(R.string.BADERSCHNEIDER)),
                "claus.baderschneider@hft-leipzig.de"));


        PersonListAdapter adapter = new PersonListAdapter((MainActivity)getActivity(),R.layout.person_list_item,persons);
        list.setAdapter(adapter);

        return view;
    }
}
