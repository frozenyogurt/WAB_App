package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.Listen.StudyListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Category;
import com.simi.hftl_app.Model.StudyCourse;
import com.simi.hftl_app.R;

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

        StudyListItem element = ((MainActivity) getActivity()).getClickedElement();
        TextView title = (TextView) view.findViewById(R.id.infoStudyTitle);
        title.setText(element.getName());

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.TitleUndeline);
        TextView titleJob = (TextView) view.findViewById(R.id.jobPerspectivesTitle);
        TextView titleCurri = (TextView) view.findViewById(R.id.curriculumTitle);
        if (element.getCategory().equals(Category.NORMAL))
        {
            layout.setBackgroundColor(getActivity().getResources().getColor(R.color.study_color));
            titleJob.setTextColor(getActivity().getResources().getColor(R.color.study_color));
            titleCurri.setTextColor(getActivity().getResources().getColor(R.color.study_color));
        }
        else if (element.getCategory().equals(Category.DUAL))
        {
            layout.setBackgroundColor(getActivity().getResources().getColor(R.color.study_dual_color));
            titleJob.setTextColor(getActivity().getResources().getColor(R.color.study_dual_color));
            titleCurri.setTextColor(getActivity().getResources().getColor(R.color.study_dual_color));
        }
        else
        {
            layout.setBackgroundColor(getActivity().getResources().getColor(R.color.study_job_color));
            titleJob.setTextColor(getActivity().getResources().getColor(R.color.study_job_color));
            titleCurri.setTextColor(getActivity().getResources().getColor(R.color.study_job_color));
        }

        TextView beginning = (TextView) view.findViewById(R.id.beginningText);
        TextView perspectives = (TextView) view.findViewById(R.id.jobPerspectivesText);
        TextView curriculumText = (TextView) view.findViewById(R.id.curriculumText);

        /*if (element.getCourse().equals(StudyCourse.ICT_MASTER)) //???????????????????????????????????
        {
            beginning.setText(getActivity().getResources().getString(R.string.ICT_MASTER_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.ICT_MASTER_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.ICT_MASTER_CURRICULUM_TEXT));
        }**/
        if (element.getCourse().equals(StudyCourse.KMI_BACHELOR))
        {

            beginning.setText(getActivity().getResources().getString(R.string.KMI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.KMI_BACHELOR_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.KMI_BACHELOR_CURRICULUM_TEXT));
    }
        else if (element.getCourse().equals(StudyCourse.DUAL_KMI_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.DUAL_KMI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.DUAL_KMI_BACHELOR_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.DUAL_KMI_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.JOB_KMI_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.JOB_KMI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.JOB_KMI_BACHELOR_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.JOB_KMI_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.IKT_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.IKT_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.IKT_BACHELOR_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.IKT_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.IKT_MASTER))
        {
            beginning.setText(getActivity().getResources().getString(R.string.IKT_MASTER_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.IKT_MASTER_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.IKT_MASTER_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.IKT_MASTER_ENGLISH)) //Passt hier nicht rein!
        {
            beginning.setText("");
            perspectives.setText("");
            curriculumText.setText("");
        }
        else if (element.getCourse().equals(StudyCourse.JOB_IKT_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.JOB_IKT_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.JOB_IKT_BACHELOR_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.JOB_IKT_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.JOB_IKT_MASTER))
        {
            beginning.setText(getActivity().getResources().getString(R.string.JOB_IKT_MASTER_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.JOB_IKT_MASTER_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.JOB_IKT_MASTER_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.WI_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.WI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.WI_BACHELOR_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.WI_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.DUAL_WI_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.DUAL_WI_MASTER))
        {
            beginning.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.JOB_WI_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.DUAL_WI_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.JOB_WI_MASTER))
        {
            beginning.setText(getActivity().getResources().getString(R.string.JOB_WI_MASTER_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.JOB_WI_MASTER_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.JOB_WI_MASTER_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.DUAL_AI_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.DUAL_AI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.DUAL_AI_BACHELOR_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.DUAL_AI_BACHELOR_CURRICULUM_TEXT));
        }

        return view;
    }
}