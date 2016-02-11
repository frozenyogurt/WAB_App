package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.simi.hftl_app.Listen.PersonListAdapter;
import com.simi.hftl_app.Listen.PersonListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Person;
import com.simi.hftl_app.R;

import java.util.ArrayList;

/**
 * Created by student on 11.02.2016.
 */
public class AboutUsFragment extends Fragment
{
    public AboutUsFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.about_us_fragment, container, false);

        ListView list = (ListView) view.findViewById(R.id.about_us_list);
        ArrayList<PersonListItem> persons = new ArrayList<>();
        persons.add(new PersonListItem("Stephan Wagener", Person.STEPHAN,
                "Ich bin Stephan und meine Aufgabe war die Kernentwicklung unserer HFTL App und aller Funktionalitäten. Außerdem fungiere ich als Ansprechpartner für alle Fragen hinsichtlich Änderungen an der App. Wer Kontakt zu mir aufnehmen möchte, erreicht mich unter folgender E-Mail Adresse: s133235@hftl.de"));
        persons.add(new PersonListItem("Björn Simion Beuran", Person.SIMION,
                "Hey lieber Studieninteressierter! Ich hoffe ich konnte dir mit dieser App ein wenig bei deiner Studiengangwahl helfen und dich für die HFTL überzeugen. Schließlich bin ich für den Inhalt, die Ideen und das Design der App zuständig. Wenn dir also noch etwas einfällt oder du noch Fragen hast, kannst du mich gerne unter folgender E-Mail erreichen: s133202@hftl.de"));
        persons.add(new PersonListItem("Florian Hollas", Person.FLORIAN,
                "Du würdest gerne einen Blick in die Dokumentation unserer App werfen? Dann kann ich dir garantiert weiterhelfen. Als Teamleiter habe ich neben allen organisatorischen Aufgaben auch die Dokumentation gepflegt und hoffe, dass sie keine Fragen offen lässt. Wenn du sie also gerne haben möchtest, oder dich allgemein für unser Projekt interessierst hast du hier die Möglichkeit: s133215@hftl.de"));
        PersonListAdapter adapter = new PersonListAdapter((MainActivity)getActivity(),R.layout.about_us_list_item,persons);
        list.setAdapter(adapter);

        return view;
    }
}