package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.simi.hftl_app.Listen.ScreenSliderPagerAdapter;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.R;

/**
 * Created by student on 16.02.2016.
 */
public class StudyTestQuestionsFragment extends MyRefreshFragment
{
    public StudyTestQuestionsFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.study_test_questions_fragment,container,false);

        final ImageView backButton = (ImageView) view.findViewById(R.id.back_button_questions);
        final ImageView forwardButton = (ImageView) view.findViewById(R.id.forward_button_questions);
        final Button result = (Button) view.findViewById(R.id.calculate_answers);
        final TextView title = (TextView) view.findViewById(R.id.test_question_title);
        title.setText(getTitleText());

        final ViewPager pager = (ViewPager) view.findViewById(R.id.question_slider);
        ScreenSliderPagerAdapter adapter = new ScreenSliderPagerAdapter(getFragmentManager(), (MainActivity) getActivity());
        pager.setAdapter(adapter);
        ((MainActivity)getActivity()).setCurrentPage(0);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                MainActivity activity = ((MainActivity) getActivity());
                activity.setCurrentPage(position);
                if (position > 0) {
                    backButton.setVisibility(View.VISIBLE);
                }
                if (position == 0) {
                    backButton.setVisibility(View.GONE);
                }
                if (position == activity.getQuestions().size() - 1) {
                    forwardButton.setVisibility(View.GONE);
                }
                if (position < activity.getQuestions().size() - 1) {
                    forwardButton.setVisibility(View.VISIBLE);
                }
                title.setText(getTitleText());
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((MainActivity) getActivity()).isTestValid()) {
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                    ft.add(R.id.activityLayout, new StudyTestResultFragment(), "StudyTestResultFragment");
                    ft.addToBackStack(StudyTestResultFragment.class.getSimpleName());
                    ft.commit();
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Der Test wurde nicht vollständig ausgefüllt.", Toast.LENGTH_LONG).show();
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(pager.getCurrentItem()-1, true);
            }
        });

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(pager.getCurrentItem() + 1, true);
            }
        });

        return view;
    }

    public String getTitleText()
    {
        MainActivity activity = ((MainActivity)getActivity());
        return "Frage " + (activity.getCurrentViewPagerItem()+1) + " von " + activity.getQuestions().size();
    }
}
