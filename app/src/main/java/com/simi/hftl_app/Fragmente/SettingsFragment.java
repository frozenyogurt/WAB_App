package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.TextSize;
import com.simi.hftl_app.R;

import java.util.Locale;

/**
 * Created by student on 11.02.2016.
 */
public class SettingsFragment extends MyRefreshFragment
{
    private Toast toast;
    private String previousTag;

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
        final CheckBox german = (CheckBox) view.findViewById(R.id.language_german);
        german.setText(getActivity().getResources().getString(R.string.SETTINGS_LANGUAGE_GERMAN));
        final CheckBox english = (CheckBox) view.findViewById(R.id.language_english);
        english.setText(getActivity().getResources().getString(R.string.SETTINGS_LANGUAGE_ENGLISH));
        final CheckBox defaultDesign = (CheckBox) view.findViewById(R.id.default_design);
        defaultDesign.setText(getActivity().getResources().getString(R.string.SETTINGS_DESIGN_DEFAULT));
        final CheckBox magentaDesign = (CheckBox) view.findViewById(R.id.magenta_design);
        magentaDesign.setText(getActivity().getResources().getString(R.string.SETTINGS_DESIGN_MAGENTA));
        final CheckBox textSizeSmall = (CheckBox) view.findViewById(R.id.text_size_small);
        textSizeSmall.setText(getActivity().getResources().getString(R.string.SETTINGS_TEXT_CHANGE_SIZE_SMALL));
        final CheckBox textSizeMiddle = (CheckBox) view.findViewById(R.id.text_size_middle);
        textSizeMiddle.setText(getActivity().getResources().getString(R.string.SETTINGS_TEXT_CHANGE_SIZE_MIDDLE));
        textSizeMiddle.setChecked(true);
        final CheckBox textSizeBig = (CheckBox) view.findViewById(R.id.text_size_big);
        textSizeBig.setText(getActivity().getResources().getString(R.string.SETTINGS_TEXT_CHANGE_SIZE_BIG));
        TextView titleChangeLanguage = (TextView) view.findViewById(R.id.titleChangeLanguage);
        titleChangeLanguage.setText(getActivity().getResources().getString(R.string.SETTINGS_LANGUAGE_TITLE));
        TextView titleChangeDesign = (TextView) view.findViewById(R.id.titleChangeColor);
        titleChangeDesign.setText(getActivity().getResources().getString(R.string.SETTINGS_DESIGN_TITLE));
        TextView titleChangeSize = (TextView) view.findViewById(R.id.title_change_text_size);
        titleChangeSize.setText(getActivity().getResources().getString(R.string.SETTINGS_TITLE_CHANGE_SIZE));

