package com.Assignment;
class  Employee{
    private String name;
    private String lastname;
    private double monthsalary;

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMonthsalary(double monthsalary) {
        if (monthsalary>0) {
            this.monthsalary = monthsalary;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public double getMonthsalary() {
        return monthsalary;
    }

    public String getName() {
        return name;
    }
}
public class Problem_09 {
}
