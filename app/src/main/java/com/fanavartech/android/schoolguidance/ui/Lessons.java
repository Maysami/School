package com.fanavartech.android.schoolguidance.ui;

import android.graphics.Color;

public class Lessons {

    private String lesson,color;

    public Lessons() {
    }

    public Lessons(String lesson, String color) {
        this.lesson = lesson;
        this.color = color;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Lessons{" +
                "lesson='" + lesson + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
