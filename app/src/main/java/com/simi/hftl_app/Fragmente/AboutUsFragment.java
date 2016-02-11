package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
public class AboutUsFragment extends Fragment
{
    public AboutUsFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.about_us_fragment, container, false);

        ListView list = (ListView) view.findViewById(R.id.about_us_list);
        ArrayList<PersonListItem> persons = new ArrayList<>();
        persons.add(new PersonListItem("Stephan Wagener", Person.STEPHAN,
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."));
        persons.add(new PersonListItem("Simion Björn Beuran", Person.SIMION,
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."));
        persons.add(new PersonListItem("Florian Hollas", Person.FLORIAN,
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."));
        PersonListAdapter adapter = new PersonListAdapter((MainActivity)getActivity(),R.layout.about_us_list_item,persons);
        list.setAdapter(adapter);

        return view;
    }
}
