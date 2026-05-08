package com.enrollment.entities;

public abstract class Person {
    private String PersonID;
    private String PersonName;

    public Person(String PersonID, String PersonName) {
        this.PersonID = PersonID;
        this.PersonName = PersonName;
    }

    public Person() {}

    public String getPersonID() { return PersonID; }

    public void setPersonID(String PersonID) {
        this.PersonID = PersonID;
    }

    public String getPersonName() { return PersonName; }

    public void setPersonName(String PersonName) {
        if (PersonName != null && !PersonName.trim().isEmpty()) {
            this.PersonName = PersonName;
        } else {
            System.out.println("Error: Name cannot be empty.");
        }
    }

    public abstract void mainTask();
}