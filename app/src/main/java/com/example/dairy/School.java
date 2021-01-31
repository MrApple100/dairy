package com.example.dairy;

import java.util.Arrays;

public class School{
    private Employee employees[]=new Employee[0];
    private Teacher teachers[]=new Teacher[0];
    private Learner learners[]=new Learner[0];
    private String Adress;
    private String Name;
    private Class classes[]=new Class[0];
    private Elective elective[]=new Elective[0];
    private Section section[]=new Section[0];

    public School(String adress, String name) {
        Adress = adress;
        Name = name;
    }

    public Teacher[] getListTeachers(){
        return teachers;
    }
    public Employee[] getListEmployees(){
        return employees;
    }
    public Learner[] getListLearners(){
        return learners;
    }
    public void addClasses(Class classroom){
        classes= Arrays.copyOf(classes, classes.length+1);
        classes[classes.length-1]=classroom;
    }
    public void getParticipant(Learner learner,Class classroom){
        learner.setCardID();
        classroom.addLearners(learner);
        learners= Arrays.copyOf(learners, learners.length+1);
        learners[learners.length-1]=learner;
    }
    public void getParticipant(Employee employee){
        employee.setCardID();
        employees= Arrays.copyOf(employees, employees.length+1);
        employees[employees.length-1]=employee;
    }
    public void addSection(Section section){
        this.section= Arrays.copyOf(this.section, this.section.length+1);
        this.section[this.section.length-1]=section;
    }
    public void addElective(Elective elective){
        this.elective= Arrays.copyOf(this.elective, this.elective.length+1);
        this.elective[this.elective.length-1]=elective;
    }

    public Mark[][] getElectronicJournal(Class classroom,Elective elective){
        int lenlearners = classroom.getList().length;
        Mark marks[][]=new Mark[lenlearners][];
        for(int i=0;i<lenlearners;i++){
            marks[i]=new Mark[elective.getMarks(classroom.getList()[i]).length];
            for(int j=0;j<elective.getMarks(classroom.getList()[i]).length;j++){
                marks[i][j]=elective.getMarks(classroom.getList()[i])[j];
            }
        }

        return marks;
    }
    public Mark[][] getElectronicJournal(Learner learner){
        int lenSubjects = learner.getElective().length+learner.getSection().length;
        Mark marks[][]=new Mark[lenSubjects][];
        for(int i=0;i<lenSubjects;i++){
        if(i<learner.getElective().length) {
                marks[i] = new Mark[learner.getElective()[i].getMarks(learner).length];
                for (int j = 0; j < learner.getElective()[i].getMarks(learner).length; j++) {
                    marks[i][j] = learner.getElective()[i].getMarks(learner)[j];
                }
            }else {
                for (int j = 0; j < learner.getSection()[i].getMarks(learner).length; j++) {
                    marks[i][j] = learner.getSection()[i].getMarks(learner)[j];
                }
            }
        }
        return marks;
    }
    public void UpdateLearners(){
        for(int i=0;i<classes.length;i++){
            for(int j=0;j<classes[i].getList().length;j++){
                learners= Arrays.copyOf(learners, learners.length+1);
                learners[learners.length-1]=classes[i].getList()[j];
            }
        }
    }
}
