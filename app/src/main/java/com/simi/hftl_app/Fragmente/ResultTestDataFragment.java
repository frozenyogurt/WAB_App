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
        titleFragment.setText(getResources().getString(R.string.RESULT_DATA_TITLE));

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

        titleWinnerCategory.setText(getResources().getString(R.string.RESULT_DATA_STUDY_CATEGORY));
        titleWinnerDegree.setText(getResources().getString(R.string.RESULT_DATA_STUDY_DEGREE));
        setText(titleOne, rating, 0);
        setText(titleTwo, rating, 1);
        setText(titleThree, rating, 2);
        setText(titleFour, rating, 3);

        progressOne.setMax(36);
        progressTwo.setMax(36);
        progressThree.setMax(36);
        progressFour.setMax(36);
        progressOne.setProgress(getValueOf(0, rating));
        progressTwo.setProgress(getValueOf(1, rating));
        progressThree.setProgress(getValueOf(2, rating));
        progressFour.setProgress(getValueOf(3, rating));
        percentageOne.setText(Math.round(((double)getValueOf(0, rating) / 36) * 100) + "%");
        percentageTwo.setText(Math.round(((double)getValueOf(1, rating) / 36) * 100) + "%");
        percentageThree.setText(Math.round(((double)getValueOf(2, rating) / 36) * 100) + "%");
        percentageFour.setText(Math.round(((double)getValueOf(3, rating) / 36) * 100) + "%");

        end.setText(getResources().getString(R.string.TEST_RESULT_END_TEST));
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).endTest(false);
            }
        });
        
        result.setText(getResources().getString(R.string.RESULT_DATA_BUTTUN_DECISION));
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
            textWinnerCategory.setText(getResources().getString(R.string.RESULT_DATA_DUAL_TITLE));
        }
        else if (first.equals(RatingCategory.JOB))
        {
            textWinnerCategory.setText(getResources().getString(R.string.RESULT_DATA_JOB_TITLE_BUTTON));
        }
        else
        {
            textWinnerCategory.setText(getResources().getString(R.string.RESULT_DATA_DIRECT_TITLE));
        }

        map = Rating.sortByValue(rating.getDregreeRatingMap());
        first = (RatingCategory) map.keySet().toArray()[0];
        RatingCategory second = (RatingCategory) map.keySet().toArray()[1];
        if (map.get(first) == map.get(second))
        {
            textWinnerDegree.setText(getResources().getString(R.string.RESULT_DATA_BACHELOR_OR_MASTER));
        }
        else if (first.equals(RatingCategory.BACHELOR))
        {
            textWinnerDegree.setText(getResources().getString(R.string.RESULT_DATA_BACHELOR));
        }
        else
        {
            textWinnerDegree.setText(getResources().getString(R.string.RESULT_DATA_MASTER));
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

            progressOne.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_magenta));
            progressTwo.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_magenta));
            progressThree.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_magenta));
            progressFour.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_magenta));
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.study_test_color);
            layout.setBackgroundColor(color);
            progressOne.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar));
            progressTwo.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar));
            progressThree.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar));
            progressFour.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar));
            result.setBackgroundResource(R.drawable.round_button_test);
        }

        return view;
    }

    public int getValueOf(int index, Rating rating)
    {
        return rating.getSortedStudyRatingMap().get(rating.getSortedStudyRatingMap().keySet().toArray()[index]);
    }

    public void setText(TextView textView, Rating rating, int index)
    {
        if (rating.getSortedStudyRatingMap().keySet().toArray()[index].equals(RatingCategory.KMI))
        {
            textView.setText(getResources().getString(R.string.RESULT_DATA_KMI_TITLE));
        }
        else if (rating.getSortedStudyRatingMap().keySet().toArray()[index].equals(RatingCategory.WI))
        {
            textView.setText(getResources().getString(R.string.RESULT_DATA_WI_TITLE));
        }
        else if (rating.getSortedStudyRatingMap().keySet().toArray()[index].equals(RatingCategory.IKT))
        {
            textView.setText(getResources().getString(R.string.RESULT_DATA_IKT_TITLE));
        }
        else if (rating.getSortedStudyRatingMap().keySet().toArray()[index].equals(RatingCategory.AI))
        {
            textView.setText(getResources().getString(R.string.RESULT_DATA_AI_TITLE));
        }
    }
}
