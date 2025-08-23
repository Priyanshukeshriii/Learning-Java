package com.string;

public class StringInJava {
    public static void main(String[] args) {
        String a1 = "ja";
        String  a2 = new String("ja");
        System.out.println(a1 == "ja");
//        System.out.println(a1.hashCode());
        System.out.println(a1.length());
        System.out.println(a1.substring(0, 1));
        System.out.println(a1.substring(1));
        System.out.println("compare to :"+a1.compareTo("ja"));
        System.out.println(a1.indexOf("a"));
        System.out.println(a1.equals(a2));
        System.out.println(a1.charAt(1));
    }
}
