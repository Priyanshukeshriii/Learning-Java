package fundamentals.Collection;

import java.util.LinkedHashSet;


public class Linked_HashSet {
    public static void main(String[] args) {
        LinkedHashSet lhs = new LinkedHashSet(); // hash set do not grantee the order of insertion  but the LinkedHashSet grantee the order
//        od insertion
        lhs.add(3930);
        lhs.add(930);
        lhs.add(393);
        lhs.add(330);
        System.out.println(lhs);
    }
}
