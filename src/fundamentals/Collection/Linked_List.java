package fundamentals.Collection;

import java.util.LinkedList;

public class Linked_List {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(209);
        ll.add("keshri");
        ll.add(209);
        ll.add("priyanshu");
        System.out.println(ll);
        ll.offer(390.3);
        System.out.println(ll);
        ll.offerLast("Last");
        ll.offerFirst("first");
        System.out.println(ll);
        System.out.println(ll.peek());
        System.out.println(ll.poll()); // this removes the element also
        System.out.println(ll.pollFirst());
        System.out.println(ll.pollLast());
        System.out.println(ll);
    }
}
