package com.example.dairy;

import java.util.ArrayList;
import java.util.Arrays;

public class Class extends UnitSociety{
    private String Number;
    private Elective defaultelective[]=new Elective[0];
    private Section defaultsection[]=new Section[0];

    public void adddefaultElective(Elective elective){
        this.defaultelective=Arrays.copyOf(this.defaultelective, this.defaultelective.length+1);
        this.defaultelective[this.defaultelective.length-1]=elective;
    }

    public Elective[] getdefaultElective() {
        return defaultelective;
    }

    public void setdefaultElective(Elective[] elective) {
        this.defaultelective = elective;
    }
    public void setdefaultElective(ArrayList<Elective> elective) {
        defaultelective= Arrays.copyOf(defaultelective, elective.size());
        for(int i=0;i<elective.size();i++){
            defaultelective[i] = elective.get(i);
        }

    }
    public void adddefaultSection(Section section){
        this.defaultsection=Arrays.copyOf(this.defaultsection, this.defaultsection.length+1);
        this.defaultsection[this.defaultsection.length-1]=section;
    }
    public Section[] getdefaultSection() {
        return defaultsection;
    }

    public void setdefaultSection(Section[] section) {
        this.defaultsection = section;
    }
    public void setdefaultSection(ArrayList<Section> sections) {
        defaultsection= Arrays.copyOf(defaultsection, sections.size());
        for(int i=0;i<sections.size();i++){
            defaultsection[i] = sections.get(i);
        }

    }
    public Class(String number, Teacher classTeacher) {
        Number = number;
        setClassTeacher(classTeacher);
    }

    public String getNumber() {
        return Number;
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
