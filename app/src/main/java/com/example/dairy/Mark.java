package com.example.dairy;

public class Mark {
    private String mark;
    private String subject;
    private int date;
    private int IDLearner;

    public Mark(String mark, String subject, int date,int IDLearner) {
        this.mark = mark;
        this.subject = subject;
        this.date = date;
        this.IDLearner=IDLearner;

    }

    public int getIDLearner() {
        return IDLearner;
    }

    public void setIDLearner(int IDLearner) {
        this.IDLearner = IDLearner;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "mark='" + mark + '\'' +
                ", subject='" + subject + '\'' +
                ", date=" + date +
                '}';
    }
}
