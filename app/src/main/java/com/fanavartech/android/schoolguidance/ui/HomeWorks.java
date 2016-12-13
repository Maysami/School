package com.fanavartech.android.schoolguidance.ui;


public class HomeWorks {
    private String typeHomeWork,deadlineDate ,urlDownloadTask ;

    public HomeWorks() {
    }

    public HomeWorks(String typeHomeWork, String deadlineDate, String urlDownloadTask) {
        this.typeHomeWork = typeHomeWork;
        this.deadlineDate = deadlineDate;
        this.urlDownloadTask = urlDownloadTask;
    }

    public String getTypeHomeWork() {
        return typeHomeWork;
    }

    public void setTypeHomeWork(String typeHomeWork) {
        this.typeHomeWork = typeHomeWork;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getUrlDownloadTask() {
        return urlDownloadTask;
    }

    public void setUrlDownloadTask(String urlDownloadTask) {
        this.urlDownloadTask = urlDownloadTask;
    }

    @Override
    public String toString() {
        return "HomeWorks{" +
                "typeHomeWork='" + typeHomeWork + '\'' +
                ", deadlineDate='" + deadlineDate + '\'' +
                ", urlDownloadTask='" + urlDownloadTask + '\'' +
                '}';
    }
}
