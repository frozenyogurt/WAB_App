package com.simi.hftl_app.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 17.02.2016.
 */
public class Rating
{
    private int dualPoints;
    private int directPoints;
    private int jobPoints;
    private int KMIPoints;
    private int WIPoints;
    private int IKTPoints;
    private int AIPoints;
    private int bachelorPoints;
    private int masterPoints;
    private ArrayList<RatingCategory> winners = new ArrayList<>();

    public Rating() {}

    public ArrayList<StudyCourse> getWinner()
    {
        LinkedHashMap<RatingCategory, Integer> sortedCategoryPoints = sortByValue(getCategoryRatingMap());
        LinkedHashMap<RatingCategory, Integer> sortedDegreePoints = sortByValue(getDregreeRatingMap());
        LinkedHashMap<RatingCategory, Integer> sortedStudyPoints = sortByValue(getStudyRatingMap());

        winners.add((RatingCategory) sortedCategoryPoints.keySet().toArray()[0]);
        winners.add((RatingCategory) sortedDegreePoints.keySet().toArray()[0]);
        winners.add((RatingCategory) sortedStudyPoints.keySet().toArray()[0]);
        if (sortedDegreePoints.get(RatingCategory.BACHELOR).equals(sortedDegreePoints.get(RatingCategory.MASTER)))
        {
            if (getDegreeStudyCourses().size() != 0)
            {
                return getDegreeStudyCourses();
            }
        }

        return getWinnerStudyCourse(winners);
    }

    public StudyCourse getAlternative()
    {
        if (winners.get(0).equals(RatingCategory.DUAL))
        {
            if (winners.get(1).equals(RatingCategory.BACHELOR))
            {
                if (winners.get(2).equals(RatingCategory.IKT))
                {
                    return StudyCourse.IKT_BACHELOR;
                }
            }
            else if (winners.get(1).equals(RatingCategory.MASTER))
            {
                if (winners.get(2).equals(RatingCategory.KMI))
                {
                    return StudyCourse.JOB_IKT_MASTER;
                }
                else if (winners.get(2).equals(RatingCategory.AI))
                {
                    return StudyCourse.JOB_IKT_MASTER;
                }
                else if (winners.get(2).equals(RatingCategory.IKT))
                {
                    return StudyCourse.JOB_IKT_MASTER;
                }
            }
        }
        else if (winners.get(0).equals(RatingCategory.DIRECT))
        {
            if (winners.get(1).equals(RatingCategory.BACHELOR))
            {
                if (winners.get(2).equals(RatingCategory.AI))
                {
                    return StudyCourse.KMI_BACHELOR;
                }
            }
            else if (winners.get(1).equals(RatingCategory.MASTER))
            {
                if (winners.get(2).equals(RatingCategory.KMI))
                {
                    return StudyCourse.IKT_MASTER;
                }
                else if (winners.get(2).equals(RatingCategory.AI))
                {
                    return StudyCourse.IKT_MASTER;
                }
                else if (winners.get(2).equals(RatingCategory.WI))
                {
                    return StudyCourse.WI_BACHELOR;
                }
            }
        }
        else if (winners.get(0).equals(RatingCategory.JOB))
        {
            if (winners.get(1).equals(RatingCategory.BACHELOR))
            {
                if (winners.get(2).equals(RatingCategory.AI))
                {
                    return StudyCourse.DUAL_AI_BACHELOR;
                }
            }
            else if (winners.get(1).equals(RatingCategory.MASTER))
            {
                if (winners.get(2).equals(RatingCategory.KMI))
                {
                    return StudyCourse.JOB_IKT_MASTER;
                }
                else if (winners.get(2).equals(RatingCategory.AI))
                {
                    return StudyCourse.JOB_IKT_MASTER;
                }
            }
        }
        return null;
    }

