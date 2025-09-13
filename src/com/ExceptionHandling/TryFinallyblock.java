package com.ExceptionHandling;

public class TryFinallyblock {
    public static void main(String[] args) {
        try{
            int i = 10/0;
        }
        finally {
            System.out.println("Finally... block");
        }
        try {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
