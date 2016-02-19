package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.StudyCourse;
import com.simi.hftl_app.R;

import java.util.ArrayList;

/**
 * Created by student on 17.02.2016.
 */
public class StudyTestResultFragment extends Fragment
{
    public StudyTestResultFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.study_test_result_fragment, container, false);

        Button end = (Button) view.findViewById(R.id.end_test);
        end.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ((MainActivity)getActivity()).endTest();
            }
        });

        MainActivity activity = ((MainActivity)getActivity());
        TextView solutionText = (TextView) view.findViewById(R.id.solution_text_test);
        if (activity.getWinner() != null)
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

        return view;
    }

    public String getWinner()
    {
        MainActivity activity = ((MainActivity)getActivity());
        String solution = "";
        if (activity.getWinner() != null)
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
                solution = "KMI Bachelor";
                break;
            case IKT_MASTER:
                solution = "IKT Master oder IKT Master Englisch";
                break;
            case WI_BACHELOR:
                solution = "WI Bachelor";
                break;
            case DUAL_KMI_BACHELOR:
                solution = "Dualer KMI Bachelor";
                break;
            case JOB_KMI_BACHELOR:
                solution = "Berufsbegleitender KMI Bachelor";
                break;
            case DUAL_WI_BACHELOR:
                solution = "Dualer WI Bachelor";
                break;
            case DUAL_WI_MASTER:
                solution = "Dualer WI Master";
                break;
            case JOB_WI_BACHELOR:
                solution = "Berufsbegleitender WI Bachelor";
                break;
            case JOB_WI_MASTER:
                solution = "Berufsbegleitender WI Master";
                break;
            case IKT_BACHELOR:
                solution = "IKT Bachelor";
                break;
            case JOB_IKT_BACHELOR:
                solution = "Berufsbegleitender IKT Bachelor";
                break;
            case JOB_IKT_MASTER:
                solution = "Berufsbegleitender IKT Master";
                break;
            case DUAL_AI_BACHELOR:
                solution = "Dualer AI Bachelor";
                break;
        }
        return solution;
    }
}
