package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Question;
import com.simi.hftl_app.R;

/**
 * Created by student on 17.02.2016.
 */
public class QuestionFragment extends MyRefreshFragment
{
    private Question currentQuestion;

    public QuestionFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.question_fragment, container, false);

        TextView questionName = (TextView) view.findViewById(R.id.question_name);
        final CheckBox answerOne = (CheckBox) view.findViewById(R.id.answer_one);
        final CheckBox answerTwo = (CheckBox) view.findViewById(R.id.answer_two);
        final CheckBox answerThree = (CheckBox) view.findViewById(R.id.answer_three);
        final CheckBox answerFour = (CheckBox) view.findViewById(R.id.answer_four);
        final CheckBox answerFive = (CheckBox) view.findViewById(R.id.answer_five);

        MainActivity activity = ((MainActivity)getActivity());
        currentQuestion = activity.getQuestions().get(activity.getCurrentViewPagerItem());
        questionName.setText(currentQuestion.getQuestionName());
        for (int i = 0; i < currentQuestion.getAnswers().size(); i++)
        {
            if (i == 0)
            {
                answerOne.setText(currentQuestion.getAnswers().get(0).getAnswerName());
                answerOne.setChecked(currentQuestion.getAnswers().get(0).isSet());
            }
            if (i == 1)
            {
                answerTwo.setText(currentQuestion.getAnswers().get(1).getAnswerName());
                answerOne.setChecked(currentQuestion.getAnswers().get(1).isSet());
            }
            if (i == 2)
            {
                answerThree.setText(currentQuestion.getAnswers().get(2).getAnswerName());
                answerOne.setChecked(currentQuestion.getAnswers().get(2).isSet());
            }
            if (i == 3)
            {
                answerFour.setText(currentQuestion.getAnswers().get(3).getAnswerName());
                answerOne.setChecked(currentQuestion.getAnswers().get(3).isSet());
            }
            if (i == 4)
            {
                answerFive.setText(currentQuestion.getAnswers().get(4).getAnswerName());
                answerOne.setChecked(currentQuestion.getAnswers().get(4).isSet());
            }
        }

        int length = currentQuestion.getAnswers().size();
        if (length == 4)
        {
            answerFive.setVisibility(View.GONE);
        }
        else if (length == 3)
        {
            answerFive.setVisibility(View.GONE);
            answerFour.setVisibility(View.GONE);
        }
        else if (length == 2)
        {
            answerFive.setVisibility(View.GONE);
            answerFour.setVisibility(View.GONE);
            answerThree.setVisibility(View.GONE);
        }

        answerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerOne.isChecked()) {
                    ((MainActivity) getActivity()).setAnswerActive(1, currentQuestion.getQuestionName(), true);
                    answerTwo.setChecked(false);
                    answerThree.setChecked(false);
                    answerFour.setChecked(false);
                    answerFive.setChecked(false);
                } else {
                    ((MainActivity) getActivity()).setAnswerActive(1, currentQuestion.getQuestionName(), false);
                }
            }
        });

        answerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerTwo.isChecked()) {
                    ((MainActivity) getActivity()).setAnswerActive(2, currentQuestion.getQuestionName(), true);
                    answerOne.setChecked(false);
                    answerThree.setChecked(false);
                    answerFour.setChecked(false);
                    answerFive.setChecked(false);
                } else {
                    ((MainActivity) getActivity()).setAnswerActive(1, currentQuestion.getQuestionName(), false);
                }
            }
        });

        answerThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerThree.isChecked()) {
                    ((MainActivity) getActivity()).setAnswerActive(3, currentQuestion.getQuestionName(), true);
                    answerTwo.setChecked(false);
                    answerOne.setChecked(false);
                    answerFour.setChecked(false);
                    answerFive.setChecked(false);
                } else {
                    ((MainActivity) getActivity()).setAnswerActive(1, currentQuestion.getQuestionName(), false);
                }
            }
        });

        answerFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerFour.isChecked()) {
                    ((MainActivity) getActivity()).setAnswerActive(4, currentQuestion.getQuestionName(), true);
                    answerTwo.setChecked(false);
                    answerThree.setChecked(false);
                    answerOne.setChecked(false);
                    answerFive.setChecked(false);
                } else {
                    ((MainActivity) getActivity()).setAnswerActive(1, currentQuestion.getQuestionName(), false);
                }
            }
        });

        answerFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerFive.isChecked()) {
                    ((MainActivity) getActivity()).setAnswerActive(5, currentQuestion.getQuestionName(), true);
                    answerTwo.setChecked(false);
                    answerThree.setChecked(false);
                    answerOne.setChecked(false);
                    answerFour.setChecked(false);
                } else {
                    ((MainActivity) getActivity()).setAnswerActive(1, currentQuestion.getQuestionName(), false);
                }
            }
        });

        return view;
    }
}
