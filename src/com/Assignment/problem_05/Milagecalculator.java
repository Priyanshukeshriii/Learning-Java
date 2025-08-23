package com.Assignment.problem_05;

public class Milagecalculator extends  MilageAbstract{

    @Override
    public double tripcalculator() {
        if (getMiles() < 0 ){
            return 0;
        }else {
            return (double) this.getMiles()/ this.getGas();
        }
    }


    @Override
    public double mileageCalculator() {
        this.setTotalgas(this.getTotalgas() + this.getGas() );
        this.setTotalmiles(this.getTotalmiles() +  this.getMiles());
        if(this.getTotalgas()<0){
            return 0;
        }else {
            return (double) getTotalmiles()/ getTotalgas();
        }
    }

}
