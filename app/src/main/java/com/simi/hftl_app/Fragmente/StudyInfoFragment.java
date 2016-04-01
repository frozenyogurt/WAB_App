package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * Created by student on 10.02.2016.
 */
public class StudyInfoFragment extends MyRefreshFragment
{
    public StudyInfoFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.study_info_fragment, container, false);

        final StudyListItem element = ((MainActivity) getActivity()).getClickedElement();
        TextView title = (TextView) view.findViewById(R.id.title_portrait);
        title.setText(element.getName());

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.TitleUndeline);
        LinearLayout websiteLink = (LinearLayout) view.findViewById(R.id.study_info_website_link);
        TextView websiteText = (TextView) view.findViewById(R.id.all_informations_link);
        TextView titleJob = (TextView) view.findViewById(R.id.jobPerspectivesTitle);
        TextView titleContent = (TextView) view.findViewById(R.id.study_content_title);
        titleContent.setText(getActivity().getResources().getString(R.string.STUDY_INFO_TITLE_CONTENT));

        TextView pointOne = (TextView) view.findViewById(R.id.study_info_first_point_text);
        TextView pointTwo = (TextView) view.findViewById(R.id.study_info_second_point_text);
        TextView pointThree = (TextView) view.findViewById(R.id.study_info_third_point_text);
        TextView pointFour = (TextView) view.findViewById(R.id.study_info_fourth_point_text);
        TextView pointFive = (TextView) view.findViewById(R.id.study_info_fifth_point_text);
        TextView pointSix = (TextView) view.findViewById(R.id.study_info_sixth_point_text);
        TextView pointSeven = (TextView) view.findViewById(R.id.study_info_seventh_point_text);

        ArrayList<TextView> pointViews = new ArrayList<>();
        pointViews.add(pointOne);
        pointViews.add(pointTwo);
        pointViews.add(pointThree);
        pointViews.add(pointFour);
        pointViews.add(pointFive);
        pointViews.add(pointSix);
        pointViews.add(pointSeven);

        if (element.getPoints().size() < 7)
        {
            pointSeven.setVisibility(View.GONE);
        }
        if (element.getPoints().size() < 6)
        {
            pointSix.setVisibility(View.GONE);
        }
        if (element.getPoints().size() < 5)
        {
            pointFive.setVisibility(View.GONE);
        }
        if (element.getPoints().size() < 4)
        {
            pointFour.setVisibility(View.GONE);
        }

        for(int i = 0; i < element.getPoints().size(); i++)
        {
            pointViews.get(i).setText(element.getPoints().get(i));
        }

        websiteText.setText("Alle Informationen");
        websiteLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).goToWebsite(element.getLink());
            }
        });

        int color = ((MainActivity) getActivity()).convertColorString();
        if (color != 0)
        {
            layout.setBackgroundColor(color);
            titleJob.setTextColor(color);
            titleContent.setTextColor(color);
        }
        else if (element.getCategory().equals(Category.NORMAL))
        {
            layout.setBackgroundColor(getActivity().getResources().getColor(R.color.study_color));
            titleJob.setTextColor(getActivity().getResources().getColor(R.color.study_color));
            titleContent.setTextColor(getActivity().getResources().getColor(R.color.study_color));
        }
        else if (element.getCategory().equals(Category.DUAL))
        {
            layout.setBackgroundColor(getActivity().getResources().getColor(R.color.study_dual_color));
            titleJob.setTextColor(getActivity().getResources().getColor(R.color.study_dual_color));
            titleContent.setTextColor(getActivity().getResources().getColor(R.color.study_dual_color));
        }
        else
        {
            layout.setBackgroundColor(getActivity().getResources().getColor(R.color.study_job_color));
            titleJob.setTextColor(getActivity().getResources().getColor(R.color.study_job_color));
            titleContent.setTextColor(getActivity().getResources().getColor(R.color.study_job_color));
        }

        TextView beginning = (TextView) view.findViewById(R.id.beginningText);
        TextView perspectives = (TextView) view.findViewById(R.id.jobPerspectivesText);
        //TextView curriculumText = (TextView) view.findViewById(R.id.curriculumText);

        if (element.getCourse().equals(StudyCourse.KMI_BACHELOR))
        {

            beginning.setText(getActivity().getResources().getString(R.string.KMI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.KMI_BACHELOR_PERSPECTIVES_TEXT));
            //curriculumText.setText(getActivity().getResources().getString(R.string.KMI_BACHELOR_CURRICULUM_TEXT));
    }
        else if (element.getCourse().equals(StudyCourse.DUAL_KMI_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.DUAL_KMI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.DUAL_KMI_BACHELOR_PERSPECTIVES_TEXT));
            //curriculumText.setText(getActivity().getResources().getString(R.string.DUAL_KMI_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.JOB_KMI_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.JOB_KMI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.JOB_KMI_BACHELOR_PERSPECTIVES_TEXT));
            //curriculumText.setText(getActivity().getResources().getString(R.string.JOB_KMI_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.IKT_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.IKT_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.IKT_BACHELOR_PERSPECTIVES_TEXT));
            //curriculumText.setText(getActivity().getResources().getString(R.string.IKT_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.IKT_MASTER))
        {
            beginning.setText(getActivity().getResources().getString(R.string.IKT_MASTER_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.IKT_MASTER_PERSPECTIVES_TEXT));
            //curriculumText.setText(getActivity().getResources().getString(R.string.IKT_MASTER_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.JOB_IKT_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.JOB_IKT_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.JOB_IKT_BACHELOR_PERSPECTIVES_TEXT));
            //curriculumText.setText(getActivity().getResources().getString(R.string.JOB_IKT_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.JOB_IKT_MASTER))
        {
            beginning.setText(getActivity().getResources().getString(R.string.JOB_IKT_MASTER_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.JOB_IKT_MASTER_PERSPECTIVES_TEXT));
            //curriculumText.setText(getActivity().getResources().getString(R.string.JOB_IKT_MASTER_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.WI_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.WI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.WI_BACHELOR_PERSPECTIVES_TEXT));
            //curriculumText.setText(getActivity().getResources().getString(R.string.WI_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.DUAL_WI_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_PERSPECTIVES_TEXT));
            //curriculumText.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.DUAL_WI_MASTER))
        {
            beginning.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_PERSPECTIVES_TEXT));
            //curriculumText.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.JOB_WI_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_PERSPECTIVES_TEXT));
            //curriculumText.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.JOB_WI_MASTER))
        {
            beginning.setText(getActivity().getResources().getString(R.string.JOB_WI_MASTER_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.JOB_WI_MASTER_PERSPECTIVES_TEXT));
            //curriculumText.setText(getActivity().getResources().getString(R.string.JOB_WI_MASTER_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.DUAL_AI_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.DUAL_AI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.DUAL_AI_BACHELOR_PERSPECTIVES_TEXT));
            //curriculumText.setText(getActivity().getResources().getString(R.string.DUAL_AI_BACHELOR_CURRICULUM_TEXT));
        }

        MainActivity activity = ((MainActivity)getActivity());
        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            titleJob.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            titleContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            websiteText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            beginning.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            perspectives.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            pointOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            pointTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            pointThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            pointFour.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            pointFive.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            pointSix.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            pointSeven.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            websiteText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            beginning.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            titleJob.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            titleContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            websiteText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            beginning.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            perspectives.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            pointOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            pointTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            pointThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            pointFour.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            pointFive.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            pointSix.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            pointSeven.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            websiteText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            beginning.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            titleJob.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            titleContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            websiteText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            beginning.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            perspectives.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            pointOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            pointTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            pointThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            pointFour.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            pointFive.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            pointSix.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            pointSeven.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            websiteText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            beginning.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
        }

        return view;
    }
}