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
public class ServicesLibraryFragment extends MyRefreshFragment
{
    public ServicesLibraryFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.services_library_fragment,container,false);

        TextView title = (TextView) view.findViewById(R.id.title_services_libary);
        title.setText("Bibliothek");

        TextView titleOne = (TextView) view.findViewById(R.id.title_library_one);
        TextView titleTwo = (TextView) view.findViewById(R.id.title_library_two);
        TextView titleThree = (TextView) view.findViewById(R.id.title_library_three);
        TextView textOne = (TextView) view.findViewById(R.id.text_library_one);
        TextView textTwo = (TextView) view.findViewById(R.id.text_library_two);
        TextView textThree = (TextView) view.findViewById(R.id.text_library_three);

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

        titleOne.setText("Adresse der Bibliothek der HfTL und HTWK Leipzig");
        titleTwo.setText("Öffnungszeiten");
        titleThree.setText("Ausleihe und Auskunft");
        textOne.setText("Hochschule für Technik, Wirtschaft und Kultur Leipzig \n" +
                "Hochschulbibliothek \n" +
                "Gustav-Freytag-Straße 40 \n" +
                "04277 Leipzig ");
        textTwo.setText("Die Hochschulbibliothek hat von Montag bis Freitag von 09.00 - 20.00 Uhr geöffnet. Die Öffnungszeiten am Samstag sind von 09.00 -16.00 Uhr.\n" +
                "Bücherrückgaben sind wie gewohnt auch bei geschlossener Bibliothek am Rückgabeautomaten möglich.\n" +
                "Katalogrecherche, Verlängerungsmöglichkeiten sowie das elektronische Angebot stehen weiterhin zur Verfügung.");
        textThree.setText("Telefon: +49 (0) 341 / 3076 6593 \n" +
                "Fax: +49 (0) 341 / 3076 6478");

        LinearLayout callLibrary = (LinearLayout) view.findViewById(R.id.call_library);
        TextView beginning1 = (TextView) view.findViewById(R.id.services_library_beginning_text);
        TextView beginning2 = (TextView) view.findViewById(R.id.services_library_beginning_text2);
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

        beginning1.setText("Die Hochschulbibliothek der HfTL wird gemeinsam mit der Bibliothek der Hochschule für Technik, Wirtschaft und Kultur (HTWK) Leipzig betrieben. Die Bestände bilden einen großen Querschnitt der einschlägigen Fachliteratur und liefern auch Informationen über den „Tellerrand“ hinaus. ");
        beginning2.setText("Die Bestände der Bibliothek und die Verwaltung Deines Benutzerkontos sind für Dich unter Bibliothekskatalog KaPri erreichbar. Zusätzlich halten wir viele erweiterte Funktionen bereit, so kannst Du Literaturlisten und gedruckte sowie elektronische Dokumente zusammenstellen.");

        return view;
    }
}
