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
import com.simi.hftl_app.Model.Rating;
import com.simi.hftl_app.R;

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

        TextView solutionText = (TextView) view.findViewById(R.id.solution_text_test);
        solutionText.setText("Du solltest dich für folgenden Studiengang entscheiden:");

        TextView result = (TextView) view.findViewById(R.id.result_test);
        result.setText(getWinner());

        return view;
    }

    public String getWinner()
    {
        Rating rating = new Rating();
        return "keinen";
    }
}