        final MainActivity activity = ((MainActivity) getActivity());
        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            save.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
            reset.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
            german.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
            english.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
            magentaDesign.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
            defaultDesign.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
            titleChangeDesign.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            titleChangeLanguage.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            titleChangeSize.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            save.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
            reset.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
            german.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
            english.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
            magentaDesign.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
            defaultDesign.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
            titleChangeDesign.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            titleChangeLanguage.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            titleChangeSize.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            save.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
            reset.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
            german.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
            english.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
            magentaDesign.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
            defaultDesign.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
            titleChangeDesign.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            titleChangeLanguage.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            titleChangeSize.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (defaultDesign.isChecked()) {
                    if (activity.getColor() != null) {
                        Toast.makeText(getActivity().getApplicationContext(), getActivity().getResources().getString(R.string.SETTINGS_DESIGN_CHANGED), Toast.LENGTH_LONG).show();
                        activity.refreshFragments();
                    }
                    activity.setColor(null);
                } else {
                    if (activity.getColor() == null) {
                        Toast.makeText(getActivity().getApplicationContext(), getActivity().getResources().getString(R.string.SETTINGS_DESIGN_CHANGED), Toast.LENGTH_LONG).show();
                        activity.refreshFragments();
                    }
                    activity.setColor(Integer.toHexString(getActivity().getResources().getColor(R.color.magenta)));
                }
                if (german.isChecked()) {
                    if (activity.getLanguage().equals("en")) {
                        Toast.makeText(getActivity().getApplicationContext(), getActivity().getResources().getString(R.string.SETTINGS_LANGUAGE_CHANGED_TO_GERMAN), Toast.LENGTH_LONG).show();
                        activity.refreshFragments();
                    }
                    activity.setLocale("de");
                } else {
                    if (activity.getLanguage().equals("de")) {
                        Toast.makeText(getActivity().getApplicationContext(), getActivity().getResources().getString(R.string.SETTINGS_LANGUAGE_CHANGED_TO_ENGLISH), Toast.LENGTH_LONG).show();
                        activity.refreshFragments();
                    }
                    activity.setLocale("en");
                }
                if (!textSizeSmall.isChecked() && !textSizeMiddle.isChecked() && !textSizeBig.isChecked()) {
                    Toast.makeText(getActivity().getApplicationContext(), getActivity().getResources().getString(R.string.SETTINGS_TEXT_CHANGE_SIZE_MESSAGE), Toast.LENGTH_LONG).show();
                } else if (textSizeSmall.isChecked()) {
                    if (!activity.getTextSize().equals(TextSize.SMALL)) {
                        activity.setTextSize(TextSize.SMALL);
                        activity.refreshFragments();
                        Toast.makeText(getActivity().getApplicationContext(),
                                getActivity().getResources().getString(R.string.SETTINGS_TEXT_CHANGE_SIZE_MESSAGE_SUCCESS) +
                                        getActivity().getResources().getString(R.string.SETTINGS_TEXT_CHANGE_SIZE_SMALL) +
                                        getActivity().getResources().getString(R.string.SETTINGS_TEXT_CHANGE_SIZE_MESSAGE_SUCCESS_TWO),
                                Toast.LENGTH_LONG).show();
                    }
                } else if (textSizeMiddle.isChecked()) {
                    if (!activity.getTextSize().equals(TextSize.MIDDLE)) {
                        activity.setTextSize(TextSize.MIDDLE);
                        activity.refreshFragments();
                        Toast.makeText(getActivity().getApplicationContext(),
                                getActivity().getResources().getString(R.string.SETTINGS_TEXT_CHANGE_SIZE_MESSAGE_SUCCESS) +
                                        getActivity().getResources().getString(R.string.SETTINGS_TEXT_CHANGE_SIZE_MIDDLE) +
                                        getActivity().getResources().getString(R.string.SETTINGS_TEXT_CHANGE_SIZE_MESSAGE_SUCCESS_TWO),
                                Toast.LENGTH_LONG).show();
                    }
                } else if (textSizeBig.isChecked()) {
                    if (!activity.getTextSize().equals(TextSize.BIG)) {
                        activity.setTextSize(TextSize.BIG);
                        activity.refreshFragments();
                        Toast.makeText(getActivity().getApplicationContext(),
                                getActivity().getResources().getString(R.string.SETTINGS_TEXT_CHANGE_SIZE_MESSAGE_SUCCESS) +
                                        getActivity().getResources().getString(R.string.SETTINGS_TEXT_CHANGE_SIZE_BIG) +
                                        getActivity().getResources().getString(R.string.SETTINGS_TEXT_CHANGE_SIZE_MESSAGE_SUCCESS_TWO),
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = ((MainActivity) getActivity());
                boolean isRefresh = false;
                if (activity.getColor() != null) {
                    activity.setColor(null);
                    isRefresh = true;
                }
                if (!Locale.getDefault().getLanguage().equals("de"))
                {
                    activity.setLocale("de");
                    isRefresh = true;
                }
                if (!activity.getTextSize().equals(TextSize.MIDDLE))
                {
                    activity.setTextSize(TextSize.MIDDLE);
                    isRefresh = true;
                }
                if (isRefresh)
                {
                    activity.refreshFragments();
                }
                german.setChecked(true);
                english.setChecked(false);
                defaultDesign.setChecked(true);
                magentaDesign.setChecked(false);
                textSizeBig.setChecked(false);
                textSizeMiddle.setChecked(true);
                textSizeSmall.setChecked(false);
                showAToast(getActivity().getResources().getString(R.string.SETTINGS_RESET_SUCCESS));
            }
        });

