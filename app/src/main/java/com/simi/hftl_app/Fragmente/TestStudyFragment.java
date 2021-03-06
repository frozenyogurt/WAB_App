package com.simi.hftl_app.Fragmente;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.TextSize;
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
        titleFragment.setText(getActivity().getResources().getString(R.string.TEST_START_BEGINNING));

        TextView firstBeginningText = (TextView) view.findViewById(R.id.test_attention_text);
        firstBeginningText.setText(getActivity().getResources().getString(R.string.TEST_START_ATTENTION));

        TextView secondDescriptionText = (TextView) view.findViewById(R.id.test_info_text);
        secondDescriptionText.setText(getActivity().getResources().getString(R.string.TEST_START_DESCRIPTION));

        TextView pointOne = (TextView) view.findViewById(R.id.study_test_first_point_text);
        TextView pointTwo = (TextView) view.findViewById(R.id.study_test_second_point_text);
        TextView pointThree = (TextView) view.findViewById(R.id.study_test_third_point_text);
        TextView pointFour = (TextView) view.findViewById(R.id.study_test_fourth_point_text);

        pointOne.setText(getActivity().getResources().getString(R.string.STUDY_TEST_POINT_ONE));
        pointTwo.setText(getActivity().getResources().getString(R.string.STUDY_TEST_POINT_TWO));
        pointThree.setText(getActivity().getResources().getString(R.string.STUDY_TEST_POINT_THREE));
        pointFour.setText(getActivity().getResources().getString(R.string.STUDY_TEST_POINT_FOUR));

        start.setText(getActivity().getResources().getString(R.string.TEST_START));
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

        MainActivity activity = ((MainActivity)getActivity());
        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            titleFragment.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            pointOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            pointTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            pointThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            pointFour.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            firstBeginningText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            secondDescriptionText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            start.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            titleFragment.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            pointOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            pointTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            pointThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            pointFour.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            firstBeginningText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            secondDescriptionText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            start.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            titleFragment.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            pointOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            pointTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            pointThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            pointFour.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            firstBeginningText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            secondDescriptionText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            start.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
        }

        return view;
    }
}
