package com.example.dairy;

import java.util.Arrays;

public class Class extends UnitSociety{
    private String Number;
    private Teacher ClassTeacher;

    public Class(String number, Teacher classTeacher) {
        Number = number;
        ClassTeacher = classTeacher;
    }

    public void addLearners(Learner learner){
        Learners= Arrays.copyOf(Learners, Learners.length+1);
        Learners[Learners.length-1]=learner;
    }
}
