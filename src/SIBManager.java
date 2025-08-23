class A{

    static {
        System.out.println("class static block SIB");
    }
    A() {
        System.out.println("constructor block");
    }
}




public class SIBManager {
    static {
        System.out.println("static Block");//we can use multi static block and calling will be top to bottom
    }
    static {
        System.out.println("static1 block");
    }

    public static void main(String[] args) {
        System.out.println("main block");
        A a = new A();
        A a1 = new A();
    }
}
