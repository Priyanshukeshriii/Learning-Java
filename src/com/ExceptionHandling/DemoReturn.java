package com.ExceptionHandling;

public class DemoReturn {

        int operationException(int i){
            int j  =0;
            try{
                j = i/0;

            }
            catch (ArithmeticException ex){

            }
            finally {
                return j;

            }
        }

    public static void main(String[] args) {
        DemoReturn d1 = new DemoReturn();
        System.out.println(d1.operationException(12));
    }
}
