package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.Listen.PersonListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.TextSize;
import com.simi.hftl_app.R;

/**
 * Created by student on 12.02.2016.
 */
public class ImprintFragment extends MyRefreshFragment
{
    public ImprintFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.imprint_hftl_fragment,container,false);

        TextView title = (TextView) view.findViewById(R.id.title_fragment_imprint);
        title.setText(getActivity().getResources().getString(R.string.IMPRINT_TITLE));
        TextView text1 = (TextView) view.findViewById(R.id.text_inprint_one);
        TextView text2 = (TextView) view.findViewById(R.id.text_inprint_two);
        TextView text3 = (TextView) view.findViewById(R.id.text_inprint_three);
        TextView titleOne = (TextView) view.findViewById(R.id.title_inprint_one);
        titleOne.setText(getActivity().getResources().getString(R.string.IMPRINT_TITLE_ONE));
        TextView titleTwo = (TextView) view.findViewById(R.id.title_inprint_two);
        titleTwo.setText(getActivity().getResources().getString(R.string.IMPRINT_TITLE_TWO));
        TextView titleThree = (TextView) view.findViewById(R.id.title_inprint_three);
        titleThree.setText(getActivity().getResources().getString(R.string.IMPRINT_TITLE_THREE));

        MainActivity activity = ((MainActivity)getActivity());
        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            titleOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            titleTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            titleThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            text1.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            text2.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
            text3.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            titleOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            titleTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            titleThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            text1.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            text2.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
            text3.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            titleOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            titleTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            titleThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            text1.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            text2.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
            text3.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
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

        text1.setText(getActivity().getResources().getString(R.string.IMPRINT_TEXT_ONE));
        text2.setText(getActivity().getResources().getString(R.string.IMPRINT_TEXT_TWO));
        text3.setText(getActivity().getResources().getString(R.string.IMPRINT_TEXT_THREE));

        LinearLayout sendMailLeader = (LinearLayout) view.findViewById(R.id.send_mail_leader);
        LinearLayout callLeader = (LinearLayout) view.findViewById(R.id.call_leader);
        LinearLayout sendMailStaff = (LinearLayout) view.findViewById(R.id.send_mail_editorial_staff);
        LinearLayout callStaff = (LinearLayout) view.findViewById(R.id.call_editorial_staff);

        TextView sendMailLeaderText = (TextView) view.findViewById(R.id.send_mail_leader_text);
        sendMailLeaderText.setText(getActivity().getResources().getString(R.string.SEND_MAIL));
        TextView callLeaderText = (TextView) view.findViewById(R.id.call_leader_text);
        callLeaderText.setText(getActivity().getResources().getString(R.string.CALL_TEXT));
        TextView sendMailStaffText = (TextView) view.findViewById(R.id.send_mail_editorial_staff_text);
        sendMailStaffText.setText(getActivity().getResources().getString(R.string.SEND_MAIL));
        TextView callStaffText = (TextView) view.findViewById(R.id.call_editorial_staff_text);
        callStaffText.setText(getActivity().getResources().getString(R.string.CALL_TEXT));

        sendMailLeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).sendMail(new PersonListItem("Dr. Oliver Lange", "pr@hft-leipzig.de"));
            }
        });

        sendMailStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).sendMail(new PersonListItem("Torsten Büttner", "torsten.buettner@hft-leipzig.de"));
            }
        });

        callLeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).callPerson("02281810");
            }
        });

        callStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).callPerson("03413062120");
            }
        });

        return view;
    }
}
