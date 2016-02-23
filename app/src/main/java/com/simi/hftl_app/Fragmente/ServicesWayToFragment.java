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

        textOne.setText("Als Anfahrtsadresse für Navigationssysteme geben Sie bitte folgende Adresse in Ihr Navigationssystem ein: \n" +
                "\n" +
                "04277 Leipzig (Sachsen)\n" +
                "Gustav-Freytag-Straße 43 - 45 ");
        textTwo.setText("Ab Leipzig Hauptbahnhof können Sie mit den folgenden Straßenbahnlinien die Hochschule für Telekommunikation bequem und schnell erreichen.\n" +
                "\n" +
                "Linie 9 (Richtung Markleeberg-West)\n" +
                "\n" +
                "Linie 10 (Richtung Lößnig)\n" +
                "\n" +
                "Linie 11 (Richtung Markleeberg-Ost)\n" +
                "\n" +
                "Von der Haltestelle Connewitzer Kreuz sind es noch ca. 5 Minuten Fußweg bis zum Eingang der HfTL in der Gustav-Freytag-Straße 43 - 45.");
        titleOne.setText("Anfahrt mit dem Auto");
        titleTwo.setText("Anfahrt mit öffentlichen Verkehrsmitteln");
        beginning.setText("Im Folgenden ist eine Anfahrtsskizze zum Gelände der HfT Leipzig, eine Navigation mit dem Auto und Möglichkeiten zur Anreise mittels öffentlicher Verkehrsmittel.");

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
                ((MainActivity)getActivity()).goToWebsite("https://www.l.de/verkehrsbetriebe/");
            }
        });

        TextView title = (TextView) view.findViewById(R.id.title_services_way_to);
        title.setText("Anfahrt");
        TextView navigateText = (TextView) view.findViewById(R.id.services_way_to_navigate_text);
        navigateText.setText("Zur Hochschule");
        TextView goToDBText = (TextView) view.findViewById(R.id.services_way_to_website_db_text);
        goToDBText.setText("Deutsche Bahn");
        TextView goToLeipzigText = (TextView) view.findViewById(R.id.services_way_to_website_leipzig_text);
        goToLeipzigText.setText("Leipziger Verkehrsbetriebe");

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
