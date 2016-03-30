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
public class ServicesLibraryFragment extends MyRefreshFragment
{
    public ServicesLibraryFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.services_library_fragment,container,false);

        TextView title = (TextView) view.findViewById(R.id.title_services_libary);
        title.setText(getActivity().getResources().getString(R.string.SERVICES_LIBRARY_TITLE));

        TextView titleOne = (TextView) view.findViewById(R.id.title_library_one);
        TextView titleTwo = (TextView) view.findViewById(R.id.title_library_two);
        TextView titleThree = (TextView) view.findViewById(R.id.title_library_three);
        TextView textOne = (TextView) view.findViewById(R.id.text_library_one);
        TextView textTwo = (TextView) view.findViewById(R.id.text_library_two);
        TextView textThree = (TextView) view.findViewById(R.id.text_library_three);
        TextView beginning1 = (TextView) view.findViewById(R.id.services_library_beginning_text);
        TextView beginning2 = (TextView) view.findViewById(R.id.services_library_beginning_text2);

        MainActivity activity = ((MainActivity)getActivity());
        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            titleOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            titleTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            titleThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            textOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            textTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            textThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            beginning1.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            beginning2.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            titleOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            titleTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            titleThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            textOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            textTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            textThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            beginning1.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            beginning2.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            titleOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            titleTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            titleThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            textOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            textTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            textThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            beginning1.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            beginning2.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
        }

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.underline);
        int color = ((MainActivity) getActivity()).convertColorString();
        if (color != 0)
        {
            layout.setBackgroundColor(color);
            titleOne.setTextColor(color);
            titleTwo.setTextColor(color);
            titleThree.setTextColor(color);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.hftl_info_color);
            layout.setBackgroundColor(color);
            titleOne.setTextColor(color);
            titleTwo.setTextColor(color);
            titleThree.setTextColor(color);
        }

        titleOne.setText(getActivity().getResources().getString(R.string.SERVICES_LIBRARY_TITLE_ONE));
        titleTwo.setText(getActivity().getResources().getString(R.string.SERVICES_LIBRARY_TITLE_TWO));
        titleThree.setText(getActivity().getResources().getString(R.string.SERVICES_LIBRARY_TITLE_THREE));
        textOne.setText(getActivity().getResources().getString(R.string.SERVICES_LIBRARY_TEXT_ONE));
        textTwo.setText(getActivity().getResources().getString(R.string.SERVICES_LIBRARY_TEXT_TWO));
        textThree.setText(getActivity().getResources().getString(R.string.SERVICES_LIBRARY_TEXT_THREE));

        LinearLayout callLibrary = (LinearLayout) view.findViewById(R.id.call_library);
        LinearLayout goToLibraryWebsite = (LinearLayout) view.findViewById(R.id.services_library_website);
        LinearLayout goToLibraryInventoryWebsite = (LinearLayout) view.findViewById(R.id.services_library_inventory_website);

        callLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).callPerson("034130766593");
            }
        });

        goToLibraryWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).goToWebsite("http://www.htwk-leipzig.de/de/biblio/");
            }
        });

        goToLibraryInventoryWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).goToWebsite("http://kapri.htwk-leipzig.de/primo_library/libweb/action/search.do?vid=49LEIPHTWK_VU1");
            }
        });

        beginning1.setText(getActivity().getResources().getString(R.string.SERVICES_LIBRARY_BEGINNING_ONE));
        beginning2.setText(getActivity().getResources().getString(R.string.SERVICES_LIBRARY_BEGINNING_TWO));
        return view;
    }
}
