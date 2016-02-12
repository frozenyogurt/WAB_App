package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.simi.hftl_app.R;

/**
 * Created by student on 11.02.2016.
 */
public class HFTLInfoFragment extends Fragment
{
    public HFTLInfoFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.hftl_info_fragment,container,false);

        Button portrait = (Button) view.findViewById(R.id.button_portrait);
        Button employee = (Button) view.findViewById(R.id.button_employee);
        Button contact = (Button) view.findViewById(R.id.button_contact);
        Button faq = (Button) view.findViewById(R.id.button_faq);
        Button imprint = (Button) view.findViewById(R.id.button_imprint);
        Button services = (Button) view.findViewById(R.id.button_services);
        Button whyHFTL = (Button) view.findViewById(R.id.button_why_hftl);
        Button news = (Button) view.findViewById(R.id.button_news);

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

        return view;
    }
}
