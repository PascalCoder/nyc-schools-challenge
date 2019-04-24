package com.example.nycschoolschallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SchoolPojo {

    @SerializedName("school_name")
    @Expose
    private String schoolName;

    @SerializedName("academicopportunities1")
    @Expose
    private String academicOpportunities1;

    @SerializedName("academicopportunities2")
    @Expose
    private String academicOpportunities2;

    @SerializedName("admissionspriority11")
    @Expose
    private String admissionsPriority11;

    @SerializedName("overview_paragraph")
    @Expose
    private String overviewParagraph;

    public SchoolPojo() { }

    public SchoolPojo(String schoolName, String academicOpportunities1, String academicOpportunities2, String admissionsPriority11) {
        this.schoolName = schoolName;
        this.academicOpportunities1 = academicOpportunities1;
        this.academicOpportunities2 = academicOpportunities2;
        this.admissionsPriority11 = admissionsPriority11;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAcademicOpportunities1() {
        return academicOpportunities1;
    }

    public void setAcademicOpportunities1(String academicOpportunities1) {
        this.academicOpportunities1 = academicOpportunities1;
    }

    public String getAcademicOpportunities2() {
        return academicOpportunities2;
    }

    public void setAcademicOpportunities2(String academicOpportunities2) {
        this.academicOpportunities2 = academicOpportunities2;
    }

    public String getAdmissionsPriority11() {
        return admissionsPriority11;
    }

    public void setAdmissionsPriority11(String admissionsPriority11) {
        this.admissionsPriority11 = admissionsPriority11;
    }

    public String getOverviewParagraph() {
        return overviewParagraph;
    }

    public void setOverviewParagraph(String overviewParagraph) {
        this.overviewParagraph = overviewParagraph;
    }
}
