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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Rating;
import com.simi.hftl_app.Model.RatingCategory;
import com.simi.hftl_app.R;

import java.util.LinkedHashMap;

/**
 * Created by student on 28.02.2016.
 */
public class ResultTestDataFragment extends MyRefreshFragment
{
    public ResultTestDataFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.result_test_data_fragment, container, false);

        TextView titleFragment = (TextView) view.findViewById(R.id.title_fragment);
        titleFragment.setText("Statistik");

        Rating rating = ((MainActivity) getActivity()).getRating();
        Button end = (Button) view.findViewById(R.id.button_end_test);
        Button result = (Button) view.findViewById(R.id.button_decision);
        ProgressBar progressOne = (ProgressBar) view.findViewById(R.id.progress_study_course_one);
        ProgressBar progressTwo = (ProgressBar) view.findViewById(R.id.progress_study_course_two);
        ProgressBar progressThree = (ProgressBar) view.findViewById(R.id.progress_study_course_three);
        ProgressBar progressFour = (ProgressBar) view.findViewById(R.id.progress_study_course_four);
        TextView titleOne = (TextView) view.findViewById(R.id.text_study_course_one);
        TextView titleTwo = (TextView) view.findViewById(R.id.text_study_course_two);
        TextView titleThree = (TextView) view.findViewById(R.id.text_study_course_three);
        TextView titleFour = (TextView) view.findViewById(R.id.text_study_course_four);
        TextView percentageOne = (TextView) view.findViewById(R.id.percentageOne);
        TextView percentageTwo = (TextView) view.findViewById(R.id.percentageTwo);
        TextView percentageThree = (TextView) view.findViewById(R.id.percentageThree);
        TextView percentageFour = (TextView) view.findViewById(R.id.percentageFour);
        TextView titleWinnerCategory = (TextView) view.findViewById(R.id.title_winner_study_category);
        TextView titleWinnerDegree = (TextView) view.findViewById(R.id.title_winner_study_degree);
        TextView textWinnerCategory = (TextView) view.findViewById(R.id.text_winner_study_category);
        TextView textWinnerDegree = (TextView) view.findViewById(R.id.text_winner_study_degree);

        titleWinnerCategory.setText("Studienart");
        titleWinnerDegree.setText("Studiengrad");
        titleOne.setText("KMI Punkte");
        titleTwo.setText("WI Punkte");
        titleThree.setText("IKT Punkte");
        titleFour.setText("AI Punkte");

        progressOne.setMax(36);
        progressTwo.setMax(36);
        progressThree.setMax(36);
        progressFour.setMax(36);
        progressOne.setProgress(rating.getKMIPoints());
        progressTwo.setProgress(rating.getWIPoints());
        progressThree.setProgress(rating.getIKTPoints());
        progressFour.setProgress(rating.getAIPoints());

        percentageOne.setText(Math.round(((double)rating.getKMIPoints() / 36) * 100) + "%");
        percentageTwo.setText(Math.round(((double)rating.getWIPoints() / 36) * 100) + "%");
        percentageThree.setText(Math.round(((double)rating.getIKTPoints() / 36) * 100) + "%");
        percentageFour.setText(Math.round(((double)rating.getAIPoints() / 36) * 100) + "%");

        end.setText("Test Beenden");
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).endTest(false);
            }
        });
        
        result.setText("Vorschlag");
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new StudyTestResultFragment(), "StudyTestResultFragment");
                ft.addToBackStack(StudyTestResultFragment.class.getSimpleName());
                ft.commit();
            }
        });
        
        LinkedHashMap map = Rating.sortByValue(rating.getCategoryRatingMap());
        RatingCategory first = (RatingCategory) map.keySet().toArray()[0];
        if (first.equals(RatingCategory.DUAL))
        {
            textWinnerCategory.setText("Dualstudium");
        }
        else if (first.equals(RatingCategory.JOB))
        {
            textWinnerCategory.setText("Berufsbegleitendes Studium");
        }
        else
        {
            textWinnerCategory.setText("Direktstudium");
        }

        map = Rating.sortByValue(rating.getDregreeRatingMap());
        first = (RatingCategory) map.keySet().toArray()[0];
        RatingCategory second = (RatingCategory) map.keySet().toArray()[1];
        if (map.get(first) == map.get(second))
        {
            textWinnerDegree.setText("Bachelor oder Master");
        }
        else if (first.equals(RatingCategory.BACHELOR))
        {
            textWinnerDegree.setText("Bachelor");
        }
        else
        {
            textWinnerDegree.setText("Master");
        }

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
            result.setBackgroundDrawable(shape);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.study_test_color);
            layout.setBackgroundColor(color);
            result.setBackgroundResource(R.drawable.round_button_test);
        }

        return view;
    }
}
