package ru.mono;

import java.util.Objects;

public class Human implements Comparable<Human>{

    private String firstName;
    private String lastName;
    private int age;
    Human (String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = Math.abs(age);
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(int age) {
        this.age = Math.abs(age);
    }

    @Override
    public int compareTo(Human h) {
        int res = firstName.compareTo(h.firstName);
        if (res!=0) return res;
        else res = lastName.compareTo(h.lastName);
        if (res!=0) return res;
        else return (Integer.compare(age, h.age));
    }

    @Override
    public boolean equals(Object obj) {
        return (this.compareTo((Human)obj)) == 0;
    }

    public String toString(){
        return(firstName+" "+lastName+" "+age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}
