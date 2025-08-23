package com.string;

import java.util.StringTokenizer;

public class String_Buffer {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer("abc");
        StringBuffer sb2 = sb1.append("123");
        StringBuffer sb3 = sb2.append("xyz");
        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb3);
        sb1.insert(0,"S K Priyanshu");
        System.out.println(sb1);
        sb1.delete(10,14);
        System.out.println(sb1);
        sb1.reverse();
        System.out.println(sb1);
        sb1.reverse().insert(0 , "S K Priyanshu");
        System.out.println(sb1);

        //StringTokenizer
        StringTokenizer st1 = new StringTokenizer("abc def ghi jkl mno pqr,stu,vwx,yz" , "," );
        System.out.println(st1.countTokens());

    }
}
