package com.ExceptionHandling;

public class Demo {
    public static void main(String[] args) {
        try{
            int i = Integer.parseInt(args[0]);
            int j = i / (i - 9);
            System.out.println("value of j " + j);
            System.out.println("main ends");
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Array index out of bound ");
            System.out.println(ex.getMessage());
        }
        catch (ArithmeticException ex){
            System.out.println("Arithmatic exception");
        }
    }
}
