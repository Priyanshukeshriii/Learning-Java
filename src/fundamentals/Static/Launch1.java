package fundamentals.Static;

class demo{

    static int a =10;
    static {
        disp();
    }


    static void disp(){
        System.out.println(a);
    }
}

public class Launch1 {
    public static void main(String[] args) {
        demo d = new demo();
    }
}
