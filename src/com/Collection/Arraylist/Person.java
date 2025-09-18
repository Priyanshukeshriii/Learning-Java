package com.Collection.Arraylist;


import java.util.ArrayList;
import java.util.Collections;

class PersonManager{
    int age;
    int weight;
    int height;
    public PersonManager (int age, int weight, int height){
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonManager{");
        sb.append("age=").append(age);
        sb.append(", weight=").append(weight);
        sb.append(", height=").append(height);
        sb.append('}');
        return sb.toString();
    }
}

public class Person {
    public static void main(String[] args) {
        ArrayList<PersonManager> pList = new ArrayList<>();
        pList.add(new PersonManager(12,4,5));
        pList.add(new PersonManager(11,9,6));
        pList.add(new PersonManager(18,9,3));
        pList.add(new PersonManager(19,7,9));
        System.out.println(pList);//pList.toString
//        System.out.println(Collections.sort(pList));
//        Collections.sort(pList);
    }
}
