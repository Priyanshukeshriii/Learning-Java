package com.Collection.Arraylist;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class HashMapmethod {
    public static void main(String[] args) {
        HashMap<Integer , String> studentMarks = new HashMap<>();
        studentMarks.put(92,"priyanshu");
        studentMarks.put(62,"pryanshu");
        studentMarks.put(92,"piyanshu");
        studentMarks.put(22,"priyanshu");
        System.out.println(studentMarks);
        System.out.println(studentMarks.get(92));
        System.out.println(studentMarks.keySet());
        System.out.println(studentMarks.values());
        System.out.println(studentMarks.entrySet());
        Set<Map.Entry<Integer,String>> setStudent = studentMarks.entrySet();
        System.out.println(setStudent);
    }
}
