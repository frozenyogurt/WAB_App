package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.simi.hftl_app.Listen.FAQListAdapter;
import com.simi.hftl_app.Listen.FAQListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Question;
import com.simi.hftl_app.R;

import java.util.ArrayList;

/**
 * Created by student on 12.02.2016.
 */
public class FAQFragment extends MyRefreshFragment
{
    public FAQFragment () {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.faq_hftl_fragment,container,false);

        ListView list = (ListView) view.findViewById(R.id.faq_list);
        final ArrayList<FAQListItem> persons = new ArrayList<>();
        persons.add(new FAQListItem("Die HfTL ist eine private Hochschule. Wie hoch sind die Studiengebühren?", Question.STUDY_COSTS));
        persons.add(new FAQListItem("Wie hoch ist der Semesterbeitrag des Studentenwerkes?", Question.STUDY_COSTS_SEMESTER));
        persons.add(new FAQListItem("An der HfTL werden sowohl berufsbegleitende als auch duale Studiengänge angeboten. Wo ist der Unterschied?", Question.STUDY_CATEGORY_DIFFERENCE));
        persons.add(new FAQListItem("Woher weiß ich, ob ein Studium an der HfTL das richtige für mich ist?", Question.WHICH_STUDY_COURSE));
        persons.add(new FAQListItem("Die Studiengänge an der HfTL verfügen über eine Akkreditierung. Was bedeutet das?", Question.MEANING_ACCREDITATION));
        persons.add(new FAQListItem("Wann erfahre ich nach meiner Bewerbung, ob ich für ein Studium an der HfTL zugelassen bin?", Question.ACCEPTED));
        persons.add(new FAQListItem("Vermittelt die HfTL Wohnheimplätze?", Question.APARTMENTS));
        persons.add(new FAQListItem("Brauche ich ein Vorpraktikum, um ein Studium an der HfTL aufzunehmen?", Question.INTERNSHIP));
        persons.add(new FAQListItem("Werden mir die Studienleistungen aus einem Auslandssemester an der HfTL anerkannt?", Question.STUDY_FAR_AWAY));
        FAQListAdapter adapter = new FAQListAdapter((MainActivity)getActivity(),R.layout.faq_list_item,persons);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((MainActivity) getActivity()).setClickedFAQ(persons.get(position));
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new FAQInfoFragment(), "FAQInfoFragment");
                ft.addToBackStack(FAQInfoFragment.class.getSimpleName());
                ft.commit();
            }
        });

        return view;
    }
}
