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

import com.simi.hftl_app.Listen.StudyListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Category;
import com.simi.hftl_app.Model.StudyCourse;
import com.simi.hftl_app.Model.TextSize;
import com.simi.hftl_app.R;

import java.util.ArrayList;

/**
 * Created by student on 17.02.2016.
 */
public class StudyTestResultFragment extends MyRefreshFragment
{
    public StudyTestResultFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.study_test_result_fragment, container, false);

        TextView titleFragment = (TextView) view.findViewById(R.id.test_question_title);
        titleFragment.setText(getActivity().getResources().getString(R.string.TEST_QUESTION_RESULT_TITLE));

        Button end = (Button) view.findViewById(R.id.end_test);
        end.setText(getActivity().getResources().getString(R.string.TEST_RESULT_END_TEST));
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).endTest(true);
            }
        });

        final MainActivity activity = ((MainActivity)getActivity());
        activity.setToolbarTitle(activity.getResources().getString(R.string.ACTIVITY_Test_TITLE));

        Button info = (Button) view.findViewById(R.id.study_info_button);
        info.setText(activity.getResources().getString(R.string.STUDY_TEST_RESULT_INFO_BUTTON));
        info.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ArrayList<StudyCourse> course = new ArrayList<>();
                if (activity.getWinner() != null && !activity.getWinner().isEmpty())
                {
                    course = activity.getWinner();
                }
                else if (activity.getAlternative() != null)
                {
                    course.add(activity.getAlternative());
                }

                activity.setClickedElement(new StudyListItem((MainActivity) getActivity(), course.get(course.size() - 1)));
                if (activity.getClickedElement() != null)
                {
                    if (activity.getClickedElement().getCategory().equals(Category.DUAL))
                    {
                        activity.setToolbarTitle(activity.getResources().getString(R.string.ACTIVITY_DUAL_TITLE));
                }
                    else if (activity.getClickedElement().getCategory().equals(Category.JOB))
                    {
                        activity.setToolbarTitle(activity.getResources().getString(R.string.ACTIVITY_JOB_TITLE));
                    }
                    else
                    {
                        activity.setToolbarTitle(activity.getResources().getString(R.string.ACTIVITY_DIRECT_TITLE));
                    }
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                    ft.add(R.id.activityLayout, new StudyInfoFragment(), "StudyInfoFragment");
                    ft.addToBackStack(StudyInfoFragment.class.getSimpleName());
                    ft.commit();
                }
            }
        });

        TextView solutionText = (TextView) view.findViewById(R.id.solution_text_test);
        if (activity.getWinner() != null && !activity.getWinner().isEmpty())
        {
            solutionText.setText(activity.getResources().getString(R.string.STUDY_TEST_RESULT_PERFECT_TEXT));
        }
        else if (activity.getAlternative() != null)
        {
            solutionText.setText(activity.getResources().getString(R.string.STUDY_TEST_RESULT_NEARLY_TEXT));
        }
        else
        {
            solutionText.setText(activity.getResources().getString(R.string.STUDY_TEST_RESULT_NOTHING_TEXT));
        }

        TextView result = (TextView) view.findViewById(R.id.result_test);
        result.setText(getWinner());


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
            info.setBackgroundDrawable(shape);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.study_test_color);
            layout.setBackgroundColor(color);
            end.setBackgroundResource(R.drawable.round_button_grey);
            info.setBackgroundResource(R.drawable.round_button_test);
        }

        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            info.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
            end.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
            titleFragment.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            solutionText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            result.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            info.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
            end.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
            titleFragment.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            solutionText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            result.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            info.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
            end.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
            titleFragment.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            solutionText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            result.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
        }

        return view;
    }

    public String getWinner()
    {
        MainActivity activity = ((MainActivity)getActivity());
        String solution = "";
        if (activity.getWinner() != null && !activity.getWinner().isEmpty())
        {
            ArrayList<StudyCourse> winner = activity.getWinner();
            if (winner.size() == 1)
            {
                solution = getSolution(winner.get(0));
            }
            else
            {
                solution = getSolution(winner.get(0)) + " " + activity.getResources().getString(R.string.STUDY_TEST_RESULT_OR) + " " + getSolution(winner.get(1));
            }
        }
        else if (activity.getAlternative() != null)
        {
            solution = getSolution(activity.getAlternative());
        }
        else
        {
            solution = activity.getResources().getString(R.string.STUDY_TEST_RESULT_NOTHING);
        }
        return solution;
    }

    public String getSolution(StudyCourse course)
    {
        String solution = "";
        switch (course)
        {
            case KMI_BACHELOR:
                solution = getActivity().getResources().getString(R.string.STUDY_TEST_RESULT_KMI_BACHELOR_RESULT);
                break;
            case IKT_MASTER:
                solution = getActivity().getResources().getString(R.string.STUDY_TEST_RESULT_IKT_MASTER_RESULT);
                break;
            case WI_BACHELOR:
                solution = getActivity().getResources().getString(R.string.STUDY_TEST_RESULT_WI_BACHELOR_RESULT);
                break;
            case DUAL_KMI_BACHELOR:
                solution = getActivity().getResources().getString(R.string.STUDY_TEST_RESULT_DUAL_KMI_BACHELOR_RESULT);
                break;
            case JOB_KMI_BACHELOR:
                solution = getActivity().getResources().getString(R.string.STUDY_TEST_RESULT_JOB_KMI_BACHELOR_RESULT);
                break;
            case DUAL_WI_BACHELOR:
                solution = getActivity().getResources().getString(R.string.STUDY_TEST_RESULT_DUAL_WI_BACHELOR_RESULT);
                break;
            case DUAL_WI_MASTER:
                solution = getActivity().getResources().getString(R.string.STUDY_TEST_RESULT_DUAL_WI_MASTER_RESULT);
                break;
            case JOB_WI_BACHELOR:
                solution = getActivity().getResources().getString(R.string.STUDY_TEST_RESULT_JOB_WI_BACHELOR_RESULT);
                break;
            case JOB_WI_MASTER:
                solution = getActivity().getResources().getString(R.string.STUDY_TEST_RESULT_JOB_WI_MASTER_RESULT);
                break;
            case IKT_BACHELOR:
                solution = getActivity().getResources().getString(R.string.STUDY_TEST_RESULT_IKT_BACHELOR_RESULT);
                break;
            case JOB_IKT_BACHELOR:
                solution = getActivity().getResources().getString(R.string.STUDY_TEST_RESULT_JOB_IKT_BACHELOR_RESULT);
                break;
            case JOB_IKT_MASTER:
                solution = getActivity().getResources().getString(R.string.STUDY_TEST_RESULT_JOB_IKT_MASTER_RESULT);
                break;
            case DUAL_AI_BACHELOR:
                solution = getActivity().getResources().getString(R.string.STUDY_TEST_RESULT_DUAL_AI_BACHELOR_RESULT);
                break;
        }
        return solution;
    }
}
