package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.TextSize;
import com.simi.hftl_app.R;

/**
 * Created by student on 11.02.2016.
 */
public class HFTLInfoFragment extends MyRefreshFragment
{
    private Button news;
    private Button employee;
    private Button contact;
    private Button faq;
    private Button imprint;
    private Button services;
    private Button whyHFTL;
    private Button portrait;

    public HFTLInfoFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.hftl_info_fragment,container,false);

        portrait = (Button) view.findViewById(R.id.button_portrait);
        employee = (Button) view.findViewById(R.id.button_employee);
        contact = (Button) view.findViewById(R.id.button_contact);
        faq = (Button) view.findViewById(R.id.button_faq);
        imprint = (Button) view.findViewById(R.id.button_imprint);
        services = (Button) view.findViewById(R.id.button_services);
        whyHFTL = (Button) view.findViewById(R.id.button_why_hftl);
        news = (Button) view.findViewById(R.id.button_news);

        portrait.setText(getActivity().getResources().getString(R.string.PORTRAIT_TITLE));
        employee.setText(getActivity().getResources().getString(R.string.EMPLOYEE_TITLE_TEXT));
        contact.setText(getActivity().getResources().getString(R.string.CONTACT_TITLE));
        faq.setText(getActivity().getResources().getString(R.string.FAQ_TITLE));
        imprint.setText(getActivity().getResources().getString(R.string.IMPRINT_TITLE));
        services.setText(getActivity().getResources().getString(R.string.SERVICES_TITLE));
        whyHFTL.setText(getActivity().getResources().getString(R.string.WHY_HFTL_TITLE));
        news.setText(getActivity().getResources().getString(R.string.NEWS_TITLE));

        MainActivity activity = ((MainActivity)getActivity());
        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            portrait.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_middle));
            employee.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_middle));
            contact.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_middle));
            faq.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_middle));
            imprint.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_middle));
            services.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_middle));
            whyHFTL.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_middle));
            news.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            portrait.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size));
            employee.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size));
            contact.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size));
            faq.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size));
            imprint.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size));
            services.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size));
            whyHFTL.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size));
            news.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            portrait.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_big));
            employee.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_big));
            contact.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_big));
            faq.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_big));
            imprint.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_big));
            services.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_big));
            whyHFTL.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_big));
            news.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_big));
        }

        if (((MainActivity) getActivity()).convertColorString() != 0)
        {
            setColors();
        }
        else
        {
            setDefaultColor();
        }

        portrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new PortraitHFTLFragment(), "PortraitHFTLFragment");
                ft.addToBackStack(PortraitHFTLFragment.class.getSimpleName());
                ft.commit();
            }
        });
        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new EmployeeHFTLFragment(), "EmployeeHFTLFragment");
                ft.addToBackStack(EmployeeHFTLFragment.class.getSimpleName());
                ft.commit();
            }
        });
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new ServicesHFTLFragment(), "ServicesHFTLFragment");
                ft.addToBackStack(ServicesHFTLFragment.class.getSimpleName());
                ft.commit();
            }
        });
        whyHFTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new WhyHFTLFragment(), "WhyHFTLFragment");
                ft.addToBackStack(WhyHFTLFragment.class.getSimpleName());
                ft.commit();
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new ContactHFTLFragment(), "ContactHFTLFragment");
                ft.addToBackStack(ContactHFTLFragment.class.getSimpleName());
                ft.commit();
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new NewsHFTLFragment(), "NewsHFTLFragment");
                ft.addToBackStack(NewsHFTLFragment.class.getSimpleName());
                ft.commit();
            }
        });
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new FAQFragment(), "FAQFragment");
                ft.addToBackStack(FAQFragment.class.getSimpleName());
                ft.commit();
            }
        });
        imprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new ImprintFragment(), "ImprintFragment");
                ft.addToBackStack(ImprintFragment.class.getSimpleName());
                ft.commit();
            }
        });

        if (((MainActivity) getActivity()).convertColorString() != 0)
        {
            setColors();
        }

        return view;
    }

    public void setDefaultColor()
    {
        MainActivity activity = ((MainActivity) getActivity());
        news.setBackgroundColor(activity.getResources().getColor(R.color.hftl_info_color));
        news.setTextColor(getResources().getColor(android.R.color.white));
        faq.setBackgroundColor(activity.getResources().getColor(R.color.hftl_info_color));
        faq.setTextColor(getResources().getColor(android.R.color.white));
        imprint.setBackgroundColor(activity.getResources().getColor(R.color.hftl_info_color));
        imprint.setTextColor(getResources().getColor(android.R.color.white));
        portrait.setBackgroundColor(activity.getResources().getColor(R.color.hftl_info_color));
        portrait.setTextColor(getResources().getColor(android.R.color.white));
        whyHFTL.setBackgroundColor(activity.getResources().getColor(R.color.hftl_info_color));
        whyHFTL.setTextColor(getResources().getColor(android.R.color.white));
        employee.setBackgroundColor(activity.getResources().getColor(R.color.hftl_info_color));
        employee.setTextColor(getResources().getColor(android.R.color.white));
        contact.setBackgroundColor(activity.getResources().getColor(R.color.hftl_info_color));
        contact.setTextColor(getResources().getColor(android.R.color.white));
        services.setBackgroundColor(activity.getResources().getColor(R.color.hftl_info_color));
        services.setTextColor(getResources().getColor(android.R.color.white));
    }

    public void setColors()
    {
        MainActivity activity = ((MainActivity) getActivity());
        news.setBackgroundColor(getResources().getColor(R.color.light_grey));
        news.setTextColor(getResources().getColor(R.color.magenta));
        faq.setBackgroundColor(getResources().getColor(R.color.light_grey));
        faq.setTextColor(getResources().getColor(R.color.magenta));
        imprint.setBackgroundColor(getResources().getColor(R.color.light_grey));
        imprint.setTextColor(getResources().getColor(R.color.magenta));
        portrait.setBackgroundColor(getResources().getColor(R.color.light_grey));
        portrait.setTextColor(getResources().getColor(R.color.magenta));
        whyHFTL.setBackgroundColor(getResources().getColor(R.color.light_grey));
        whyHFTL.setTextColor(getResources().getColor(R.color.magenta));
        employee.setBackgroundColor(getResources().getColor(R.color.light_grey));
        employee.setTextColor(getResources().getColor(R.color.magenta));
        contact.setBackgroundColor(getResources().getColor(R.color.light_grey));
        contact.setTextColor(getResources().getColor(R.color.magenta));
        services.setBackgroundColor(getResources().getColor(R.color.light_grey));
        services.setTextColor(getResources().getColor(R.color.magenta));
    }
}
