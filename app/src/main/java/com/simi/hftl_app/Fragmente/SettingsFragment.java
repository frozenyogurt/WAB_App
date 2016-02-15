package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.R;

/**
 * Created by student on 11.02.2016.
 */
public class SettingsFragment extends Fragment
{
    public SettingsFragment () {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.settings_fragment,container,false);

        Button save = (Button) view.findViewById(R.id.button_save);
        Button reset = (Button) view.findViewById(R.id.button_reset);
        final EditText hex_value = (EditText) view.findViewById(R.id.hex_value);
        final CheckBox german = (CheckBox) view.findViewById(R.id.language_german);
        final CheckBox english = (CheckBox) view.findViewById(R.id.language_english);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = ((MainActivity)getActivity());
                activity.setColor(hex_value.getText().toString());
                if (!hex_value.getText().toString().equals(""))
                {
                    if (activity.convertColorString(false) != 0)
                    {
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
                    }
                    activity.setLocale("de");
                }
                else
                {
                    if (((MainActivity)getActivity()).getLanguage().equals("de"))
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "Die Sprache wurde auf Englisch geändert.", Toast.LENGTH_LONG).show();
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
                german.setChecked(true);
                english.setChecked(false);
                hex_value.setText("");
                ((MainActivity)getActivity()).setLocale("de_DE");
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
