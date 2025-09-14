package com.ExceptionHandling;
import java.util.Scanner;
public class Throw {
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the age : ");
        int age = input.nextInt();
        if(age >0){
            System.out.println("age is : " + age);
        }else{
            try {
                throw new InvaldiAgeException("age can not be negative");
            } catch (InvaldiAgeException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
