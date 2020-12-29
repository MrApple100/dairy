package com.example.dairy;

import java.util.Arrays;

public class UnitSociety {
    private Teacher ClassTeacher;
    protected Learner[] Learners=new Learner[0];
    private Mark AllMarksOfLearners[][]=new Mark[0][0];
    public Learner[] getList(){
        return Learners;
    }

    protected Mark[] getMarks(Learner learner){
        Mark[] marks=new Mark[10];
        for(int i=0;i<AllMarksOfLearners.length;i++) {
            if(AllMarksOfLearners[i][0].getIDLearner()==learner.getCardID()){
                if(marks.length<AllMarksOfLearners[i].length) {
                    marks = Arrays.copyOf(marks, AllMarksOfLearners.length);
                }
                for(int j=0;j<AllMarksOfLearners[i].length;j++){
                    marks[j]=AllMarksOfLearners[i][j];
                }
            }
        }
        return marks;
    }
    private int getlengthofParrents(){
        int k=0;
        for(int i=0;i<Learners.length;i++)
            for(int j=0;j<Learners[i].getParrents().length;j++){
                k++;
            }
        return k;
    }
    protected Parrent[] getlistParrents(){
        Parrent[] parrents=new Parrent[getlengthofParrents()];
        int k=0;
        for(int i=0;i<Learners.length;i++)
            for(int j=0;j<Learners[i].getParrents().length;j++){
                parrents[k]=Learners[i].getParrents()[j];
                k++;
            }

        return parrents;
    }
}
