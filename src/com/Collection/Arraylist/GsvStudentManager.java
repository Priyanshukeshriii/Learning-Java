package com.Collection.Arraylist;

import java.util.HashSet;
import java.util.Objects;

class GsvStudent{
    String name ;
    int marks;

    public GsvStudent(int marks, String name) {
        this.marks = marks;
        this.name = name;
    }
    public String toString(){
        return "Student [ "+ " Name :"+this.name + ", Marks: " + this.marks +"]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GsvStudent that = (GsvStudent) o;
        return marks == that.marks && Objects.equals(name, that.name);
    }

}

public class GsvStudentManager {
    public static void main(String[] args) {
        HashSet gsvSet = new HashSet<>();
        gsvSet.add(new GsvStudent(30 , "priyanshu"));
        gsvSet.add(new GsvStudent(30 , "priyanshu"));
        gsvSet.add(new GsvStudent(24 , "priyansh"));
        gsvSet.add(new GsvStudent(50 , "priyanhu"));
        System.out.println(gsvSet);
    }
}
