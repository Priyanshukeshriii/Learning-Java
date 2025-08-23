class c {
    public c() {
        System.out.println("default con");
    }
    public c(int i) {
        this();
        System.out.println("one int con");
    }
    public c(int i , int j) {
        this(i+j);
        System.out.println("two int con");
    }

}


public class ThisManager {
    public static void main(String[] args) {
        c c = new c(3,8);
    }
}
