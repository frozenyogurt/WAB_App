package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.Listen.PersonListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.R;

/**
 * Created by student on 12.02.2016.
 */
public class ImprintFragment extends Fragment
{
    public ImprintFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.imprint_hftl_fragment,container,false);

        TextView text1 = (TextView) view.findViewById(R.id.text_inprint_one);
        TextView text2 = (TextView) view.findViewById(R.id.text_inprint_two);
        TextView text3 = (TextView) view.findViewById(R.id.text_inprint_three);

        text1.setText("Friedrich-Ebert-Allee 140\n" +
                "53113 Bonn\n" +
                "\n" +
                "Sitz der Gesellschaft: Bonn\n" +
                "Amtsgericht Bonn HRB 19361\n" +
                "USt-IdNr. DE 292363279");
        text2.setText("Dr. Elke Frank\n" +
                "Dr. Oliver Lange\n" +
                "Friedrich-Ebert-Allee 140\n" +
                "53113 Bonn\n" +
                "\n" +
                "Telefon: 0228 181 - 0\n" +
                "E-Mail: pr@hft-leipzig.de");
        text3.setText("Torsten Büttner \n" +
                "Referent Öffentlichkeitsarbeit\n" +
                "Public Relations\n" +
                "Gustav-Freytag-Str. 43-45\n" +
                "04277 Leipzig \n" +
                "0341/3062 120\n" +
                "torsten.buettner@hft-leipzig.de\n" +
                "Bei Fragen zum Unternehmen, zur Hochschule und den angebotenen Studiengängen, nutzen Sie bitte unser Kontaktformular.");

        LinearLayout sendMailLeader = (LinearLayout) view.findViewById(R.id.send_mail_leader);
        LinearLayout callLeader = (LinearLayout) view.findViewById(R.id.call_leader);
        LinearLayout sendMailStaff = (LinearLayout) view.findViewById(R.id.send_mail_editorial_staff);
        LinearLayout callStaff = (LinearLayout) view.findViewById(R.id.call_editorial_staff);

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
