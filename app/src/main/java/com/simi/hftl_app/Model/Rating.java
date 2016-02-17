package com.simi.hftl_app.Model;

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
    private int ICTPoints;
    private int AIPoints;

    public Rating() {}

    public StudyCourse getWinner()
    {
        return StudyCourse.DUAL_KMI_BACHELOR;
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

    public int getICTPoints() {
        return ICTPoints;
    }

    public void setICTPoints(int ICTPoints) {
        this.ICTPoints = ICTPoints;
    }

    public int getAIPoints() {
        return AIPoints;
    }

    public void setAIPoints(int AIPoints) {
        this.AIPoints = AIPoints;
    }
}
