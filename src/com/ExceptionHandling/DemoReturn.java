package com.ExceptionHandling;

public class DemoReturn {

        int operationException(int i){
            int j  =0;
            try{
                j = i/0;
                return j;
//                System.exit(0);
            }
            catch (ArithmeticException ex){
                System.out.println(ex.getMessage());
                return j;
            }
            finally {
                System.out.println("Finally Bolck Starts");
                System.exit(0);
                System.out.println("finally block");
            }

        }

    public static void main(String[] args) {
        DemoReturn d1 = new DemoReturn();
        System.out.println(d1.operationException(12));
    }
}
