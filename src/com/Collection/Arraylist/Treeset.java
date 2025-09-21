package com.Collection.Arraylist;

import java.util.TreeSet;

class StudentTreeset implements Comparable{
    int age;
    float height;
    double weight;

    public StudentTreeset ( int age , float height , double weight){
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        StudentTreeset s1 = (StudentTreeset) o;
        return this.age- s1.age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudentTreeset{");
        sb.append("age=").append(age);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}

public class Treeset {
    public static void main(String[] args) {
        TreeSet<StudentTreeset> studentTreeSet = new TreeSet<>();
        studentTreeSet.add(new StudentTreeset(15,25,95));
        studentTreeSet.add(new StudentTreeset(35,25,95));
        studentTreeSet.add(new StudentTreeset(25,25,95));
        studentTreeSet.add(new StudentTreeset(55,25,95));
        System.out.println(studentTreeSet);
        System.out.println(studentTreeSet.first());
        System.out.println(studentTreeSet.last());

    }
}
