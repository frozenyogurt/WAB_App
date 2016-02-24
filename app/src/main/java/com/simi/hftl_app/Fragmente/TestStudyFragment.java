package com.simi.hftl_app.Fragmente;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.R;

/**
 * Created by student on 09.02.2016.
 */
public class TestStudyFragment extends MyRefreshFragment
{
    public TestStudyFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.test_study_fragment,container,false);

        Button start = (Button) view.findViewById(R.id.start_test);

        TextView titleFragment = (TextView) view.findViewById(R.id.title_fragment);
        titleFragment.setText("Einführung");

        TextView firstBeginningText = (TextView) view.findViewById(R.id.test_attention_text);
        firstBeginningText.setText("Dein Achtung Achtung Text simmi");

        TextView secondDescriptionText = (TextView) view.findViewById(R.id.test_info_text);
        secondDescriptionText.setText("Bescgriebung des Testes");

        start.setText("Test Starten");
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).initQuestionList();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new StudyTestQuestionsFragment(), "StudyTestQuestionsFragment");
                ft.addToBackStack(StudyTestQuestionsFragment.class.getSimpleName());
                ft.commit();
            }
        });

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.underline);
        int color = ((MainActivity) getActivity()).convertColorString();
        if (color != 0)
        {
            layout.setBackgroundColor(color);
            GradientDrawable shape =  new GradientDrawable();
            float scale = getContext().getResources().getDisplayMetrics().density;
            int pixels = (int) (10 * scale + 0.5f);
            shape.setCornerRadius(pixels);
            shape.setColor(color);
            start.setBackgroundDrawable(shape);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.study_test_color);
            layout.setBackgroundColor(color);
            start.setBackgroundResource(R.drawable.round_button_test);
        }

        return view;
    }
}
