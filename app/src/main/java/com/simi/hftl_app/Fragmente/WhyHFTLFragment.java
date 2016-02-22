package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simi.hftl_app.R;

/**
 * Created by student on 12.02.2016.
 */
public class WhyHFTLFragment extends MyRefreshFragment
{
    public WhyHFTLFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.why_hftl_fragment,container,false);

        TextView beginningText = (TextView) view.findViewById(R.id.why_hftl_text);
        TextView titleFragment = (TextView) view.findViewById(R.id.title_fragment);
        TextView titleOne = (TextView) view.findViewById(R.id.title_why_one);
        TextView titleTwo = (TextView) view.findViewById(R.id.title_why_two);
        TextView titleThree = (TextView) view.findViewById(R.id.title_why_three);
        TextView titleFour = (TextView) view.findViewById(R.id.title_why_four);
        TextView titleFive = (TextView) view.findViewById(R.id.title_why_five);
        TextView titleSix = (TextView) view.findViewById(R.id.title_why_six);
        TextView titleSeven = (TextView) view.findViewById(R.id.title_why_seven);

        TextView textOne = (TextView) view.findViewById(R.id.text_why_one);
        TextView textTwo = (TextView) view.findViewById(R.id.text_why_two);
        TextView textThree = (TextView) view.findViewById(R.id.text_why_three);
        TextView textFour = (TextView) view.findViewById(R.id.text_why_four);
        TextView textFive = (TextView) view.findViewById(R.id.text_why_five);
        TextView textSix = (TextView) view.findViewById(R.id.text_why_six);
        TextView textSeven = (TextView) view.findViewById(R.id.text_why_seven);

        beginningText.setText(getActivity().getResources().getString(R.string.why_hftl_text));
        titleFragment.setText("Warum HfTL?");
        titleOne.setText("Titel 1");
        titleTwo.setText("Titel 2");
        titleThree.setText("Titel 3");
        titleFour.setText("Titel 4");
        titleFive.setText("Titel 5");
        titleSix.setText("Titel 6");
        titleSeven.setText("Titel 7");

        textOne.setText("Text 1");
        textTwo.setText("Text 2");
        textThree.setText("Text 3");
        textFour.setText("Text 4");
        textFive.setText("Text 5");
        textSix.setText("Text 6");
        textSeven.setText("Text 7");

        return view;
    }
}
