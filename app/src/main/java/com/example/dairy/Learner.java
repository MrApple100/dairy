package com.example.dairy;

import java.util.Arrays;

public class Learner extends Participant{
    private Parrent parrents[]=new Parrent[0];
    private Elective elective[]=new Elective[0];
    private Section section[]=new Section[0];

    public Learner(String fullName, long phone) {
        super(fullName, phone);
    }

    public Parrent[] getParrents() {
        return parrents;
    }

    public void setParrents(Parrent[] parrents) {
        this.parrents = parrents;
    }
    public void addParrent(Parrent parrent){
       parrents= Arrays.copyOf(parrents, parrents.length+1);
       parrents[parrents.length]=parrent;
    }
    public void addElective(Elective elective){
        this.elective= Arrays.copyOf(this.elective, this.elective.length+1);
        this.elective[this.elective.length-1]=elective;
    }

    public Elective[] getElective() {
        return elective;
    }

    public void setElective(Elective[] elective) {
        this.elective = elective;
    }
    public void addSection(Section section){
        this.section= Arrays.copyOf(this.section, this.section.length+1);
        this.section[this.section.length-1]=section;
    }
    public Section[] getSection() {
        return section;
    }

    public void setSection(Section[] section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "FullName='" + FullName + '\'' +
                ", Phone=" + Phone +
                '}';
    }
}