        german.setChecked(activity.getLanguage().equals("de"));
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

        english.setChecked(activity.getLanguage().equals("en"));
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (german.isChecked()) {
                    german.setChecked(false);
                }
                if (!english.isChecked()) {
                    german.setChecked(true);
                }
            }
        });

        defaultDesign.setChecked(activity.getColor() == null);
        defaultDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (magentaDesign.isChecked()) {
                    magentaDesign.setChecked(false);
                }
                if (!defaultDesign.isChecked()) {
                    magentaDesign.setChecked(true);
                }
            }
        });

        magentaDesign.setChecked(activity.getColor() != null);
        magentaDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (defaultDesign.isChecked()) {
                    defaultDesign.setChecked(false);
                }
                if (!magentaDesign.isChecked()) {
                    defaultDesign.setChecked(true);
                }
            }
        });

        textSizeSmall.setChecked(activity.getTextSize().equals(TextSize.SMALL));
        textSizeSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (textSizeSmall.isChecked())
                {
                    textSizeMiddle.setChecked(false);
                    textSizeBig.setChecked(false);
                }
            }
        });

        textSizeMiddle.setChecked(activity.getTextSize().equals(TextSize.MIDDLE));
        textSizeMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (textSizeMiddle.isChecked())
                {
                    textSizeSmall.setChecked(false);
                    textSizeBig.setChecked(false);
                }
            }
        });

        textSizeBig.setChecked(activity.getTextSize().equals(TextSize.BIG));
        textSizeBig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (textSizeBig.isChecked())
                {
                    textSizeMiddle.setChecked(false);
                    textSizeSmall.setChecked(false);
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

    @Override
    public void onStart()
    {
        previousTag = ((MainActivity) getActivity()).getToolbatTag();
        ((MainActivity) getActivity()).setToolbarTitle(getActivity().getResources().getString(R.string.MENU_SETTINGS_NAME));
        super.onStart();
    }

    @Override
    public void onStop()
    {
        if (previousTag != null)
        {
            if (previousTag.equals("EDUCATION"))
            {
                ((MainActivity) getActivity()).setToolbarTitle(getResources().getString(R.string.ACTIVITY_EDUCATION_TITLE));
            }
            else if (previousTag.equals("DIRECT"))
            {
                ((MainActivity) getActivity()).setToolbarTitle(getResources().getString(R.string.ACTIVITY_DIRECT_TITLE));
            }
            else if (previousTag.equals("JOB"))
            {
                ((MainActivity) getActivity()).setToolbarTitle(getResources().getString(R.string.ACTIVITY_JOB_TITLE));
            }
            else if (previousTag.equals("DUAL"))
            {
                ((MainActivity) getActivity()).setToolbarTitle(getResources().getString(R.string.ACTIVITY_DUAL_TITLE));
            }
            else if (previousTag.equals("HFTL_INFO"))
            {
                ((MainActivity) getActivity()).setToolbarTitle(getResources().getString(R.string.ACTIVITY_HFTL_INFO_TITLE));
            }
            else if (previousTag.equals("TEST"))
            {
                ((MainActivity) getActivity()).setToolbarTitle(getResources().getString(R.string.ACTIVITY_Test_TITLE));
            }
            else if (previousTag.equals("APP"))
            {
                ((MainActivity) getActivity()).setToolbarTitle(getResources().getString(R.string.ACTIVITY_APP_TITLE));
            }
        }
        super.onStop();
    }
}
