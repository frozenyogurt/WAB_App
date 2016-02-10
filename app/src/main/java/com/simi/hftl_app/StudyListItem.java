package com.simi.hftl_app;

/**
 * Created by student on 10.02.2016.
 */
public class StudyListItem
{
    private String name;
    private StudyCourse course;
    private Category category;
    private Degree studyDegree;
    private StudyType studyType;

    public StudyListItem(String name, StudyCourse course)
    {
        this.name = name;
        this.course = course;
        init();
    }

    private void init()
    {
        if (course.equals(StudyCourse.ICT_MASTER))
        {
            this.category = Category.NORMAL;
            this.studyDegree = Degree.MASTER;
            this.studyType = StudyType.ICT;
        }
        if (course.equals(StudyCourse.KMI_BACHELOR))
        {
            this.category = Category.NORMAL;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.KMI;
        }
        if (course.equals(StudyCourse.DUAL_KMI_BACHELOR))
        {
            this.category = Category.DUAL;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.KMI;
        }
        if (course.equals(StudyCourse.JOB_KMI_BACHELOR))
        {
            this.category = Category.JOB;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.KMI;
        }
        if (course.equals(StudyCourse.WI_BACHELOR))
        {
            this.category = Category.NORMAL;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.WI;
        }
        if (course.equals(StudyCourse.DUAL_WI_BACHELOR))
        {
            this.category = Category.DUAL;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.WI;
        }
        if (course.equals(StudyCourse.DUAL_WI_MASTER))
        {
            this.category = Category.DUAL;
            this.studyDegree = Degree.MASTER;
            this.studyType = StudyType.WI;
        }
        if (course.equals(StudyCourse.JOB_WI_BACHELOR))
        {
            this.category = Category.JOB;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.WI;
        }
        if (course.equals(StudyCourse.JOB_WI_MASTER))
        {
            this.category = Category.JOB;
            this.studyDegree = Degree.MASTER;
            this.studyType = StudyType.WI;
        }
        if (course.equals(StudyCourse.DUAL_AI_BACHELOR))
        {
            this.category = Category.DUAL;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.AI;
        }
        if (course.equals(StudyCourse.IKT_BACHELOR))
        {
            this.category = Category.NORMAL;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.IKT;
        }
        if (course.equals(StudyCourse.IKT_MASTER))
        {
            this.category = Category.NORMAL;
            this.studyDegree = Degree.MASTER;
            this.studyType = StudyType.IKT;
        }
        if (course.equals(StudyCourse.JOB_IKT_BACHELOR))
        {
            this.category = Category.JOB;
            this.studyDegree = Degree.BACHELOR;
            this.studyType = StudyType.IKT;
        }
        if (course.equals(StudyCourse.JOB_IKT_MASTER))
        {
            this.category = Category.JOB;
            this.studyDegree = Degree.MASTER;
            this.studyType = StudyType.IKT;
        }
        if (course.equals(StudyCourse.IKT_MASTER_ENGLISH))
        {
            this.category = Category.NORMAL;
            this.studyDegree = Degree.MASTER;
            this.studyType = StudyType.IKT;
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
}
