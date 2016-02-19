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

        persons.add(new PersonListItem("Prorektor: Prof. Dr. Jean-Alexander Müller", Person.MUELLER,
                (getActivity().getResources().getString(R.string.MUELLER)),
                "mueller01@hft-leipzig.de"));
        persons.add(new PersonListItem("Florian Hollas", Person.FLORIAN,
                "Du würdest gerne einen Blick in die Dokumentation unserer App werfen? Dann kann ich dir garantiert weiterhelfen. Als Teamleiter habe ich neben allen organisatorischen Aufgaben auch die Dokumentation gepflegt und hoffe, dass sie keine Fragen offen lässt. Wenn du sie also gerne haben möchtest, oder dich allgemein für unser Projekt interessierst hast du hier die Möglichkeit: s133215@hftl.de",
                "s133215@hftl.de"));
        persons.add(new PersonListItem("Florian Hollas", Person.FLORIAN,
                "Du würdest gerne einen Blick in die Dokumentation unserer App werfen? Dann kann ich dir garantiert weiterhelfen. Als Teamleiter habe ich neben allen organisatorischen Aufgaben auch die Dokumentation gepflegt und hoffe, dass sie keine Fragen offen lässt. Wenn du sie also gerne haben möchtest, oder dich allgemein für unser Projekt interessierst hast du hier die Möglichkeit: s133215@hftl.de",
                "s133215@hftl.de"));


        PersonListAdapter adapter = new PersonListAdapter((MainActivity)getActivity(),R.layout.person_list_item,persons);
        list.setAdapter(adapter);

        return view;
    }
}