    private ArrayList<StudyCourse> getDegreeStudyCourses()
    {
        ArrayList<StudyCourse> courses = new ArrayList<>();
        if (winners.get(0).equals(RatingCategory.DUAL))
        {
            if (winners.get(2).equals(RatingCategory.WI))
            {
                courses.add(StudyCourse.DUAL_WI_BACHELOR);
                courses.add(StudyCourse.DUAL_WI_MASTER);
            }
        }
        else if (winners.get(0).equals(RatingCategory.DIRECT))
        {
            if (winners.get(2).equals(RatingCategory.IKT))
            {
                courses.add(StudyCourse.IKT_BACHELOR);
                courses.add(StudyCourse.IKT_MASTER);
            }
        }
        else if (winners.get(0).equals(RatingCategory.JOB))
        {
            if (winners.get(2).equals(RatingCategory.IKT))
            {
                courses.add(StudyCourse.JOB_IKT_BACHELOR);
                courses.add(StudyCourse.JOB_IKT_MASTER);
            }
            else if (winners.get(2).equals(RatingCategory.WI))
            {
                courses.add(StudyCourse.JOB_WI_BACHELOR);
                courses.add(StudyCourse.JOB_WI_MASTER);
            }
        }
        return courses;
    }

    private ArrayList<StudyCourse> getWinnerStudyCourse(ArrayList<RatingCategory> winners)
    {
        ArrayList<StudyCourse> courses = new ArrayList<>();

        if (winners.get(0).equals(RatingCategory.DUAL))
        {
            if (winners.get(1).equals(RatingCategory.BACHELOR))
            {
                if (winners.get(2).equals(RatingCategory.KMI))
                {
                    courses.add(StudyCourse.DUAL_KMI_BACHELOR);
                }
                else if (winners.get(2).equals(RatingCategory.WI))
                {
                    courses.add(StudyCourse.DUAL_WI_BACHELOR);
                }
                else if (winners.get(2).equals(RatingCategory.AI))
                {
                    courses.add(StudyCourse.DUAL_AI_BACHELOR);
                }
            }
            else if (winners.get(1).equals(RatingCategory.MASTER))
            {
                if (winners.get(2).equals(RatingCategory.WI))
                {
                    courses.add(StudyCourse.DUAL_WI_MASTER);
                }
            }
        }
        else if (winners.get(0).equals(RatingCategory.JOB))
        {
            if (winners.get(1).equals(RatingCategory.BACHELOR))
            {
                if (winners.get(2).equals(RatingCategory.IKT))
                {
                    courses.add(StudyCourse.JOB_IKT_BACHELOR);
                }
                else if (winners.get(2).equals(RatingCategory.KMI))
                {
                    courses.add(StudyCourse.JOB_KMI_BACHELOR);
                }
                else if (winners.get(2).equals(RatingCategory.WI))
                {
                    courses.add(StudyCourse.JOB_WI_BACHELOR);
                }
            }
            else if (winners.get(1).equals(RatingCategory.MASTER))
            {
                if (winners.get(2).equals(RatingCategory.IKT))
                {
                    courses.add(StudyCourse.JOB_IKT_MASTER);
                }
                else if (winners.get(2).equals(RatingCategory.WI))
                {
                    courses.add(StudyCourse.JOB_WI_MASTER);
                }
            }
        }
        else if (winners.get(0).equals(RatingCategory.DIRECT))
        {
            if (winners.get(1).equals(RatingCategory.BACHELOR))
            {
                if (winners.get(2).equals(RatingCategory.KMI))
                {
                    courses.add(StudyCourse.KMI_BACHELOR);
                }
                else if (winners.get(2).equals(RatingCategory.WI))
                {
                    courses.add(StudyCourse.WI_BACHELOR);
                }
                else if (winners.get(2).equals(RatingCategory.IKT))
                {
                    courses.add(StudyCourse.IKT_BACHELOR);
                }
            }
            else if (winners.get(1).equals(RatingCategory.MASTER))
            {
                if (winners.get(2).equals(RatingCategory.IKT))
                {
                    courses.add(StudyCourse.IKT_MASTER);
                }
            }
        }
        return null;
    }

