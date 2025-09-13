package com.ExceptionHandling;

public class CompileTimeException {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jbdc.driver");
        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
            System.out.println("Driver class is not found");
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("This is the finally block");
        }
    }
}
