package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.TextSize;
import com.simi.hftl_app.R;

/**
 * Created by student on 09.02.2016.
 */
public class ServicesSportFragment extends MyRefreshFragment
{
    public ServicesSportFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.services_sport_fragment,container,false);

        TextView beginning = (TextView) view.findViewById(R.id.services_sport_beginning_text);
        TextView titleOne = (TextView) view.findViewById(R.id.services_sport_title_one);
        TextView titleTwo = (TextView) view.findViewById(R.id.services_sport_title_two);
        TextView titleThree = (TextView) view.findViewById(R.id.services_sport_title_three);
        TextView titleFour = (TextView) view.findViewById(R.id.services_sport_title_four);
        TextView textOne = (TextView) view.findViewById(R.id.services_sport_text_one);
        TextView textTwo = (TextView) view.findViewById(R.id.services_sport_text_two);
        TextView textThree = (TextView) view.findViewById(R.id.services_sport_text_three);
        TextView textFour = (TextView) view.findViewById(R.id.services_sport_text_four);
        LinearLayout goToSportWebsite = (LinearLayout) view.findViewById(R.id.services_sport_website);

        TextView title = (TextView) view.findViewById(R.id.title_services_sport);
        title.setText(getActivity().getResources().getString(R.string.SERVICES_SPORT_TITLE));
        TextView websiteText = (TextView) view.findViewById(R.id.services_sport_website_text);
        websiteText.setText(getActivity().getResources().getString(R.string.SERVICES_SPORT_WEBSITE));

        MainActivity activity = ((MainActivity)getActivity());
        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            titleOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            titleTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            titleThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            titleFour.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            textOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            textTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            textThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            textFour.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            websiteText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            beginning.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            titleOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            titleTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            titleThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            titleFour.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            textOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            textTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            textThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            websiteText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            beginning.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            textFour.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            titleOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            titleTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            titleThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            titleFour.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            textOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            textTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            textThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            textFour.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            beginning.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            websiteText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
        }

        goToSportWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).goToWebsite("http://sport.htwk-leipzig.de/");
            }
        });

        beginning.setText(getActivity().getResources().getString(R.string.SERVICES_SPORT_BEGINNING));
        titleOne.setText(getActivity().getResources().getString(R.string.SERVICES_SPORT_TITLE_ONE));
        titleTwo.setText(getActivity().getResources().getString(R.string.SERVICES_SPORT_TITLE_TWO));
        titleThree.setText(getActivity().getResources().getString(R.string.SERVICES_SPORT_TITLE_THREE));
        titleFour.setText(getActivity().getResources().getString(R.string.SERVICES_SPORT_TITLE_FOUR));

        textOne.setText(getActivity().getResources().getString(R.string.SERVICES_SPORT_TEXT_ONE));
        textTwo.setText(getActivity().getResources().getString(R.string.SERVICES_SPORT_TEXT_TWO));
        textThree.setText(getActivity().getResources().getString(R.string.SERVICES_SPORT_TEXT_THREE));
        textFour.setText(getActivity().getResources().getString(R.string.SERVICES_SPORT_TEXT_FOUR));

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.underline);
        int color = ((MainActivity) getActivity()).convertColorString();
        if (color != 0)
        {
            layout.setBackgroundColor(color);
            titleOne.setTextColor(color);
            titleTwo.setTextColor(color);
            titleThree.setTextColor(color);
            titleFour.setTextColor(color);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.hftl_info_color);
            layout.setBackgroundColor(color);
            titleOne.setTextColor(color);
            titleTwo.setTextColor(color);
            titleThree.setTextColor(color);
            titleFour.setTextColor(color);
        }

        return view;
    }
}
