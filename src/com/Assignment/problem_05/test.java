package com.Assignment.problem_05;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Milagecalculator m1  = new Milagecalculator();
        double miles;
        double gas;
        do {
            System.out.println("Enter the miles of one trip (press -1 to quit): ");
            miles = input.nextDouble();
            m1.setMiles(miles);
            System.out.println("Enter the gas of one trip (press -1 to quit): ");
            gas = input.nextDouble();
            m1.setGas(gas);
            System.out.println("Total Milage for the trip "+m1.tripcalculator());
            System.out.println("Total milage for all trip "+ m1.mileageCalculator());

        }while (miles>0 || gas >0);
    }
}
