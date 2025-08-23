package com.string;

public class StringInJava {
    public static void main(String[] args) {
        String a1 = "Learning Java";
        String  a2 = new String("ja");
        System.out.println(a1 == "ja");
//        System.out.println(a1.hashCode());
        System.out.println(a1.length());
        //substring
        System.out.println(a1.substring(0,1));
        System.out.println(a1.substring(1));
        //subsequence use to make a char array
        System.out.println("Sub string: "+a1.subSequence(0,1));
        //compareTo return 0 if string is same and 1 if not same
        System.out.println("compare to :"+a1.compareTo("ja"));
        System.out.println(a1.indexOf("a"));
        System.out.println(a1.equals(a2));
        System.out.println(a1.charAt(1));
        //getChars is public void  is similar as substring
        char[] ch = new char[4];
        ch[0] = 'S';
        ch[1] = 'K';
        System.out.println(ch);
        a1.getChars(2,6,ch , 0);
        System.out.println(ch);
        //important concept
        String s1 = "kk";
        s1.concat(a1);
        System.out.println(s1);
    }
}
