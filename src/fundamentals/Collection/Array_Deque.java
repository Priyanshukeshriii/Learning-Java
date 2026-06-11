package fundamentals.Collection;

import java.util.ArrayDeque;

public class Array_Deque {
    public static void main(String[] args) {
        ArrayDeque ad  = new ArrayDeque<>(); // index based insertion is not allowed
        ad.add(30);
        ad.add(49);
        ad.add("priyanshu");
        System.out.println(ad);
        ad.addFirst("keshri");
        System.out.println(ad);
    }
}
