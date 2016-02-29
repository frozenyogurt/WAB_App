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
    private Toast toast;

    public SettingsFragment () {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.settings_fragment,container,false);

        Button save = (Button) view.findViewById(R.id.button_save);
        save.setText(getActivity().getResources().getString(R.string.SETTINGS_SAVE));
        Button reset = (Button) view.findViewById(R.id.button_reset);
        reset.setText(getActivity().getResources().getString(R.string.SETTINGS_RESET));
        final EditText hex_value = (EditText) view.findViewById(R.id.hex_value);
        hex_value.setHint(getActivity().getResources().getString(R.string.SETTINGS_HINT_TEXT));
        final CheckBox german = (CheckBox) view.findViewById(R.id.language_german);
        german.setText(getActivity().getResources().getString(R.string.SETTINGS_LANGUAGE_GERMAN));
        final CheckBox english = (CheckBox) view.findViewById(R.id.language_english);
        english.setText(getActivity().getResources().getString(R.string.SETTINGS_LANGUAGE_ENGLISH));
        TextView titleChangeLanguage = (TextView) view.findViewById(R.id.titleChangeLanguage);
        titleChangeLanguage.setText(getActivity().getResources().getString(R.string.SETTINGS_LANGUAGE_TITLE));
        TextView titleChangeDesign = (TextView) view.findViewById(R.id.titleChangeColor);
        titleChangeDesign.setText(getActivity().getResources().getString(R.string.SETTINGS_DESIGN_TITLE));
        TextView textInfo = (TextView) view.findViewById(R.id.changeColorInfoText);
        textInfo.setText("");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = ((MainActivity) getActivity());
                if (!hex_value.getText().toString().equals("")) {
                    activity.setColor(hex_value.getText().toString());
                    if (activity.convertColorString() != 0) {
                        activity.refreshFragments();
                        Toast.makeText(getActivity().getApplicationContext(), getActivity().getResources().getString(R.string.SETTINGS_YOUR_VALUE) +" "+ hex_value.getText().toString() +" "+ getActivity().getResources().getString(R.string.SETTINGS_VALUE_SAVED), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), getActivity().getResources().getString(R.string.SETTINGS_WRONG_VALUE), Toast.LENGTH_LONG).show();
                    }
                }
                if (german.isChecked()) {
                    if (((MainActivity) getActivity()).getLanguage().equals("en")) {
                        Toast.makeText(getActivity().getApplicationContext(), getActivity().getResources().getString(R.string.SETTINGS_LANGUAGE_CHANGED_TO_GERMAN), Toast.LENGTH_LONG).show();
                        ((MainActivity) getActivity()).refreshFragments();
                    }
                    activity.setLocale("de");
                } else {
                    if (((MainActivity) getActivity()).getLanguage().equals("de")) {
                        Toast.makeText(getActivity().getApplicationContext(), getActivity().getResources().getString(R.string.SETTINGS_LANGUAGE_CHANGED_TO_ENGLISH), Toast.LENGTH_LONG).show();
                        ((MainActivity) getActivity()).refreshFragments();
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
                MainActivity activity = ((MainActivity)getActivity());
                if (activity.getColor() != null)
                {
                    activity.setColor(null);
                    activity.refreshFragments();
                }
                german.setChecked(true);
                english.setChecked(false);
                hex_value.setText("");
                activity.setLocale("de");
                showAToast(getActivity().getResources().getString(R.string.SETTINGS_RESET_SUCCESS));
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

    public void showAToast (String st)
    {
        try
        {
            toast.getView().isShown();
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setText(st);
        }
        catch (Exception ex)
        {
            toast = Toast.makeText(getActivity().getApplicationContext(), st, Toast.LENGTH_LONG);
        }
        toast.show();
    }
}
