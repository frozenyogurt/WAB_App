package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.R;

/**
 * Created by student on 11.02.2016.
 */
public class SettingsFragment extends MyRefreshFragment
{
    public SettingsFragment () {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.settings_fragment,container,false);

        Button save = (Button) view.findViewById(R.id.button_save);
        save.setText("Speichern");
        Button reset = (Button) view.findViewById(R.id.button_reset);
        reset.setText("Zurücksetzen");
        final EditText hex_value = (EditText) view.findViewById(R.id.hex_value);
        hex_value.setHint("hexadezimalen Wert eingeben");
        final CheckBox german = (CheckBox) view.findViewById(R.id.language_german);
        german.setText("Deutsch");
        final CheckBox english = (CheckBox) view.findViewById(R.id.language_english);
        english.setText("Englisch");
        TextView titleChangeLanguage = (TextView) view.findViewById(R.id.titleChangeLanguage);
        titleChangeLanguage.setText("Sprache");
        TextView titleChangeDesign = (TextView) view.findViewById(R.id.titleChangeColor);
        titleChangeDesign.setText("Farbdesign");
        TextView textInfo = (TextView) view.findViewById(R.id.changeColorInfoText);
        textInfo.setText("Der hier eingegebene Wert wird auf alle Farben angewandt, die nicht Magenta sind. Er muss das Format #RRGGBB oder #AARRGGBB haben.");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = ((MainActivity)getActivity());
                if (!hex_value.getText().toString().equals(""))
                {
                    activity.setColor(hex_value.getText().toString());
                    if (activity.convertColorString() != 0)
                    {
                        activity.refreshFragments();
                        Toast.makeText(getActivity().getApplicationContext(), "Ihr Wert " + hex_value.getText().toString() + " wurde erfolgreich gespeichert.", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "Ihr Wert war ungültig!", Toast.LENGTH_LONG).show();
                    }
                }
                if (german.isChecked())
                {
                    if (((MainActivity)getActivity()).getLanguage().equals("en"))
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "Die Sprache wurde auf Deutsch geändert.", Toast.LENGTH_LONG).show();
                        ((MainActivity)getActivity()).refreshFragments();
                    }
                    activity.setLocale("de");
                }
                else
                {
                    if (((MainActivity)getActivity()).getLanguage().equals("de"))
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "Die Sprache wurde auf Englisch geändert.", Toast.LENGTH_LONG).show();
                        ((MainActivity)getActivity()).refreshFragments();
                    }
                    activity.setLocale("en");
                }

                hex_value.setText("");
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ((MainActivity)getActivity()).setColor(null);
                ((MainActivity)getActivity()).refreshFragments();
                german.setChecked(true);
                english.setChecked(false);
                hex_value.setText("");
                ((MainActivity)getActivity()).setLocale("de");
                Toast.makeText(getActivity().getApplicationContext(), "Alle Werte wurden erfolgreich zurückgesetzt.", Toast.LENGTH_LONG).show();
            }
        });

        german.setChecked(((MainActivity) getActivity()).getLanguage().equals("de"));
        german.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (english.isChecked()) {
                    english.setChecked(false);
                }
                if (!german.isChecked()) {
                    english.setChecked(true);
                }
            }
        });

        english.setChecked(((MainActivity) getActivity()).getLanguage().equals("en"));
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (german.isChecked())
                {
                    german.setChecked(false);
                }
                if (!english.isChecked())
                {
                    german.setChecked(true);
                }
            }
        });

        return view;
    }
}
