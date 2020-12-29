package com.example.dairy;

public class Teacher extends Participant{
    String Position;
    String Qualification;

    public Teacher(String fullName, int phone, String position, String qualification) {
        super(fullName, phone);
        Position = position;
        Qualification = qualification;
    }
}
