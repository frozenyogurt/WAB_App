package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.R;

/**
 * Created by student on 09.02.2016.
 */
public class ServicesWayToFragment extends MyRefreshFragment
{
    public ServicesWayToFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.services_way_to_fragment,container,false);

        TextView titleOne = (TextView) view.findViewById(R.id.services_way_to_title_one);
        TextView titleTwo = (TextView) view.findViewById(R.id.services_way_to_title_two);
        TextView textOne = (TextView) view.findViewById(R.id.services_way_to_text_one);
        TextView textTwo = (TextView) view.findViewById(R.id.services_way_to_text_two);
        TextView beginning = (TextView) view.findViewById(R.id.services_way_to_beginning_text);

        textOne.setText(getActivity().getResources().getString(R.string.SERVICES_WAY_TO_TEXT_ONE));
        textTwo.setText(getActivity().getResources().getString(R.string.SERVICES_WAY_TO_TEXT_TWO));
        titleOne.setText(getActivity().getResources().getString(R.string.SERVICES_WAY_TO_TITLE_ONE));
        titleTwo.setText(getActivity().getResources().getString(R.string.SERVICES_WAY_TO_TITLE_TWO));
        beginning.setText(getActivity().getResources().getString(R.string.SERVICES_WAY_TO_BEGINNING));

        LinearLayout navigate = (LinearLayout) view.findViewById(R.id.services_way_to_navigate);
        LinearLayout goToDB = (LinearLayout) view.findViewById(R.id.services_way_to_website_db);
        LinearLayout goToLeipzig = (LinearLayout) view.findViewById(R.id.services_way_to_website_leipzig);

        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).navigateToHFTL();
            }
        });

        goToDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).goToWebsite("http://www.bahn.de/p/view/index.shtml");
            }
        });

        goToLeipzig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).goToWebsite("https://www.l.de/verkehrsbetriebe/");
            }
        });

        TextView title = (TextView) view.findViewById(R.id.title_services_way_to);
        title.setText(getActivity().getResources().getString(R.string.SERVICES_WAY_TO_TITLE));
        TextView navigateText = (TextView) view.findViewById(R.id.services_way_to_navigate_text);
        navigateText.setText(getActivity().getResources().getString(R.string.SERVICES_WAY_TO_NAVIGATE));
        TextView goToDBText = (TextView) view.findViewById(R.id.services_way_to_website_db_text);
        goToDBText.setText(getActivity().getResources().getString(R.string.SERVICES_WAY_TO_DB));
        TextView goToLeipzigText = (TextView) view.findViewById(R.id.services_way_to_website_leipzig_text);
        goToLeipzigText.setText(getActivity().getResources().getString(R.string.SERVICES_WAY_TO_LEIPZIG));

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.underline);
        int color = ((MainActivity) getActivity()).convertColorString();
        if (color != 0)
        {
            layout.setBackgroundColor(color);
            titleOne.setTextColor(color);
            titleTwo.setTextColor(color);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.hftl_info_color);
            layout.setBackgroundColor(color);
            titleOne.setTextColor(color);
            titleTwo.setTextColor(color);
        }

        return view;
    }
}
