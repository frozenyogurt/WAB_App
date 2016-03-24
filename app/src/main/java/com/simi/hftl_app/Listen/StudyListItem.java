package com.simi.hftl_app.Listen;

import android.app.Activity;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Category;
import com.simi.hftl_app.Model.Degree;
import com.simi.hftl_app.Model.StudyCourse;
import com.simi.hftl_app.Model.StudyType;
import com.simi.hftl_app.R;

/**
 * Created by student on 10.02.2016.
 */
public class StudyListItem
{
    private String name;
    private String link;
    private StudyCourse course;
    private Category category;
    private Degree studyDegree;
    private StudyType studyType;
    private Activity activity;

    public StudyListItem(MainActivity activity, StudyCourse course)
    {
        this.course = course;
        this.activity = activity;
        init();
    }

    private void init()
    {
        if (course.equals(StudyCourse.KMI_BACHELOR))
        {
            this.name = activity.getResources().getString(R.string.KMI_BACHELOR_NAME);
            this.category = Category.NORMAL;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.KMI;
            this.link = "https://www.hft-leipzig.de/de/studiengaenge-end/direktstudium/kmi-bachelor.html";
        }
        if (course.equals(StudyCourse.DUAL_KMI_BACHELOR))
        {
            this.name = activity.getResources().getString(R.string.KMI_BACHELOR_NAME);
            this.category = Category.DUAL;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.KMI;
            this.link = "https://www.hft-leipzig.de/de/studiengaenge-end/duales-studium/kmi-bachelor-dual.html";
        }
        if (course.equals(StudyCourse.JOB_KMI_BACHELOR))
        {
            this.name = activity.getResources().getString(R.string.KMI_BACHELOR_NAME);
            this.category = Category.JOB;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.KMI;
            this.link = "https://www.hft-leipzig.de/de/studiengaenge-end/berufsbegleitendes-studium/kmi-bachelor-berufsbegleitend.html";
        }
        if (course.equals(StudyCourse.WI_BACHELOR))
        {
            this.name = activity.getResources().getString(R.string.WI_BACHELOR_NAME);
            this.category = Category.NORMAL;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.WI;
            this.link = "https://www.hft-leipzig.de/de/studiengaenge-end/direktstudium/wi-bachelor.html";
        }
        if (course.equals(StudyCourse.DUAL_WI_BACHELOR))
        {
            this.name = activity.getResources().getString(R.string.WI_BACHELOR_NAME);
            this.category = Category.DUAL;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.WI;
            this.link = "https://www.hft-leipzig.de/de/studiengaenge-end/duales-studium/wi-bachelor-dual.html";
        }
        if (course.equals(StudyCourse.DUAL_WI_MASTER))
        {
            this.name = activity.getResources().getString(R.string.WI_MASTER_NAME);
            this.category = Category.DUAL;
            this.studyDegree = Degree.MASTER;
            this.studyType = StudyType.WI;
            this.link = "https://www.hft-leipzig.de/de/studiengaenge-end/duales-studium/wi-master-dual.html";
        }
        if (course.equals(StudyCourse.JOB_WI_BACHELOR))
        {
            this.name = activity.getResources().getString(R.string.WI_BACHELOR_NAME);
            this.category = Category.JOB;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.WI;
            this.link = "https://www.hft-leipzig.de/de/studiengaenge-end/berufsbegleitendes-studium/wi-bachelor-berufsbegleitend.html";
        }
        if (course.equals(StudyCourse.JOB_WI_MASTER))
        {
            this.name = activity.getResources().getString(R.string.WI_MASTER_NAME);
            this.category = Category.JOB;
            this.studyDegree = Degree.MASTER;
            this.studyType = StudyType.WI;
            this.link = "https://www.hft-leipzig.de/de/studiengaenge-end/berufsbegleitendes-studium/wi-master-berufsbegleitend.html";
        }
        if (course.equals(StudyCourse.DUAL_AI_BACHELOR))
        {
            this.name = activity.getResources().getString(R.string.AI_BACHELOR_NAME);
            this.category = Category.DUAL;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.AI;
            this.link = "https://www.hft-leipzig.de/de/studiengaenge-end/duales-studium/ai-bachelor-dual.html";
        }
        if (course.equals(StudyCourse.IKT_BACHELOR))
        {
            this.name = activity.getResources().getString(R.string.IKT_BACHELOR_NAME);
            this.category = Category.NORMAL;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.IKT;
            this.link = "https://www.hft-leipzig.de/de/studiengaenge-end/direktstudium/ikt-bachelor.html";
        }
        if (course.equals(StudyCourse.IKT_MASTER))
        {
            this.name = activity.getResources().getString(R.string.IKT_MASTER_NAME);
            this.category = Category.NORMAL;
            this.studyDegree = Degree.MASTER;
            this.studyType = StudyType.IKT;
            this.link = "https://www.hft-leipzig.de/de/studiengaenge-end/direktstudium/ikt-master.html";
        }
        if (course.equals(StudyCourse.JOB_IKT_BACHELOR))
        {
            this.name = activity.getResources().getString(R.string.IKT_BACHELOR_NAME);
            this.category = Category.JOB;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.IKT;
            this.link = "https://www.hft-leipzig.de/de/studiengaenge-aktuelle-daten/berufsbegleitendes-studium/ikt-bachelor-berufsbegleitend.html";
        }
        if (course.equals(StudyCourse.JOB_IKT_MASTER))
        {
            this.name = activity.getResources().getString(R.string.IKT_MASTER_NAME);
            this.category = Category.JOB;
            this.studyDegree = Degree.MASTER;
            this.studyType = StudyType.IKT;
            this.link = "https://www.hft-leipzig.de/de/studiengaenge-end/berufsbegleitendes-studium/ikt-master-berufsbegleitend.html";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudyCourse getCourse() {
        return course;
    }

    public void setCourse(StudyCourse course) {
        this.course = course;
    }

    public Category getCategory()
    {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Degree getStudyDegree() {
        return studyDegree;
    }

    public void setStudyDegree(Degree studyDegree) {
        this.studyDegree = studyDegree;
    }

    public StudyType getStudyType() {
        return studyType;
    }

    public void setStudyType(StudyType studyType) {
        this.studyType = studyType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
