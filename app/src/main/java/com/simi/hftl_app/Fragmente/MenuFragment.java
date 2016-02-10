package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.simi.hftl_app.Listen.OptionListAdapter;
import com.simi.hftl_app.Listen.OptionListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Option;
import com.simi.hftl_app.R;

import java.util.ArrayList;

/**
 * Created by student on 10.02.2016.
 */
public class MenuFragment extends Fragment
{
    public MenuFragment () {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.study_menu,container,false);

        final ArrayList<OptionListItem> items = new ArrayList<>();
        items.add(new OptionListItem("Über uns", Option.ABOUTUS));
        items.add(new OptionListItem("Einstellunegn", Option.SETTINGS));
        items.add(new OptionListItem("Zur Webseite", Option.WEBSITE));
        items.add(new OptionListItem("Beenden", Option.EXIT));

        ListView list = (ListView) view.findViewById(R.id.options_list);
        OptionListAdapter adapter = new OptionListAdapter((MainActivity)getActivity(), R.layout.option_list_item, items);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (items.get(position).getOption().equals(Option.EXIT)) {
                    getActivity().finish();
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), items.get(position).getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
