package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.simi.hftl_app.Listen.PersonListAdapter;
import com.simi.hftl_app.Listen.PersonListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Person;
import com.simi.hftl_app.Model.TextSize;
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

        TextView title = (TextView) view.findViewById(R.id.title_about_us);
        title.setText("Unser Team");
        MainActivity activity = ((MainActivity)getActivity());
        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
        }

        ListView list = (ListView) view.findViewById(R.id.about_us_list);
        ArrayList<PersonListItem> persons = new ArrayList<>();
        persons.add(new PersonListItem(getActivity().getResources().getString(R.string.STEPHAN_NAME),
                Person.STEPHAN,
                getActivity().getResources().getString(R.string.STEPHAN_DESCRIPTION),
                getActivity().getResources().getString(R.string.STEPHAN_MAIL)));
        persons.add(new PersonListItem(getActivity().getResources().getString(R.string.SIMION_NAME),
                Person.SIMION,
                getActivity().getResources().getString(R.string.SIMION_DESCRIPTION),
                getActivity().getResources().getString(R.string.SIMION_MAIL)));
        persons.add(new PersonListItem(getActivity().getResources().getString(R.string.FLORIAN_NAME),
                Person.FLORIAN,
                getActivity().getResources().getString(R.string.FLORIAN_DESCRIPTION),
                getActivity().getResources().getString(R.string.FLORIAN_MAIL)));
        PersonListAdapter adapter = new PersonListAdapter((MainActivity)getActivity(),R.layout.person_list_item,persons);
        list.setAdapter(adapter);

        return view;
    }
}