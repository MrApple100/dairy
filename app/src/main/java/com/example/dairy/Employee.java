package com.example.dairy;

public class Employee extends Participant{
    private String Position;

    public Employee(String fullName, long phone, String position) {
        super(fullName, phone);
        Position = position;
    }
}
