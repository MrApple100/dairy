package com.example.dairy;

import java.util.Arrays;

public class Class extends UnitSociety{
    private String Number;
    private Teacher ClassTeacher;

    public Class(String number, Teacher classTeacher) {
        Number = number;
        ClassTeacher = classTeacher;
    }

    public String getNumber() {
        return Number;
    }

    public Teacher getClassTeacher() {
        return ClassTeacher;
    }

    public void setClassTeacher(Teacher classTeacher) {
        ClassTeacher = classTeacher;
    }

    public void addLearners(Learner learner){
        Learners= Arrays.copyOf(Learners, Learners.length+1);
        Learners[Learners.length-1]=learner;
    }
    public void addElective(Elective elective){
        for (Learner learner: Learners) {
            learner.addElective(elective);
        }
    }
    public void addSection(Section section){
        for (Learner learner: Learners) {
            learner.addSection(section);
        }
    }
}
