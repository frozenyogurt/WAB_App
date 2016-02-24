package com.simi.hftl_app.Fragmente;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

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

        TextView title = (TextView) view.findViewById(R.id.employee_title);
        title.setText(getActivity().getResources().getString(R.string.EMPLOYEE_TITLE_TEXT));

        ListView list = (ListView) view.findViewById(R.id.employee_list);
        ArrayList<PersonListItem> persons = new ArrayList<>();

        persons.add(new PersonListItem(getActivity().getResources().getString(R.string.REKTOR_SAUPE_NAME),
                Person.SAUPE,
                getActivity().getResources().getString(R.string.SAUPE),
                getActivity().getResources().getString(R.string.REKTOR_SAUPE_MAIL)));
        persons.add(new PersonListItem(getActivity().getResources().getString(R.string.PROREKTOR_MUELLER_NAME),
                Person.MUELLER,
                getActivity().getResources().getString(R.string.MUELLER),
                getActivity().getResources().getString(R.string.PROREKTOR_MUELLER_MAIL)));
        persons.add(new PersonListItem(getActivity().getResources().getString(R.string.PROREKTOR_BADERSCHNEIDER_NAME),
                Person.BADERSCHNEIDER,
                getActivity().getResources().getString(R.string.BADERSCHNEIDER),
                getActivity().getResources().getString(R.string.PROREKTOR_BADERSCHNEIDER_MAIL)));

        PersonListAdapter adapter = new PersonListAdapter((MainActivity)getActivity(),R.layout.person_list_item,persons);
        list.setAdapter(adapter);

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.underline);
        int color = ((MainActivity) getActivity()).convertColorString();
        if (color != 0)
        {
            layout.setBackgroundColor(color);
            list.setDivider(new ColorDrawable(color));
            list.setDividerHeight(5);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.hftl_info_color);
            layout.setBackgroundColor(color);
            list.setDivider(new ColorDrawable(color));
            list.setDividerHeight(5);
        }

        return view;
    }
}
