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

import com.simi.hftl_app.Listen.StudyListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Category;
import com.simi.hftl_app.Model.StudyCourse;
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

        Button info = (Button) view.findViewById(R.id.study_info_button);
        info.setText("Infomationen");
        info.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                MainActivity activity = ((MainActivity)getActivity());
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

        MainActivity activity = ((MainActivity)getActivity());
        TextView solutionText = (TextView) view.findViewById(R.id.solution_text_test);
        if (activity.getWinner() != null && !activity.getWinner().isEmpty())
        {
            solutionText.setText("Der folgende Studiengang passt perfekt zu dir:");
        }
        else if (activity.getAlternative() != null)
        {
            solutionText.setText("Der folgende Studiengang kommt deinen Anforderungen am Nähesten:");
        }
        else
        {
            solutionText.setText("Lieder haben wir keinen Studiengang an der HfTL für dich ausfindig machen können.");
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
                solution = getSolution(winner.get(0)) + " oder " + getSolution(winner.get(1));
            }
        }
        else if (activity.getAlternative() != null)
        {
            solution = getSolution(activity.getAlternative());
        }
        else
        {
            solution = "Keinen";
        }
        return solution;
    }

    public String getSolution(StudyCourse course)
    {
        String solution = "";
        switch (course)
        {
            case KMI_BACHELOR:
                solution = "Direkter Bachelor of Enigeering: Kommunikations- und Medieninformatik";
                break;
            case IKT_MASTER:
                solution = "Erst den direkten Bachelor of Engineering: Informations- und Kommunikationstechnik und dann den direkten Master of Engineering: Informations- und Kommunikationstechnik in Englisch oder Deutsch";
                break;
            case WI_BACHELOR:
                solution = "Direkter Bachlor of Science: Wirtschaftsinformatik";
                break;
            case DUAL_KMI_BACHELOR:
                solution = "Dualer Bachelor of Enigeering: Kommunikations- und Medieninformatik";
                break;
            case JOB_KMI_BACHELOR:
                solution = "Berufsbegleitender Bachelor of Enigeering: Kommunikations- und Medieninformatik";
                break;
            case DUAL_WI_BACHELOR:
                solution = "Dualer Bachlor of Science: Wirtschaftsinformatik";
                break;
            case DUAL_WI_MASTER:
                solution = "Erst den dualen Bachlor of Science: Wirtschaftsinformatik und dann den dualen Master of Science: Wirtschaftsinformatik.";
                break;
            case JOB_WI_BACHELOR:
                solution = "Berufsbegleitender Bachlor of Science: Wirtschaftsinformatik";
                break;
            case JOB_WI_MASTER:
                solution = "Erst den berufsbegleitenden Bachlor of Science: Wirtschaftsinformatik und dann den berufsbegleitenden Master of Science: Wirtschaftsinformatik";
                break;
            case IKT_BACHELOR:
                solution = "Direkter Bachelor of Engineering: Informations- und Kommunikationstechnik";
                break;
            case JOB_IKT_BACHELOR:
                solution = "Berufsbegleitender Bachelor of Engineering: Informations- und Kommunikationstechnik";
                break;
            case JOB_IKT_MASTER:
                solution = "Erst den berufsbegleitenden Bachelor of Engineering: Informations- und Kommunikationstechnik und dann den berufsbegleitenden Master of Engineering: Informations- und Kommunikationstechnik";
                break;
            case DUAL_AI_BACHELOR:
                solution = "Dualer Bachelor of Science: Angewandte Informatik";
                break;
        }
        return solution;
    }
}
