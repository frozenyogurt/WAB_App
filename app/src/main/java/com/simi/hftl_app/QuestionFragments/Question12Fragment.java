package com.simi.hftl_app.QuestionFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.simi.hftl_app.Fragmente.MyRefreshFragment;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Question;
import com.simi.hftl_app.Model.TextSize;
import com.simi.hftl_app.R;

/**
 * Created by student on 17.02.2016.
 */
public class Question12Fragment extends MyRefreshFragment
{
    private Question currentQuestion;

    public Question12Fragment() {}

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
            currentQuestion = activity.getQuestions().get(11);
        }
        else
        {
            currentQuestion = new Question("Frage unbekannt");
        }

        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            questionOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
            questionTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
            questionThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
            questionFour.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
            questionFive.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
            questionName.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            questionOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
            questionTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
            questionThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
            questionFour.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
            questionFive.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
            questionName.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            questionOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
            questionTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
            questionThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
            questionFour.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
            questionFive.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
            questionName.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
        }

        int color = activity.convertColorString();
        if (color != 0)
        {
            questionOne.setButtonDrawable(R.drawable.checkbox_selector_magenta);
            questionTwo.setButtonDrawable(R.drawable.checkbox_selector_magenta);
            questionThree.setButtonDrawable(R.drawable.checkbox_selector_magenta);
            questionFour.setButtonDrawable(R.drawable.checkbox_selector_magenta);
            questionFive.setButtonDrawable(R.drawable.checkbox_selector_magenta);
        }
        else
        {
            questionOne.setButtonDrawable(R.drawable.checkbox_selector_green);
            questionTwo.setButtonDrawable(R.drawable.checkbox_selector_green);
            questionThree.setButtonDrawable(R.drawable.checkbox_selector_green);
            questionFour.setButtonDrawable(R.drawable.checkbox_selector_green);
            questionFive.setButtonDrawable(R.drawable.checkbox_selector_green);
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
