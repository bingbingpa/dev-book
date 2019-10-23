package com.ch03;

public class Person {
    private String first;
    private String middle;
    private String last;

    public Person(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }
    
    public String getFirstName() {
        return first;
    }
    
    public String getMiddleName() {
        return middle;
    }
    
    public String getLastName() {
        return last;
    }
    
    public String getName() {
        if (middle == null) {
            return first + " " + last;
        }
        else {
            return first + " " + middle + " " + last;
        }
    }
    
    public String toString() {
        return getName();
    }
}