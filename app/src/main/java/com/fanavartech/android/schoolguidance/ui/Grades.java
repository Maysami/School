package com.fanavartech.android.schoolguidance.ui;

/**
 * Created by Seven on 12/13/2016.
 */
public class Grades {

    private String valueDate, scoreExam, typeExam, status;

    public Grades() {
    }

    public Grades(String valueDate, String scoreExam, String typeExam, String status) {
        this.valueDate = valueDate;
        this.scoreExam = scoreExam;
        this.typeExam = typeExam;
        this.status = status;
    }


    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getScoreExam() {
        return scoreExam;
    }

    public void setScoreExam(String scoreExam) {
        this.scoreExam = scoreExam;
    }

    public String getTypeExam() {
        return typeExam;
    }

    public void setTypeExam(String typeExam) {
        this.typeExam = typeExam;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "valueDate='" + valueDate + '\'' +
                ", scoreExam='" + scoreExam + '\'' +
                ", typeExam='" + typeExam + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