    public static <K, V extends Comparable<? super V>> LinkedHashMap<K, V> sortByValue( HashMap<K, V> map )
    {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<K, V>>()
        {
            public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 )
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        } );

        LinkedHashMap<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list)
        {
            result.put( entry.getKey(), entry.getValue() );
        }
        return result;
    }

    public static HashMap<RatingCategory, Integer> getInitializedRatingMap(int dualPoints, int directPoints, int jobPoints,
                                                                           int KMIPoints, int WIPoints, int IKTPoints,
                                                                           int AIPoints, int bachelorPoints, int masterPoints)
    {
        HashMap<RatingCategory, Integer> points = new HashMap<>();
        points.put(RatingCategory.DUAL, dualPoints);
        points.put(RatingCategory.DIRECT, directPoints);
        points.put(RatingCategory.JOB, jobPoints);
        points.put(RatingCategory.BACHELOR, bachelorPoints);
        points.put(RatingCategory.MASTER, masterPoints);
        points.put(RatingCategory.WI, WIPoints);
        points.put(RatingCategory.KMI, KMIPoints);
        points.put(RatingCategory.IKT, IKTPoints);
        points.put(RatingCategory.AI, AIPoints);
        return points;
    }

    public HashMap<RatingCategory, Integer> getCategoryRatingMap()
    {
        HashMap<RatingCategory, Integer> points = new HashMap<>();
        points.put(RatingCategory.DUAL, dualPoints);
        points.put(RatingCategory.DIRECT, directPoints);
        points.put(RatingCategory.JOB, jobPoints);
        return points;
    }

    public HashMap<RatingCategory, Integer> getDregreeRatingMap()
    {
        HashMap<RatingCategory, Integer> points = new HashMap<>();
        points.put(RatingCategory.BACHELOR, bachelorPoints);
        points.put(RatingCategory.MASTER, masterPoints);
        return points;
    }

    private HashMap<RatingCategory, Integer> getStudyRatingMap()
    {
        HashMap<RatingCategory, Integer> points = new HashMap<>();
        points.put(RatingCategory.WI, WIPoints);
        points.put(RatingCategory.KMI, KMIPoints);
        points.put(RatingCategory.IKT, IKTPoints);
        points.put(RatingCategory.AI, AIPoints);
        return points;
    }

    public int getDualPoints() {
        return dualPoints;
    }

    public void setDualPoints(int dualPoints) {
        this.dualPoints = dualPoints;
    }

    public int getDirectPoints() {
        return directPoints;
    }

    public void setDirectPoints(int directPoints) {
        this.directPoints = directPoints;
    }

    public int getJobPoints() {
        return jobPoints;
    }

    public void setJobPoints(int jobPoints) {
        this.jobPoints = jobPoints;
    }

    public int getKMIPoints() {
        return KMIPoints;
    }

    public void setKMIPoints(int KMIPoints) {
        this.KMIPoints = KMIPoints;
    }

    public int getWIPoints() {
        return WIPoints;
    }

    public void setWIPoints(int WIPoints) {
        this.WIPoints = WIPoints;
    }

    public int getIKTPoints() {
        return IKTPoints;
    }

    public void setIKTPoints(int IKTPoints) {
        this.IKTPoints = IKTPoints;
    }

    public int getAIPoints() {
        return AIPoints;
    }

    public void setAIPoints(int AIPoints) {
        this.AIPoints = AIPoints;
    }

    public int getBachelorPoints() {
        return bachelorPoints;
    }

    public void setBachelorPoints(int bachelorPoints) {
        this.bachelorPoints = bachelorPoints;
    }

    public int getMasterPoints() {
        return masterPoints;
    }

    public void setMasterPoints(int masterPoints) {
        this.masterPoints = masterPoints;
    }
}
