package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.R;

/**
 * Created by student on 11.02.2016.
 */
public class HFTLInfoFragment extends Fragment
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

    @Override
    public void onResume()
    {
        if (((MainActivity) getActivity()).convertColorString(true) != 0)
        {
            setColors();
        }
        else
        {
            setDefaultColor();
        }
        super.onResume();
    }

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

        portrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new PortraitHFTLFragment());
                ft.addToBackStack(PortraitHFTLFragment.class.getSimpleName());
                ft.commit();
            }
        });
        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new EmployeeHFTLFragment());
                ft.addToBackStack(EmployeeHFTLFragment.class.getSimpleName());
                ft.commit();
            }
        });
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new ServicesHFTLFragment());
                ft.addToBackStack(ServicesHFTLFragment.class.getSimpleName());
                ft.commit();
            }
        });
        whyHFTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new WhyHFTLFragment());
                ft.addToBackStack(WhyHFTLFragment.class.getSimpleName());
                ft.commit();
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new ContactHFTLFragment());
                ft.addToBackStack(ContactHFTLFragment.class.getSimpleName());
                ft.commit();
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new NewsHFTLFragment());
                ft.addToBackStack(NewsHFTLFragment.class.getSimpleName());
                ft.commit();
            }
        });
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new FAQFragment());
                ft.addToBackStack(FAQFragment.class.getSimpleName());
                ft.commit();
            }
        });
        imprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new ImprintFragment());
                ft.addToBackStack(ImprintFragment.class.getSimpleName());
                ft.commit();
            }
        });

        if (((MainActivity) getActivity()).convertColorString(true) != 0)
        {
            setColors();
        }

        return view;
    }

    public void setDefaultColor()
    {
        MainActivity activity = ((MainActivity) getActivity());
        news.setBackgroundColor(activity.getResources().getColor(R.color.hftl_info_color));
        faq.setBackgroundColor(activity.getResources().getColor(R.color.hftl_info_color));
        imprint.setBackgroundColor(activity.getResources().getColor(R.color.hftl_info_color));
        portrait.setBackgroundColor(activity.getResources().getColor(R.color.hftl_info_color));
        whyHFTL.setBackgroundColor(activity.getResources().getColor(R.color.hftl_info_color));
        employee.setBackgroundColor(activity.getResources().getColor(R.color.hftl_info_color));
        contact.setBackgroundColor(activity.getResources().getColor(R.color.hftl_info_color));
        services.setBackgroundColor(activity.getResources().getColor(R.color.hftl_info_color));
    }

    public void setColors()
    {
        MainActivity activity = ((MainActivity) getActivity());
        news.setBackgroundColor(activity.convertColorString(true));
        faq.setBackgroundColor(activity.convertColorString(true));
        imprint.setBackgroundColor(activity.convertColorString(true));
        portrait.setBackgroundColor(activity.convertColorString(true));
        whyHFTL.setBackgroundColor(activity.convertColorString(true));
        employee.setBackgroundColor(activity.convertColorString(true));
        contact.setBackgroundColor(activity.convertColorString(true));
        services.setBackgroundColor(activity.convertColorString(true));
    }
}
