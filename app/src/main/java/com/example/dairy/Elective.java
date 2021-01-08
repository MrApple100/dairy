package com.example.dairy;

public class Elective extends UnitSociety{
    private String AcademicSubject;

    public Elective(String academicSubject) {
        AcademicSubject = academicSubject;
    }

    public String getAcademicSubject() {
        return AcademicSubject;
    }
}
