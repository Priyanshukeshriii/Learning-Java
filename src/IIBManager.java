class B {
    static {// static block can be called without an object
        //before the constructor static block is called
        //this does not run every time the object is created
        System.out.println("this is the SIB block");
    }
    {
        //this IIB block runs every time the object is created
        System.out.println("1st IIB block");// IIB block can not called without the object
    }
    {
        System.out.println("2st IIB block");
    }

    public B() {
        super();// after super the IIB block is called
        System.out.println("B Constructor");
    }
}



public class IIBManager {
    {
        System.out.println("Mian IIB block");
    }
    public static void main(String[] args) {
        IIBManager b = new IIBManager();
        B b1 = new B();
        B b2 = new B();
    }
}
