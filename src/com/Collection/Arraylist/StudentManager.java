package com.Collection.Arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student{
    int age ;
    float height;
    float weight;

    public Student(int age, float height, float weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("age=").append(age);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
class StudentSortAge implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        return s1.age -s2.age;
    }
}

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student(12,15.05f,15));
        studentArrayList.add(new Student(14,15.3f,15));
        Collections.sort(studentArrayList,new StudentSortAge());
        System.out.println(studentArrayList);
        String s1 = "irhg";
        System.out.println(s1.indexOf("i"));
    }
}
