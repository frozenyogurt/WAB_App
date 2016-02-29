package com.simi.hftl_app.QuestionFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.simi.hftl_app.Fragmente.MyRefreshFragment;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Question;
import com.simi.hftl_app.R;

/**
 * Created by student on 17.02.2016.
 */
public class Question11Fragment extends MyRefreshFragment
{
    private Question currentQuestion;

    public Question11Fragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.question_fragment, container, false);

        TextView questionName = (TextView) view.findViewById(R.id.question_name);
        final CheckBox questionOne = (CheckBox) view.findViewById(R.id.answer_one);
        final CheckBox questionTwo = (CheckBox) view.findViewById(R.id.answer_two);
        final CheckBox questionThree = (CheckBox) view.findViewById(R.id.answer_three);
        final CheckBox questionFour = (CheckBox) view.findViewById(R.id.answer_four);
        final CheckBox questionFive = (CheckBox) view.findViewById(R.id.answer_five);

        MainActivity activity = ((MainActivity)getActivity());
        if (activity.getQuestions().size() != 0)
        {
            currentQuestion = activity.getQuestions().get(10);
        }
        else
        {
            currentQuestion = new Question("Frage unbekannt");
        }
        questionName.setText(currentQuestion.getQuestionName());
        for (int i = 0; i < currentQuestion.getAnswers().size(); i++)
        {
            if (i == 0)
            {
                questionOne.setText(currentQuestion.getAnswers().get(0).getAnswerName());
            }
            if (i == 1)
            {
                questionTwo.setText(currentQuestion.getAnswers().get(1).getAnswerName());
            }
            if (i == 2)
            {
                questionThree.setText(currentQuestion.getAnswers().get(2).getAnswerName());
            }
            if (i == 3)
            {
                questionFour.setText(currentQuestion.getAnswers().get(3).getAnswerName());
            }
            if (i == 4)
            {
                questionFive.setText(currentQuestion.getAnswers().get(4).getAnswerName());
            }
        }

        int length = currentQuestion.getAnswers().size();
        if (length == 4)
        {
            questionFive.setVisibility(View.GONE);
        }
        else if (length == 3)
        {
            questionFive.setVisibility(View.GONE);
            questionFour.setVisibility(View.GONE);
        }
        else if (length == 2)
        {
            questionFive.setVisibility(View.GONE);
            questionFour.setVisibility(View.GONE);
            questionThree.setVisibility(View.GONE);
        }

        questionOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionOne.isChecked())
                {
                    ((MainActivity)getActivity()).setAnswerActive(1, currentQuestion.getQuestionName(), true);
                    questionTwo.setChecked(false);
                    questionThree.setChecked(false);
                    questionFour.setChecked(false);
                    questionFive.setChecked(false);
                }
                else
                {
                    ((MainActivity)getActivity()).setAnswerActive(1, currentQuestion.getQuestionName(), false);
                }

            }
        });

        questionTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionTwo.isChecked())
                {
                    ((MainActivity)getActivity()).setAnswerActive(2, currentQuestion.getQuestionName(), true);
                    questionOne.setChecked(false);
                    questionThree.setChecked(false);
                    questionFour.setChecked(false);
                    questionFive.setChecked(false);
                }
                else
                {
                    ((MainActivity)getActivity()).setAnswerActive(1, currentQuestion.getQuestionName(), false);
                }
            }
        });

        questionThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionThree.isChecked())
                {
                    ((MainActivity)getActivity()).setAnswerActive(3, currentQuestion.getQuestionName(), true);
                    questionTwo.setChecked(false);
                    questionOne.setChecked(false);
                    questionFour.setChecked(false);
                    questionFive.setChecked(false);
                }
                else
                {
                    ((MainActivity)getActivity()).setAnswerActive(1, currentQuestion.getQuestionName(), false);
                }
            }
        });

        questionFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionFour.isChecked())
                {
                    ((MainActivity)getActivity()).setAnswerActive(4, currentQuestion.getQuestionName(), true);
                    questionTwo.setChecked(false);
                    questionThree.setChecked(false);
                    questionOne.setChecked(false);
                    questionFive.setChecked(false);
                }
                else
                {
                    ((MainActivity)getActivity()).setAnswerActive(1, currentQuestion.getQuestionName(), false);
                }
            }
        });

        questionFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionFive.isChecked())
                {
                    ((MainActivity)getActivity()).setAnswerActive(5, currentQuestion.getQuestionName(), true);
                    questionTwo.setChecked(false);
                    questionThree.setChecked(false);
                    questionOne.setChecked(false);
                    questionFour.setChecked(false);
                }
                else
                {
                    ((MainActivity)getActivity()).setAnswerActive(1, currentQuestion.getQuestionName(), false);
                }
            }
        });

        return view;
    }
}
