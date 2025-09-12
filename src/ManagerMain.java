class A3 {
    A3(){
//        first this print statement will run
//        while returning the other print statement will run
        System.out.println("A con");
    }
    A3(int i){
        this();//here we are calling the other constructor which do not have any parameter
//        as this is called the non parametrized constructor is called and the print statement will not run
        System.out.println("A " +i);
    }
}
class B3 extends A3{
    B3(){
//        super(); //this can not be done as only this or super can be called
        //this(10) call the other constructor that has parameter
        this(10);//this or super should be the first line of the constructor
//        as this(10) runs the other constructor is called and the print statement have not executed
//        super(); //this also can not be done
        System.out.println("B con");
    }
    B3(int i){
        super(i);//here we are calling the super class constructor which has the parameter
//        as super executed the super call the super class constructor and the print statement will not run
        System.out.println("B " +i );
    }
}


public class ManagerMain {
    public static void main(String[] args) {
        B3 b = new B3();
        /*
        * Output
        *
        * A con
        * A 10
        * B 10
        * B con
        * */


    }
}
