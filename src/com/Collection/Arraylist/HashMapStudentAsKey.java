package com.Collection.Arraylist;

import java.util.HashMap;

import java.util.Objects;

class StudentAsKey{
    int age;
    float height;
    double weight;

    public StudentAsKey(int age, float height, double weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudentAsKey{");
        sb.append("age=").append(age);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o ){
        if (o == null || this.getClass() != o.getClass()){
            return false;
        }
        StudentAsKey s1 = (StudentAsKey) o;
        return this.age == s1.age && this.height == s1.height && this.weight==s1.weight;
    }
    @Override
    public int hashCode(){
        String age = String.valueOf(this.age).intern();
        String height = String.valueOf(this.height).intern();
        String weight = String.valueOf(this.weight).intern();
        int hashage = age.hashCode();
        int hashheight = height.hashCode();
        int hashWeight = weight.hashCode();
        int hash = 0 ;
        hash = hash + hashage+hashWeight+hashheight;
        return hash;

    }
}

public class HashMapStudentAsKey {
    public static void main(String[] args) {
        HashMap<StudentAsKey , String>  studentStringHashMap = new HashMap<>();
        studentStringHashMap.put(new StudentAsKey(12,115,125), "Priyanshu");
        studentStringHashMap.put(new StudentAsKey(12,115,125), "Priyanshu");
        studentStringHashMap.put(new StudentAsKey(12,15,125), "Priyanshu");
        System.out.println(studentStringHashMap);
    }
}
