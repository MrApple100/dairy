package com.example.dairy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnitSociety {
    private Teacher ClassTeacher;
    protected Learner[] Learners=new Learner[0];
    protected Mark AllMarksOfLearners[][]=new Mark[0][0];
    protected Mark OneMarksofLearners[]=new Mark[1];
    private SavePaint[] savinglist=new SavePaint[2];
    public Learner[] getList(){
        return Learners;
    }
    public Teacher getClassTeacher() {
        return ClassTeacher;
    }
    public void setClassTeacher(Teacher classTeacher) {
        ClassTeacher = classTeacher;
    }

    public int getAllMarksOfLearnerslength() {
        return AllMarksOfLearners.length;
    }

    public void setLearners(ArrayList<Learner> learners) {
        Learners= Arrays.copyOf(Learners, learners.size());
        for(int i=0;i<learners.size();i++){
            Learners[i] = learners.get(i);
        }

    }
    public void setLearners(Learner[] learners) {
        this.Learners=learners;
    }

    protected Mark[] getMarks(Learner learner){
        //UpdateAllMarksOfLearners1();
        //UpdateAllMarksOfLearners3();
        int templength=0;
        int tempindex=-1;
        for(int i=0;i<AllMarksOfLearners.length;i++) {
            if (AllMarksOfLearners[i][0].getIDLearner() == learner.getCardID()) {
                templength=AllMarksOfLearners[i].length;
                tempindex=i;
            }
        }
        Mark[] marks=new Mark[templength];
        for (int i=0;i<marks.length;i++) {

            marks[i]=new Mark("","",-1,learner.getCardID());
        }
            if(tempindex!=-1){
                for (int j = 0; j < AllMarksOfLearners[tempindex].length; j++) {
                    marks[j] = AllMarksOfLearners[tempindex][j];
                }
            }


        return marks;
    }
    protected void UpdateAllMarksOfLearners1(){
        AllMarksOfLearners=new Mark[Learners.length][1];
    }
    protected void UpdateAllMarksOfLearners2() {
        for (int index = 0; index < AllMarksOfLearners.length; index++) {
            AllMarksOfLearners[index][0]=new Mark("", "", -1, Learners[index].getCardID());

        }

    }
    protected void UpdateAllMarksOfLearners3(){
        for(int index=0;index<AllMarksOfLearners.length;index++){
            AllMarksOfLearners[index][0].setIDLearner(Learners[index].getCardID());

        }

    }
    protected void setMarks(Learner learner,ArrayList<Mark> marks){
        //UpdateAllMarksOfLearners1();
        UpdateAllMarksOfLearners3();
        for(int i=0;i<AllMarksOfLearners.length;i++){

        }
        for(int i=0;i<AllMarksOfLearners.length;i++) {
            if(AllMarksOfLearners[i][0].getIDLearner()==learner.getCardID()){
                if(marks.size()>AllMarksOfLearners[i].length) {
                    AllMarksOfLearners[i] = Arrays.copyOf( AllMarksOfLearners[i],marks.size());
                }
                for(int j=0;j<marks.size();j++){
                    AllMarksOfLearners[i][j] = marks.get(j);
                }
            }
        }

    }

    public SavePaint getSavinglist(int index) {
        return savinglist[index];
    }

    public void setSavinglist(SavePaint savinglist,int index) {
        this.savinglist[index] = savinglist;
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
