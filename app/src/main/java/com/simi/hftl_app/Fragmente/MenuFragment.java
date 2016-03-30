package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.simi.hftl_app.Listen.OptionListAdapter;
import com.simi.hftl_app.Listen.OptionListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Option;
import com.simi.hftl_app.Model.TextSize;
import com.simi.hftl_app.R;

import java.util.ArrayList;

/**
 * Created by student on 10.02.2016.
 */
public class MenuFragment extends MyRefreshFragment
{
    public MenuFragment () {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.study_menu,container,false);

        final ArrayList<OptionListItem> items = new ArrayList<>();
        items.add(new OptionListItem(getActivity().getResources().getString(R.string.MENU_SETTINGS_NAME), Option.SETTINGS));
        items.add(new OptionListItem(getActivity().getResources().getString(R.string.MENU_WEBSITE_NAME), Option.WEBSITE));
        items.add(new OptionListItem(getActivity().getResources().getString(R.string.MENU_ABOUT_US_NAME), Option.ABOUTUS));
        items.add(new OptionListItem(getActivity().getResources().getString(R.string.MENU_EXIT_NAME), Option.EXIT));

        TextView titleFragemnt = (TextView) view.findViewById(R.id.titleOptions);
        titleFragemnt.setText("Optionen");
        MainActivity activity = ((MainActivity)getActivity());
        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            titleFragemnt.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            titleFragemnt.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            titleFragemnt.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
        }

        ListView list = (ListView) view.findViewById(R.id.options_list);
        OptionListAdapter adapter = new OptionListAdapter((MainActivity)getActivity(), R.layout.option_list_item, items);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (items.get(position).getOption().equals(Option.EXIT)) {
                    getActivity().finish();
                } else if (items.get(position).getOption().equals(Option.WEBSITE)) {
                    ((MainActivity)getActivity()).goToWebsite("http://www.hftl.de");
                } else if (items.get(position).getOption().equals(Option.ABOUTUS)) {
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                    ft.add(R.id.activityLayout, new AboutUsFragment(), "AboutUsFragment");
                    ft.addToBackStack(AboutUsFragment.class.getSimpleName());
                    ft.commit();
                } else {
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                    ft.add(R.id.activityLayout, new SettingsFragment(), "SettingsFragment");
                    ft.addToBackStack(SettingsFragment.class.getSimpleName());
                    ft.commit();
                }
            }
        });

        RelativeLayout tabToClose = (RelativeLayout) view.findViewById(R.id.menu_container);
        tabToClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).handleMenuClick();
            }
        });

        return view;
    }
}
