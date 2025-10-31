package MidSem;

import java.util.ArrayList;

class a{
    static {
        System.out.println("a static");
    }
}
class b extends a {

}


public class ClassForName {
    public static void main(String[] args) {
//        try{
//            Class.forName("MidSem.a");//only calls static block
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        String s1 = "java";
//        String s4 = "java";
//        String s3 = new String("java");
//        String s2 = "ja".concat("va");
//        System.out.println(s1 == s2);
//        a A1 = new a();
//        a A2 = new a();
//        System.out.println(A1.equals(A1));

//        try{
//            b b1 = new a();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        ArrayList<Integer> a1 = new ArrayList<>();
//        System.out.println(a1.iterator());
        String s1 = "39";
        int  i1  = 81;
        int  i = Integer.parseInt(s1);
        float f = Float.parseFloat("92374");


    }

}
