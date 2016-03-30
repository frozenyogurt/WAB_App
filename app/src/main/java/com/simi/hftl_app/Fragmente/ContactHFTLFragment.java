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
public class ContactHFTLFragment extends MyRefreshFragment
{
    public ContactHFTLFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.contact_hftl_fragment,container,false);

        TextView titleFragment = (TextView) view.findViewById(R.id.title_fragment);
        TextView hftlText = (TextView) view.findViewById(R.id.contact_hftl_text);
        TextView hftlTitle = (TextView) view.findViewById(R.id.contact_hftl_tite);
        TextView developerText = (TextView) view.findViewById(R.id.contact_developer_text);
        TextView developerTitle = (TextView) view.findViewById(R.id.contact_developer_title);
        LinearLayout sendForm = (LinearLayout) view.findViewById(R.id.send_form);
        TextView sendFormText = (TextView) view.findViewById(R.id.send_form_text);
        LinearLayout sendMail = (LinearLayout) view.findViewById(R.id.send_mail_to_developer);
        TextView sendMailText = (TextView) view.findViewById(R.id.send_mail_text);

        MainActivity activity = ((MainActivity)getActivity());
        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            titleFragment.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            developerTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            hftlTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            developerText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            hftlText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            sendFormText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
            sendMailText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            titleFragment.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            developerTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            hftlTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            developerText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            hftlText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            sendFormText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
            sendMailText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            titleFragment.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            developerTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            hftlTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            developerText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            hftlText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            sendFormText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
            sendMailText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
        }

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.underline);
        int color = ((MainActivity) getActivity()).convertColorString();
        if (color != 0)
        {
            layout.setBackgroundColor(color);
            hftlTitle.setTextColor(color);
            developerTitle.setTextColor(color);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.hftl_info_color);
            layout.setBackgroundColor(color);
            hftlTitle.setTextColor(color);
            developerTitle.setTextColor(color);
        }

        titleFragment.setText(getActivity().getResources().getString(R.string.CONTACT_TITLE));
        hftlText.setText("Kontakt hftl Text");
        hftlTitle.setText(getActivity().getResources().getString(R.string.CONTACT_HFTL_TITLE));

        developerText.setText("Kontakt Entwickler Text");
        developerTitle.setText(getActivity().getResources().getString(R.string.CONTACT_DEVELOPER_TITLE));

        sendFormText.setText(getActivity().getResources().getString(R.string.SEND_FORM));
        sendMailText.setText(getActivity().getResources().getString(R.string.SEND_MAIL));

        sendForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).goToWebsite("https://www.hft-leipzig.de/de/kontakt/kontakt.html");
            }
        });

        sendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).sendMail(new PersonListItem("Stephan Wagener", "s133235@hftl.de"));
            }
        });

        return view;
    }
}
