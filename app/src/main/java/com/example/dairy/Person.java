package com.example.dairy;

public class Person {
    protected String FullName;
    protected long Phone;

    public Person(String fullName, long phone) {
        FullName = fullName;
        Phone = phone;
    }

    public String getFullName() {
        return FullName;
    }

    public long getPhone() {
        return Phone;
    }
}
